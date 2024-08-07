package SchiffeVersenken;

public class SchiffeVersenken {

	private SchiffeVersenkenGUI view;
	private SchiffeVersenkenData data;
	
	public SchiffeVersenken() {
		data = new SchiffeVersenkenData();
		view = new SchiffeVersenkenGUI(data);
	}
	
	public static void main(String[] args) {
		
		SchiffeVersenken notebook = new SchiffeVersenken();
		notebook.view.setVisible(true);
	}

}
