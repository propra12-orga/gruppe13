package Bomberman;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import multiplayer.MyClientSocket;
import multiplayer.MyServerSocket;

public class JMenue extends JFrame implements ActionListener {

	/**
	 * Spielfeldbreite
	 */
	public static int mapWidth = 19;
	/**
	 * Spielfeldhöhe
	 */
	public static int mapHeight = 19;

	/**
	 * Kachelbreite in Pixel
	 */
	public static final int tileWidth = 32;
	/**
	 * Kachelhöhe in Pixel
	 */
	public static final int tileHeight = 32;
	/**
	 * Zahl der Level
	 */
	public static int max = 16;

	public static JFeld feld;
	public static JJFrame frame;
	static Figur bm1, bm2;
	public static Sounds sound = new Sounds();
	/**
	 * boolean stopper fuer Menuesound
	 */
	public static boolean stopper = true;
	public static boolean load = false;

	/**
	 * Zeichnet das Feld immer wieder neu
	 */
	static javax.swing.Timer t = new javax.swing.Timer(1, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
	});
	/**
	 * Timer fuer das Tutorial. Hier sind saemtliche Abfragen fuer die einzelnen
	 * Schritte enthalten
	 */
	public static boolean check1 = true;
	public static boolean check2 = false;
	public static boolean check3 = false;
	static javax.swing.Timer tut = new javax.swing.Timer(1,
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.repaint();
					// Abfrage, ob Spieler die geforderte Stelle erreicht hat
					if (bm1.getxPosition() == 9 && bm1.getyPosition() == 9
							&& check1) {
						JOptionPane.showMessageDialog(null, "Geschafft!");
						check1 = false;
						// Spielfeld modifizieren
						feld.getmap()[7][9] = JFeld.entry[8];
						feld.getmap()[9][7] = JFeld.entry[8];
						feld.getmap()[8][8] = JFeld.entry[0];
						frame.repaint();
						JOptionPane
								.showMessageDialog(
										null,
										"Schritt 2:\n"
												+ "Sie sehen, dass sich das Spielfeld geaendert hat.\n"
												+ "Sie sind jetzt von zwei zerstoerbaren X-Feldern und einem festen sincos-Feld umgeben.\n"
												+ "Zerstoeren Sie die beiden X-Felder nacheinander, indem Sie vor das Feld mit der "
												+ "Leertaste eine Bombe legen.\n"
												+ "Passen Sie auf, dass Sie nicht im Bereich des Explosionsradius sind.\n"
												+ "Die Explosion verbreitet sich jeweils ein Feld nach oben, unten\n"
												+ "links und rechts.");
						check2 = true;
					}
					// Abfrage, ob Spieler X-Felder zerstoert hat
					if (feld.getmap()[7][9].getImage() == 1
							&& feld.getmap()[9][7].getImage() == 1 && check2) {
						JOptionPane.showMessageDialog(null, "Geschafft!");
						check2 = false;
						// Spielfeld erneut modifizieren und
						// zufaellige Bloecke erstellen
						// (Aufbau wie Level 1)
						for (int i = 1; i < 9; i += 2) {
							for (int j = 1; j < 9; j += 2) {
								feld.getmap()[i + 1][j + 1] = JFeld.entry[0];
								feld.getmap()[i][j + 1] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
								feld.getmap()[i + 1][j] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
								feld.getmap()[i][9] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
								feld.getmap()[i + 1][9] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
								feld.getmap()[9][j] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
								feld.getmap()[9][j + 1] = JFeld.entry[(int) (Math
										.random() * 2 + 1)];
							}
						}
						// Diese Schleife ersetzt die X-Felder, damit im
						// Tutorial keine Items erscheinen!
						for (int i = 1; i < 9; i++) {
							for (int j = 1; j < 9; j++) {
								if (feld.getmap()[i][j].getImage() == 2) {
									feld.getmap()[i][j] = JFeld.entry[8];
								}
							}
						}

						// Damit der Spieler nicht eingesperrt wird, folgene
						// Felder festsetzen
						feld.getmap()[8][9] = JFeld.entry[1];
						feld.getmap()[9][8] = JFeld.entry[1];
						feld.getmap()[2][9] = JFeld.entry[8];
						feld.getmap()[1][8] = JFeld.entry[8];
						feld.getmap()[1][9] = JFeld.entry[3];
						frame.repaint();
						JOptionPane
								.showMessageDialog(
										null,
										"Schritt 3:\n"
												+ "Sie sehen nun in der linken unteren Ecke ein Viereck.\n"
												+ "Dies stellt den Ausgang dar.\n"
												+ "Ihre letzte Aufgabe besteht nun darin, den Ausgang zu erreichen.\n"
												+ "Um Ihnen den Weg nicht zu leicht zu machen, haben wir noch ein\n"
												+ "paar Steine in den Weg gelegt.\n"
												+ "Wichtig: Im Spiel kann sich der Ausgang hinter einem X verbergen.");
						check3 = true;
					}
					// Abfrage, ob der Spieler den Ausgang erreicht hat
					if (bm1.getxPosition() == 1 && bm1.getyPosition() == 9
							&& check3) {
						JOptionPane
								.showMessageDialog(
										null,
										"Geschafft!\n"
												+ "Herzlichen Glueckwunsch. Sie haben das Tutorial erfolgreich abgeschlossen.\n"
												+ "Probieren Sie doch gleich mal die verschiedenen Level aus.\n"
												+ "Noch ein Tipp: Sie werden im Spiel auf verschiedene Gegenstaende treffen.\n"
												+ "Diese koennen den Explosionsradius Ihrer Bomben erhoehen oder erlauben etwa\n"
												+ "das Legen von mehreren Bomben gleichzeitig.\n"
												+ "Viel Spass beim Spielen.");
						check3 = false;
						tut.stop();
					}
				}
			});

	private static final long serialVersionUID = 1L;

	public JMenue(String t) {
		sound.start();
		setTitle(t);
		LayoutManager manager = new FlowLayout();
		setLayout(manager);

		JButton spielstarten1P = new JButton("Einzelspieler");
		spielstarten1P.setActionCommand("go1");
		spielstarten1P.addActionListener(this);
		add(spielstarten1P);
		JButton spielstarten2P = new JButton("Mehrspieler");
		spielstarten2P.setActionCommand("go2");
		spielstarten2P.addActionListener(this);
		add(spielstarten2P);
		JButton spielstarten3P = new JButton("Netzwerk (Host)");
		spielstarten3P.setActionCommand("go3");
		spielstarten3P.addActionListener(this);
		add(spielstarten3P);
		JButton spielstarten4P = new JButton("Netzwerk (Client)");
		spielstarten4P.setActionCommand("go4");
		spielstarten4P.addActionListener(this);
		add(spielstarten4P);
		JButton tut = new JButton("Tutorial");
		tut.setActionCommand("go5");
		tut.addActionListener(this);
		add(tut);
		JButton load = new JButton("Spielstand laden");
		load.setActionCommand("go6");
		load.addActionListener(this);
		add(load);
		JButton spielbeenden = new JButton("Spiel beenden");
		spielbeenden.setActionCommand("exit");
		spielbeenden.addActionListener(this);
		add(spielbeenden);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) {

		/**
		 * Spiel beenden
		 */
		if (arg0.getActionCommand().equals("exit")) {
			System.exit(0);
		}
		/**
		 * Spiel starten
		 */
		if (arg0.getActionCommand().equals("go1")) {
			/**
			 * Spielfeld auslesen
			 */
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = null;
			int zahl = 0;
			boolean check = true;
			FieldEntry.itemm = true;
			while (nr == null || Math.abs(zahl) > max || !check) {
				check = true;
				nr = JOptionPane
						.showInputDialog(
								"Waehlen Sie ein Level X aus. (1-"
										+ max
										+ ")\nTipp: Waehle -X fuer eine zufaellige Verteilung der zerstoerbaren Bloecke.",
								"0");
				// abbrechen
				if (nr == null) {
					break;
				}
				try {
					zahl = Integer.parseInt(nr);
					if (nr.substring(0, 1).equals("0") && !nr.equals("0")) {
						JOptionPane.showMessageDialog(null,
								"Kein gueltiges Level.");
						check = false;
					}
					if (nr.equals("0")) {
						nr = "" + (int) (Math.random() * (JMenue.max) + 1);
					}
					if (nr.equals("-0")) {
						nr = "-" + (int) (Math.random() * (JMenue.max) + 1);
					}
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null, "Kein gueltiges Level.");
				}
			}
			if (nr != null) {
				Mapreader create = new Mapreader(nr, load);
				feld = new JFeld(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, nr, false);
				frame = new JJFrame(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, feld, nr);
				bm1 = new Figur(1, 1, 1);
				new Control(frame, bm1, feld, 0, null, true);
				t.start();
			} else {
				setVisible(true);
				JMenue.stopper = true;// MenueSound wieder abspielen wenn
				// tot/neustart
				// etc
				Thread lala = new Sounds();
				lala.start();
			}
		}
		/**
		 * 2 Player Spiel starten
		 */
		if (arg0.getActionCommand().equals("go2")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = null;
			int zahl = 0;
			boolean check = true;
			FieldEntry.itemm = true;
			while (nr == null || Math.abs(zahl) > max || !check) {
				check = true;
				nr = JOptionPane
						.showInputDialog(
								"Waehlen Sie ein Level X aus. (1-"
										+ max
										+ ")\nTipp: Waehle -X fuer eine zufaellige Verteilung der zerstoerbaren Bloecke.",
								"0");
				if (nr == null) {
					break;
				}
				try {
					zahl = Integer.parseInt(nr);

					if (nr.substring(0, 1).equals("0") && !nr.equals("0")) {
						JOptionPane.showMessageDialog(null,
								"Kein gueltiges Level.");
						check = false;

					}
					if (nr.equals("0")) {
						nr = "" + (int) (Math.random() * (JMenue.max) + 1);
					}
					if (nr.equals("-0")) {
						nr = "-" + (int) (Math.random() * (JMenue.max) + 1);
					}
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null, "Kein gueltiges Level.");
				}
			}
			if (nr != null) {
				Mapreader create = new Mapreader(nr, load);
				feld = new JFeld(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, nr, true);
				frame = new JJFrame(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, feld, nr);
				bm1 = new Figur(1, 1, 1);
				bm2 = new Figur(create.getWidth() - 2, create.getHeight() - 2,
						2);
				new Control(frame, bm1, feld, 0, null, false);
				new Control(frame, bm2, feld, 1, null, false);
				t.start();
			} else {
				setVisible(true);
				JMenue.stopper = true;// MenueSound wieder abspielen wenn
				// tot/neustart
				// etc
				Thread lala = new Sounds();
				lala.start();
			}

		}

		/**
		 * Multiplayer Host
		 */
		if (arg0.getActionCommand().equals("go3")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = "1";
			JFeld.multi = true;
			FieldEntry.itemm = false;

			// statisches Level: 1
			Mapreader create = new Mapreader(nr, load);
			feld = new JFeld(create.getWidth(), create.getHeight(), tileWidth,
					tileHeight, nr, true);
			frame = new JJFrame(create.getWidth(), create.getHeight(),
					tileWidth, tileHeight, feld, nr);
			bm1 = new Figur(1, 1, 1);
			bm2 = new Figur(create.getWidth() - 2, create.getHeight() - 2, 2);

			// Instanz des Server-Sockets erstellen
			MyServerSocket sSocket = new MyServerSocket(bm2);

			Control control = new Control(frame, bm1, feld, 0, sSocket, false);
			// übergabe der Control-Instanz an das Server-Socket
			sSocket.setControl(control);

			t.start();

		}

		/**
		 * Multiplayer Client
		 */
		if (arg0.getActionCommand().equals("go4")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = "1";
			JFeld.multi = true;
			FieldEntry.itemm = false;

			// statisches Level: 1
			Mapreader create = new Mapreader(nr, load);
			feld = new JFeld(create.getWidth(), create.getHeight(), tileWidth,
					tileHeight, nr, true);
			frame = new JJFrame(create.getWidth(), create.getHeight(),
					tileWidth, tileHeight, feld, nr);
			bm1 = new Figur(1, 1, 1);
			bm2 = new Figur(create.getWidth() - 2, create.getHeight() - 2, 2);

			// Abfrage für die IP-Adresse der Servers
			String ip = JOptionPane.showInputDialog(frame, "IP des Hosts:",
					"IP", JOptionPane.QUESTION_MESSAGE);

			// Instanz des Client-Sockets erstellen
			MyClientSocket cSocket = new MyClientSocket(ip, bm1);

			Control control = new Control(frame, bm2, feld, 0, cSocket, false);
			// Control-Instanz an den Client-Socket übergeben
			cSocket.setControl(control);
			t.start();

		}
		/**
		 * Tutorial starten
		 */
		if (arg0.getActionCommand().equals("go5")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = "tut";
			Mapreader create = new Mapreader(nr, load);
			feld = new JFeld(create.getWidth(), create.getHeight(), tileWidth,
					tileHeight, nr, false);
			frame = new JJFrame(create.getWidth(), create.getHeight(),
					tileWidth, tileHeight, feld, nr);
			bm1 = new Figur(1, 1, 1);
			new Control(frame, bm1, feld, 0, null, false);
			// Einfuehrungstext
			JOptionPane
					.showMessageDialog(
							null,
							"Willkommen bei Final Derivation.\nIn diesem Level werden kurz die Steuerung, "
									+ "sowie die wichtigsten Elemente des Spiels erlaeutert.");
			JOptionPane
					.showMessageDialog(
							null,
							"Schritt 1: Bewegen Sie Ihre Spielfigur mit Hilfe der Tasten w,a,s,d.\n"
									+ "Mit w laufen Sie nach oben, mit s laufen Sie nach unten,\n"
									+ "Mit a laufen Sie nach links und mit d laufen Sie nach Rechts.\n"
									+ "Probieren Sie es aus und laufen Sie in die untere rechte Ecke.");
			tut.start();
		}
		/**
		 * Spielstand laden
		 */
		if (arg0.getActionCommand().equals("go6")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String lname = "";
			JFileChooser fc = new JFileChooser("src/saves/");
			fc.setDialogTitle("Spielstand laden");
			fc.setFileFilter(new FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.isDirectory()
							|| f.getName().toLowerCase().endsWith(".txt");
				}

				@Override
				public String getDescription() {
					return "Spielstand";
				}

			});
			int state = fc.showOpenDialog(null);
			if (state == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				lname = file.getName()
						.substring(0, file.getName().length() - 4);
				load = true;
				Mapreader create = new Mapreader(lname, load);
				feld = new JFeld(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, lname, false);
				frame = new JJFrame(create.getWidth(), create.getHeight(),
						tileWidth, tileHeight, feld, lname);
				int[] kor = create.pos();
				System.out.println(kor[1]);
				bm1 = new Figur(kor[0], kor[1], 1);
				new Control(frame, bm1, feld, 0, null, true);
				t.start();
			} else {
				setVisible(true);
				JMenue.stopper = true;// MenueSound wieder abspielen wenn
				// tot/neustart
				// etc
				Thread lala = new Sounds();
				lala.start();
			}
		}
	}

}
