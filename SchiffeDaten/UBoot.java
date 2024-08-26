package SchiffeDaten;

public class UBoot extends Schiffe{

	protected static int anzahl = 4;
	
    public UBoot() {
    	this.laenge = 2;
    	this.arrayPosition = 3;
    }
    
    public boolean getTreffer() {
        return treffer;
    }
 
    public void setTreffer() {
		treffer = true;
	}
    
    public int getLaenge() {
        return laenge;
    }
    
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
    
    public int getArrayPosition() {
		return arrayPosition;
	}
}