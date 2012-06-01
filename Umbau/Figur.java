public class Figur {
	/*
	 * neues Object. Grundlage fuer Figuren Mutterklasse von Bomberman und
	 * Monstern.
	 */

	// Instanz der Glasspane
	private FeldGP glasspane;

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

	public void links(Feld field) {
		FieldEntry[][] map = field.getmap();
		// neue Position
		int x = getxPosition() - 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), x,
					getyPosition());
			this.setxPosition(x);
			// Menue aufrufen, wenn Ausgang erreicht
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
			if (map[getxPosition()][getyPosition()].getImage() == 5) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
		}
	}

	public void rechts(Feld field) {
		FieldEntry[][] map = field.getmap();
		int x = getxPosition() + 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), x,
					getyPosition());
			this.setxPosition(x);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				Start.frame.setVisible(false);
				Start.menue.setVisible(true);
			}
		}
	}

	public void oben(Feld field) {
		FieldEntry[][] map = field.getmap();
		int y = getyPosition() - 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), getxPosition(),
					y);
			this.setyPosition(y);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				Start.frame.setVisible(false);
				Start.menue.setVisible(true);
			}
		}

	}

	public void unten(Feld field) {
		FieldEntry[][] map = field.getmap();
		int y = getyPosition() + 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), getxPosition(),
					y);
			this.setyPosition(y);
			if (map[getxPosition()][getyPosition()].getImage() == 3) {
				Start.frame.setVisible(false);
				Start.menue.setVisible(true);
			}
		}
	}

	// Setter, um die GP-Instanz zu sichern
	public void setGP(FeldGP gp) {
		this.glasspane = gp;
	}
}
