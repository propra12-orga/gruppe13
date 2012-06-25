package Bomberman;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JJFrame(int mapWidth, int mapHeight, int tileWidth, int tileHeight,
			JFeld feld, String title) {
		add(feld);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JMenue.t.stop();
				JFeld.exit = false;
			}
		});
		// Framesize
		int frameWidth = mapWidth * tileWidth + 6;
		int frameHeight = mapHeight * tileHeight + 28;
		setSize(frameWidth, frameHeight);

		// Fenstergroesse fest
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(title);

	}

}
