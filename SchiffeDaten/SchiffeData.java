package SchiffeDaten;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SchiffeData {

	private Felder[][] SpielFeld;

	public SchiffeData() {
		SpielFeld = new Felder[10][10];
		for(int z = 0; z <= 9; z++) {
			for(int s = 0; s <= 9; s++) {
				SpielFeld[z][s] = new NormalFeld();
			}
		}
	}
	
	public void setSchiff(String Schiff, String Richtung, String Zelle) {
		Felder schiff = SchiffType(Schiff);
		int[] richungsMatrix = RichtungToInt(Richtung);
		int[] feldInt = ZelleToInt(Zelle);
		
		if(FreieFelder(schiff, richungsMatrix, feldInt )) {
			if(schiff.getCounter > 0) {
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
	
	private Felder SchiffType(String s) {
		switch(s) {
		case "Schlachtschiff (5 Kästchen)": return new Schlachtschiff();
		case "Kreuzer (4 Kästchen)": return new Kreuzer();
		case "Zerstörer (3 Kästchen)": return new Zerstoerer();
		case "U-Boot (2 Kästchen)": return new UBoot();
		default: return null;
		}
	}
	
	private int[] RichtungToInt(String richtung) {
		switch (richtung) {
	        case "Norden": return new int[]{1, 0};
	        case "Osten": return new int[]{0, 1};
	        case "Süden": return new int[]{-1, 0};
	        case "Westen": return new int[]{0, -1};
	        default: throw new IllegalArgumentException("Ungültige Richtung: " + richtung);
	    }
	}
	
	private int[] ZelleToInt(String feld) {
		int[] zelle = {0,0};
		StringTokenizer input = new StringTokenizer(feld);
	    String start = input.nextToken();

	    char startChar = start.charAt(0);
	    if (startChar < 'A' || startChar > 'J') {
	          throw new Error();
	    }
	    zelle[0] = startChar - 'A';

	    zelle[1] = Integer.parseInt(start.substring(1)) - 1;
	    if (zelle[1] < 0 || zelle[1] > 10) {
	         throw new Error();
	    }

	    return zelle;
	}
	
	private boolean FreieFelder(Felder schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			if(!(SpielFeld[zeile][spalte] instanceof NormalFeld)) {
				return false;
			}
			else {
				zeile = zeile + r[0];
				spalte = spalte + r[1];
			}
		}
		return true;
	}
	
	private void SchiffSetzen(Felder schiff, int[] r, int[] f) {
		int zeile = f[0];
		int spalte = f[1];
		
		for(int i = 1; i <= schiff.getLaenge(); i++) {
			DummyFelder(zeile, spalte);
			//TODO 
			SpielFeld[zeile][spalte] = ;
			zeile = zeile + r[0];
			spalte = spalte + r[1];
		}
		schiff.setCounter();
	}

	private void DummyFelder(int z, int s) {
		if(!(z-1 < 0) && SpielFeld[z][s] instanceof NormalFeld) 
			SpielFeld[z-1][s] = BelegtesFeld();
		if(!(z+1 > 9) && SpielFeld[z][s] instanceof NormalFeld)
			SpielFeld[z+1][s] = BelegtesFeld();
		if(!(s-1 < 0) && SpielFeld[z][s] instanceof NormalFeld)
			SpielFeld[z][s-1] = BelegtesFeld();
		if(!(s+1 > 9) && SpielFeld[z][s] instanceof NormalFeld)
			SpielFeld[z][s+1] = BelegtesFeld();
	}

	public boolean getVersenkt(int zeile, int spalte) {
		System.out.println("[Data] Schuss Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte].getVersenkt();
	}
	
	public boolean getType(int zeile, int spalte) {
		System.out.println("[Data] Type Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte] ;
	}
	
	public boolean getStatus(int zeile, int spalte) {
		System.out.println("[Data] Status Felde " + zeile + " " + spalte);
		return SpielFeld[zeile][spalte].getStatus();
	}
	
	public void setSchuss(String Zelle) {
		int[] feldInt = ZelleToInt(Zelle);
		int zeile = feldInt[0];
		int spalte = feldInt[1];
		SpielFeld[zeile][spalte].setSchuss();
	}
}


