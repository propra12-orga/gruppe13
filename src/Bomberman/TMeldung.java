package Bomberman;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Zeigt das richtige Bild bei Sieg oder Niederlage an.
 * 
 * @author Janka
 * 
 */
public class TMeldung extends Thread {

	private int n;
	private static ImageIcon[] bild = new ImageIcon[3];

	public TMeldung(int zahl) {
		this.n = zahl;
		bild[0] = new ImageIcon(this.getClass().getResource(
				"/images/Niederlage1P.jpg"));
		bild[1] = new ImageIcon(this.getClass().getResource(
				"/images/Sieg1P.jpg"));
		bild[2] = new ImageIcon(this.getClass().getResource(
				"/images/SiegPi.jpg"));
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