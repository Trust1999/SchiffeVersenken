/* Noch die Tabellen unschreibbar für den Benutzer machen? Dafür braucht es aber Zeug, was ich so nicht kenne :
 * // Erstellen eines nicht editierbaren DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Alle Zellen sind nicht editierbar
            }
        };

        JTable table = new JTable(model);
 */

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
import javax.swing.table.AbstractTableModel;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenkenGUI extends JFrame {
	
	private SchiffeData spieler1;
	private SchiffeData spieler2;
	private int Werspielt = 0;
	
	private JTextArea spielfeldTextArea;
	private JTextArea schirm;
	private JLabel infoLabel;
	private JTextField eingabeschuss;
	private JTextField eingabesetzen;
	
	private JTable tabellespieler1;
	private JTable tabellespieler2;
	private JTable tabellenotizen1;
	private JTable tabellenotizen2;
	
	private String[] header = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private String[][] datenMatrixs1 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}} ;
	private String[][] datenMatrixs2 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}} ;
	private String[][] datenMatrixn1 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}} ;
	private String[][] datenMatrixn2 = {{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}} ; //Zwischenspeicher
	
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
	
	// Panel2 - Legende
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
	
	// Panel8 - Setzen
	private JPanel p8;
	private JComboBox ComboBoxSchiff;
	private JComboBox ComboBoxRichtung;
	private String[] schiffart = {"Schlachtschiff (5 Kästchen)","Kreuzer (4 Kästchen)",
									"Zerstörer (3 Kästchen)","U-Boot (2 Kästchen)"};
	private String[] richtungen = {"Norden","Osten","Süden","Westen"};
	private JButton setzenButton;
	
	// Panel9 - Notizfeld2
	private JPanel p9;
	private JButton regelnButton;
	
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
				
				datenMatrixs1 = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellespieler1 = new JTable(datenMatrixs1, header);
				tabellespieler1.setBounds(50, 50, 150, 160);
				p1.add(tabellespieler1, BorderLayout.CENTER);

				//P2-Legende
				p2.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Legende:");
				infoLabel.setBounds(30, 10, 80, 20);
				p2.add(infoLabel);
				
				spielfeldTextArea = new JTextArea("\n   weißes Feld = leeres Feld \n\n   "
						+ "Plus + = Schiff \n\n   Kreis O = Schuss auf leeres Feld \n\n   "
						+ "Kreuz X = Schuss hat Schiff getroffen \n\n   "
						+ "Raute # = Schiff versenkt");
				spielfeldTextArea.setBounds(30, 35, 300, 200);
				spielfeldTextArea.setFont(new Font("Arial", Font.PLAIN, 14));;
				p2.add(spielfeldTextArea);
				spielfeldTextArea.setEditable(false);
				
				regelnButton = new JButton("Regeln");
				regelnButton.setBounds(340, 195, 100, 40);
				p2.add(regelnButton);
				regelnButton.addActionListener(e -> linkerSchirm()); //regeln_anzeigen()
				
				//P3-Spielfeld2
				p3.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Spieler2:");
				infoLabel.setBounds(30, 10, 50, 20);
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
				
				datenMatrixs2 = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellespieler2 = new JTable(datenMatrixs2, header);
				tabellespieler2.setBounds(50, 50, 150, 160);
				p3.add(tabellespieler2, BorderLayout.CENTER);
				
				//P4-Leer
				p4.setBackground(Color.decode("#98EAE9"));
				
				//P5-Schuss
				p5.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Schuss:");
				infoLabel.setBounds(30, 1, 50, 20);
				p5.add(infoLabel);
				infoLabel = new JLabel("Schuss in der Form Großbuchstabe-Zahl angeben:");
				infoLabel.setBounds(30, 20, 500, 20);
				p5.add(infoLabel);
				
				eingabeschuss = new JTextField(null);
				eingabeschuss.setBounds(30, 50, 300, 90);
				eingabeschuss.setHorizontalAlignment(JTextField.CENTER);
				eingabeschuss.setFont(new Font("Arial", Font.BOLD, 20));
				p5.add(eingabeschuss);
				
				schussButton = new JButton("Schuss");
				schussButton.setBounds(30, 150, 300, 60);
				p5.add(schussButton);
				schussButton.setEnabled(false);
				schussButton.addActionListener(e -> schuss());
				
				//P6-Leer
				p6.setBackground(Color.decode("#98EAE9"));
				
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
				
				datenMatrixn1 = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellenotizen1 = new JTable(datenMatrixn1, header);
				tabellenotizen1.setBounds(50, 50, 150, 160);
				p7.add(tabellenotizen1, BorderLayout.CENTER);
				
				//P8-Setzen
				p8.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Setzen:");
				infoLabel.setBounds(30, 10, 50, 20);
				p8.add(infoLabel);
				
				ComboBoxSchiff = new JComboBox<String>(schiffart);
				ComboBoxSchiff.setBounds(30, 30, 300, 25);
				p8.add(ComboBoxSchiff);
				ComboBoxRichtung = new JComboBox<String>(richtungen);
				ComboBoxRichtung.setBounds(30, 65, 300, 25);
				p8.add(ComboBoxRichtung);
				
				eingabesetzen = new JTextField(null);
				eingabesetzen.setBounds(30, 100, 300, 60);
				eingabesetzen.setHorizontalAlignment(JTextField.CENTER);
				eingabesetzen.setFont(new Font("Arial", Font.BOLD, 20));
				p8.add(eingabesetzen);
				
				setzenButton = new JButton("Setzen");
				setzenButton.setBounds(30, 170, 300, 60);
				p8.add(setzenButton);
				setzenButton.addActionListener(e -> setzen());
				
				//P9-Notizen2
				p9.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Notizen2:");
				infoLabel.setBounds(30, 10, 60, 20);
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
				
				datenMatrixn2 = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellenotizen2 = new JTable(datenMatrixn2, header);
				tabellenotizen2.setBounds(50, 50, 150, 160);
				p9.add(tabellenotizen2, BorderLayout.CENTER);
				
				//Bestimmung der Speilerreihenfolge
				Random zufall = new Random();
				Werspielt = Werspielt + zufall.nextInt(2);  //0 - inclusiv, 2 - exclusiv => 0 und 1
			}
	
			private void linkerSchirm() {
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
				
				//schirm erstellen
				schirm = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm.setBounds(getBounds(getBounds()));
				schirm.setBackground(Color.green);
				schirm.setFont(new Font("Arial", Font.PLAIN, 40));
				p1.add(schirm);
				
				schirm = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm.setBounds(getBounds(getBounds()));
				schirm.setBackground(Color.green);
				schirm.setFont(new Font("Arial", Font.PLAIN, 40));
				p4.add(schirm);
				schirm.setEditable(false);
				
				schirm = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm.setBounds(getBounds(getBounds()));
				schirm.setBackground(Color.green);
				schirm.setFont(new Font("Arial", Font.PLAIN, 40));
				p7.add(schirm);
				
				//für das eigentliche zeichnen
				repaint();
			}

			private void setzen() {
				String Schiff = ComboBoxSchiff.getSelectedItem().toString();
				String Richtung = ComboBoxRichtung.getSelectedItem().toString();
				String Zelle = eingabesetzen.getText();
				int Anzahl = 0;
				
				//ACHTUNG! HIER KOMMT GERADE NOCH ANDAUERND EIN ERROR!!! Endlosschleife
				if(Anzahl < 11) {
					try {
						spieler1.setSchiff(Schiff, Richtung, Zelle);
						System.out.println("[GUI] Schiffsart: " + Schiff + ", Richtung: " + Richtung 
											+ ", Feld: " + Zelle);
						Anzahl = Anzahl + 1;
						System.out.println("Anzahl: " + Anzahl + " 111");
						aktualisieren(0);
					}
					catch(Exception  e) //Error Nachrichten
					{
						JOptionPane.showMessageDialog(this, e);
					}
				}
				else {
					try {
						spieler2.setSchiff(Schiff, Richtung, Zelle);
						System.out.println("[GUI] Schiffsart: " + Schiff + ", Richtung: " + Richtung 
											+ ", Feld: " + Zelle);
						Anzahl = Anzahl + 1;
						System.out.println("Anzahl: " + Anzahl + " 222");
						aktualisieren(2);
					}
					catch(Exception  e) //Error Nachrichten
					{
						JOptionPane.showMessageDialog(this, e);
					}
				}
				if(Anzahl >= 20) {
					setzenButton.setEnabled(false);
					System.out.println("[GUI] Setzen Button deaktiviert.");
					schussButton.setEnabled(true);
					System.out.println("[GUI] Schuss Button aktiviert.");
					spielbeginnt();	
				}
			}

			private void spielbeginnt() {
				if(Werspielt == 0) {
					//Schirm auf rechter Seite
					JOptionPane.showMessageDialog(this,"Spieler1 beginnt!");
				}
				if(Werspielt == 1) {
					linkerSchirm();
					JOptionPane.showMessageDialog(this,"Spieler2 beginnt!");
				} else {
					System.out.println("[GUI] Error! Es kam bei der Bestimmung des Startspielers zu einem Fehler");
				}
			}
			
			private void schuss() {
				String Zelle = eingabeschuss.getText();
				switch (Werspielt %2) {
				case 0:
					Werspielt = Werspielt + 1;
					try {
						if(spieler1.setSchuss(Zelle) == true) {
							aktualisieren(2);
						} else {
							aktualisieren(2);
							JOptionPane.showMessageDialog(this, "   Spieler 1 hat gewonnen! \n   "
									+ "Um erneut zu spielen schließen Sie das Programm \n   "
									+ "und starten Sie es von neuem.");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, e);
					}
				case 1:
					Werspielt = Werspielt + 1;
					try {
						if(spieler2.setSchuss(Zelle) == true) {
							aktualisieren(3);
						} else {
							aktualisieren(3);
							JOptionPane.showMessageDialog(this, "   Spieler 2 hat gewonnen! \n   "
									+ "Um erneut zu spielen schließen Sie das Programm \n   "
									+ "und starten Sie es von neuem.");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, e);
					}
				default:
					System.out.println("[GUI] Error! Es kam bei der Bestimmung wer schiesst zu einem Fehler");
				}
			}
			
			private void aktualisieren(int i) {
			switch (i) {
			case 0: //Setzen, Änderung bei Spieler1
				setzen1();
			case 1: //Setzen, Änderung bei Spieler2
				setzen2();
			case 2: //Spieler 1 schiesst, Änderung bei Spieler2 und Notizen1
				s1schuss();
			case 3: //Spieler 2 schiesst, Änderung bei Spieler1 und Notizen2
				s2schuss();
			default:
				System.out.println("[GUI] Error! Es kam bei der Bestimmung welche Art von "
						+ "Aktualisierung zu einem Fehler");
				}
			}
			
			//ACHTUNG! Eigentlich schon zu viele Einrückungen. Wie anders machen? Oder drauf pfeifen?
			private void setzen1() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler1.getType(i,j) == true) {
							datenMatrixs1[i][j] = "+";
						}
					}
				}
				((AbstractTableModel) tabellespieler1.getModel()).fireTableDataChanged();
			}
			
			private void setzen2() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler2.getType(i,j) == true) {
							datenMatrixs2[i][j] = "+";
						}
					}
				}
				((AbstractTableModel) tabellespieler2.getModel()).fireTableDataChanged();
			}
			
			private void s1schuss() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler2.getStatus(i,j) == true && spieler2.getType(i, j) == true) {
							datenMatrixs2[i][j] = "X";
						}
						if(spieler2.getVersenkt(i, j) == true) {
							datenMatrixs2[i][j] = "#";
						}
						else {
							datenMatrixs2[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellespieler2.getModel()).fireTableDataChanged();
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler2.getStatus(i,j) == true && spieler2.getType(i, j) == true) {
							datenMatrixn1[i][j] = "X";
						}
						if(spieler2.getVersenkt(i, j) == true) {
							datenMatrixn1[i][j] = "#";
						}
						else {
							datenMatrixn1[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellenotizen1.getModel()).fireTableDataChanged();
			}
			
			private void s2schuss() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler1.getStatus(i,j) == true && spieler1.getType(i, j) == true) {
							datenMatrixs1[i][j] = "X";
						}
						if(spieler1.getVersenkt(i, j) == true) {
							datenMatrixs1[i][j] = "#";
						}
						else {
							datenMatrixs1[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellespieler1.getModel()).fireTableDataChanged();
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler1.getStatus(i,j) == true && spieler1.getType(i, j) == true) {
							datenMatrixn2[i][j] = "X";
						}
						if(spieler1.getVersenkt(i, j) == true) {
							datenMatrixn2[i][j] = "#";
						}
						else {
							datenMatrixn2[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellenotizen2.getModel()).fireTableDataChanged();
			}
			
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