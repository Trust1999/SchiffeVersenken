package SchiffeDaten;

public class BelegtesFeld extends Felder { 

	public boolean getTreffer() {
		return treffer;
	}

	public void setTreffer() {
		this.treffer = true;
	}
	
	public boolean getVersenkt() {
		return versenkt;
	}

	public int[] getRichtung() {
		return null;
	}

	@Override
	public int getAnzTreffer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLaenge() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void setVersenkt(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnzTreffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRichtung(int[] r) {
		// TODO Auto-generated method stub
		
	}
}