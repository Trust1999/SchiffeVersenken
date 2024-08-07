package SchiffeVersenken;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenken {

	private SchiffeVersenkenGUI view;
	private SchiffeData data;
	
	public SchiffeVersenken() {
		data = new SchiffeData();
		view = new SchiffeVersenkenGUI(data);
	}
	
	public static void main(String[] args) {
		
		SchiffeVersenken notebook = new SchiffeVersenken();
		notebook.view.setVisible(true);
	}

}
