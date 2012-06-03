package Bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Control {

	public Control(final JFrame f, final Figur bm, final JFeld feld, int nr) {

		switch (nr) {
		// Steuerung 0=pfeiltasten 1=w a s d
		case 0:
			f.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// Auslesen der gedrückten Tasten
					// entsprechende Reaktion
					switch (e.getKeyCode()) {
					case 65:
						// a
						bm.links(feld.getmap());
						// f.repaint();
						break;
					case 87:
						// w
						bm.oben(feld.getmap());
						// f.repaint();
						break;
					case 68:
						// d
						bm.rechts(feld.getmap());
						// f.repaint();
						break;
					case 83:
						// s
						bm.unten(feld.getmap());
						// f.repaint();
						break;
					case 32:
						// spacebar
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
					// Auslesen der gedrückten Tasten
					// entsprechende Reaktion
					switch (e.getKeyCode()) {
					case 37:
						// links
						bm.links(feld.getmap());
						// f.repaint();
						break;
					case 38:
						// oben
						bm.oben(feld.getmap());
						// f.repaint();
						break;
					case 39:
						// rechts
						bm.rechts(feld.getmap());
						// f.repaint();
						break;
					case 40:
						// unten
						bm.unten(feld.getmap());
						// f.repaint();
						break;
					case 13:
						// enter
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
