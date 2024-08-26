package SchiffeDaten;

public class Schlachtschiff extends Schiffe{

	protected static int anzahl = 1;
	
    public Schlachtschiff() {
    	this.laenge = 5;
    	this.arrayPosition = 0;
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
