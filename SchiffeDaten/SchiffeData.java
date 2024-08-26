package SchiffeDaten;

import java.util.Scanner;

public class SchiffeData {

	private Felder[][] SpielFeld;
	
	/*Gibt an wie viele Schiffe pro Type erzeugt werden können
	 * AnzahlSchiffe[0] -> Schlachtschiff
	 * AnzahlSchiffe[1] -> Kreuzer
	 * AnzahlSchiffe[2] -> Zerstörer
	 * AnzahlSchiffe[3] -> U-Boot
	 */
	private int[] AnzahlSchiffe = new int[3];
	//Gesamtzahl der Gesetzten Schiffsfelder
	private int mSchiff;
	
	
	/**
	 * @brief Konstruktor der Klasse SchiffeDaten
	 * 
	 * Das 10x10 Spielfeld wird mit dem Obekt FreiesFeld gefühlt
	 * 
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public SchiffeData() {
		System.out.println("[Data] Spielfeld wird gefüllt");
		SpielFeld = new Felder[10][10];
		for(int z = 0; z <= 9; z++) {
			for(int s = 0; s <= 9; s++) {
				SpielFeld[z][s] = new FreiesFeld();
			}
		}
		mSchiff = 0;
		AnzahlSchiffe = new int[]{1, 1, 1, 1};
	}
	
	/**
	 * @brief Setzt ein Schiff auf das Spielfeld.
	 * 
	 * Die Funktion erstellt ein Schiffsobjekt basierend auf dem Schiffsnamen. Die
	 * Richtung wird in einer 1x2 Matrix abgespeichert, die eine numerische
	 * Darstellung der Richtung angibt (z.B. [1,0] für horizontal oder [0,1] für 
	 * vertikal). Die übergebene Startzelle wird von einem String in ein 
	 * Integer-Array umgewandelt, um die Position auf dem Spielfeld darzustellen.
	 * 
	 * Es wird überprüft, ob die notwendigen Spielfeldbereiche frei sind, um das 
	 * Schiff zu platzieren, und ob das gewählte Schiff noch verfügbar ist (d.h., 
	 * ob noch Schiffe dieses Typs übrig sind). Falls beide Bedingungen erfüllt sind,
	 * wird das Schiff auf dem Spielfeld gesetzt. Falls das Schiff nicht mehr 
	 * verfügbar ist, wird eine Ausnahme geworfen.
	 * 
	 * @param Schiff Der Name des ausgewählten Schiffes.
	 * @param Richtung Die Richtung, in der das Schiff platziert werden soll 
	 *        		   (z.B. "Norden" oder "Süden", usw.).
	 * @param Zelle Das Startfeld, auf dem das Schiff platziert werden soll, in 
	 * 		  		String-Form (z.B. "A5" für Spalte A und Zeile 5).
	 * 
	 * @throws Exception Wird geworfen, wenn das ausgewählte Schiff nicht mehr 
	 *                   verfügbar ist, da bereits alle Exemplare dieses Typs 
	 *                   platziert wurden.
	 * 
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public void setSchiff(String Schiff, String Richtung, String Zelle) throws Error {
		Schiffe schiff = SchiffType(Schiff);
		int[] richungsMatrix = RichtungToInt(Richtung);
		int[] feldInt = ZelleToInt(Zelle);
		
		if(FreieFelder(schiff, richungsMatrix, feldInt )) {
			if( AnzahlSchiffe[schiff.getArrayPosition()] <= 0) {
				System.out.println("[Data] Schiff nicht mehr vorhanden");
				throw new Error("kein Schiff mehr frei");
			}
			SchiffSetzen(Schiff, schiff, richungsMatrix, feldInt);
		}
	}
	
	/**
	 * @brief Erstellt ein Schiffsobjekt basierend auf dem ausgewählten Schiffstyp.
	 * 
	 * Die Methode erstellt je nach übergebenem String 's' ein entsprechendes 
	 * Schiffsobjekt. Die zur Auswahl stehenden Schiffstypen sind "Schlachtschiff",
	 * "Kreuzer", "Zerstörer" und "U-Boot". Für jedes dieser Schiffe wird ein 
	 * spezifisches Objekt erzeugt und zurückgegeben.
	 * Wenn der übergebene Schiffstyp nicht erkannt wird, gibt die Methode 'null'
	 * zurück.
	 * 
	 * @param s Der Name des ausgewählten Schiffes inklusive Größe und Anzahl 
	 *          (z.B. "Schlachtschiff (5 Kästchen) [1 Stück]").
	 * @return Ein Objekt der Klasse 'Schiffe', das dem ausgewählten Schiff
	 * 		   entspricht, oder 'null', falls der Schiffstyp unbekannt ist.
	 * @throws Exception Wird geworfen, wenn übergebener String falsch ist.
	 * 
	 * @pre Ein Schiff soll ins Spielfeld gesetzt werden.
	 * @post Ein Schiffsobejekt wird erzeugt.
	 *         
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	private Schiffe SchiffType(String s) throws Error {
		switch(s) {
		case "Schlachtschiff (5 Kästchen) [1 Stück]": 
			System.out.println("[Data] Schlachtschiff wird erstellt");
			return new Schlachtschiff();
		case "Kreuzer (4 Kästchen) [2 Stück]":
			System.out.println("[Data] Kreuzer wird erstellt");
			return new Kreuzer();
		case "Zerstörer (3 Kästchen) [3 Stück]":
			System.out.println("[Data] Zerstörer wird erstellt");
			return new Zerstoerer();
		case "U-Boot (2 Kästchen) [4 Stück]":
			System.out.println("[Data] U-Boot wird erstellt");
			return new UBoot();
		default: 
			System.out.println("[Data] kein Schiff wird erstellt");
			throw new Error("Ungültiges Schiff: " + s);
		}
	}
	
	/**
	 * @brief Wandelt die ausgewählte Richtung in eine entsprechende Richtungsmatrix um.
	 * 
	 * Diese Methode nimmt eine String der Himmelsrichtung (Norden, Osten, Süden,
	 * Westen) und gibt ein Integer-Array zurück, das die entsprechende 
	 * Richtungsmatrix beschreibt. Diese Matrix wird verwendet, um die 
	 * Setzrichtung eines Schiffs auf dem Spielfeld zu steuern.
	 * 
	 * - "Norden" wird zu [-1, 0], was eine Richtung nach oben darstellt.
	 * - "Osten" wird zu [0, 1], was eine Richtung nach rechts darstellt.
	 * - "Süden" wird zu [1, 0], was eine Richtung nach unten darstellt.
	 * - "Westen" wird zu [0, -1], was eine Richtung nach links darstellt.
	 * 
	 * Wenn eine ungültige Richtung übergeben wird, wird ein Fehler geworfen.
	 * 
	 * @param richtung Die Himmelsrichtung als String (z.B. "Norden", "Osten", 
	 * 				   "Süden", "Westen").
	 * @return Ein Integer-Array, das die Richtung auf dem Spielfeld 
	 * 		   beschreibt.
	 * @throws Error Wird geworfen, wenn eine ungültige Himmelsrichtung
	 * 				 übergeben wird.
	 * 
	 * @pre Ein Schiff soll auf dem Spielfeld gesetzt werden.
	 * @post Gibt ein Integer-Array zurück, das die entsprechende Richtung als 
	 * 		 Richtungsmatrix beschreibt.
	 * 
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	private int[] RichtungToInt(String richtung) throws Error {
		switch (richtung) {
	        case "Norden": 
	        	System.out.println("[Data] Richtungsmatrix Norden: {1, 0}");
	        	return new int[]{-1, 0};
	        case "Osten": 
	        	System.out.println("[Data] Richtungsmatrix Osten: {0, 1}");
	        	return new int[]{0, 1};
	        case "Süden": 
	        	System.out.println("[Data] Richtungsmatrix Süden: {-1, 0}");
	        	return new int[]{1, 0};
	        case "Westen": 
	        	System.out.println("[Data] Richtungsmatrix Westen: {0, -1}");
	        	return new int[]{0, -1};
	        default: 
	        	System.out.println("[Data] Richtungsmatrix Fehler " + richtung);
	        	throw new Error("Ungültige Richtung: " + richtung);
	    }
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 * 
	 * @pre
	 * @post
	 * 
	 * @since
	 * @author Anton Unger
	 */
	private int[] ZelleToInt(String f) throws Error {
		System.out.println("[Data] Umwandlung " + f + " in Int");
		int[] zelle = {0,0};
		
		 Scanner scanner = new Scanner(f);
		 String eingabe = scanner.nextLine().toUpperCase();
	        
	     if (eingabe.matches("[A-J][1-9]") || eingabe.matches("[A-J]10")) {  
	    	 char spalteChar = eingabe.charAt(0);
	         zelle[1] = spalteChar - 'A';
	            
	         zelle[0] = Integer.parseInt(eingabe.substring(1)) - 1;
	            
	         System.out.println("[Data] " + zelle[1] + " " + zelle[0]);
	     } else {
	         System.out.println("[Data] Ungültige Eingabe");
	         throw new Error("Ungültige Eingabe! Bitte geben Sie ein Feld im Format A-J und 1-10 ein.");
	     }
	        
	     scanner.close();
	     return zelle;
	}
	
