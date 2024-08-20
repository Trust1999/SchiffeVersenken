package SchiffeDaten;

public abstract class Schiffe extends Felder {

    protected int anzahl;
    protected int laenge;
    protected int mengeSchiffe = 5 + 8 + 9 + 8;
    
	protected abstract int getAnzahl();
	protected abstract int getLaenge();
	protected abstract void setAnzahl();
	protected abstract int getMengeSchiffe();
}
