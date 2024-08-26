package SchiffeDaten;

public abstract class Felder {

	protected boolean treffer = false;
	protected boolean versenkt = false;
	
	public abstract void setTreffer();
	public abstract boolean getTreffer();
}
