package Bomberman;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Meldung {

	private int n;

	public Meldung(int zahl) {
		this.n = zahl;
	}

	public static void main(String[] args) {
	}

	/*
	 * Image[] bild = new Image[2];
	 * 
	 * bild[0] = new ImageIcon(this.getClass().getResource(
	 * "/images/Niederlage1P.jpg")).getImage(); bild[1] = new
	 * ImageIcon(this.getClass().getResource( "/images/Sieg1P.jpg")).getImage();
	 */

	public void start() {

		ImageIcon[] bild = new ImageIcon[2];

		bild[0] = new ImageIcon(this.getClass().getResource(
				"/images/Niederlage1P.jpg"));
		bild[1] = new ImageIcon(this.getClass().getResource(
				"/images/Sieg1P.jpg"));

		show(bild[n]);

	}

	private static void show(ImageIcon img) {
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
