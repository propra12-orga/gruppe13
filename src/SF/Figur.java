package SF;

import javax.swing.JComponent;

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
		// Überprüfung, ob das zu besuchende Feld gültig ist
		// Momentan sind alle Felder außer der solid-Kacheln gültig
		if (map[x][y].getImage() != 0)
			return true;
		else
			return false;
	}

	public void links(Feld field) {
		FieldEntry[][] map = field.getmap();
		// neue Position
		int x = getxPosition() - 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), x, getyPosition());
			this.setxPosition(x);
		}
	}

	public void rechts(Feld field) {
		FieldEntry[][] map = field.getmap();
		int x = getxPosition() + 1;
		boolean b = this.feldfrei(x, getyPosition(), map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), x, getyPosition());
			this.setxPosition(x);
		}
	}

	public void oben(Feld field) {
		FieldEntry[][] map = field.getmap();
		int y = getyPosition() - 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), getxPosition(), y);
			this.setyPosition(y);
		}

	}

	public void unten(Feld field) {
		FieldEntry[][] map = field.getmap();
		int y = getyPosition() + 1;
		boolean b = this.feldfrei(getxPosition(), y, map);
		if (b == true) {
			// Aufruf an die Glasspane, den BM entsprechend zu bewegen
			glasspane.walkFigur(getxPosition(), getyPosition(), getxPosition(), y);
			this.setyPosition(y);
		}
	}

	// Setter, um die GP-Instanz zu sichern
	public void setGP(FeldGP gp) {
		this.glasspane = gp;
	}

	// TESTS

	/*
	 * @Test public void neuFigur() { Figur a = new Figur(); a.setxPosition(5);
	 * int b = a.getxPosition(); assertTrue(5==b); }
	 */
}
