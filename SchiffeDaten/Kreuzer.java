package SchiffeDaten;

public class Kreuzer extends Schiffe{
	
	public Kreuzer() {
		this.anzahl = 2;
		this.laenge = 4; 
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