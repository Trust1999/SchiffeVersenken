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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SchiffeDaten.SchiffeData;

public class SchiffeVersenkenGUI extends JFrame {
	
	private SchiffeData spieler1;
	private SchiffeData spieler2;
	private JTextArea spielfeldTextArea;
	private JLabel infoLabel;
	private JTextField eingabeschuss;
	private JTextField eingabesetzen;
	
	private JTable tabellespieler1;
	private JTable tabellespieler2;
	private JTable tabellenotizen1;
	private JTable tabellenotizen2;
	
	
	private String[] header = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private String[][] datenMatrix = {
			{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
	} ; //Zwischenspeicher/Cache
	
	// Panel1 - Spielfeld1
	private JPanel p1;
	
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
	
	// Panel8 - Setzen
	private JPanel p8;
	private JComboBox ComboBox;
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
				tabellespieler1 = new JTable(datenMatrix, header);
				tabellespieler1.setBounds(50, 50, 150, 160);
				p1.add(tabellespieler1, BorderLayout.CENTER);

				
				//P2-Legende
				p2.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Legende:");
				infoLabel.setBounds(30, 10, 80, 20);
				p2.add(infoLabel);
				
				spielfeldTextArea = new JTextArea("\n   weißes Feld = leeres Feld \n\n   schwarzes Kreuz = Schiff \n\n   grünes Kreuz = Schuss auf leeres Feld \n\n   rotes Kreuz = Schuss hat Schiff getroffen \n\n   (Kreise = Schiff versenkt)");
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
				
				datenMatrix = new String[10][10]; // 10x10 Matrix + Kopf und Seite
				tabellespieler2 = new JTable(datenMatrix, header);
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
				schussButton.addActionListener(e -> aktualisieren());
				
				
				//P6-Leer
				p6.setBackground(Color.decode("#98EAE9"));
				
				//P7-Notizen1
				p7.setBackground(Color.decode("#98EAE9"));
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
				tabellenotizen1 = new JTable(datenMatrix, header);
				tabellenotizen1.setBounds(50, 50, 150, 160);
				p7.add(tabellenotizen1, BorderLayout.CENTER);
				
				//P8-Setzen
				p8.setBackground(Color.decode("#98EAE9"));
				infoLabel = new JLabel("Setzen:");
				infoLabel.setBounds(30, 1, 50, 20);
				p8.add(infoLabel);
				
				ComboBox = new JComboBox<String>(schiffart);
				ComboBox.setBounds(30, 30, 300, 25);
				p8.add(ComboBox);
				ComboBox = new JComboBox<String>(richtungen);
				ComboBox.setBounds(30, 65, 300, 25);
				p8.add(ComboBox);
				
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
				tabellenotizen2 = new JTable(datenMatrix, header);
				tabellenotizen2.setBounds(50, 50, 150, 160);
				p9.add(tabellenotizen2, BorderLayout.CENTER);
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

			private void setzen() {
				//Auslesen Schiff, Richtung, Feld(noch hinzufügen!!!!)
				try {
					spieler1.setSchiff();
					aktualisieren();
				}
				catch(Exception  e) //error Nachrichten
				{
					JOptionPane.showMessageDialog(this, e);
					//Filler: "Achtung! Sie haben eine flasche Eingabe betätigt. \nBitte versuchen Sie es noch einmal. \nZur Erinnerung: Die Eingabe in den Textfeldern muss \ndie Form GroßbuchstabeZahl (z.B. A1, B2, C3, ...) haben."
				}
				aktualisieren();
			}

			private void aktualisieren() {
			//for Zeile,Spalte	
				if(spieler1.getZustand(0, 0)) {	// .getZustand(int, int)-->boolean True = treffer
					//spieler1/2.getType(0,0,) --> (Feldtype)-->boolean True=Schiff
				}
				else {
					//spieler1/2.getType(0,0,) --> (Feldtype)-->boolean True=Schiff
				}
			}
		}
			
