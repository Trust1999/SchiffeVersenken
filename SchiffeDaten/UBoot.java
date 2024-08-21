package SchiffeDaten;

public class UBoot extends Schiffe{

    public UBoot() {
    	this.anzahl = 4;
    	this.laenge = 2;
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