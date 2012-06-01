import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Spielmenue extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// public Start Start = new Start();

	public Spielmenue(String t) {

		setTitle(t);
		LayoutManager manager = new FlowLayout();
		setLayout(manager);

		JButton spielstarten = new JButton("Spiel starten");
		spielstarten.setActionCommand("go");
		spielstarten.addActionListener(this);
		add(spielstarten);
		JButton spielbeenden = new JButton("Spiel beenden");
		spielbeenden.setActionCommand("exit");
		spielbeenden.addActionListener(this);
		add(spielbeenden);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {

		// Spiel beenden
		if (arg0.getActionCommand().equals("exit")) {
			System.exit(0);
		}
		// Spiel starten
		if (arg0.getActionCommand().equals("go")) {
			Start.frame = new Spielfeld(Start.mapWidth, Start.mapHeight,
					Start.tileWidth, Start.tileHeight);
			Start.bomberman.setxPosition(1);
			Start.bomberman.setyPosition(1);
			Start.getFeld().generateMap();
			Start.gp = new FeldGP(Start.getFeld());
			Start.bomberman.setGP(Start.gp);
			Start.go = true;
			Start.frame.setGlassPane(Start.gp);
			Start.frame.setVisible(true);
			// Menue ausblenden beim Spielstart
			setVisible(false);
		}

	}
	/*
	 * public static void main(String[] args) { SpielMenu menu = new
	 * SpielMenu("Bomberman - Menü"); }
	 */
}
