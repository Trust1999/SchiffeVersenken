package SchiffeDaten;

public abstract class Felder {

	protected boolean treffer = false;
	protected boolean versenkt = false;
	
	public abstract void setTreffer();
	public abstract boolean getTreffer();
	public abstract boolean getVersenkt();
	public abstract int getAnzTreffer();
	public abstract int getLaenge();
	public abstract void setVersenkt(boolean b);
	public abstract int[] getRichtung();
	public abstract void setAnzTreffer();
	public abstract void setRichtung(int[] r);
}
