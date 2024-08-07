package SchiffeDaten;

import java.util.ArrayList;

public class SchiffeData {

	private Felder[][] Feld = new Felder[10][10]; 

	public void setSchiffe(int zeile, int spalte) {
		Feld[zeile][spalte] = new Felder();
	}
	
	public boolean getSchuss(int zeile, int spalte) {
		return Feld[zeile][spalte].getZustand();	
	}
}


