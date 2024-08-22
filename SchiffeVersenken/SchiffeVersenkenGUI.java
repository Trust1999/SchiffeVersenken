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
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenkenGUI extends JFrame {

	
	Random zufall = new Random();	//Bestimmung der Speilerreihenfolge
	private int Werspielt = zufall.nextInt(2); //0 - inclusiv, 2 - exclusiv => 0 und 1
	
	private SchiffeData spieler1;
	private SchiffeData spieler2;
	private int Anzahl = 0;
	
	private JTextArea spielfeldTextArea;
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
	private JTextArea schirm1;
	
	// Panel2 - Legende
	private JPanel p2;
	private JButton regelnButton;
	
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
	private JTextArea schirm4;
	
	// Panel4 - Leer
	private JPanel p4;
	private JTextArea schirm2;
	
	// Panel5 - Schuss
	private JPanel p5;
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
	private JTextArea schirm3;
	
	// Panel8 - Setzen
	private JPanel p8;
	private JComboBox ComboBoxSchiff;
	private JComboBox ComboBoxRichtung;
	private String[] schiffart = {"Schlachtschiff (5 Kästchen) [1 Stück]","Kreuzer (4 Kästchen) [2 Stück]",
									"Zerstörer (3 Kästchen) [3 Stück]","U-Boot (2 Kästchen) [4 Stück]"};
	private String[] richtungen = {"Norden","Osten","Süden","Westen"};
	private JButton setzenButton;
	
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
	private JTextArea schirm6;
	
	/*****************************************************************
	 *****************************************************************/
	
	public SchiffeVersenkenGUI (SchiffeData d, SchiffeData f) {
		
		this.spieler1= d;	
		this.spieler2= f;
		
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
				regelnButton.addActionListener(e -> regeln_anzeigen());
				
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
				eingabeschuss.setEnabled(false);
				
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
				
				datenMatrixn2 = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellenotizen2 = new JTable(datenMatrixn2, header);
				tabellenotizen2.setBounds(50, 50, 150, 160);
				p9.add(tabellenotizen2, BorderLayout.CENTER);
				
				rechterSchirmAn();
				//JOptionPane.showMessageDialog(this, "Spieler 1 setzt zuerst alle seine/ihre Schiffe.");
				
				
	}
		
	/*****************************************************************
	 *****************************************************************/
	
			private void setzen() {
				String Schiff = ComboBoxSchiff.getSelectedItem().toString();
				String Richtung = ComboBoxRichtung.getSelectedItem().toString();
				String Zelle = eingabesetzen.getText();
				
				
				/*TODO
				 * hier kommt neue Funktion
				 * spieler1.Spielerwechsel(); false ->wechsel
				 */
				if(Anzahl < 2) { // 10 //spieler1.Spielerwechsel() && debungging ->aus
					try {
						
						spieler1.setSchiff(Schiff, Richtung, Zelle);
						System.out.println("[GUI] Schiffsart: " + Schiff + ", Richtung: " + Richtung 
											+ ", Feld: " + Zelle);
						Anzahl = Anzahl + 1;
						System.out.println("Anzahl: " + Anzahl + " Spieler 1");
						setzen1();
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
						System.out.println("Anzahl: " + Anzahl + " Spieler 2");
						setzen2();
					}
					catch(Exception  e) //Error Nachrichten
					{
						JOptionPane.showMessageDialog(this, e);
					}
				}
				//Schirmwechsel
				if(Anzahl == 2) { //10
					setzenButton.setEnabled(false);
					Timer timer = new Timer(1000, ex -> {
						rechterSchirmAus();
						linkerSchirmAn();
						setzenButton.setEnabled(true);
					});
					timer.setRepeats(false);
					timer.start();
					
				}
				/*TODO
				 * hier kommt neue Funktion
				 * spieler2.Spielerwechsel(); false ->wechsel
				 */
				if(Anzahl >= 4) {
					rechterSchirmAn();
					setzenButton.setEnabled(false);
					eingabesetzen.setEnabled(false);
					eingabesetzen.setText("");
					System.out.println("[GUI] Setzen Button und Setzen Eingabefeld deaktiviert.");
					schussButton.setEnabled(true);
					eingabeschuss.setEnabled(true);
					System.out.println("[GUI] Schuss Button und Schuss Eingabefeld aktiviert.");
					spielbeginnt();	
				}
			}

			private void spielbeginnt() {
				if(Werspielt == 0) {
					//Schirm auf rechter Seite
					JOptionPane.showMessageDialog(this,"Spieler1 beginnt!");
					linkerSchirmAus();
				}
				if(Werspielt == 1) {
					linkerSchirmAn();
					JOptionPane.showMessageDialog(this,"Spieler2 beginnt!");
					rechterSchirmAus();
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
						if(spieler2.setSchuss(Zelle)) {
							System.out.println("[GUI] Tabelle wird aktualisiert");
							s1schuss();
							JOptionPane.showMessageDialog(this, "Spielerwechsel: Spieler 2 ist dran.");
							rechterSchirmAus();
							linkerSchirmAn();
							break;
						} else {
							s1schuss();
							rechterSchirmAus();
							JOptionPane.showMessageDialog(this, "   Spieler 1 hat gewonnen! \n   "
									+ "Um erneut zu spielen schließen Sie das Programm \n   "
									+ "und starten Sie es von neuem.");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, e);
					}
					break;
				case 1:
					Werspielt = Werspielt + 1;
					try {
						if(spieler1.setSchuss(Zelle)) {
							System.out.println("[GUI] Tabelle wird aktualisiert");
							s2schuss();
							JOptionPane.showMessageDialog(this, "Spielerwechsel: Spieler 1 ist dran.");
							linkerSchirmAus();
							rechterSchirmAn();
							break;
						} else {
							s2schuss();
							linkerSchirmAus();
							JOptionPane.showMessageDialog(this, "   Spieler 2 hat gewonnen! \n   "
									+ "Um erneut zu spielen schließen Sie das Programm \n   "
									+ "und starten Sie es von neuem.");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this, e);
					}
					break;
				default:
					System.out.println("[GUI] Error! Es kam bei der Bestimmung wer schiesst zu einem Fehler");
					break;
				}
			}
			
			//ACHTUNG! Eigentlich schon zu viele Einrückungen.
			private void setzen1() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler1.getType(i,j)) {
							datenMatrixs1[i][j] = "+";
						}
					}
				}
				((AbstractTableModel) tabellespieler1.getModel()).fireTableDataChanged();
			}
			
			private void setzen2() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler2.getType(i,j)) {
							datenMatrixs2[i][j] = "+";
						}
					}
				}
				((AbstractTableModel) tabellespieler2.getModel()).fireTableDataChanged();
			}
			
			private void s1schuss() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler2.getStatus(i,j) && spieler2.getType(i,j)) {
							datenMatrixs2[i][j] = "X";
							datenMatrixn1[i][j] = "X";
							if(spieler2.getVersenktGUI(i, j)) {
								datenMatrixs2[i][j] = "#";
								datenMatrixn1[i][j] = "#";
							}
						}
						else if(spieler2.getStatus(i, j)){
							datenMatrixs2[i][j] = "O";
							datenMatrixn1[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellespieler2.getModel()).fireTableDataChanged();
				((AbstractTableModel) tabellenotizen1.getModel()).fireTableDataChanged();
			}
			
			private void s2schuss() {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(spieler1.getStatus(i,j) && spieler1.getType(i,j)) {
							datenMatrixs1[i][j] = "X";
							datenMatrixn2[i][j] = "X";
							if(spieler1.getVersenktGUI(i, j)) {
								datenMatrixs1[i][j] = "#";
								datenMatrixn2[i][j] = "#";
							}
						}
						else if(spieler1.getStatus(i, j)){
							datenMatrixs1[i][j] = "O";
							datenMatrixn2[i][j] = "O";
						}
					}
				}
				((AbstractTableModel) tabellespieler1.getModel()).fireTableDataChanged();
				((AbstractTableModel) tabellenotizen2.getModel()).fireTableDataChanged();
			}
			
			private void linkerSchirmAn() {
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
				schirm1 = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm1.setBounds(getBounds(getBounds()));
				schirm1.setBackground(Color.green);
				schirm1.setFont(new Font("Arial", Font.PLAIN, 40));
				p1.add(schirm1);
				schirm1.setEditable(false);
				
				linkerSchirmMitteAn();
				
				schirm3 = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm3.setBounds(getBounds(getBounds()));
				schirm3.setBackground(Color.green);
				schirm3.setFont(new Font("Arial", Font.PLAIN, 40));
				p7.add(schirm3);
				schirm3.setEditable(false);
				
				//für das eigentliche zeichnen
				repaint();
			}
			
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
				schirm1.setVisible(false);
				
				linkerSchirmMitteAus();
				
				schirm3.setVisible(false);
			}
			
			private void linkerSchirmMitteAn() {
				schirm2 = new JTextArea("\n\n       Spieler 2 ist dran");
				schirm2.setBounds(getBounds(getBounds()));
				schirm2.setBackground(Color.green);
				schirm2.setFont(new Font("Arial", Font.PLAIN, 40));
				p4.add(schirm2);
				schirm2.setEditable(false);
				repaint();
			}
			
			private void linkerSchirmMitteAus() {
				schirm2.setVisible(false);
			}
			
			private void rechterSchirmAn() {
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
				
				//schirm erstellen
				schirm4 = new JTextArea("\n\n       Spieler 1 ist dran");
				schirm4.setBounds(getBounds(getBounds()));
				schirm4.setBackground(Color.green);
				schirm4.setFont(new Font("Arial", Font.PLAIN, 40));
				p3.add(schirm4);
				schirm4.setEditable(false);
				
				rechterSchirmMitteAn();
				
				schirm6 = new JTextArea("\n\n       Spieler 1 ist dran");
				schirm6.setBounds(getBounds(getBounds()));
				schirm6.setBackground(Color.green);
				schirm6.setFont(new Font("Arial", Font.PLAIN, 40));
				p9.add(schirm6);
				schirm6.setEditable(false);
				
				//für das eigentliche zeichnen
				repaint();
			}
			
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
				schirm4.setVisible(false);
				
				rechterSchirmMitteAus();
				
				schirm6.setVisible(false);
			}
			
			private void rechterSchirmMitteAn() {
				schirm5 = new JTextArea("\n\n       Spieler 1 ist dran");
				schirm5.setBounds(getBounds(getBounds()));
				schirm5.setBackground(Color.green);
				schirm5.setFont(new Font("Arial", Font.PLAIN, 40));
				p6.add(schirm5);
				schirm5.setEditable(false);
				repaint();
			}
			
			private void rechterSchirmMitteAus() {
				schirm5.setVisible(false);
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
