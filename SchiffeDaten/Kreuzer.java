package SchiffeDaten;

public class Kreuzer extends Schiffe{
	// TODO Konsolen Ausgabe in allen Klassen und Methoden anpassen, siehe unten.
	protected static int anzahl = 2;
	
	public Kreuzer() {
		this.laenge = 4;
		this.arrayPosition = 1;
	}
	 
    public boolean getTreffer() {
        System.out.println("[Kreuzer] Treffer " + treffer);
    	return treffer;
    }
 
    public void setTreffer() {
		System.out.println("[Kreuzer] Treffer gesetzt");
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