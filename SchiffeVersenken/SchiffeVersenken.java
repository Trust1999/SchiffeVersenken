package SchiffeVersenken;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenken {

	private SchiffeVersenkenGUI view;
	//zweimal SchiffeData für zwei Spieler
	private SchiffeData data1;
	private SchiffeData data2;
	
	/**
	 * @brief Konstruktor der Klasse SchiffeVersenken
	 * 
	 * erstellt zwei neue Datas für die zwei Spieler sowie eine view, 
	 * welche sich auf die Datas bezieht.
	 * 
	 * @since 07.08.2024
	 * @author Kiara Schunk
	 */
	public SchiffeVersenken() {
		data1 = new SchiffeData();
		data2 = new SchiffeData();
		view = new SchiffeVersenkenGUI(data1, data2);
	}
	
	/**
	 * @brief Main-Funktion
	 * 
	 * Die Main-Klasse die das SchiffeVersenken-Spiel startet. Es wird erst eine Instanz des 
	 * SchiffeVersenken-Spiels erstellt und darauf wird die Spiel-View auf sichtbar gesetzt.
	 * 
	 * @param args Kommandozeilenargumente, die beim Start des Programms übergeben werden
	 * 
	 * @since 07.08.2024
	 * @author Kiara Schunk
	 */
	public static void main(String[] args) {
		SchiffeVersenken schiffeVersenkenSpiel = new SchiffeVersenken();
		schiffeVersenkenSpiel.view.setVisible(true);
	}
}