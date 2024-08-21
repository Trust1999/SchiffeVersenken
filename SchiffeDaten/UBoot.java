package SchiffeDaten;

public class UBoot extends Schiffe{

	protected static int anzahl = 4;
	
    public UBoot() {
    	this.laenge = 2;
    	this.position = 3;
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
        this.versenkt = true;
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