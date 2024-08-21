package SchiffeDaten;

public abstract class Felder {

	protected Boolean treffer = false;
	protected Boolean versenkt = false;
	
	protected abstract void setTreffer();
	protected abstract Boolean getTreffer();
	protected abstract Boolean getVersenkt();
}
