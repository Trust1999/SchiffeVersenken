package SchiffeDaten

public class Schlachtschiff extends Schiffe{

    private int counter = 1;
    super super treffer;
    super versenkt;
    super anzahl;
    super laenge = 2;

    public int getTreffer() {
        return treffer;
    }
    public void setTreffer(Boolean treffer) {
        this.treffer = treffer;
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
    public void setCounter() {
        counter--;
    }
}