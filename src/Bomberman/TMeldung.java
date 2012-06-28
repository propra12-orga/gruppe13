package Bomberman;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Zeigt das richtige Bild bei Sieg oder Niederlage an.
 * 
 * 
 * 
 */
public class TMeldung extends Thread {

	private int n;
	private static ImageIcon[] bild = new ImageIcon[5];

	public TMeldung(int zahl) {
		this.n = zahl;
		bild[0] = new ImageIcon(this.getClass().getResource(
				"/images/Niederlage1P.jpg")); // Singleplayer
		bild[1] = new ImageIcon(this.getClass().getResource(
				"/images/SiegeE.jpg")); // Multiplayer
		bild[2] = new ImageIcon(this.getClass().getResource(
				"/images/SiegPi.jpg")); // Multiplayer
		bild[3] = new ImageIcon(this.getClass().getResource(
				"/images/Sieg1P.jpg")); // Singleplayer
		bild[4] = new ImageIcon(this.getClass().getResource(
				"/images/DoppelKO.jpg")); // Multiplayer
	}

	public void run() {
		/**
		 * Zeichnet das Bild, zeigt es fuer ein paar Sekunden an
		 */
		//
		JFrame anzeige = new JFrame();

		JLabel l1 = new JLabel(bild[n]);
		JPanel pan = new JPanel();
		pan.add(l1);

		anzeige.add(pan);
		anzeige.pack();
		anzeige.setResizable(false);
		anzeige.setLocationRelativeTo(null);
		anzeige.pack();
		anzeige.setVisible(true);

		try {
			Thread.currentThread();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		anzeige.dispose();

	}

}
