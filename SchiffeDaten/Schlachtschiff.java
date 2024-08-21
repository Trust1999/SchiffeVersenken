package SchiffeDaten;

public class Schlachtschiff extends Schiffe{

	protected static int anzahl = 1;
	
    public Schlachtschiff() {
    	//Schlachtschiff.anzahl = 1;
    	this.laenge = 5;
    	this.position = 0;
    }
    

    public Boolean getTreffer() {
        return treffer;
    }
    public void setTreffer() {
        this.treffer = true;
        this.anzTreffer++;
        mengeSchiffe--;
    }
    public Boolean getVersenkt() {
        return versenkt;
    }
    public void setVersenkt() {
        this.versenkt = versenkt;
    }

    public int getLaenge() {
        return laenge;
    }
    public int getAnzahl() {
        return anzahl;
    }
    public void setAnzahl() {
        anzahl--;
        System.out.println("[Schlachtschiff] Anzahl: " + Schlachtschiff.anzahl);
    }
    
    protected int getMengeSchiffe() {
		return mengeSchiffe;
	}
    
    protected int getPosition() {
		return position;
	}
}
