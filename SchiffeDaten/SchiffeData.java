package SchiffeDaten;

import java.util.StringTokenizer;

public class SchiffeData {

	private Felder[][] SpielFeld;

	public SchiffeData() {
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
				throw new Exception("kein Schiff mehr frei");
			}
		}
		else {
			throw new Exception("mindestens ein Feld ist belegt");
		}
	}
	
	private Schiffe SchiffType(String s) {
		switch(s) {
		case "Schlachtschiff (5 Kästchen)": return new Schlachtschiff();
		case "Kreuzer (4 Kästchen)": return new Kreuzer();
		case "Zerstörer (3 Kästchen)": return new Zerstoerer();
		case "U-Boot (2 Kästchen)": return new UBoot();
		default: return null;
		}
	}
	
	private int[] RichtungToInt(String richtung) throws Exception {
		switch (richtung) {
	        case "Norden": return new int[]{1, 0};
	        case "Osten": return new int[]{0, 1};
	        case "Süden": return new int[]{-1, 0};
	        case "Westen": return new int[]{0, -1};
	        default: throw new Exception("Ungültige Richtung: " + richtung);
	    }
	}
	
	private int[] ZelleToInt(String f) throws Exception {
		int[] zelle = {0,0};
		StringTokenizer input = new StringTokenizer(f);
	    String feld = input.nextToken();

	    char feldChar = feld.charAt(0);
	    if (feldChar < 'A' || feldChar > 'J') {
	          throw new Exception(feldChar + " außerhalb der Range");
	    }
	    zelle[0] = feldChar - 'A';

	    zelle[1] = Integer.parseInt(feld.substring(1)) - 1;
	    if (zelle[1] < 0 || zelle[1] > 10) {
	         throw new Exception(zelle[1] + " außerhalb der Range");
	    }

	    return zelle;
	}
	
	private boolean FreieFelder(Schiffe schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(!(SpielFeld[zeile][spalte] instanceof FreiesFeld)) {
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
		schiff.setAnzahl();
	}

	private void DummyFelder(int z, int s) {
		if(!(z-1 < 0) && SpielFeld[z][s] instanceof FreiesFeld) 
			SpielFeld[z-1][s] = new BelegtesFeld();
		if(!(z+1 > 9) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z+1][s] = new BelegtesFeld();
		if(!(s-1 < 0) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z][s-1] = new BelegtesFeld();
		if(!(s+1 > 9) && SpielFeld[z][s] instanceof FreiesFeld)
			SpielFeld[z][s+1] = new BelegtesFeld();
	}

	public boolean getVersenkt(int zeile, int spalte) {
		System.out.println("[Data] Schuss Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte].getVersenkt();
	}
	
	public boolean getType(int zeile, int spalte) {
		System.out.println("[Data] Type Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte] instanceof Schiffe ;
	}
	
	public boolean getStatus(int zeile, int spalte) {
		System.out.println("[Data] Status Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte].getTreffer();
	}
	
	public boolean setSchuss(String Zelle) throws Exception {
		int[] feldInt = ZelleToInt(Zelle);
		int zeile = feldInt[0];
		int spalte = feldInt[1];
		if(SpielFeld[zeile][spalte].getTreffer()) {
			throw new Exception("Feld wurde schon beschossen");
		}
		SpielFeld[zeile][spalte].setTreffer();
		return Spielend(zeile, spalte);
	}

	private boolean Spielend(int zeile, int spalte) {
		if(((Schiffe) SpielFeld[zeile][spalte]).getMengeSchiffe() == 0) {
			return true;
		}
		else {
			return false;
		}	
	}
}
