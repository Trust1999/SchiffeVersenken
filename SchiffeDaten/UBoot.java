package SchiffeDaten;

public class UBoot extends Schiffe{

	protected static int anzahl = 4;
	
    public UBoot() {
    	this.laenge = 2;
    	this.position = 3;
    }
    

    public boolean getTreffer() {
        return treffer;
    }
    public void setTreffer() {
        this.treffer = true;
        mengeSchiffe--;
    }
    public boolean getVersenkt() {
        return versenkt;
    }
    public void setVersenkt(boolean wahrheitswert) {
        this.versenkt = wahrheitswert;
    }

    public int getLaenge() {
        return laenge;
    }
    
/*    public int getSchiffsNummer() {
    	return schiffsNummer;
    }
	public void setSchiffsNummer(int n) {
		this.schiffsNummer = n;
	}*/

	public int[] getRichtung() {
		return richtung;
	}
	public void setRichtung(int[] ausrichtung) {
		this.richtung = ausrichtung;
	}
	
    public int getAnzTreffer() {
        return anzTreffer;
    }
    public void setAnzTreffer() {
    	this.anzTreffer++;
    }
    
    public int getAnzahl() {
        return anzahl;
    }
    public void setAnzahl() {
        anzahl--;
    }
    
    public int getMengeSchiffe() {
		return mengeSchiffe;
	}
    
    public int getPosition() {
		return position;
	}
}