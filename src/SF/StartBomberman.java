package SF;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class StartBomberman {

	// Spielfeldgroesse:
	public static int mapWidth = 19;
	public static int mapHeight = 19;
	// Kachelgroesse (Standard: 32x32 Pixel):
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	public static JFrame frame;
	public static SpielMenu menu = new SpielMenu("Bomberman - Menü");

	public static Figur bomberman;
	private static Feld f;

	public static void main(String[] args) {
		frame = new JFrame("Bomberman");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Beim Schliessen wird das Menue wieder angezeigt
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				menu.setVisible(true);
			}
		});

		f = new Feld(mapWidth, mapHeight, TILE_WIDTH, TILE_HEIGHT, "random");
		frame.add(f);
		// Fuer Linux ohne +6 und ohne +33!
		int frameWidth = mapWidth * TILE_WIDTH + 6;
		int frameHeight = mapHeight * TILE_HEIGHT + 33;
		frame.setSize(frameWidth, frameHeight);
		// Fenstergroesse fest
		frame.setResizable(false);
		// Groesse des Bildschirms ermitteln
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Position des JFrames errechnen
		int left = (screenSize.width - frameWidth) / 2;
		int top = (screenSize.height - frameHeight) / 2;
		frame.setLocation(left, top);
		frame.setVisible(false);
		// f.showArray(); test***

		// Instantiierung von BM
		bomberman = new Figur(1, 1);
		// Instantiierung von GP
		FeldGP gp = new FeldGP(f);
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
				case 10:
					// Bombe legen
					new Bombe(bomberman.getxPosition(), bomberman
							.getyPosition(), f);
					/*
					 * try { Thread.sleep(2000); } catch (InterruptedException
					 * e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					break;

				default:
					break;
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}
		});

	}

	public static int getTileWidth() {
		return TILE_WIDTH;
	}

}
