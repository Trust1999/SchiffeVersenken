package SchiffeVersenken;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenken {

	private SchiffeVersenkenGUI view;
	private SchiffeData data1;
	private SchiffeData data2;
	
	public SchiffeVersenken() {
		data1 = new SchiffeData();
		data2 = new SchiffeData();
		view = new SchiffeVersenkenGUI(data1, data2);
	}
	
	public static void main(String[] args) {
		
		SchiffeVersenken notebook = new SchiffeVersenken();
		notebook.view.setVisible(true);
	}

}
