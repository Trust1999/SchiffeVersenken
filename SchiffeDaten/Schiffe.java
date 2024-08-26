package SchiffeDaten;

public abstract class Schiffe extends Felder {

    protected int laenge;
    protected int[] richtung = new int[1];
    protected int arrayPosition;
	protected int anzTreffer = 0;
	//protected boolean versenkt;
    
	public abstract int getLaenge();
	public abstract int[] getRichtung();
	public abstract void setRichtung(int[] ausrichtung);
	
	public abstract int getArrayPosition();
	
	public abstract int getAnzTreffer();
	public abstract void setAnzTreffer();
	
	//public abstract void setVersenkt(boolean b);
}
