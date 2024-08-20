package SchiffeDaten;

public class Schlachtschiff extends Schiffe{

    public Schlachtschiff() {
    	this.anzahl = 1;
    	this.laenge = 5;
    }
    

    public Boolean getTreffer() {
        return treffer;
    }
    public void setTreffer() {
        this.treffer = true;
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