package Bomberman;

public class Figur {
	/*
	 * neues Object. Grundlage fuer Figuren Mutterklasse von Bomberman und
	 * Monstern.
	 */

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

	public boolean feldfrei(int x, int y, FieldEntry[][] map) {
		// ueberprueft, ob ein Feld frei ist
		// Momentan sind alle Felder ausser der solid-Kacheln gueltig

		return map[x][y].getWalk();
	}

	public void rechts(FieldEntry[][] map) {
		int x = getxPosition() + 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			this.setxPosition(x);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.setVisible(false);
				Start.M.setVisible(true);
			}
		}
	}

	public void links(FieldEntry[][] map) {
		int x = getxPosition() - 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			this.setxPosition(x);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.setVisible(false);
				Start.M.setVisible(true);
			}
		}
	}

	public void unten(FieldEntry[][] map) {
		int y = getyPosition() + 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			this.setyPosition(y);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.setVisible(false);
				Start.M.setVisible(true);
			}
		}
	}

	public void oben(FieldEntry[][] map) {
		int y = getyPosition() - 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			this.setyPosition(y);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				JMenue.frame.setVisible(false);
				Start.M.setVisible(true);
			}
		}
	}

}
