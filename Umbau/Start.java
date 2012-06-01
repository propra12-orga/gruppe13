import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Start {

	// Spielfeldgroesse:
	public static int mapWidth = 19;
	public static int mapHeight = 19;
	// Kachelgroesse (Standard: 32x32 Pixel):
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	public static JFrame frame;
	public static Spielmenue menue = new Spielmenue("Bomberman - Menü");
	public static FeldGP gp;
	public static boolean go = false;

	public static Figur bomberman;
	private static Feld f;

	public static void main(String[] args) {
		// go wird erst mit dem Klick auf Start auf true gesetzt
		while (!go) {
		}

		// Instantiierung von BM
		bomberman = new Figur(1, 1);
		// Instantiierung von GP
		gp = new FeldGP(f);
		// Übergabe der GP an BM
		bomberman.setGP(gp);

		// Zuweisung der GP an das Frame
		frame.setGlassPane(gp);
		frame.getGlassPane().setVisible(true);

		// Key-Listener, implementiert die Steuerung durch
		// Pfeiltasten
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Auslesen der gedrückten Tasten
				// entsprechende Reaktion
				switch (e.getKeyCode()) {
				case 37:
					// links
					bomberman.links(f);
					break;
				case 38:
					// oben
					bomberman.oben(f);
					break;
				case 39:
					// rechts
					bomberman.rechts(f);
					break;
				case 40:
					// unten
					bomberman.unten(f);
					break;
				case 32:
					// spacebar
					Bombe bomb = new Bombe(bomberman.getxPosition(), bomberman
							.getyPosition(), f);

					// try {
					bomb.start();
					// } catch (InterruptedException e1) {
					// // TODO Auto-generated catch block
					// e1.printStackTrace();
					// }

					break;
				default:
					break;
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		});
		// FieldEntry[][] map = f.getmap();
		// System.out.println(map[1][3].getItem());
		// System.out.println(map[3][1].getItem());

		// alle �nderungen sollen hier
		// erfasst und neu gezeichnet
		// werden.
		while (frame.isVisible() == true) {
			f = Synchroniser.feldaktualisierung();
			f.repaint(); // repaint funktioniert wahrscheinlich anders
			try {
				Thread.sleep(40);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static int getTileWidth() {
		return tileWidth;
	}

	public static Feld getFeld() {
		return f;
	}
}