	private boolean FreieFelder(Schiffe schiff, int[] r, int[] f) throws Error {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(((zeile < 0) || (spalte < 0) || (zeile > 9) || (spalte > 9))) {
				System.out.println("[Data] Schiff aus Spielfeld");
				throw new Error("Schiff auserhalb des Spielfeldes platziert");
			}
			
			if(!(SpielFeld[zeile][spalte] instanceof FreiesFeld)) {
				System.out.println("[Data] Feld "+ zeile + spalte + " ist belegt");
				throw new Error("Feld ist belegt");
			}
			zeile = zeile + r[0];
			spalte = spalte + r[1];			
		}
		
		System.out.println("[Data] Feld "+ zeile + spalte + " ist frei");
		return true;
	}
	
	private void SchiffSetzen(String schiffsTyp, Schiffe schiff, int[] r, int[] f)
			throws Error {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			SpielFeld[zeile][spalte] = SchiffType(schiffsTyp);
			DummyFelder(zeile, spalte);
			((Schiffe) SpielFeld[zeile][spalte]).setRichtung(r);
			System.out.println("[Data] Schiffteil " + zeile +" " + spalte);
			zeile = zeile + r[0];
			spalte = spalte + r[1];
		}
		
		System.out.println("[Data] Schiff gesetzt");
		mSchiff += schiff.getLaenge();
		System.out.println("[Data] Aktuelle Schiffsfelder: " + mSchiff);
		AnzahlSchiffe[schiff.getArrayPosition()]--;
	}

	private void DummyFelder(int zeile, int spalte) {
		if((zeile-1 >= 0) && SpielFeld[zeile-1][spalte] instanceof FreiesFeld) {
			SpielFeld[zeile-1][spalte] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + (zeile-1) + " " + spalte);
		}
		if((zeile+1 <= 9) && SpielFeld[zeile+1][spalte] instanceof FreiesFeld) {
			SpielFeld[zeile+1][spalte] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + (zeile+1) + " " + spalte);	
		}	
		if((spalte-1 >= 0) && SpielFeld[zeile][spalte-1] instanceof FreiesFeld) {
			SpielFeld[zeile][spalte-1] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + zeile + " " + (spalte-1));
		}
		if((spalte+1 <= 9) && SpielFeld[zeile][spalte+1] instanceof FreiesFeld) {
			SpielFeld[zeile][spalte+1] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + zeile + " " + (spalte+1));
		}
	}

	public boolean getType(int zeile, int spalte) {
		boolean schiff = SpielFeld[zeile][spalte] instanceof Schiffe;
		System.out.println("[Data] Schiffsfeld " + zeile + " " + spalte + ": " + schiff);
		return schiff;
	}
	
	public boolean getStatus(int zeile, int spalte) {
		boolean treffer = SpielFeld[zeile][spalte].getTreffer();
		System.out.println("[Data] Treffer Feld " + zeile + " " + spalte + ": " + treffer);
		return treffer; 
	}
	
	public boolean setSchuss(String zelle) throws Error {
		System.out.println("[Data] Setze schuss auf " + zelle);
		
		int[] feldInt = ZelleToInt(zelle);
		int zeile = feldInt[0];
		int spalte = feldInt[1];
		
		if(SpielFeld[zeile][spalte].getTreffer()) {
			System.out.println("[Data] Feld schon getroffen");
			throw new Error("Feld wurde schon beschossen");
		}
		
		System.out.println("[Data] Feld  getroffen");
		SpielFeld[zeile][spalte].setTreffer();
		
		if(SpielFeld[zeile][spalte] instanceof Schiffe) {
			System.out.println("[Data] VersenkungsTest startet!");
			erhoeheTrefferCount(zeile, spalte);			
			//setVersenkt(zeile, spalte);
			mSchiff--;
			return Spielend(zeile, spalte);	
		}
		return true;
	}
	
	private void erhoeheTrefferCount(int zeile, int spalte) {
		int zeilenRichtung = ((Schiffe) SpielFeld[zeile][spalte]).getRichtung()[0];
		int spaltenRichtung = ((Schiffe) SpielFeld[zeile][spalte]).getRichtung()[1];
		int z = zeile - zeilenRichtung;	//Kopien für den 2. Durchgang in die entgegengesetzte Richtung
		int s = spalte - spaltenRichtung;
		try {
			versenkungsTestSchleife(zeile, spalte, zeilenRichtung, spaltenRichtung);
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
		try {
			versenkungsTestSchleife(z, s, (zeilenRichtung*-1), (spaltenRichtung*-1));
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
	}

	private void versenkungsTestSchleife(int zeile, int spalte, int zeilenRichtung, int spaltenRichtung) {
		while(SpielFeld[zeile][spalte] instanceof Schiffe) {
			((Schiffe) SpielFeld[zeile][spalte]).setAnzTreffer();
			System.out.println("[Data] erhöhe Treffer Counter Feld " + (zeile) + " " + (spalte));
			System.out.println("[Data] Anzahl Treffer: "+((Schiffe) SpielFeld[zeile][spalte]).getAnzTreffer());
			zeile += zeilenRichtung;
			spalte += spaltenRichtung;
		}
	}

	public boolean getVersenktGUI(int zeile, int spalte) {
		
		//boolean versenkt = SpielFeld[zeile][spalte].getVersenkt();
		boolean versenkt = ((Schiffe) SpielFeld[zeile][spalte]).getAnzTreffer() == ((Schiffe) SpielFeld[zeile][spalte]).getLaenge();
				
		System.out.println("[Data] Feld " + zeile + " " + spalte + " versenkt? " + versenkt);
		return versenkt;
	}

	/*
	private void setVersenkt(int zeile, int spalte) {
		System.out.println("[Data] Feld ["+zeile+","+spalte+"] Anzahl Treffer: " + SpielFeld[zeile][spalte].getAnzTreffer() + " Länge: " + SpielFeld[zeile][spalte].getLaenge());
		
		int zeilenRichtung = SpielFeld[zeile][spalte].getRichtung()[0];
		int spaltenRichtung = SpielFeld[zeile][spalte].getRichtung()[1];
		int z = zeile;	//Kopien für den 2. Durchgang in die entgegengesetzte Richtung
		int s = spalte;
		try {
			while(SpielFeld[zeile][spalte] instanceof Schiffe) {
				SpielFeld[zeile][spalte].setVersenkt(SpielFeld[zeile][spalte].getAnzTreffer() >= SpielFeld[zeile][spalte].getLaenge());
				zeile += zeilenRichtung;
				spalte += spaltenRichtung;
			}
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
		try {
			while(SpielFeld[z][s] instanceof Schiffe) {
				SpielFeld[z][s].setVersenkt(SpielFeld[z][s].getAnzTreffer() >= SpielFeld[z][s].getLaenge());
				z -= zeilenRichtung;
				s -= spaltenRichtung;
			}
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
	}
	*/

	private boolean Spielend(int zeile, int spalte) {
		System.out.println("[Data] Noch vorhandene Schiffe: " + mSchiff);
		if(mSchiff == 0) {
			System.out.println("[Data] Spielende");
			return false;
		}
		else {
			System.out.println("[Data] kein Spielende");
			return true;
		}	
	}
	
	public boolean Spielerwechsel() {
		int aSchiffe = AnzahlSchiffe[0] + AnzahlSchiffe[1] + AnzahlSchiffe[2]
						+ AnzahlSchiffe[3];
		if(aSchiffe == 0) {	
			return true;
		}
		return false;		
	}
}
