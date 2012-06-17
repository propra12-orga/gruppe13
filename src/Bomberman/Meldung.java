package Bomberman;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Zeigt das richtige Bild bei Sieg oder Niederlage an.
 * @author Janka
 *
 */
public class Meldung {

	private int n;

	public Meldung(int zahl) {
		this.n = zahl;
	}

	public static void main(String[] args) {
	}

	public void start() {

		ImageIcon[] bild = new ImageIcon[3];

		bild[0] = new ImageIcon(this.getClass().getResource(
				"/images/Niederlage1P.jpg"));
		bild[1] = new ImageIcon(this.getClass().getResource(
				"/images/Sieg1P.jpg"));
		bild[2] = new ImageIcon(this.getClass().getResource(
				"/images/SiegPi.jpg"));

		show(bild[n]);

	}

	private static void show(ImageIcon img) {
		
		/**
		 *  Zeichnet das Bild, zeigt es fuer ein paar Sekunden und macht es dann
		 *  unsichtbar.
		 */
		// 
		JFrame anzeige = new JFrame();

		JLabel l1 = new JLabel(img);
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

		anzeige.setVisible(false);

	}

}
