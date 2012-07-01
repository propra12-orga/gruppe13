package Bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import multiplayer.MySockets;

public class Control {
	// Klassenvariablen
	public static int[] maxbomb = new int[] { 1, 1 };
	public static int[] counter = new int[] { 0, 0 };

	private JFeld feld = null;
	private MySockets socket = null;

	public Control(final JFrame f, final Figur bm, final JFeld feld, int nr,
			MySockets socket) {
		this.feld = feld;
		this.socket = socket;

		switch (nr) {
		// Steuerung: 0=pfeiltasten ; 1=w a s d
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
						// An den anderen Spieler senden, dass die Bombe
						// gelegt wurde
						if (Control.this.socket != null) {
							Control.this.socket.send(
									new Figur(bm.getxPosition(), bm
											.getyPosition(), 1), true);
						}
						bombeLegen(bm);
						break;
					case 121:
						// speichert den Spielstand
						Mapsaver save = new Mapsaver("test", feld.getmap(),
								feld.height(), feld.width(), bm.getxPosition(),
								bm.getyPosition());
						save.start();
						System.out.println("Ich bin F10!");
						break;
					default:
						break;
					}

					if (Control.this.socket != null) {
						Control.this.socket.send(new Figur(bm.getxPosition(),
								bm.getyPosition(), 1), false);
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
						break;
					case 38:
						// oben
						bm.oben(feld.getmap());
						break;
					case 39:
						// rechts
						bm.rechts(feld.getmap());
						break;
					case 40:
						// unten
						bm.unten(feld.getmap());
						break;
					case 8:
						// Backspace
						if (counter[1] < maxbomb[1]) {
							new TBomb(bm.getxPosition(), bm.getyPosition(),
									feld.getmap(), 1).start();
							counter[1]++;
							Thread d = new Sounds2();
							d.start();
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

	// Methode zum Legen einer Bombe für Player 1
	public void bombeLegen(Figur bm) {
		if (counter[0] < maxbomb[0]) {
			new TBomb(bm.getxPosition(), bm.getyPosition(), feld.getmap(), 0)
					.start();
			counter[0]++;
			Thread d = new Sounds2();
			d.start();
		}
	}

}
