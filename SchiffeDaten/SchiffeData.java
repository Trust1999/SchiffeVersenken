package SchiffeDaten;

import java.util.Scanner;


/**
 * @brief Verwaltet die Daten für das Schiffs-Spiel, einschließlich des Spielfelds
 * 		  und der Schiffe.
 * 
 * Diese Klasse ist für die Verwaltung des Spielfelds sowie für das Platzieren und 
 * Verfolgen von Schiffen verantwortlich. Sie bietet Methoden zum Setzen von
 * Schiffen, Überprüfen von Schüssen, Überprüfen des Spielstatus und Spielerwechsel.
 * 
 * @since 18.08.2024
 * @lastModified 27.08.2024
 * @author Anton Unger
 */
public class SchiffeData {

	private Felder[][] SpielFeld;
	
	private int[] AnzahlSchiffe = new int[3];
	private int mSchiff;
	
	/**
	 * @brief Konstruktor der Klasse SchiffeData.
	 * 
	 * Dieser Konstruktor initialisiert ein 10x10 Spielfeld, wobei jedes Feld 
	 * mit einem Objekt vom Typ 'FreiesFeld' gefüllt wird. 
	 * 
	 * Zusätzlich wird der Zähler für gesetzte Schiffe (mSchiff) auf 0 gesetzt 
	 * und die Anzahl der verfügbaren Schiffe für jeden Schiffstyp (Schlachtschiff, 
	 * Kreuzer, Zerstörer, U-Boot) wird in einem Array initialisiert, in dieser 
	 * Reihenfolge. 
	 * 
	 * @since 11.08.2024
	 * @lastModified 26.08.2024
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
		AnzahlSchiffe = new int[]{1, 2, 3, 4};
	}
	
	/**
	 * @brief Setzt ein Schiff auf das Spielfeld.
	 * 
	 * Die Funktion erstellt ein Schiffsobjekt basierend auf dem Schiffsnamen. Die
	 * Richtung wird in einer 1x2 Matrix abgespeichert, die eine numerische
	 * Darstellung der Richtung angibt. Die übergebene Startzelle wird von einem String
	 * in ein Integer-Array umgewandelt, um die Position auf dem Spielfeld darzustellen.
	 * 
	 * Es wird überprüft, ob die notwendigen Spielfeldbereiche frei sind, um das 
	 * Schiff zu platzieren, und ob das gewählte Schiff noch verfügbar ist (d.h., 
	 * ob noch Schiffe dieses Typs übrig sind). Falls beide Bedingungen erfüllt sind,
	 * wird das Schiff auf dem Spielfeld gesetzt. Falls das Schiff nicht mehr 
	 * verfügbar ist, wird ein Fehler geworfen.
	 * 
	 * @param Schiff Der Name des ausgewählten Schiffes.
	 * @param Richtung Die Richtung, in der das Schiff platziert werden soll 
	 *        		   (z.B. "Norden" oder "Süden", usw.).
	 * @param Zelle Das Startfeld, auf dem das Schiff platziert werden soll, in 
	 * 		  		String-Form (z.B. "A5" für Spalte A und Zeile 5).
	 * 
	 * @throws Error Wird geworfen, wenn das ausgewählte Schiff nicht mehr 
	 *               verfügbar ist, da bereits alle Exemplare dieses Typs 
	 *               platziert wurden.
	 * 
	 * @since 11.08.2024
	 * @lastModified 21.08.2024
	 * @author Anton Unger
	 */
	public void setSchiff(String Schiff, String Richtung, String Zelle) throws Error {
		Schiffe schiff = schiffType(Schiff);
		int[] richungsMatrix = richtungToInt(Richtung);
		int[] feldInt = zelleToInt(Zelle);
		
		if(freieFelder(schiff, richungsMatrix, feldInt )) {
			if( AnzahlSchiffe[schiff.getArrayPosition()] <= 0) {
				System.out.println("[Data] Schiff nicht mehr vorhanden");
				throw new Error("kein Schiff mehr frei");
			}
			schiffSetzen(Schiff, schiff, richungsMatrix, feldInt);
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
	 * 
	 * @throws Error Wird geworfen, wenn übergebener String falsch ist.
	 * 
	 * @pre Ein Schiff soll ins Spielfeld gesetzt werden.
	 * @post Ein Schiffsobejekt wird erzeugt.
	 *         
	 * @since 11.08.2024
	 * @lastModified 21.08.2024
	 * @author Anton Unger
	 */
	private Schiffe schiffType(String s) throws Error {
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
	 * 
	 * @throws Error Wird geworfen, wenn eine ungültige Himmelsrichtung
	 * 				 übergeben wird.
	 * 
	 * @pre Ein Schiff soll auf dem Spielfeld gesetzt werden.
	 * @post Gibt ein Integer-Array zurück, das die entsprechende Richtung als 
	 * 		 Richtungsmatrix beschreibt.
	 * 
	 * @since 11.08.2024
	 * @lastModified 21.08.2024
	 * @author Anton Unger
	 */
	private int[] richtungToInt(String richtung) throws Error {
		switch (richtung) {
	        case "Norden": 
	        	System.out.println("[Data] Richtungsmatrix Norden: {-1, 0}");
	        	return new int[]{-1, 0};
	        case "Osten": 
	        	System.out.println("[Data] Richtungsmatrix Osten: {0, 1}");
	        	return new int[]{0, 1};
	        case "Süden": 
	        	System.out.println("[Data] Richtungsmatrix Süden: {1, 0}");
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
	 * @brief Wandelt die Spielfeldkoordinate von String- in Integer-Form um.
	 * 
	 * Diese Methode nimmt eine Spielfeldkoordinate in String-Form (z.B. "A5") 
	 * und konvertiert sie in ein Integer-Array, das die Position auf dem Spielfeld 
	 * angibt. Der Buchstabe (A-J) steht dabei für die Spalte und die Zahl (1-10) 
	 * für die Zeile. Die Rückgabe erfolgt in einem Array, in dem die erste 
	 * Position die Zeile und die zweite Position die Spalte repräsentiert.
	 * 
	 * Es können Klein- und Großbuchstaben eingegeben werden.
	 * 
	 * Es werden nur Eingaben im Bereich "A1" bis "J10" akzeptiert. Bei einer 
	 * ungültigen Eingabe wird ein 'Error' geworfen.
	 * 
	 * @param f Der String, der die Zelle repräsentiert, im Format [A-J][1-10].
	 * @return Ein Integer-Array, in dem die erste Position die Zeile und die zweite 
	 *         Position die Spalte repräsentiert.
	 * 
	 * @throws Error Wird geworfen, wenn die Eingabe ungültig ist (d.h. sie liegt 
	 *               außerhalb des erlaubten Bereichs "A1" bis "J10").
	 * 
	 * @pre Der Spieler möchte ein Schiff setzten
	 * @post Gibt ein Integer-Array zurück, das die Position des Feldes in
	 * 		 numerischer Form beschreibt.
	 * 
	 * @since 11.08.2024
	 * @lastModified 22.08.2024
	 * @author Anton Unger
	 */
	private int[] zelleToInt(String f) throws Error {
		System.out.println("[Data] Umwandlung " + f + " in Int");
		int[] zelle = {0,0};
		
		if(f.isEmpty()) {
			System.out.println("[Data] keine Eingabe");
			throw new Error("Es wurde nichts eingegebn");
		}
		
		 Scanner scanner = new Scanner(f);
		 String eingabe = scanner.nextLine().toUpperCase();
	        
	     if (eingabe.matches("[A-J][1-9]") || eingabe.matches("[A-J]10")) {  
	    	 char spalteChar = eingabe.charAt(0);
	         zelle[1] = spalteChar - 'A';
	            
	         zelle[0] = Integer.parseInt(eingabe.substring(1)) - 1;
	            
	         System.out.println("[Data] " + zelle[1] + " " + zelle[0]);
	         scanner.close();
	     } else {
	         System.out.println("[Data] Ungültige Eingabe");
	         scanner.close();
	         throw new Error("Ungültige Eingabe! Bitte geben Sie ein Feld im Format A-J und 1-10 ein.");
	     }
	     return zelle;
	}
	
	/**
	 * @brief Überprüft, ob die Felder für das Schiff frei sind und auf dem 
	 * 		  Spielfeld liegen.
	 * 
	 * Diese Methode prüft, ob die Felder, auf denen ein Schiff platziert werden
	 * soll, frei sind und sich innerhalb der Grenzen des Spielfelds (10x10)
	 * befinden. Dabei wird die Länge des Schiffes berücksichtigt und in der 
	 * angegebenen Richtung überprüft, ob alle benötigten Felder frei sind (d.h.,
	 * noch nicht von einem anderen Schiff belegt). 
	 * 
	 * @param schiff Das Schiffsobjekt, das platziert werden soll.
	 * @param r Ein Integer-Array, das die Bewegungsrichtung des Schiffes angibt 
	 *          (z.B. [1, 0] für eine Richtung nach Süden)
	 * @param f Ein Integer-Array, das die Startkoordinate auf dem Spielfeld angibt 
	 *          im Format [Zeile][Spalte]
	 * @return Gibt 'true' zurück, wenn alle Felder für das Schiff frei sind und 
	 * 		   sich innerhalb der Grenzen des Spielfelds befinden.
	 * 
	 * @throws Error Wird geworfen, wenn das Schiff außerhalb des Spielfelds
	 * 		   		 platziert werden soll oder eines der benötigten Felder bereits
	 * 		  		 belegt ist durch ein Schiff und ein Belegtes Feld.
	 * 
	 * @pre Der Spieler möchte ein Schiff platzieren
	 * @post Gibt 'true' zurück, wenn alle Felder für das Schiff erfolgreich
	 * 		 überprüft wurden und frei sind. Sonst erhält der Spieler einen Fehler
	 * 		 und das Schiff wird nicht platziert.
	 * 
	 * @since 11.08.2024
	 * @lastModified 27.08.2024
	 * @author Anton Unger
	 */
	private boolean freieFelder(Schiffe schiff, int[] r, int[] f) throws Error {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(((zeile < 0) || (spalte < 0) || (zeile > 9) || (spalte > 9))) {
				System.out.println("[Data] Schiff aus Spielfeld");
				throw new Error("Schiff auserhalb des Spielfeldes platziert");
			}
			
			if(!(SpielFeld[zeile][spalte] instanceof FreiesFeld)) {
				System.out.println("[Data] Feld "+ spalte + " " + zeile + " ist belegt");
				throw new Error("Feld " + (char)(spalte + 'A') + (zeile + 1) + " ist belegt");
			}
			zeile = zeile + r[0];
			spalte = spalte + r[1];			
		}
		
		System.out.println("[Data] Feld "+ zeile + spalte + " ist frei");
		return true;
	}
	
	/**
	 * @brief Platziert ein Schiff auf dem Spielfeld.
	 * 
	 * Diese Methode setzt ein Schiff vom angegebenen Typ auf das Spielfeld. 
	 * Das Schiff wird in der Richtung, die durch das Richtungs-Array 'r'
	 * bestimmt wird, und ab der Startkoordinate 'f' platziert. Jedes Segment des 
	 * Schiffs wird auf dem Spielfeld in der entsprechenden Zelle gesetzt. Zudem 
	 * wird die Richtung für das Schiff gespeichert und das Spielfeld um das 
	 * Schiff herum entsprechend mit BelegtFeldern markiert.
	 * 
	 * Am Ende der Platzierung wird die Anzahl der verfügbaren Schiffe des 
	 * entsprechenden Typs reduziert, und die Anzahl der gesetzten Schiffsfelder
	 * wird aktualisiert.
	 * 
	 * @param schiffsTyp Der Name des Schiffs, das gesetzt werden soll.
	 * @param schiff Das Schiffsobjekt, das die Eigenschaften des zu platzierenden 
	 * 				 Schiffs enthält.
	 * @param r Ein Integer-Array, das die Richtung des Schiffs angibt 
	 *          (z.B. [1, 0] für eine Bewegung nach Süden)
	 * @param f Ein Integer-Array, das die Startkoordinate auf dem Spielfeld angibt 
	 *          im Format [Zeile][Spalte]
	 * 
	 * @pre Das Spielfeld muss ausreichend freie Felder in der angegebenen Richtung 
	 * 		haben.
	 * @post Das Schiff wird auf dem Spielfeld platziert, die Anzahl der verfügbaren Schiffe wird reduziert,
	 *       und die Anzahl der belegten Schiffsfelder wird aktualisiert.
	 * 
	 * @lastModified 21.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	private void schiffSetzen(String schiffsTyp, Schiffe schiff, int[] r, int[] f){
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			SpielFeld[zeile][spalte] = schiffType(schiffsTyp);
			dummyFelder(zeile, spalte);
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

	
	/**
	 * @brief Setzt Dummy-Felder um ein Schiff herum.
	 * 
	 * Diese Methode setzt Felder um das Schiff herum auf, um zu verhindern, dass 
	 * ein weiteres Schiff direkt neben einem bereits platzierten Schiff gesetzt
	 * wird. Dabei wird für jedes angrenzende Feld überprüft, ob es sich im Spielfeld
	 * befindet und ob es ein freies Feld ist. Ist dies der Fall, wird das Feld in 
	 * ein Belegtes Feld umgewandelt.
	 * 
	 * @param zeile Die Zeile der aktuellen Position des Schiffssegments.
	 * @param spalte Die Spalte der aktuellen Position des Schiffssegments.
	 * 
	 * @pre Das Schiff wird auf das Spielfeld gestzt.
	 * @post Die angrenzenden Felder um das Schiff werden auf "belegt" gesetzt, 
	 * 		 sofern sie frei sind.
	 * 
	 * @lastModified 27.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	private void dummyFelder(int zeile, int spalte) {
	    int[][] richtungen = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

	    for (int[] richtung : richtungen) {
	        int neueZeile = zeile + richtung[0];
	        int neueSpalte = spalte + richtung[1];
	        
	        if (neueZeile >= 0 && neueZeile <= 9 && neueSpalte >= 0 && neueSpalte <= 9 
	            && SpielFeld[neueZeile][neueSpalte] instanceof FreiesFeld) {
	            SpielFeld[neueZeile][neueSpalte] = new BelegtesFeld();
	            System.out.println("[Data] DummyFeld gesetzt: " + neueZeile + " " + neueSpalte);
	        }
	    }
	}

	/**
	 * @brief Überprüft, ob sich an der angegebenen Position ein Schiff befindet.
	 * 
	 * Diese Methode überprüft, ob das Feld an der angegebenen Position (Zeile und 
	 * Spalte) ein Schiffsobjekt enthält. Das Ergebnis wird als boolean-Wert
	 * zurückgegeben, wobei 'true' bedeutet, dass an der Position ein Schiff ist, 
	 * und 'false', dass es kein Schiff ist.
	 * 
	 * @param zeile Die Zeile der zu überprüfenden Position auf dem Spielfeld.
	 * @param spalte Die Spalte der zu überprüfenden Position auf dem Spielfeld.
	 * @return Gibt 'true' zurück, wenn sich an der angegebenen Position ein 
	 * 		   Schiff befindet, andernfalls 'false'.
	 * 
	 * @pre GUI aktuallisiert Anzeige.
	 * @post Gibt das Ergebnis der Überprüfung zurück, ob an der angegebenen 
	 * 		 Position ein Schiff liegt.
	 * 
	 * @lastModified 11.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public boolean getType(int zeile, int spalte) {
		boolean schiff = SpielFeld[zeile][spalte] instanceof Schiffe;
		System.out.println("[Data] Schiffsfeld " + zeile + " " + spalte + ": " + schiff);
		return schiff;
	}
	
	/**
	 * @brief Überprüft, ob ein Feld getroffen wurde.
	 * 
	 * Diese Methode überprüft, ob das Feld an der angegebenen Position (Zeile und
	 * Spalte) bereits getroffen wurde. Das Ergebnis wird als boolean-Wert 
	 * zurückgegeben.
	 * 
	 * @param zeile Die Zeile der zu überprüfenden Position auf dem Spielfeld.
	 * @param spalte Die Spalte der zu überprüfenden Position auf dem Spielfeld.
	 * @return Gibt 'true' zurück, wenn das Feld bereits getroffen wurde, 
	 * 		   andernfalls 'false'.
	 * 
	 * @pre GUI aktuallisiert Anzeige.
	 * @post Gibt den Trefferstatus des Feldes zurück.
	 * 
	 * @lastModified 11.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public boolean getStatus(int zeile, int spalte) {
		boolean treffer = SpielFeld[zeile][spalte].getTreffer();
		System.out.println("[Data] Treffer Feld " + zeile + " " + spalte + ": " + treffer);
		return treffer; 
	}
	
	/**
	 * @brief Setzt einen Schuss auf das angegebene Feld und überprüft das Ergebnis.
	 * 
	 * Diese Methode registriert einen Schuss auf das angegebene Feld. Sie prüft, ob
	 * das Feld bereits getroffen wurde, und wenn nicht, wird der Trefferstatus des
	 * Feldes aktualisiert. Wenn das Feld ein Schiffsobjekt enthält, wird zusätzlich
	 * überprüft, ob das Schiff versenkt wurde. Die Anzahl der Schiffe wird 
	 * reduziert, und es wird überprüft, ob das Spiel endet.
	 * 
	 * @param zelle Die Koordinate des Feldes, auf das der Schuss abgegeben wird,
	 * 		  im Format "A-J 1-10".
	 * @return Gibt 'true' zurück, wenn der Schuss erfolgreich gesetzt wurde und das
	 * 		   Spiel weitergeht, andernfalls 'false', wenn das Spiel endet.
	 * 
	 * @throws Error Wird geworfen, wenn das Feld bereits getroffen wurde.
	 * 
	 * @pre Spieler gibt schuss auf ein Feld ab.
	 * @post Der Trefferstatus des Feldes wird aktualisiert, und wenn ein Schiff
	 * 		 getroffen wird, wird überprüft, ob es versenkt wurde und ob das Spiel
	 * 		 endet.
	 * 
	 * @lastModified 26.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public boolean setSchuss(String zelle) throws Error {
		System.out.println("[Data] Setze schuss auf " + zelle);
		
		int[] feldInt = zelleToInt(zelle);
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
			mSchiff--;
			return spielend();	
		}
		return true;
	}
	
	/**
	 * @brief Erhöht den Counter für die Treffer eines kompletten Schiffs (also alle einzelnen Schiffsteile)
	 * 
	 * Mit Hilfe der Erkenntnis, dass ein Schiff immer nur eine Breite von 1 Feld hat und beim Treffen
	 * eines Schiffsteils der Treffercount für alle Teile des jeweiligen Schiffs erhöht werden soll,
	 * werde zuerst in Schiffsrichtung alle Schiffsteile um einen Treffer erhöht, bis das Ende des Schiffs
	 * erreicht ist; und dann ausgehend vom getroffenen Feld in die entgegengesetzte Richtung des Schiffs
	 * alle restlichen Teile um einen Treffercount nach oben gesetzt (siehe versenkungsTestSchleife()).
	 * Das Ende des Schiffs wird bestimmt, indem entweder ein leeres Feld aufgerufen wird - somit die
	 * Schleife verlassen wird, oder aber (z.B. wenn ein Schiff am Rande des Spielfelds platziert ist)
	 * es kommt zu einem Fehler, wenn das Spielfeld bei einem Aufruf verlassen wird. Dieser Fehler wird
	 * dann durch den try-catch-Block abgefangen.
	 *        
	 * Somit kann danach ermittelt werden, ob alle Teile eines Schiffs getroffen wurden.
	 * 
	 * @param zeile Die Zeile der zu überprüfenden Position auf dem Spielfeld.
	 * @param spalte Die Spalte der zu überprüfenden Position auf dem Spielfeld.
	 * 
	 * @pre Ein Schiff wurde getroffen.
	 * @post Es wird überprüft, ob es versenkt wurde und ob das Spiel
	 * 		 endet.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
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
	
	/**
	 * @brief Erhöht den Counter für die Treffer jeweils Schiffsteile
	 * 
	 * Es werden für die gewünschte Richtung die jeweiligen Schiffsteile um einen Treffer erhöht.
	 * Weitere Details siehe erhoeheTrefferCount().
	 * 
	 * @param zeile Die Zeile der zu überprüfenden Position auf dem Spielfeld.
	 * @param spalte Die Spalte der zu überprüfenden Position auf dem Spielfeld.
	 * @param zeilenRichtung Die ZeilenRichtung des Schiffs (Richtungsmatrix: 1. Dimension).
	 * @param spaltenRichtung Die SpaltenRichtung des Schiffs (Richtungsmatrix: 2. Dimension).
	 * 
	 * @pre Der Treffer Count soll erhöht werden.
	 * @post Gegebenenfalls sollen noch andere Schiffsteile um ihren Treffer Counter erhöht werden.
	 *       Dann wird überprüft, ob es versenkt wurde und ob das Spiel endet.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	private void versenkungsTestSchleife(int zeile, int spalte, int zeilenRichtung, int spaltenRichtung) {
		while(SpielFeld[zeile][spalte] instanceof Schiffe) {
			((Schiffe) SpielFeld[zeile][spalte]).setAnzTreffer();
			System.out.println("[Data] erhöhe Treffer Counter Feld " + (zeile) + " " + (spalte));
			System.out.println("[Data] Anzahl Treffer: "+((Schiffe) SpielFeld[zeile][spalte]).getAnzTreffer());
			zeile += zeilenRichtung;
			spalte += spaltenRichtung;
		}
	}
	
	/**
	 * @brief Überprüft, ob ein Schiff an einer bestimmten Position versenkt wurde.
	 * 
	 * Diese Methode überprüft, ob das Schiff, das sich auf der angegebenen Zelle befindet, versenkt wurde.
	 * Dazu wird das Schiff an den übergebenen Koordinaten (Zeile, Spalte) auf dem Spielfeld geprüft.
	 * 
	 * @param zeile Die Zeilenkoordinate des Schiffs auf dem Spielfeld.
	 * @param spalte Die Spaltenkoordinate des Schiffs auf dem Spielfeld.
	 * @return Gibt 'true' zurück, wenn das Schiff auf der angegebenen Position versenkt wurde, 
	 *         andernfalls 'false'.
	 * 
	 * @pre Die Zelle an den angegebenen Koordinaten muss ein Schiffsobjekt enthalten.
	 * @post Gibt den Status des Schiffs (versenkt/nicht versenkt) an.
	 * 
	 * @lastModified 28.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */
	public boolean getVersenktGUI(int zeile, int spalte) {
		
		boolean versenkt = ((Schiffe) SpielFeld[zeile][spalte]).getVersenkt();
					
		System.out.println("[Data] Feld " + zeile + " " + spalte + " versenkt? " + versenkt);
		return versenkt;
	}

	/**
	 * @brief Überprüft, ob das Spiel beendet ist.
	 * 
	 * Diese Methode prüft, ob noch Schiffe auf dem Spielfeld vorhanden sind. Wenn 
	 * keine Schiffe mehr übrig sind ('mSchiff' ist 0), wird das Spiel als beendet 
	 * betrachtet und 'false' zurückgegeben. Andernfalls wird das Spiel fortgesetzt
	 * und 'true' zurückgegeben.
	 * 
	 * @return Gibt 'false' zurück, wenn das Spiel beendet ist (keine Schiffe mehr 
	 * 		   vorhanden), andernfalls 'true', wenn das Spiel fortgesetzt werden 
	 * 		   kann.
	 * 
	 * @pre Der Spieler hat ein erfolgreich ein Schiff getroffen
	 * @post Gibt den Status des Spiels zurück (beendet oder fortlaufend).
	 * 
	 * @lastModified 28.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	private boolean spielend() {
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
	
	/**
	 * @brief Überprüft, ob ein Spielerwechsel erforderlich ist.
	 * 
	 * Diese Methode prüft, ob alle Schiffe des aktuellen Spielers platziert wurden. 
	 * Dies wird ermittelt, indem die Anzahl der verbleibenden Schiffe für jeden 
	 * Schiffstyp summiert wird. Wenn keine Schiffe mehr übrig sind ('aSchiffe' ist 
	 * 0), wird 'true' zurückgegeben.
	 * 
	 * @return Gibt 'true' zurück, wenn ein Spielerwechsel erforderlich ist 
	 * 		   (alle Schiffe sind platziert), andernfalls 'false'.
	 * 
	 * @pre Der aktuelle Spieler soll ein Schiff setzen
	 * @post Gibt zurück, ob ein Spielerwechsel notwendig ist.
	 * 
	 * @lastModified 27.08.2024
	 * @since 11.08.2024
	 * @author Anton Unger
	 */
	public boolean spielerwechsel() {
		int aSchiffe = AnzahlSchiffe[0] + AnzahlSchiffe[1] + AnzahlSchiffe[2]
						+ AnzahlSchiffe[3];
		if(aSchiffe == 0) {	
			return true;
		}
		return false;		
	}
}
