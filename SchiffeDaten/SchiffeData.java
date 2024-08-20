package SchiffeDaten;

import java.util.StringTokenizer;

public class SchiffeData {

	private Felder[][] SpielFeld;

	public SchiffeData() {
		System.out.println("[Data] Spielfeld wird gefühlt");
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
			if( schiff.getAnzahl() > 0) {
				SchiffSetzen(schiff, richungsMatrix, feldInt);
			}
			else {
				System.out.println("[Data] Schiff nicht mehr vorhanden");
				throw new Exception("kein Schiff mehr frei");
			}
		}
		else {
			throw new Exception("mindestens ein Feld ist belegt");
		}
	}
	
	private Schiffe SchiffType(String s) {
		switch(s) {
		case "Schlachtschiff (5 Kästchen)": 
			System.out.println("[Data] Schlachtschiff wird erstellt");
			return new Schlachtschiff();
		case "Kreuzer (4 Kästchen)":
			System.out.println("[Data] Kreuzer wird erstellt");
			return new Kreuzer();
		case "Zerstörer (3 Kästchen)":
			System.out.println("[Data] Zerstörer wird erstellt");
			return new Zerstoerer();
		case "U-Boot (2 Kästchen)":
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
	        	return new int[]{1, 0};
	        case "Osten": 
	        	System.out.println("[Data] Richtungsmatrix Osten: {0, 1}");
	        	return new int[]{0, 1};
	        case "Süden": 
	        	System.out.println("[Data] Richtungsmatrix Süden: {-1, 0}");
	        	return new int[]{-1, 0};
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
		StringTokenizer input = new StringTokenizer(f);
	    String feld = input.nextToken();

	    char feldChar = feld.charAt(0);
	    if (feldChar < 'A' || feldChar > 'J') {
	    	System.out.println("[Data] " + feldChar + " nicht in Range A-J");
	        throw new Exception(feldChar + " außerhalb der Range");
	    }
	    zelle[0] = feldChar - 'A';
	    System.out.println("[Data] Zeile in Int: " + zelle[0]);
	    
	    zelle[1] = Integer.parseInt(feld.substring(1)) - 1;
	    if (zelle[1] < 0 || zelle[1] > 10) {
	    	System.out.println("[Data] " + zelle[1] + " nicht in Range A-J");
	         throw new Exception(zelle[1] + " außerhalb der Range");
	    }
	    System.out.println("[Data] Spalte in Int: " + zelle[1]);
	    
	    return zelle;
	}
	
	private boolean FreieFelder(Schiffe schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(!(SpielFeld[zeile][spalte] instanceof FreiesFeld)) {
				System.out.println("[Data] Feld "+ zeile + spalte + " ist belegt");
				return false;
			}
			else {
				zeile = zeile + r[0];
				spalte = spalte + r[1];
			}
		}
		return true;
	}
	
	private void SchiffSetzen(Schiffe schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			DummyFelder(zeile, spalte);
			SpielFeld[zeile][spalte] = schiff;
			zeile = zeile + r[0];
			spalte = spalte + r[1];
		}
		System.out.println("[Data] Schiff gesetzt");
		schiff.setAnzahl();
	}

	private void DummyFelder(int z, int s) {
		if(!(z-1 < 0) && SpielFeld[z][s] instanceof FreiesFeld) 
			SpielFeld[z-1][s] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + (z-1) + s);
		if(!(z+1 > 9) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z+1][s] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + (z+1) + s);
		if(!(s-1 < 0) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z][s-1] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + z + (s-1));
		if(!(s+1 > 9) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z][s+1] = new BelegtesFeld();
			System.out.println("[Data] DummyFeld gesetzt: " + z + (s+1));
	}

	public boolean getVersenkt(int zeile, int spalte) {
		boolean versenkt = SpielFeld[zeile][spalte].getVersenkt();
		System.out.println("[Data] Versenktes Felde " + zeile + " " + spalte + ": " + versenkt);
		return versenkt;
	}
	
	public boolean getType(int zeile, int spalte) {
		boolean schiff = SpielFeld[zeile][spalte] instanceof Schiffe;
		System.out.println("[Data] Schiffsfeld" + zeile + " " + spalte + ": " + schiff);
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
		else {
			System.out.println("[Data] Feld  getroffen");
			SpielFeld[zeile][spalte].setTreffer();
			return Spielend(zeile, spalte);	
		}
	}

	private boolean Spielend(int zeile, int spalte) {
		int mengeSchiffe = ((Schiffe) SpielFeld[zeile][spalte]).getMengeSchiffe();
		System.out.println("[Data] Noch vorhandene Schiffe: " + mengeSchiffe);
		if(mengeSchiffe == 0) {
			System.out.println("[Data] Spielende");
			return true;
		}
		else {
			System.out.println("[Data] kein Spielende");
			return false;
		}	
	}
}
