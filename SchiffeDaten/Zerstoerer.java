package SchiffeDaten;

public class Zerstoerer extends Schiffe{

	protected static int anzahl = 3;
	
	public Zerstoerer() {
	    this.laenge = 3;
	    this.position = 2;
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
    }
    
    protected int getMengeSchiffe() {
		return mengeSchiffe;
	}
    
    protected int getPosition() {
		return position;
	}
}