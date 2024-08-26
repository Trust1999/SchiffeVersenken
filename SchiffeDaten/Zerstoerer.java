package SchiffeDaten;

public class Zerstoerer extends Schiffe{

	protected static int anzahl = 3;
	
	public Zerstoerer() {
	    this.laenge = 3;
	    this.arrayPosition = 2;
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