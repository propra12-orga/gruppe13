package Bomberman;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JMenue extends JFrame implements ActionListener {

	/**
	 * 
	 */
	// Spielfeldgroesse:
	public static int mapWidth = 19;
	public static int mapHeight = 19;
	// Kachelgroesse (Standard: 32x32 Pixel):
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;

	public static JFeld feld;

	private static final long serialVersionUID = 1L;

	public JMenue(String t) {

		setTitle(t);
		LayoutManager manager = new FlowLayout();
		setLayout(manager);

		JButton spielstarten1P = new JButton("Spiel starten (1P)");
		spielstarten1P.setActionCommand("go1");
		spielstarten1P.addActionListener(this);
		add(spielstarten1P);
		JButton spielstarten2P = new JButton("Spiel starten (2P)");
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

			// Spielfeld erstellen
			feld = new JFeld(mapWidth, mapHeight, tileWidth, tileHeight,
					"random", false);
			feld.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					feld.setVisible(false);
					setVisible(true);
				}
			});
			// Menue ausblenden beim Spielstart
			setVisible(false);

		}
		// Spiel starten 2P
		if (arg0.getActionCommand().equals("go2")) {

			// Spielfeld erstellen
			feld = new JFeld(mapWidth, mapHeight, tileWidth, tileHeight,
					"random", true);
			feld.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					feld.setVisible(false);
					setVisible(true);
				}
			});
			// Menue ausblenden beim Spielstart
			setVisible(false);

		}

	}

}
