package SchiffeDaten;

public abstract class Schiffe extends Felder {

    //protected static int anzahl;
    protected int laenge;
    protected int mengeSchiffe = 5 + 8 + 9 + 8; //erstmal tote Leiche
    //protected int schiffsNummer = 0;
    protected int[] richtung = new int[1];
    protected int position;
	protected int anzTreffer = 0;
	protected boolean versenkt;
    
	public abstract int getAnzahl();
	public abstract void setAnzahl();
	public abstract int getLaenge();
//	public abstract int getSchiffsNummer();
//	public abstract void setSchiffsNummer(int n);
	public abstract int[] getRichtung();
	public abstract void setRichtung(int[] ausrichtung);
	public abstract int getMengeSchiffe();
	
	public abstract int getPosition();
	public abstract void setTreffer();
	public abstract boolean getVersenkt();
}
