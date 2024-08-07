package SchiffeDaten;

import java.util.ArrayList;

public class SchiffeData {

	private Felder[][] Feld = new Felder[10][10]; 

	public void setSchiff(String Schiff, String Richtung, String Feld) {
		//Feld[zeile][spalte] = new Felder();
	}
	
	public boolean getSchuss(int zeile, int spalte) {
		return Feld[zeile][spalte].getZustand();	
	}
	
}


