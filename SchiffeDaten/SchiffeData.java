package SchiffeDaten;

import java.util.Scanner;

public class SchiffeData {

	private Felder[][] SpielFeld;
	
	/*TODO Anton - Johannes
	 * static Klassen
	*/
	private int[] AnzahlSchiffe = {1,2,3,4};
	private int mSchiff = 0;
	
	public SchiffeData() {
		System.out.println("[Data] Spielfeld wird gefüllt");
		SpielFeld = new Felder[10][10];
		for(int z = 0; z <= 9; z++) {
			for(int s = 0; s <= 9; s++) {
				SpielFeld[z][s] = new FreiesFeld();
			}
		}
	}
	
	public void setSchiff(String Schiff, String Richtung, String Zelle) throws Exception {
		Schiffe schiff = SchiffType(Schiff);
		int[] richungsMatrix = RichtungToInt(Richtung);
		int[] feldInt = ZelleToInt(Zelle);
		
		if(FreieFelder(schiff, richungsMatrix, feldInt )) {
			if( AnzahlSchiffe[schiff.getPosition()] <= 0) {
				System.out.println("[Data] Schiff nicht mehr vorhanden");
				throw new Exception("kein Schiff mehr frei");
			}
			SchiffSetzen(Schiff, schiff, richungsMatrix, feldInt);
		}
	}
	
	private Schiffe SchiffType(String s) {
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
			return null;
		}
	}
	
	private int[] RichtungToInt(String richtung) throws Exception {
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
	        	throw new Exception("Ungültige Richtung: " + richtung);
	    }
	}
	
	private int[] ZelleToInt(String f) throws Exception {
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
	         throw new Exception("Ungültige Eingabe! Bitte geben Sie ein Feld im Format A-J und 1-10 ein.");
	     }
	        
	     scanner.close();
	     return zelle;
	}
	
	private boolean FreieFelder(Schiffe schiff, int[] r, int[] f) throws Exception {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(((zeile < 0) || (spalte < 0) || (zeile > 9) || (spalte > 9))) {
				System.out.println("[Data] Schiff aus Spielfeld");
				throw new Exception("Schiff auserhalb des Spielfeldes platziert");
			}
			
			if(!(SpielFeld[zeile][spalte] instanceof FreiesFeld)) {
				System.out.println("[Data] Feld "+ zeile + spalte + " ist belegt");
				throw new Exception("Feld ist belegt");
			}
			zeile = zeile + r[0];
			spalte = spalte + r[1];			
		}
		
		System.out.println("[Data] Feld "+ zeile + spalte + " ist frei");
		return true;
	}
	
	private void SchiffSetzen(String schiffsTyp, Schiffe schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			SpielFeld[zeile][spalte] = SchiffType(schiffsTyp);
			DummyFelder(zeile, spalte);
			SpielFeld[zeile][spalte].setRichtung(r);
			System.out.println("[Data] Schiffteil " + zeile +" " + spalte);
			zeile = zeile + r[0];
			spalte = spalte + r[1];
		}
		
		System.out.println("[Data] Schiff gesetzt");
		mSchiff += schiff.getLaenge();
		System.out.println("[Data] Aktuelle Schiffsfelder: " + mSchiff);
		AnzahlSchiffe[schiff.getPosition()]--;
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
	
	public boolean setSchuss(String zelle) throws Exception {
		System.out.println("[Data] Setze schuss auf " + zelle);
		
		int[] feldInt = ZelleToInt(zelle);
		int zeile = feldInt[0];
		int spalte = feldInt[1];
		
		if(SpielFeld[zeile][spalte].getTreffer()) {
			System.out.println("[Data] Feld schon getroffen");
			throw new Exception("Feld wurde schon beschossen");
		}
		
		System.out.println("[Data] Feld  getroffen");
		SpielFeld[zeile][spalte].setTreffer();
		
		if(SpielFeld[zeile][spalte] instanceof Schiffe) {
			System.out.println("[Data] VersenkungsTest startet!");
			erhoeheTrefferCount(zeile, spalte);			
			setVersenkt(zeile, spalte);
			mSchiff--;
			return Spielend(zeile, spalte);	
		}
		return true;
	}
	
	private void erhoeheTrefferCount(int zeile, int spalte) {
		int zeilenRichtung = SpielFeld[zeile][spalte].getRichtung()[0];
		int spaltenRichtung = SpielFeld[zeile][spalte].getRichtung()[1];
		int z = zeile - zeilenRichtung;	//Kopien für den 2. Durchgang in die entgegengesetzte Richtung
		int s = spalte - spaltenRichtung;
		try {
			while(SpielFeld[zeile][spalte] instanceof Schiffe) {
				SpielFeld[zeile][spalte].setAnzTreffer();
				System.out.println("[Data] erhöheTC Feld " + (zeile) + " " + (spalte));
				System.out.println("[Data] Anzahl Treffer: "+SpielFeld[zeile][spalte].getAnzTreffer());
				zeile += zeilenRichtung;
				spalte += spaltenRichtung;
			}
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
		try {
			while(SpielFeld[z][s] instanceof Schiffe) {
				SpielFeld[z][s].setAnzTreffer();
				System.out.println("[Data] erhöheTC Feld " + (z) + " " + (s));
				System.out.println("[Data] Anzahl Treffer: "+SpielFeld[z][s].getAnzTreffer());
				z -= zeilenRichtung;
				s -= spaltenRichtung;
			}
		} catch(Exception e) {
			System.out.println("[Data] Ende des Spielfeldes erreicht");
		}
		
	}

	/*TODO
	 * Implementieren - Johannes
	 */
	public boolean getVersenktGUI(int zeile, int spalte) {
		
		boolean versenkt = SpielFeld[zeile][spalte].getVersenkt();
		
		System.out.println("[Data] Feld " + zeile + " " + spalte + " versenkt? " + versenkt);
		return versenkt;
	}
	/*TODO
	 * Implementieren - Johannes
	 */
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
	

	private boolean Spielend(int zeile, int spalte) {
		//int mengeSchiffe = ((Schiffe) SpielFeld[zeile][spalte]).getMengeSchiffe();
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
	
	private boolean Spielerwechsel() {
		if(mSchiff == 40) {	//40 Gesamtzahl der Schiffsfelder
			return true;
		}
		return false;		
	}
}
