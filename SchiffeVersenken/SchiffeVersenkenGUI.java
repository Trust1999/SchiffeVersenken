/*
 * TODO
 * mehrere Tabbelen (statt einer)
 */

package SchiffeVersenken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenkenGUI extends JFrame {
	
	private SchiffeData spieler1;
	private SchiffeData spieler2;
	private JTextArea spielfeldTextArea;
	private JLabel infoLabel;
	private JTextField feld;
	
	private JTable tabelle;
	private String[] header = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private String[][] datenMatrix = {
			{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
	} ; //Zwischenspeicher/Cache
	
	// Panel1 - Spielfeld1
	private JPanel p1;
	
	// Panel2 - Log
	private JPanel p2;
	
	// Panel3 - Spielfeld2
	private JPanel p3;
	
	// Panel4 - Leer
	private JPanel p4;
	
	// Panel5 - Schuss
	private JPanel p5;
	private JButton schussButton;
	
	// Panel6 - Leer
	private JPanel p6;
	
	// Panel7 - Notizfeld1
	private JPanel p7;
	
	// Panel8 - Setzen
	private JPanel p8;
	private JComboBox ComboBox;
	private String[] schiffart = {"Schlachtschiff (5 Kästchen)","Kreuzer (4 Kästchen)",
									"Zerstörer (3 Kästchen)","U-Boot (2 Kästchen)"};
	private String[] richtungen = {"Norden","Osten","Süden","Westen"};
	private JButton setzenButton;
	
	// Panel9 - Notizfeld2
	private JPanel p9;
	
	public SchiffeVersenkenGUI (SchiffeData d) {
		
		this.spieler1= d;	
		this.spieler2= d;
		
		// JFrame-Konfiguration
		this.setLayout(new GridLayout(3, 3));
		this.setTitle("Schiffe Versenken (2 Spieler)");
		this.setSize(1500,780);
		this.setLocation(20,30);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panels (3 Spalten, 3 Zeilen)
		p1 = new JPanel();
		p1.setLayout(null);

		p2 = new JPanel();
		p2.setLayout(null);
		
		p3 = new JPanel();
		p3.setLayout(null);
		
		p4 = new JPanel();
		p4.setLayout(null);
		
		p5 = new JPanel();
		p5.setLayout(null);
		
		p6 = new JPanel();
		p6.setLayout(null);
		
		p7 = new JPanel();
		p7.setLayout(null);
		
		p8 = new JPanel();
		p8.setLayout(null);
		
		p9 = new JPanel();
		p9.setLayout(null);

		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.add(p9);
		
		//P1-Spielfeld1
		p1.setBackground(Color.CYAN);
		infoLabel = new JLabel("Spieler1:");
		infoLabel.setBounds(30, 10, 50, 20);
		p1.add(infoLabel);
		
		infoLabel = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		infoLabel.setBounds(50, 30, 200, 20);
		p1.add(infoLabel);
		
		infoLabel = new JLabel("1");
		infoLabel.setBounds(40, 46, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("2");
		infoLabel.setBounds(40, 63, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("3");
		infoLabel.setBounds(40, 79, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("4");
		infoLabel.setBounds(40, 94, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("5");
		infoLabel.setBounds(40, 110, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("6");
		infoLabel.setBounds(40, 126, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("7");
		infoLabel.setBounds(40, 142, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("8");
		infoLabel.setBounds(40, 158, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("9");
		infoLabel.setBounds(40, 174, 20, 20);
		p1.add(infoLabel);
		infoLabel = new JLabel("10");
		infoLabel.setBounds(34, 191, 20, 20);
		p1.add(infoLabel);
		
		datenMatrix = new String[10][10]; // 10x10 Matrix + Kopf und Seite
		tabelle = new JTable(datenMatrix, header);
		tabelle.setBounds(50, 50, 150, 160);
		p1.add(tabelle, BorderLayout.CENTER);
		
		//P2-Log
		p2.setBackground(Color.CYAN);
		infoLabel = new JLabel("Log:");
		infoLabel.setBounds(30, 1, 50, 20);
		p2.add(infoLabel);

		feld = new JTextField(null);
		feld.setBounds(30, 20, 300, 210);
		p2.add(feld);
		
		//P3-Spielfeld2
		p3.setBackground(Color.CYAN);
		infoLabel = new JLabel("Spieler2:");
		infoLabel.setBounds(30, 1, 50, 20);
		p3.add(infoLabel);

		infoLabel = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		infoLabel.setBounds(50, 30, 200, 20);
		p3.add(infoLabel);
		
		infoLabel = new JLabel("1");
		infoLabel.setBounds(40, 46, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("2");
		infoLabel.setBounds(40, 63, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("3");
		infoLabel.setBounds(40, 79, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("4");
		infoLabel.setBounds(40, 94, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("5");
		infoLabel.setBounds(40, 110, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("6");
		infoLabel.setBounds(40, 126, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("7");
		infoLabel.setBounds(40, 142, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("8");
		infoLabel.setBounds(40, 158, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("9");
		infoLabel.setBounds(40, 174, 20, 20);
		p3.add(infoLabel);
		infoLabel = new JLabel("10");
		infoLabel.setBounds(34, 191, 20, 20);
		p3.add(infoLabel);
		
		datenMatrix = new String[10][10]; // 10x10 Matrix + Kopf und Seite
		tabelle = new JTable(datenMatrix, header);
		tabelle.setBounds(50, 50, 150, 160);
		p3.add(tabelle, BorderLayout.CENTER);
		
		//P4-Leer
		p4.setBackground(Color.CYAN);
		
		//P5-Schuss
		p5.setBackground(Color.CYAN);
		infoLabel = new JLabel("Schuss:");
		infoLabel.setBounds(30, 1, 50, 20);
		p5.add(infoLabel);
		infoLabel = new JLabel("Schuss in der Form Großbuchstabe-Zahl angeben:");
		infoLabel.setBounds(30, 20, 500, 20);
		p5.add(infoLabel);
		
		feld = new JTextField(null);
		feld.setBounds(30, 50, 300, 100);
		p5.add(feld);
		
		schussButton = new JButton("Schuss");
		schussButton.setBounds(30, 170, 300, 60);
		p5.add(schussButton);
		schussButton.addActionListener(e -> test());
		
		
		//P6-Leer
		p6.setBackground(Color.decode("#98EAE9"));
		
		//P7-Notizen1
		p7.setBackground(Color.CYAN);
		infoLabel = new JLabel("Notizen1:");
		infoLabel.setBounds(30, 1, 60, 20);
		p7.add(infoLabel);
		
		infoLabel = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		infoLabel.setBounds(50, 30, 200, 20);
		p7.add(infoLabel);
		
		infoLabel = new JLabel("1");
		infoLabel.setBounds(40, 46, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("2");
		infoLabel.setBounds(40, 63, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("3");
		infoLabel.setBounds(40, 79, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("4");
		infoLabel.setBounds(40, 94, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("5");
		infoLabel.setBounds(40, 110, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("6");
		infoLabel.setBounds(40, 126, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("7");
		infoLabel.setBounds(40, 142, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("8");
		infoLabel.setBounds(40, 158, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("9");
		infoLabel.setBounds(40, 174, 20, 20);
		p7.add(infoLabel);
		infoLabel = new JLabel("10");
		infoLabel.setBounds(34, 191, 20, 20);
		p7.add(infoLabel);
		
		datenMatrix = new String[10][10]; // 10x10 Matrix + Kopf und Seite
		tabelle = new JTable(datenMatrix, header);
		tabelle.setBounds(50, 50, 150, 160);
		p7.add(tabelle, BorderLayout.CENTER);
		
		//P8-Setzen
		p8.setBackground(Color.CYAN);
		infoLabel = new JLabel("Setzen:");
		infoLabel.setBounds(30, 1, 50, 20);
		p8.add(infoLabel);
		
		ComboBox = new JComboBox<String>(schiffart);
		ComboBox.setBounds(30, 30, 300, 60);
		p8.add(ComboBox);
		ComboBox = new JComboBox<String>(richtungen);
		ComboBox.setBounds(30, 100, 300, 60);
		p8.add(ComboBox);
		
		setzenButton = new JButton("Setzen");
		setzenButton.setBounds(30, 170, 300, 60);
		p8.add(setzenButton);
		setzenButton.addActionListener(e -> setzen());
		
		//P9-Notizen2
		p9.setBackground(Color.CYAN);
		infoLabel = new JLabel("Notizen2:");
		infoLabel.setBounds(30, 1, 60, 20);
		p9.add(infoLabel);
		
		infoLabel = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		infoLabel.setBounds(50, 30, 200, 20);
		p9.add(infoLabel);
		
		infoLabel = new JLabel("1");
		infoLabel.setBounds(40, 46, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("2");
		infoLabel.setBounds(40, 63, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("3");
		infoLabel.setBounds(40, 79, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("4");
		infoLabel.setBounds(40, 94, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("5");
		infoLabel.setBounds(40, 110, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("6");
		infoLabel.setBounds(40, 126, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("7");
		infoLabel.setBounds(40, 142, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("8");
		infoLabel.setBounds(40, 158, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("9");
		infoLabel.setBounds(40, 174, 20, 20);
		p9.add(infoLabel);
		infoLabel = new JLabel("10");
		infoLabel.setBounds(34, 191, 20, 20);
		p9.add(infoLabel);
		
		datenMatrix = new String[10][10]; // 10x10 Matrix + Kopf und Seite
		tabelle = new JTable(datenMatrix, header);
		tabelle.setBounds(50, 50, 150, 160);
		p9.add(tabelle, BorderLayout.CENTER);
	}

	private void setzen() {
		//Auslesen Schiff, Richtung, Feld(noch hinzufügen!!!!)
		spieler1.setSchiff();
		//Tabelle aktualisieren
	}

	private void test() {
	//for Zeile,Spalte	
		if(spieler1.getSchuss(0, 0)) {	// .getSchuss(int, int)-->boolean True = treffer
			//spieler1/2.getType(0,0,) --> (Feldtype)-->boolean True=Schiff
		}
		else {
			//spieler1/2.getType(0,0,) --> (Feldtype)-->boolean True=Schiff
		}
	}
}
	

