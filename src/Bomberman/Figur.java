package Bomberman;

import java.io.Serializable;

public class Figur implements Serializable {
	/*
	 * neues Object. Grundlage fuer Figuren Mutterklasse von Bomberman und
	 * Monstern.
	 */

	private static final long serialVersionUID = -690705663199374065L;
	private int xposition;
	private int yposition;

	public Figur() {
	}

	public Figur(int xpos, int ypos) {
		this.xposition = xpos;
		this.yposition = ypos;

	}

	public int getxPosition() {
		return this.xposition;
	}

	public void setxPosition(int xpos) {
		this.xposition = xpos;
	}

	public int getyPosition() {
		return this.yposition;
	}

	public void setyPosition(int ypos) {
		this.yposition = ypos;
	}

	public void rechts(FieldEntry[][] map) {
		// Ueberprueft ob Feld frei ist
		if (map[getxPosition() + 1][getyPosition()].getWalk() == true) {
			this.setxPosition(getxPosition() + 1);
			// Check Exit
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
			// Check Flamme
			if (map[getxPosition()][getyPosition()].getImage() == 5) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}

		}
	}

	public void links(FieldEntry[][] map) {
		if (map[getxPosition() - 1][getyPosition()].getWalk() == true) {
			this.setxPosition(getxPosition() - 1);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
			if (map[getxPosition()][getyPosition()].getImage() == 5) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
		}
	}

	public void unten(FieldEntry[][] map) {
		if (map[getxPosition()][getyPosition() + 1].getWalk() == true) {
			this.setyPosition(getyPosition() + 1);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
			if (map[getxPosition()][getyPosition()].getImage() == 5) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
		}
	}

	public void oben(FieldEntry[][] map) {
		if (map[getxPosition()][getyPosition() - 1].getWalk() == true) {
			this.setyPosition(getyPosition() - 1);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
			if (map[getxPosition()][getyPosition()].getImage() == 5) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
			}
		}
	}

}
