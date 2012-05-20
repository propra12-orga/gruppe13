package SF;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SpielMenu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StartBomberman Start = new StartBomberman();

	public SpielMenu(String t) {

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
			StartBomberman.bomberman.setxPosition(1);
			StartBomberman.bomberman.setyPosition(1);
			StartBomberman.getFeld().generateMap();
			StartBomberman.gp = new FeldGP(StartBomberman.getFeld());
			StartBomberman.bomberman.setGP(StartBomberman.gp);
			StartBomberman.frame.setGlassPane(StartBomberman.gp);
			StartBomberman.frame.setVisible(true);
			// Menue ausblenden beim Spielstart
			setVisible(false);
		}

	}
	/*
	 * public static void main(String[] args) { SpielMenu menu = new
	 * SpielMenu("Bomberman - Menü"); }
	 */
}
