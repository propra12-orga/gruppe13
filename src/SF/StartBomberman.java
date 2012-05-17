package SF;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

public class StartBomberman {

	// Spielfeldgroesse:
	public static int mapWidth = 19;
	public static int mapHeight = 19;
	// Kachelgroesse (Standard: 32x32 Pixel):
	public static int tileWidth = 32;
	public static int tileHeight = 32;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bomberman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Feld f = new Feld(mapWidth, mapHeight, tileWidth, tileHeight, "random");
		frame.add(f);
		// Fuer Linux ohne +6 und ohne +33!
		int frameWidth = mapWidth * tileWidth + 6;
		int frameHeight = mapHeight * tileHeight + 33;
		frame.setSize(frameWidth, frameHeight);
		// Fenstergroesse fest
		frame.setResizable(false);
		// Groesse des Bildschirms ermitteln
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Position des JFrames errechnen
		int left = (screenSize.width - frameWidth) / 2;
		int top = (screenSize.height - frameHeight) / 2;
		frame.setLocation(left, top);
		frame.setVisible(true);
		// f.showArray(); test***

		// Steuerung (Das zeichnen fehlt noch)

		Figur bomberman = new Figur(1, 1);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Wo lang?");
			int eingabe = sc.nextInt();
			if (eingabe == 4) {
				bomberman.links(f);
			} else if (eingabe == 6) {
				bomberman.rechts(f);
			} else if (eingabe == 8) {
				bomberman.oben(f);
			} else if (eingabe == 2) {
				bomberman.unten(f);
			} else {
			}
			System.out.println("Bomberman ist bei (" + bomberman.getxPosition()
					+ "/" + bomberman.getyPosition() + ")");
		}

	}

}
