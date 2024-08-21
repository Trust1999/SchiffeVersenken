package SchiffeDaten;

public abstract class Schiffe extends Felder {

    //protected static int anzahl;
    protected int laenge;
    protected int mengeSchiffe = 5 + 8 + 9 + 8; //erstmal tote Leiche
    protected int position;
	protected int anzTreffer = 0;
	//protected boolean versenkt = versenkungCheck();
    
	protected abstract int getAnzahl();
	protected abstract int getLaenge();
	protected abstract void setAnzahl();
	protected abstract int getMengeSchiffe();
	/*protected abstract boolean versenkungCheck() {
		return (anzTreffer == laenge);
	}*/
	protected abstract int getPosition();
}
