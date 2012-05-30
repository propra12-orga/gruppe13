import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Spielfeld extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Spielfeld(int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Beim Schliessen wird das Menue wieder angezeigt
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				Start.menue.setVisible(true);
			}
		});
		Feld f = new Feld(mapWidth, mapHeight, tileWidth, tileHeight, "random");
		add(f);
		// Fuer Linux ohne +6 und ohne +33!
		int frameWidth = mapWidth * tileWidth + 6;
		int frameHeight = mapHeight * tileHeight + 33;
		setSize(frameWidth, frameHeight);
		// Fenstergroesse fest
		setResizable(false);
		// Groesse des Bildschirms ermitteln
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Position des JFrames errechnen
		int left = (screenSize.width - frameWidth) / 2;
		int top = (screenSize.height - frameHeight) / 2;
		setLocation(left, top);
		setVisible(true);
	}
}