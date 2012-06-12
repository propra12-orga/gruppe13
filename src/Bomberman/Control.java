package Bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
/**
 * Die Steuerung 
 */
public class Control {
	public static int maxbomb1 = 2;
	public static int maxbomb2 = 2;
	public static int[] counter = new int[2];

	public Control(final JFrame f, final Figur bm, final JFeld feld, int nr) {
		counter[0] = 0;
		if (JFeld.multi == true) {
			counter[1] = 0;
		}

		switch (nr) {
		/**
		 * Steuerung: 0=Pfeiltasten ; 1=w a s d
		 */
		case 0:
			f.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					/**
					 * Auslesen der gedrückten Tasten
					 * entsprechende Reaktion
					 */
					switch (e.getKeyCode()) {
					case 65:
						// a
						bm.links(feld.getmap());
						break;
					case 87:
						// w
						bm.oben(feld.getmap());
						break;
					case 68:
						// d
						bm.rechts(feld.getmap());
						break;
					case 83:
						// s
						bm.unten(feld.getmap());
						break;
					case 32:
						// spacebar
						if (counter[0] < maxbomb1) {
							new TBomb(bm.getxPosition(), bm.getyPosition(),
									feld.getmap(), 0).start();
							counter[0]++;
						}
						break;
					default:
						break;
					}

				}

				@Override
				public void keyTyped(KeyEvent e) {

				}
			});
			break;
		case 1:
			f.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					/**
					 * Auslesen der gedrückten Tasen, hier 2P noch
					 * entsprechende Reaktion
					 */
					switch (e.getKeyCode()) {
					case 37:
						// links
						bm.links(feld.getmap());
						f.repaint();
						break;
					case 38:
						// oben
						bm.oben(feld.getmap());
						f.repaint();
						break;
					case 39:
						// rechts
						bm.rechts(feld.getmap());
						f.repaint();
						break;
					case 40:
						// unten
						bm.unten(feld.getmap());
						f.repaint();
						break;
					case 8:
						// enter
						if (counter[1] < maxbomb2) {
							new TBomb(bm.getxPosition(), bm.getyPosition(),
									feld.getmap(), 1).start();
							counter[1]++;
						}
						break;
					default:
						break;
					}

				}

				@Override
				public void keyTyped(KeyEvent e) {

				}
			});
			break;
		default:
			break;
		}

	}

}
