package SchiffeDaten;

public class FreiesFeld extends Felder {
	
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