package Bomberman;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JMenue extends JFrame implements ActionListener {

	/**
	 * Spielfeldgroesse
	 */
	public static int mapWidth = 19;
	public static int mapHeight = 19;
	/**
	 * Kachelgroesse
	 */
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	/**
	 * Zahl der Level
	 */
	public static int max = 15;

	public static JFeld feld;
	public static JJFrame frame;
	static Figur bm1, bm2;
	public static Sounds sound = new Sounds();
	public static boolean stopper = true;

	/**
	 * Zeichnet das Feld immer wieder neu
	 */
	static javax.swing.Timer t = new javax.swing.Timer(1, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
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

		// Spiel beenden
		if (arg0.getActionCommand().equals("exit")) {
			System.exit(0);
		}
		// Spiel starten 1P
		if (arg0.getActionCommand().equals("go1")) {
			// Spielfeld auslesen
			setVisible(false);
			stopper = false;// fuer Menuesound
			String nr = null;
			int zahl = 0;
			boolean check = true;
			while (nr == null || Math.abs(zahl) < 1 || Math.abs(zahl) > max
					|| !check) {
				check = true;
				nr = JOptionPane
						.showInputDialog("Waehlen Sie ein Level X aus. (1-"
								+ max
								+ ")\nTipp: Waehle -X fuer eine zufaellige Verteilung der zerstoerbaren Bloecke.");
				try {
					zahl = Integer.parseInt(nr);

					if (nr.substring(0, 1).equals("0")) {
						JOptionPane.showMessageDialog(null,
								"Kein gueltiges Level.");
						check = false;

					}
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null, "Kein gueltiges Level.");
				}
			}
			Mapreader create = new Mapreader(nr);
			feld = new JFeld(create.getWidth(), create.getHeight(), tileWidth,
					tileHeight, nr, false);
			frame = new JJFrame(mapWidth, mapHeight, tileWidth, tileHeight,
					feld, nr);
			bm1 = new Figur(1, 1);
			new Control(frame, bm1, feld, 0);
			t.start();
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
			while (nr == null || Math.abs(zahl) < 1 || Math.abs(zahl) > max
					|| !check) {
				check = true;
				nr = JOptionPane
						.showInputDialog("Waehlen Sie ein Level X aus. (1-"
								+ max
								+ ")\nTipp: Waehle -X fuer eine zufaellige Verteilung der zerstoerbaren Bloecke.");
				try {
					zahl = Integer.parseInt(nr);

					if (nr.substring(0, 1).equals("0")) {
						JOptionPane.showMessageDialog(null,
								"Kein gueltiges Level.");
						check = false;

					}
				} catch (NumberFormatException e) {
					JOptionPane
							.showMessageDialog(null, "Kein gueltiges Level.");
				}
			}
			Mapreader create = new Mapreader(nr);
			feld = new JFeld(create.getWidth(), create.getHeight(), tileWidth,
					tileHeight, nr, true);
			frame = new JJFrame(mapWidth, mapHeight, tileWidth, tileHeight,
					feld, nr);
			bm1 = new Figur(1, 1);
			bm2 = new Figur(mapHeight - 2, mapWidth - 2);
			new Control(frame, bm1, feld, 0);
			new Control(frame, bm2, feld, 1);
			t.start();

		}

	}

}
