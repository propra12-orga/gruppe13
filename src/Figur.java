import static org.junit.Assert.*;

import org.junit.Test;

public class Figur {
	/*
	 * neues Object.
	 * Grundlage fuer Figuren 
	 * Mutterklasse von Bomberman und Monstern.
	 */

	private int xposition;
	private int yposition;

	public Figur(int xposition, int yposition) {
		this.xposition = xposition;
		this.yposition = yposition;
	}
	
	private int getxPosition() {
		return xposition;
	}

	private void setxPosition(int xposition) {
		this.xposition = xposition;
	}

	private int getyPosition() {
		return yposition;
	}

	private void setyPosition(int yposition) {
		this.yposition = yposition;
	}

	private boolean feldfrei(int x, int y) {
		//if (map[x][y]==0) return true;
		// else
		return false;

	}

	@SuppressWarnings("unused")
	private void links() {
		boolean b=feldfrei(getxPosition(),getyPosition());
		if(b==true)
		setxPosition(xposition - 1);
	}

	@SuppressWarnings("unused")
	private void rechts() {
		// fehlt ueberpruefung auf wegfrei.
		setxPosition(xposition + 1);
	}

	@SuppressWarnings("unused")
	private void oben() {
		// fehlt ueberpruefung auf wegfrei.
		setyPosition(yposition + 1);

	}

	@SuppressWarnings("unused")
	private void unten() {
		// fehlt ueberpruefung auf wegfrei.
		setyPosition(yposition - 1);
	}

	// TESTS

	
	 @Test
	 public void neuFigur() {
		 Figur a = new Figur(5, 5);
		 assertEquals(5, a.getxPosition());
		 }
	
}
