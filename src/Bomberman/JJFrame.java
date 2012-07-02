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
				JMenue.stopper = true;// MenueSound wieder abspielen wenn
										// tot/neustart
				// etc
				Thread lala = new Sounds();
				lala.start();
				JMenue.t.stop();
				JFeld.exit = false;
				TBomb.radius[0] = 1;
				TBomb.radius[1] = 1;
				Control.maxbomb[0] = 1;
				Control.maxbomb[1] = 1;
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
		if (!JMenue.load) {
			if (title.equals("tut")) {
				setTitle("Tutorial");
			} else if (Integer.parseInt(title) < 0) {
				setTitle("Level " + title.substring(1, title.length())
						+ " Random");
			} else {
				setTitle("Level " + title);
			}
		}

	}

}
