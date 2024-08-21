package SchiffeDaten;

public class Zerstoerer extends Schiffe{

	public Zerstoerer() {
	    this.anzahl = 3;
	    this.laenge = 3;	
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
}