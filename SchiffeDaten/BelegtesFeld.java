package SchiffeDaten;

public class BelegtesFeld extends Felder { 

	public Boolean getTreffer() {
		return treffer;
	}

	public void setTreffer() {
		this.treffer = true;
	}
	
	protected Boolean getVersenkt() {
		return versenkt;
	}
}