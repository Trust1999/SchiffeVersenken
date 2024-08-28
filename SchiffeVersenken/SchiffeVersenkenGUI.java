package SchiffeVersenken;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import SchiffeDaten.SchiffeData;

public class SchiffeVersenkenGUI extends JFrame {

	Random zufall = new Random();
	private int werSpielt = zufall.nextInt(2);
	
	private SchiffeData spieler1;
	private SchiffeData spieler2;
	
	private JLabel infoLabel;
	private String[] header = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	
	private int anzahl = 0;
	private boolean debug = false;
	
	// Panel1 - Spielfeld1
	private JPanel p1;
	private JLabel labels1;
	private JLabel xachses1;
	private JLabel yachses1_1;
	private JLabel yachses1_2;
	private JLabel yachses1_3;
	private JLabel yachses1_4;
	private JLabel yachses1_5;
	private JLabel yachses1_6;
	private JLabel yachses1_7;
	private JLabel yachses1_8;
	private JLabel yachses1_9;
	private JLabel yachses1_10;
	private JTable tabellespieler1;
	private String[][] datenMatrixs1 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}};
	private JTextArea schirm1;
	
	// Panel2 - Legende
	private JPanel p2;
	private JTextArea legendeTextArea;
	private JButton debug_modusAn;
	private JButton debug_modusAus;
	
	// Panel3 - Spielfeld2
	private JPanel p3;
	private JLabel labels2;
	private JLabel xachses2;
	private JLabel yachses2_1;
	private JLabel yachses2_2;
	private JLabel yachses2_3;
	private JLabel yachses2_4;
	private JLabel yachses2_5;
	private JLabel yachses2_6;
	private JLabel yachses2_7;
	private JLabel yachses2_8;
	private JLabel yachses2_9;
	private JLabel yachses2_10;
	private JTable tabellespieler2;
	private String[][] datenMatrixs2 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}};
	private JTextArea schirm4;
	
	// Panel4 - Leer
	private JPanel p4;
	private JTextArea schirm2;
	
	// Panel5 - Schuss
	private JPanel p5;
	private JTextField eingabeschuss;
	private JButton schussButton;
	
	// Panel6 - Leer
	private JPanel p6;
	private JTextArea schirm5;
	
	// Panel7 - Notizfeld1
	private JPanel p7;
	private JLabel labeln1;
	private JLabel xachsen1;
	private JLabel yachsen1_1;
	private JLabel yachsen1_2;
	private JLabel yachsen1_3;
	private JLabel yachsen1_4;
	private JLabel yachsen1_5;
	private JLabel yachsen1_6;
	private JLabel yachsen1_7;
	private JLabel yachsen1_8;
	private JLabel yachsen1_9;
	private JLabel yachsen1_10;
	private JTable tabellenotizen1;
	private String[][] datenMatrixn1 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}};
	private JTextArea schirm3;
	
	// Panel8 - Setzen
	private JPanel p8;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSchiff;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxRichtung;
	private String[] schiffart = {"Schlachtschiff (5 Kästchen) [1 Stück]","Kreuzer (4 Kästchen) [2 Stück]",
									"Zerstörer (3 Kästchen) [3 Stück]","U-Boot (2 Kästchen) [4 Stück]"};
	private String[] richtungen = {"Norden","Osten","Süden","Westen"};
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxSpieler;
	private String[] spieler = {"Spieler1", "Spieler2"};
	private JTextField eingabesetzen;
	private JButton setzenButton;
	private JButton regelnButton;
	
	// Panel9 - Notizfeld2
	private JPanel p9;
	private JLabel labeln2;
	private JLabel xachsen2;
	private JLabel yachsen2_1;
	private JLabel yachsen2_2;
	private JLabel yachsen2_3;
	private JLabel yachsen2_4;
	private JLabel yachsen2_5;
	private JLabel yachsen2_6;
	private JLabel yachsen2_7;
	private JLabel yachsen2_8;
	private JLabel yachsen2_9;
	private JLabel yachsen2_10;
	private JTable tabellenotizen2;
	private String[][] datenMatrixn2 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}};
	private JTextArea schirm6;
	
	/*****************************************************************
	 *****************************************************************/
	
	/**
	 * @brief Konstruktor der Klasse SchiffeVersenkenGUI
	 * 
	 * Erstellt die grafische Benztzeroberfläche für Schiffe-Versenken für zwei Spieler. Jene besteht aus einem 
	 * Gatter mit neun Bereichen. Zum einen werden zwei Spieler-Tabellen und zwei Notizen-Tabellen erstellt, zum 
	 * anderen eine Legende, ein Bereich für das Schießen auf Schiffe und ein Bereich für das Setzen von Schiffen.
	 * Weiterhin werden sechs Schirm-Teile erstellt, welche im Spiel als linker und rechter Schirm zur
	 * Abdeckung der Gegnerischen Spieler-Tabellen dienen. Zum Schluss wird eine Funktion aufgerufen,
	 * welche den Schirm auf der rechten Seite aktiviert.
	 * 
	 * Somit initialisiert der Konstruktor also alle GUI-Komponenten, passt sie an die vorgegeben Layout-
	 * Anweisungen an und stellt sicher, dass alle Elemente korrekt angezeigt werden und funktional sind.
	 * 
	 * @param d Ein 'SchiffeData'-Objekt, enthält die Informationen über Spieler 1, 
	 * 			wie z.B. Positionen der Schiffe und Treffer.
	 * @param f Ein 'SchiffeData'-Objekt, enthält die Informationen über Spieler 2, 
	 * 			wie z.B. Positionen der Schiffe und Treffer.
	 * 
	 * @throws IllegalArgumentException Wenn einer der Parameter 'null' ist.
	 * 
	 * @since 07.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	public SchiffeVersenkenGUI (SchiffeData d, SchiffeData f) {
		
		if (d == null || f == null) {
	        throw new IllegalArgumentException("Die Spieler-Daten dürfen nicht null sein.");
	    }
		
		this.spieler1= d;	
		this.spieler2= f;
		
		// JFrame-Konfiguration
		this.setLayout(new GridLayout(3, 3));
		this.setTitle("Schiffe Versenken (2 Spieler)");
		this.setSize(1500,780);
		this.setLocation(20,30);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Panels werden initialisiert und dem Frame hinzugefügt (3 x 3)
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
		p1.setBackground(Color.decode("#98EAE9"));
		labels1 = new JLabel("Spieler1:");
		labels1.setBounds(30, 10, 50, 20);
		p1.add(labels1);
		
		xachses1 = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		xachses1.setBounds(50, 30, 200, 20);
		p1.add(xachses1);
		
		yachses1_1 = new JLabel("1");
		yachses1_1.setBounds(40, 46, 20, 20);
		p1.add(yachses1_1);
		yachses1_2 = new JLabel("2");
		yachses1_2.setBounds(40, 63, 20, 20);
		p1.add(yachses1_2);
		yachses1_3 = new JLabel("3");
		yachses1_3.setBounds(40, 79, 20, 20);
		p1.add(yachses1_3);
		yachses1_4 = new JLabel("4");
		yachses1_4.setBounds(40, 94, 20, 20);
		p1.add(yachses1_4);
		yachses1_5 = new JLabel("5");
		yachses1_5.setBounds(40, 110, 20, 20);
		p1.add(yachses1_5);
		yachses1_6 = new JLabel("6");
		yachses1_6.setBounds(40, 126, 20, 20);
		p1.add(yachses1_6);
		yachses1_7 = new JLabel("7");
		yachses1_7.setBounds(40, 142, 20, 20);
		p1.add(yachses1_7);
		yachses1_8 = new JLabel("8");
		yachses1_8.setBounds(40, 158, 20, 20);
		p1.add(yachses1_8);
		yachses1_9 = new JLabel("9");
		yachses1_9.setBounds(40, 174, 20, 20);
		p1.add(yachses1_9);
		yachses1_10 = new JLabel("10");
		yachses1_10.setBounds(34, 191, 20, 20);
		p1.add(yachses1_10);
		
		datenMatrixs1 = new String[10][10];
		tabellespieler1 = new JTable(datenMatrixs1, header);
		tabellespieler1.setBounds(50, 50, 150, 160);
		p1.add(tabellespieler1, BorderLayout.CENTER);
		
		//Schirm 1
		schirm1 = new JTextArea("\n\n       Spieler 2 ist dran");
		schirm1.setBounds(getBounds(getBounds()));
		schirm1.setBackground(Color.green);
		schirm1.setFont(new Font("Arial", Font.PLAIN, 40));
		p1.add(schirm1);
		schirm1.setEditable(false);
		schirm1.setVisible(false);

		//P2-Legende
		p2.setBackground(Color.decode("#98EAE9"));
		infoLabel = new JLabel("Legende:");
		infoLabel.setBounds(30, 10, 80, 20);
		p2.add(infoLabel);
		
		legendeTextArea = new JTextArea("\n   weißes Feld = leeres Feld \n\n   "
				+ "Plus + = Schiff \n\n   Kreis O = Schuss auf leeres Feld/Wasser \n\n   "
				+ "Kreuz X = Schuss hat Schiff getroffen \n\n   "
				+ "Raute # = Schiff versenkt");
		legendeTextArea.setBounds(30, 35, 300, 200);
		legendeTextArea.setFont(new Font("Arial", Font.PLAIN, 14));;
		p2.add(legendeTextArea);
		legendeTextArea.setEditable(false);
		
		infoLabel = new JLabel("   Debug-Modus:");
		infoLabel.setBounds(340, 20, 115, 40);
		p2.add(infoLabel);
		
		debug_modusAn = new JButton("aktivieren");
		debug_modusAn.setBounds(340, 55, 115, 40);
		p2.add(debug_modusAn);
		debug_modusAn.addActionListener(e -> debugModusAn());
		
		debug_modusAus = new JButton("deaktivieren");
		debug_modusAus.setBounds(340, 105, 115, 40);
		p2.add(debug_modusAus);
		debug_modusAus.addActionListener(e -> debugModusAus());
		debug_modusAus.setEnabled(false);
		
		comboBoxSpieler = new JComboBox<String>(spieler);
		comboBoxSpieler.setBounds(340, 155, 115, 30);
		p2.add(comboBoxSpieler);
		comboBoxSpieler.setVisible(false);
		
		//P3-Spielfeld2
		p3.setBackground(Color.decode("#98EAE9"));
		labels2 = new JLabel("Spieler2:");
		labels2.setBounds(30, 10, 50, 20);
		p3.add(labels2);

		xachses2 = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		xachses2.setBounds(50, 30, 200, 20);
		p3.add(xachses2);
		
		yachses2_1 = new JLabel("1");
		yachses2_1.setBounds(40, 46, 20, 20);
		p3.add(yachses2_1);
		yachses2_2 = new JLabel("2");
		yachses2_2.setBounds(40, 63, 20, 20);
		p3.add(yachses2_2);
		yachses2_3 = new JLabel("3");
		yachses2_3.setBounds(40, 79, 20, 20);
		p3.add(yachses2_3);
		yachses2_4 = new JLabel("4");
		yachses2_4.setBounds(40, 94, 20, 20);
		p3.add(yachses2_4);
		yachses2_5 = new JLabel("5");
		yachses2_5.setBounds(40, 110, 20, 20);
		p3.add(yachses2_5);
		yachses2_6 = new JLabel("6");
		yachses2_6.setBounds(40, 126, 20, 20);
		p3.add(yachses2_6);
		yachses2_7 = new JLabel("7");
		yachses2_7.setBounds(40, 142, 20, 20);
		p3.add(yachses2_7);
		yachses2_8 = new JLabel("8");
		yachses2_8.setBounds(40, 158, 20, 20);
		p3.add(yachses2_8);
		yachses2_9 = new JLabel("9");
		yachses2_9.setBounds(40, 174, 20, 20);
		p3.add(yachses2_9);
		yachses2_10 = new JLabel("10");
		yachses2_10.setBounds(34, 191, 20, 20);
		p3.add(yachses2_10);
		
		datenMatrixs2 = new String[10][10];
		tabellespieler2 = new JTable(datenMatrixs2, header);
		tabellespieler2.setBounds(50, 50, 150, 160);
		p3.add(tabellespieler2, BorderLayout.CENTER);
		
		//Schirm 4
		schirm4 = new JTextArea("\n\n       Spieler 1 ist dran");
		schirm4.setBounds(getBounds(getBounds()));
		schirm4.setBackground(Color.green);
		schirm4.setFont(new Font("Arial", Font.PLAIN, 40));
		p3.add(schirm4);
		schirm4.setEditable(false);
		schirm4.setVisible(false);
		
		//P4-Leer
		p4.setBackground(Color.decode("#98EAE9"));
		
		//Schirm 2
		schirm2 = new JTextArea("\n\n       Spieler 2 ist dran");
		schirm2.setBounds(getBounds(getBounds()));
		schirm2.setBackground(Color.green);
		schirm2.setFont(new Font("Arial", Font.PLAIN, 40));
		p4.add(schirm2);
		schirm2.setEditable(false);
		schirm2.setVisible(false);
		
		//P5-Schuss
		p5.setBackground(Color.decode("#98EAE9"));
		infoLabel = new JLabel("Schuss:");
		infoLabel.setBounds(30, 25, 50, 20);
		p5.add(infoLabel);
		
		eingabeschuss = new JTextField(null);
		eingabeschuss.setBounds(30, 50, 300, 90);
		eingabeschuss.setHorizontalAlignment(JTextField.CENTER);
		eingabeschuss.setFont(new Font("Arial", Font.BOLD, 20));
		p5.add(eingabeschuss);
		eingabeschuss.setEnabled(false);
		
		schussButton = new JButton("Schuss");
		schussButton.setBounds(30, 150, 300, 60);
		p5.add(schussButton);
		schussButton.setEnabled(false);
		schussButton.addActionListener(e -> schuss());
		
		//P6-Leer
		p6.setBackground(Color.decode("#98EAE9"));
		
		//Schirm 5
		schirm5 = new JTextArea("\n\n       Spieler 1 ist dran");
		schirm5.setBounds(getBounds(getBounds()));
		schirm5.setBackground(Color.green);
		schirm5.setFont(new Font("Arial", Font.PLAIN, 40));
		p6.add(schirm5);
		schirm5.setEditable(false);
		schirm5.setVisible(false);
		
		//P7-Notizen1
		p7.setBackground(Color.decode("#98EAE9"));
		labeln1 = new JLabel("Notizen1:");
		labeln1.setBounds(30, 10, 60, 20);
		p7.add(labeln1);
		
		xachsen1 = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		xachsen1.setBounds(50, 30, 200, 20);
		p7.add(xachsen1);
		
		yachsen1_1 = new JLabel("1");
		yachsen1_1.setBounds(40, 46, 20, 20);
		p7.add(yachsen1_1);
		yachsen1_2 = new JLabel("2");
		yachsen1_2.setBounds(40, 63, 20, 20);
		p7.add(yachsen1_2);
		yachsen1_3 = new JLabel("3");
		yachsen1_3.setBounds(40, 79, 20, 20);
		p7.add(yachsen1_3);
		yachsen1_4 = new JLabel("4");
		yachsen1_4.setBounds(40, 94, 20, 20);
		p7.add(yachsen1_4);
		yachsen1_5 = new JLabel("5");
		yachsen1_5.setBounds(40, 110, 20, 20);
		p7.add(yachsen1_5);
		yachsen1_6 = new JLabel("6");
		yachsen1_6.setBounds(40, 126, 20, 20);
		p7.add(yachsen1_6);
		yachsen1_7 = new JLabel("7");
		yachsen1_7.setBounds(40, 142, 20, 20);
		p7.add(yachsen1_7);
		yachsen1_8 = new JLabel("8");
		yachsen1_8.setBounds(40, 158, 20, 20);
		p7.add(yachsen1_8);
		yachsen1_9 = new JLabel("9");
		yachsen1_9.setBounds(40, 174, 20, 20);
		p7.add(yachsen1_9);
		yachsen1_10 = new JLabel("10");
		yachsen1_10.setBounds(34, 191, 20, 20);
		p7.add(yachsen1_10);
		
		datenMatrixn1 = new String[10][10];
		tabellenotizen1 = new JTable(datenMatrixn1, header);
		tabellenotizen1.setBounds(50, 50, 150, 160);
		p7.add(tabellenotizen1, BorderLayout.CENTER);
		
		//Schirm 3
		schirm3 = new JTextArea("\n\n       Spieler 2 ist dran");
		schirm3.setBounds(getBounds(getBounds()));
		schirm3.setBackground(Color.green);
		schirm3.setFont(new Font("Arial", Font.PLAIN, 40));
		p7.add(schirm3);
		schirm3.setEditable(false);
		schirm3.setVisible(false);
		
		//P8-Setzen
		p8.setBackground(Color.decode("#98EAE9"));
		infoLabel = new JLabel("Setzen:");
		infoLabel.setBounds(30, 10, 50, 20);
		p8.add(infoLabel);
		
		comboBoxSchiff = new JComboBox<String>(schiffart);
		comboBoxSchiff.setBounds(30, 30, 300, 25);
		p8.add(comboBoxSchiff);
		comboBoxRichtung = new JComboBox<String>(richtungen);
		comboBoxRichtung.setBounds(30, 65, 300, 25);
		p8.add(comboBoxRichtung);
						
		eingabesetzen = new JTextField(null);
		eingabesetzen.setBounds(30, 100, 300, 60);
		eingabesetzen.setHorizontalAlignment(JTextField.CENTER);
		eingabesetzen.setFont(new Font("Arial", Font.BOLD, 20));
		p8.add(eingabesetzen);
		
		setzenButton = new JButton("Setzen");
		setzenButton.setBounds(30, 170, 300, 60);
		p8.add(setzenButton);
		setzenButton.addActionListener(e -> setzen());
		
		regelnButton = new JButton("Regeln");
		regelnButton.setBounds(340, 190, 115, 40);
		p8.add(regelnButton);
		regelnButton.addActionListener(e -> regeln_anzeigen());
		
		//P9-Notizen2
		p9.setBackground(Color.decode("#98EAE9"));
		labeln2 = new JLabel("Notizen2:");
		labeln2.setBounds(30, 10, 60, 20);
		p9.add(labeln2);
		
		xachsen2 = new JLabel("A | B | C| D| E| F| G| H| I  | J ");
		xachsen2.setBounds(50, 30, 200, 20);
		p9.add(xachsen2);
		
		yachsen2_1 = new JLabel("1");
		yachsen2_1.setBounds(40, 46, 20, 20);
		p9.add(yachsen2_1);
		yachsen2_2 = new JLabel("2");
		yachsen2_2.setBounds(40, 63, 20, 20);
		p9.add(yachsen2_2);
		yachsen2_3 = new JLabel("3");
		yachsen2_3.setBounds(40, 79, 20, 20);
		p9.add(yachsen2_3);
		yachsen2_4 = new JLabel("4");
		yachsen2_4.setBounds(40, 94, 20, 20);
		p9.add(yachsen2_4);
		yachsen2_5 = new JLabel("5");					
		yachsen2_5.setBounds(40, 110, 20, 20);
		p9.add(yachsen2_5);
		yachsen2_6 = new JLabel("6");
		yachsen2_6.setBounds(40, 126, 20, 20);
		p9.add(yachsen2_6);
		yachsen2_7 = new JLabel("7");
		yachsen2_7.setBounds(40, 142, 20, 20);
		p9.add(yachsen2_7);
		yachsen2_8 = new JLabel("8");
		yachsen2_8.setBounds(40, 158, 20, 20);
		p9.add(yachsen2_8);
		yachsen2_9 = new JLabel("9");
		yachsen2_9.setBounds(40, 174, 20, 20);
		p9.add(yachsen2_9);
		yachsen2_10 = new JLabel("10");
		yachsen2_10.setBounds(34, 191, 20, 20);
		p9.add(yachsen2_10);
		
		datenMatrixn2 = new String[10][10];
		tabellenotizen2 = new JTable(datenMatrixn2, header);
		tabellenotizen2.setBounds(50, 50, 150, 160);
		p9.add(tabellenotizen2, BorderLayout.CENTER);
		
		//Schirm 6
		schirm6 = new JTextArea("\n\n       Spieler 1 ist dran");
		schirm6.setBounds(getBounds(getBounds()));
		schirm6.setBackground(Color.green);
		schirm6.setFont(new Font("Arial", Font.PLAIN, 40));
		p9.add(schirm6);
		schirm6.setEditable(false);
		schirm6.setVisible(false);
		
		// Rechter Schirm wird aktiviert
		rechterSchirmAn();
	}

	/*****************************************************************
	 *****************************************************************/
	
	/**
	 * @brief Setzt ein Schiff auf dem Spielfeld des aktuellen Spielers
	 * 
	 * Diese Methode überprüft, welcher Spieler an der Reihe ist, über das Aufrufen einer SchiffData Methode
	 * die einen boolean Wert zurück gibt. Wenn der Wert false ist und der Debugmodus nicht aktiv ist,
	 * setzt die Methode ein Schiff auf dem Spielfeld des Spielers 1 über eine weitere Methode.
	 * Anschließend wird das Modell der Tabelle aktualisiert, um den neuen Zustand der Tabelle darzustellen.
	 * Wenn Spielerwechsel() true zurück gibt, wird das Schiff auf dem Spielfeld von Spieler 2 ein Schiff
	 * platziert und die Tabelle von Spieler 2 aktualisiert.
	 * Nach dem Setzen werden die Methoden Schirmwechsel 1 und 2 aufgerufen.
	 * 
	 * @pre Der Schuss Button wurde gedrückt
	 * 
	 * @since 13.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void setzen() {		
		if(!(spieler1.spielerwechsel() || debugModus() == 1)) {
			schiffSpieler(spieler1,datenMatrixs1);
			((AbstractTableModel) tabellespieler1.getModel()).fireTableDataChanged();
		}
		else {
			schiffSpieler(spieler2,datenMatrixs2);
			((AbstractTableModel) tabellespieler2.getModel()).fireTableDataChanged();
		}
		schirmwechsel1();
		schirmwechsel2();
	}
	
	/**
	 * @brief Überprüft, ob ein Schiff auf dem Spielfeld des Spielers gesetzt werden kann
	 * 
	 * Diese Methode gibt die Informationen was für ein Schiff gesetzt werden soll, 
	 * auf welchem Feld und in welche Richtung an die SchiffeData. 
	 * Diese Informationen werden an ein 'SchiffeData'-Objekt übergeben. 
	 * Wenn das Schiff erfolgreich gesetzt werden kann, wird die Methode 'setzenSchiff'
	 * aufgerufen, um das Schiff auf dem Spielfeld des Spielers zu platzieren. 

	 * @param spieler Ein 'SchiffeData'-Objekt, das den aktuellen Spieler darstellt
	 * @param matrix Eine String Matrix, das Spielfeld auf dem Schiffe gesetzt werden darstellt
	 * 
	 * @throws Error Wird geworfen, wenn das Schiff nicht auf dem Spielfeld platziert werden kann. 
	 * 				 Die Fehlermeldung wird als Pop-up angezeigt.
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void schiffSpieler(SchiffeData spieler, String[][] matrix) {
		String Schiff = comboBoxSchiff.getSelectedItem().toString();
		String Richtung = comboBoxRichtung.getSelectedItem().toString();
		String Zelle = eingabesetzen.getText();
		
		try {
			spieler.setSchiff(Schiff, Richtung, Zelle);
			System.out.println("[GUI] Schiffsart: " + Schiff + ", Richtung: " + Richtung 
								+ ", Feld: " + Zelle);
			setzenSchiff(spieler, matrix);
		}
		catch(Error  e) 
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	/**
	 * @brief Das Schiff wird auf das Spielfeld gesetzt
	 * 
	 * Die Matrix des Spielers wird Zelle für Zelle durchgegangen und zeichnet da, 
	 * wo sie von der Data true ein Schiffsteil zurück bekommt, ein "+" hin. 
	 *  
	 * @param spieler Ein 'SchiffeData'-Objekt, das den aktuellen Spieler darstellt
	 * @param matrix Eine String Matrix, welches das Spielfeld, auf dem das Schiff gesetzt wird, darstellt
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void setzenSchiff(SchiffeData spieler, String[][] matrix) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(spieler.getType(i,j)) {
					matrix[i][j] = "+";
				}
			}
		}
	}
	
	/**
	 * @brief Schirmwechsel von rechts nach links bzw Spielerwechsel zu Spieler 2
	 * 
	 * Wenn die Data für Spieler 1 true zurück gibt, bedeutet das, dass Spieler 2 mit Setzen dran ist.
	 * Weiterhin wird überprüft, ob Anzahl noch null ist, denn wenn die Methode einmal durchgeführt
	 * wurde, wird Anzahl um eins erhört, damit nicht bei jedem weiteren Setzen diese Methode
	 * aktiv wird. 
	 * Nach dem Ablaufen eines Timers geht der Schirm auf der rechten Seite aus und auf der linken
	 * an. Außerdem werden die Auswahlboxen und das Eingabefeld in den Anfangszustand gebracht,
	 * damit Spieler 2 nicht einen informativen Vorteil bekommt.
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void schirmwechsel1() {
		if(spieler1.spielerwechsel() && anzahl == 0) {
			anzahl += 1;
			setzenButton.setEnabled(false);
			Timer timer = new Timer(1000, ex -> {
				rechterSchirmAus();
				linkerSchirmAn();
				setzenButton.setEnabled(true);
				eingabesetzen.setText("");
				comboBoxSchiff.setSelectedItem("Schlachtschiff (5 Kästchen) [1 Stück]");
				comboBoxRichtung.setSelectedItem("Norden");
			});
			timer.setRepeats(false);
			timer.start();
		}
	}
	
	/**
	 * @brief Beide Schirme an und Wechsel von Spielvorbereitung zu Spielbeginn
	 * 
	 * Wenn die Data für Spieler 2 true zurück gibt, bedeutet das, dass beide Spieler mit dem Setzen
	 * fertig sind. Dementsprechend kann der Setzen-Bereich in seinen Anfangszustand und deaktiviert
	 * werden. Dafür wird der Schuss-Bereich aktiviert. Zuvor wurde der rechte Schirm aktiviert, damit 
	 * beide Felder verdeckt sind, bevor es richtig los geht.
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void schirmwechsel2() {
		if(spieler2.spielerwechsel()) {
			rechterSchirmAn();
			setzenButton.setEnabled(false);
			eingabesetzen.setEnabled(false);
			eingabesetzen.setText("");
			comboBoxSchiff.setSelectedItem("Schlachtschiff (5 Kästchen) [1 Stück]");
			comboBoxRichtung.setSelectedItem("Norden");
			System.out.println("[GUI] Setzen Button und Setzen Eingabefeld deaktiviert.");
			schussButton.setEnabled(true);
			eingabeschuss.setEnabled(true);
			System.out.println("[GUI] Schuss Button und Schuss Eingabefeld aktiviert.");
			spielbeginnt();	
		}	
	}
	
	/**
	 * @brief Bestimmung des Anfangsspielers
	 * 
	 * Über einen Zufallsgenerator wurde bereits am Anfang bestimmt, welcher Spieler beginnt.
	 * Nun wird diese Information an die Nutzer gegeben und der Schirm auf der Seite des zuerst
	 * schießenden Spielers wird deaktiviert.
	 * 
	 * @since 20.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void spielbeginnt() {
		if(werSpielt == 0) {
			JOptionPane.showMessageDialog(this,"Spieler1 beginnt!");
			linkerSchirmAus();
		}
		if(werSpielt == 1) {
			JOptionPane.showMessageDialog(this,"Spieler2 beginnt!");
			rechterSchirmAus();
		} 
	}
	
	/**
	 * @brief Bestimmung welcher Spieler im weiteren dran ist
	 * 
	 * Diese Methode ist v.a. für den Debug-Modus wichtig, denn wenn dieser an bzw true ist,
	 * soll er nicht den aktuellen Spieler über Modulus 2 bestimmen, sondern über
	 * eine weitere Methode. 
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private int werSpielt() {
		if(debug) {
			return debugModus();
		}
		return werSpielt%2;
	}
	
	/**
	 * @brief Bestimmung ob geschossen werden kann
	 * 
	 * Je nachdem welcher Spieler dran ist, was über die Methode 'werSpielt' in Erfahrung
	 * gebracht wird, springt das Programm in den passenden case und über die Methode 
	 * 'spielerSchuss' wird versucht auf ein Feld zu schießen.
	 * 
	 * @pre Der Schuss Button wurde gedrückt
	 * 
	 * @throws Error Wird geworfen, wenn der Schuss nicht möglich ist, zum Beispiel weil 
	 * 				 das Feld bereits beschossen wurde. Die Fehlermeldung wird als Pop-up angezeigt.
	 * 
	 * @since 13.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void schuss() {
		switch (werSpielt()) {
		case 0:
			try {
				spielerSchuss(spieler2, datenMatrixs2, datenMatrixn1, tabellespieler2, tabellenotizen1);
			} 
			catch (Error e) {
				JOptionPane.showMessageDialog(this, e);
			}
			break;
		case 1:
			try {
				spielerSchuss(spieler1, datenMatrixs1, datenMatrixn2, tabellespieler1, tabellenotizen2);
			} 
			catch (Error e) {
				JOptionPane.showMessageDialog(this, e);
			}
			break;
		}
	}
	
	/**
	 * @brief Gibt Schuss an Data weiter
	 * 
	 * Hier wird der Schuss an die 'SchiffeData' weitergegeben, die wiederrum angibt, ob es damit
	 * zu einem Spielende kommt, 'ausgabe2', oder nicht, 'ausgabe1'. Weiterhin wird bei der Situation,
	 * dass das Spiel weitergeht 'werSpielt' um eins erhöht, um den Spielerwechsel zu haben.
	 * Die Parameter werden an die Methode 'schussSchiff' übergeben.
	 * 
	 * @param spieler Ein 'SchiffeData'-Objekt, das den aktuellen Spieler darstellt
	 * @param matrix1 Eine 'String[][]'-Matrix, die das eigene Spielfeld des Spielers darstellt
	 * @param matrix2 Eine 'String[][]'-Matrix, die das Notizen-Spielfeld darstellt
	 * @param tabellespieler Eine 'JTable', die das eigene Spielfeld des Spielers visuell darstellt
	 * @param tabellenotizen Eine 'JTable', die das Notizen-Spielfeld visuell darstellt
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void spielerSchuss(SchiffeData spieler,String[][] matrix1, 
			String[][] matrix2, JTable tabellespieler, JTable tabellenotizen) throws Error {
		String Zelle = eingabeschuss.getText();
		
		if(spieler.setSchuss(Zelle)) {
			werSpielt = werSpielt + 1;
			schussSchiff(spieler, matrix1, matrix2, tabellespieler, tabellenotizen);
			if(!debug) {
				ausgabe1();
			}
		} 
		else {
			schussSchiff(spieler, matrix1, matrix2, tabellespieler, tabellenotizen);
			ausgabe2();
		}
	}

	/**
	 * @brief Setzt den Schuss in das sichtbare Spielfeld und in die Notiz-Tabelle
	 * 
	 * Die Matrix des Spielers und die der Notiz wird Zelle für Zelle durchgegangen und je nachdem,
	 * worum es sich bei der Stelle handelt, wird ein "X", ein "#" oder ein "O" eingezeichnet. 
	 * Daraufhin werden beide Tabellen neu geladen, wodurch der Schuss sichtbar wird.
	 * 
	 * @param spieler Ein 'SchiffeData'-Objekt, das den aktuellen Spieler darstellt
	 * @param datenMatrixSpieler Eine 'String[][]'-Matrix, die das eigene Spielfeld des Spielers darstellt
	 * @param datenMatrixNotizen Eine 'String[][]'-Matrix, die das Notizen-Spielfeld darstellt
	 * @param tabellespieler Eine 'JTable', die das eigene Spielfeld des Spielers visuell darstellt
	 * @param tabellenotizen Eine 'JTable', die das Notizen-Spielfeld visuell darstellt
	 * 
	 * @since 21.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void schussSchiff(SchiffeData spieler, String[][] datenMatrixSpieler, String[][] datenMatrixNotizen, JTable tabellespieler, JTable tabellenotizen) {
	    for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            if(spieler.getStatus(i,j) && spieler.getType(i,j)) {
	                datenMatrixSpieler[i][j] = "X";  // Treffer
	                datenMatrixNotizen[i][j] = "X";
	                if(spieler.getVersenktGUI(i, j)) {
	                    datenMatrixSpieler[i][j] = "#";  // Versenkt
	                    datenMatrixNotizen[i][j] = "#";
	                }
	            }
	            else if(spieler.getStatus(i, j)){
	                datenMatrixSpieler[i][j] = "O";  // Wasser (Schuss ins Leere)
	                datenMatrixNotizen[i][j] = "O";
	            }
	        }
	    }
	    ((AbstractTableModel) tabellespieler.getModel()).fireTableDataChanged();
	    ((AbstractTableModel) tabellenotizen.getModel()).fireTableDataChanged();
	}
	
	/**
	 * @brief Spielerwechsel mit Pop-up
	 * 
	 * Je nachdem wer dran war erscheint ein Pop-up, um den Nutzern mitzuteilen, dass der andere
	 * Spieler nun dran ist. Daraufhin wechseln die Schirme. Der eben noch aus war geht an und
	 * nach dem Ablaufen eines Timers geht der andere zuvor aktive Schirm aus.
	 * Während des Schirmwechsels ist der Schuss-Button deaktiviert.
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void ausgabe1() {
		switch (werSpielt%2) {
		case 0:
			JOptionPane.showMessageDialog(this, "   Spielerwechsel: Spieler 1 ist dran.\n"
					+ "   Bitte OK drücken und schnell weitergeben.");
			rechterSchirmAn();
			schussButton.setEnabled(false);
			eingabeschuss.setText("");
			Timer timer1 = new Timer(1500, ex -> {
				linkerSchirmAus();
				schussButton.setEnabled(true);
			});
			timer1.setRepeats(false);
			timer1.start();
			break;
		case 1:
			JOptionPane.showMessageDialog(this, "   Spielerwechsel: Spieler 2 ist dran.\n"
					+ "   Bitte OK drücken und schnell weitergeben.");
			linkerSchirmAn();
			schussButton.setEnabled(false);
			eingabeschuss.setText("");
			Timer timer2 = new Timer(1500, ex -> {
				rechterSchirmAus();
				schussButton.setEnabled(true);
			});
			timer2.setRepeats(false);
			timer2.start();
			break;
		default:
		}
	}

	/**
	 * @brief Spielende
	 * 
	 * Ein Pop-up benachrichtigt die Nutzer, dass ein Spieler gewonnen hat und der
	 * zuvor aktive Schirm wird ausgestellt, damit beide Spielfelder einsehbar sind.
	 * Außerdem wird das Schuss-Menu deaktiviert, da von hier an kein Weiterspielen
	 * möglich ist und die Anwendung neu gestartet werden muss um erneut zu spielen.
	 * 
	 * @since 24.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void ausgabe2() {
		switch (werSpielt()) {
		case 0:
			rechterSchirmAus();
			JOptionPane.showMessageDialog(this, "   Spieler 1 hat gewonnen! \n   "
					+ "Um erneut zu spielen schließen Sie die Anwendung \n   "
					+ "und starten Sie es von neuem.");
			break;
		case 1:
			linkerSchirmAus();
			JOptionPane.showMessageDialog(this, "   Spieler 2 hat gewonnen! \n   "
					+ "Um erneut zu spielen schließen Sie die Anwendung \n   "
					+ "und starten Sie es von neuem.");
			break;
		default:
		}
		schussButton.setEnabled(false);
		eingabeschuss.setEnabled(false);
		eingabeschuss.setText("");
	}
	
	/**
	 * @brief Spielerauswahl im Debug-Modus
	 * 
	 * Diese Methode ließt aus, welcher Spieler über die Combobox ausgewählt ist,
	 * wenn der Debug-Modus aktiv bzw true ist. Diese Information ist fürs setzen
	 * und schießen wichtig.
	 * 
	 * @since 26.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private int debugModus() {
		String Spieler = comboBoxSpieler.getSelectedItem().toString();
		if(debug) {
			switch(Spieler) {
			case "Spieler1": return 0;
			case "Spieler2": return 1;
			}
		}
		return 999999;
	}
	
	/**
	 * @brief Aktivierung des Debug-Modus
	 * 
	 * Hier wird in den Debug-Modus gewechselt. Dazu wird debug auf true gesetzt, eine ComboBox 
	 * zur Spielerauswahl sichtbar, die beiden Menus Schuss und Setzen aktiviert und die Schirme deaktiviert.
	 * 
	 * @pre Der aktivieren-Button wurde gedrückt
	 * 
	 * @since 26.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void debugModusAn() {
		JOptionPane.showMessageDialog(this, "Debug-Modus eingeschaltet.");
		comboBoxSpieler.setVisible(true);
		debug = true;
		debug_modusAus.setEnabled(true);
		schussButton.setEnabled(true);
		eingabeschuss.setEnabled(true);
		setzenButton.setEnabled(true);
		eingabesetzen.setEnabled(true);
		debug_modusAn.setEnabled(false);
		linkerSchirmAus();
		rechterSchirmAus();
	}

	/**
	 * @brief Deaktivierung des Debug-Modus
	 * 
	 * Hier wird der Debug-Modus ausgeschalten. Dazu wird debug auf false gesetzt, die ComboBox 
	 * zur Spielerauswahl verschwindet, das Schuss Menu deaktiviert und der rechte Schirm aktiviert.
	 * 
	 * @pre Der deaktivieren-Button wurde gedrückt
	 * 
	 * @since 26.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void debugModusAus() {
		JOptionPane.showMessageDialog(this, "Debug-Modus ausgeschaltet.");
		comboBoxSpieler.setVisible(false);
		debug = false;
		debug_modusAn.setEnabled(true);
		debug_modusAus.setEnabled(false);
		schussButton.setEnabled(false);
		eingabeschuss.setEnabled(false);
		eingabeschuss.setText("");
		rechterSchirmAn();
	}

	/**
	 * @brief Aktivierung des linken Schirms
	 * 
	 * Diese Methode lässt den linken Schirm erscheinen, welcher aus drei Teil-Schirmen besteht
	 * (Schirm 1, 2 und 3). Zuerst werden die Spieler-Tabelle und die Notizen-Tabelle von Spieler 1
	 * unsichtbar gestellt. Dann werden die drei Schirme als TextAreas gezeichnet und daraufhin
	 * werden die drei betroffenen Teile des Window-Frame aktualisiert.
	 * 
	 * Dies geschieht nicht im Debug-Modus.
	 * 
	 * @since 21.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void linkerSchirmAn() {
		if(!debug) {
			//Tabellen verstecken
			tabellespieler1.setVisible(false);
			labels1.setVisible(false);
			xachses1.setVisible(false);
			yachses1_1.setVisible(false);
			yachses1_2.setVisible(false);
			yachses1_3.setVisible(false);
			yachses1_4.setVisible(false);
			yachses1_5.setVisible(false);
			yachses1_6.setVisible(false);
			yachses1_7.setVisible(false);
			yachses1_8.setVisible(false);
			yachses1_9.setVisible(false);
			yachses1_10.setVisible(false);
			
			tabellenotizen1.setVisible(false);
			labeln1.setVisible(false);
			xachsen1.setVisible(false);
			yachsen1_1.setVisible(false);
			yachsen1_2.setVisible(false);
			yachsen1_3.setVisible(false);
			yachsen1_4.setVisible(false);
			yachsen1_5.setVisible(false);
			yachsen1_6.setVisible(false);
			yachsen1_7.setVisible(false);
			yachsen1_8.setVisible(false);
			yachsen1_9.setVisible(false);
			yachsen1_10.setVisible(false);
			
			//Schirm erstellen
			schirm1 = new JTextArea("\n\n       Spieler 2 ist dran");
			schirm1.setBounds(getBounds(getBounds()));
			schirm1.setBackground(Color.green);
			schirm1.setFont(new Font("Arial", Font.PLAIN, 40));
			p1.add(schirm1);
			schirm1.setEditable(false);
			schirm1.setVisible(true);
			
			schirm2 = new JTextArea("\n\n       Spieler 2 ist dran");
			schirm2.setBounds(getBounds(getBounds()));
			schirm2.setBackground(Color.green);
			schirm2.setFont(new Font("Arial", Font.PLAIN, 40));
			p4.add(schirm2);
			schirm2.setEditable(false);
			schirm2.setVisible(true);
			
			schirm3 = new JTextArea("\n\n       Spieler 2 ist dran");
			schirm3.setBounds(getBounds(getBounds()));
			schirm3.setBackground(Color.green);
			schirm3.setFont(new Font("Arial", Font.PLAIN, 40));
			p7.add(schirm3);
			schirm3.setEditable(false);
			schirm3.setVisible(true);
			
			//für das eigentliche zeichnen
			p1.revalidate();
			p1.repaint();
			p4.revalidate();
			p4.repaint();
			p7.revalidate();
			p7.repaint();
		}
	}
	
	/**
	 * @brief Deaktivierung des linken Schirms
	 * 
	 * Diese Methode lässt den linken Schirm verschwinden, welcher aus drei Teil-Schirmen besteht
	 * (Schirm 1, 2 und 3). Zuerst werden die Spieler-Tabelle und die Notizen-Tabelle von Spieler 1
	 * wieder sichtbar gestellt. Dann werden die drei Schirme entfernt und daraufhin
	 * werden die drei betroffenen Teile des Window-Frame wieder aktualisiert.
	 * 
	 * @since 21.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void linkerSchirmAus() {
		//Tabellen wieder Sichtbar
		tabellespieler1.setVisible(true);
		labels1.setVisible(true);
		xachses1.setVisible(true);
		yachses1_1.setVisible(true);
		yachses1_2.setVisible(true);
		yachses1_3.setVisible(true);
		yachses1_4.setVisible(true);
		yachses1_5.setVisible(true);
		yachses1_6.setVisible(true);
		yachses1_7.setVisible(true);
		yachses1_8.setVisible(true);
		yachses1_9.setVisible(true);
		yachses1_10.setVisible(true);
		
		tabellenotizen1.setVisible(true);
		labeln1.setVisible(true);
		xachsen1.setVisible(true);
		yachsen1_1.setVisible(true);
		yachsen1_2.setVisible(true);
		yachsen1_3.setVisible(true);
		yachsen1_4.setVisible(true);
		yachsen1_5.setVisible(true);
		yachsen1_6.setVisible(true);
		yachsen1_7.setVisible(true);
		yachsen1_8.setVisible(true);
		yachsen1_9.setVisible(true);
		yachsen1_10.setVisible(true);
		
		//vorherigen Zustand einrichten
		p1.remove(schirm1);
		System.out.println("[GUI] Schirm 1 aus");
		
		p4.remove(schirm2);
		System.out.println("[GUI] Schirm 2 aus");
		
		p7.remove(schirm3);
		System.out.println("[GUI] Schirm 3 aus");
		
		//für das eigentliche zeichnen
		p1.revalidate();
		p1.repaint();
		p4.revalidate();
		p4.repaint();
		p7.revalidate();
		p7.repaint();
	}
	
	/**
	 * @brief Aktivierung des rechten Schirms
	 * 
	 * Diese Methode lässt den rechten Schirm erscheinen, welcher aus drei Teil-Schirmen besteht
	 * (Schirm 4, 5 und 6). Zuerst werden die Spieler-Tabelle und die Notizen-Tabelle von Spieler 2
	 * unsichtbar gestellt. Dann werden die drei Schirme als TextAreas gezeichnet und daraufhin
	 * werden die drei betroffenen Teile des Window-Frame aktualisiert.
	 * 
	 * Dies geschieht nicht im Debug-Modus.
	 * 
	 * @since 21.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void rechterSchirmAn() {
		if(!debug) {
			//Tabellen verstecken
			tabellespieler2.setVisible(false);
			labels2.setVisible(false);
			xachses2.setVisible(false);
			yachses2_1.setVisible(false);
			yachses2_2.setVisible(false);
			yachses2_3.setVisible(false);
			yachses2_4.setVisible(false);
			yachses2_5.setVisible(false);
			yachses2_6.setVisible(false);
			yachses2_7.setVisible(false);
			yachses2_8.setVisible(false);
			yachses2_9.setVisible(false);
			yachses2_10.setVisible(false);
			
			tabellenotizen2.setVisible(false);
			labeln2.setVisible(false);
			xachsen2.setVisible(false);
			yachsen2_1.setVisible(false);
			yachsen2_2.setVisible(false);
			yachsen2_3.setVisible(false);
			yachsen2_4.setVisible(false);
			yachsen2_5.setVisible(false);
			yachsen2_6.setVisible(false);
			yachsen2_7.setVisible(false);
			yachsen2_8.setVisible(false);
			yachsen2_9.setVisible(false);
			yachsen2_10.setVisible(false);
			
			//Schirm erstellen
			schirm4 = new JTextArea("\n\n       Spieler 1 ist dran");
			schirm4.setBounds(getBounds(getBounds()));
			schirm4.setBackground(Color.green);
			schirm4.setFont(new Font("Arial", Font.PLAIN, 40));
			p3.add(schirm4);
			schirm4.setEditable(false);
			schirm4.setVisible(true);
			
			schirm5 = new JTextArea("\n\n       Spieler 1 ist dran");
			schirm5.setBounds(getBounds(getBounds()));
			schirm5.setBackground(Color.green);
			schirm5.setFont(new Font("Arial", Font.PLAIN, 40));
			p6.add(schirm5);
			schirm5.setEditable(false);
			schirm5.setVisible(true);
			
			schirm6 = new JTextArea("\n\n       Spieler 1 ist dran");
			schirm6.setBounds(getBounds(getBounds()));
			schirm6.setBackground(Color.green);
			schirm6.setFont(new Font("Arial", Font.PLAIN, 40));
			p9.add(schirm6);
			schirm6.setEditable(false);
			schirm6.setVisible(true);
			
			//für das eigentliche zeichnen
			p3.revalidate();
			p3.repaint();
			p6.revalidate();
			p6.repaint();
			p9.revalidate();
			p9.repaint();
		}
	}
	
	/**
	 * @brief Deaktivierung des rechten Schirms
	 * 
	 * Diese Methode lässt den rechten Schirm verschwinden, welcher aus drei Teil-Schirmen besteht
	 * (Schirm 4, 5 und 6). Zuerst werden die Spieler-Tabelle und die Notizen-Tabelle von Spieler 2
	 * wieder sichtbar gestellt. Dann werden die drei Schirme entfernt und daraufhin
	 * werden die drei betroffenen Teile des Window-Frame wieder aktualisiert.
	 * 
	 * @since 21.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void rechterSchirmAus() {
		//Tabellen wieder Sichtbar
		tabellespieler2.setVisible(true);
		labels2.setVisible(true);
		xachses2.setVisible(true);
		yachses2_1.setVisible(true);
		yachses2_2.setVisible(true);
		yachses2_3.setVisible(true);
		yachses2_4.setVisible(true);
		yachses2_5.setVisible(true);
		yachses2_6.setVisible(true);
		yachses2_7.setVisible(true);
		yachses2_8.setVisible(true);
		yachses2_9.setVisible(true);
		yachses2_10.setVisible(true);
		
		tabellenotizen2.setVisible(true);
		labeln2.setVisible(true);
		xachsen2.setVisible(true);
		yachsen2_1.setVisible(true);
		yachsen2_2.setVisible(true);
		yachsen2_3.setVisible(true);
		yachsen2_4.setVisible(true);
		yachsen2_5.setVisible(true);
		yachsen2_6.setVisible(true);
		yachsen2_7.setVisible(true);
		yachsen2_8.setVisible(true);
		yachsen2_9.setVisible(true);
		yachsen2_10.setVisible(true);
			
		//vorherigen Zustand einrichten
		p3.remove(schirm4);
		System.out.println("[GUI] Schirm 4 aus");
			
		p6.remove(schirm5);
		System.out.println("[GUI] Schirm 5 aus");
			
		p9.remove(schirm6);
		System.out.println("[GUI] Schirm 6 aus");
			
		//für das eigentliche zeichnen
		p3.revalidate();
		p3.repaint();
		p6.revalidate();
		p6.repaint();
		p9.revalidate();
		p9.repaint();
	}
	
	/**
	 * @brief Anzeigen der Regeln
	 * 
	 * Bei dieser Methode erscheint ein Pop-up, welches als Text die Regeln des Spiels
	 * anzeigt. Somit können die Nutzer sich mit jenen nochmal bei Bedarf vertraut machen.
	 * 
	 * @pre Der Regeln-Button wurde gedrückt
	 * 
	 * @since 13.08.2024
	 * @lastModified 28.08.2024
	 * @author Kiara Schunk
	 */
	private void regeln_anzeigen() {
		JOptionPane.showMessageDialog(this, "Es werden zehn Schiffe (in Form von Gruppen von Kästchen im Gitter) ohne Einsicht des\r\n"
				+ "Gegners nach den folgenden Regeln platziert:\r\n"
				+ "* Schiffe dürfen nicht aneinander angrenzen.\r\n"
				+ "* Schiffe müssen als eine gerade Linie dargestellt werden.\r\n"
				+ "* Schiffe dürfen am Gitterrand liegen.\r\n"
				+ "* Schiffe dürfen nicht diagonal aufgestellt werden.\r\n"
				+ "* Jeder Spieler platziert 10 Schiffe\r\n"
				+ "   o ein Schlachtschiff (5 Kästchen groß)\r\n"
				+ "   o zwei Kreuzer (je 4 Kästchen groß)\r\n"
				+ "   o drei Zerstörer (je 3 Kästchen groß)\r\n"
				+ "   o vier U-Boote (je 2 Kästchen groß)\r\n"
				+ "Es wird zufällig bestimmt welcher Spieler beginnt. Der schießende Spieler gibt eine Koordinate im Gitter\r\n"
				+ "an. Der beschossene Spieler gibt nun an, ob der schießende Spieler ein Schiff getroffen („Treffer“),\r\n"
				+ "getroffen und versenkt („Treffer, versenkt“) oder verfehlt („Wasser“) hat. Der schießende Spieler kann sich\r\n"
				+ "nun Notizen machen. Der beschossene Spieler markiert die Felder ebenfalls, um zu sehen, wenn ein\r\n"
				+ "Schiff „versenkt“ ist.\r\n"
				+ "Nach jedem Schuss wechseln die Spieler die Rollen.");
	}
}