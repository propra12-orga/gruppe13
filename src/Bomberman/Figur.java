package Bomberman;

import java.io.Serializable;

public class Figur implements Serializable {
	/*
	 * neues Object. Grundlage fuer Figuren Mutterklasse von Bomberman und
	 * Monstern.
	 */

<<<<<<< HEAD
	private static final long serialVersionUID = -690705663199374065L;
	private int xposition;
	private int yposition;
=======
	private int xposition, yposition;
	private int P;
	private int m = 0;
>>>>>>> 48d8a01b3acb1ecbcf9285c76d8771cb15aad7d8

	public Figur() {
	}

	public Figur(int xpos, int ypos, int P) {
		this.xposition = xpos;
		this.yposition = ypos;
		this.P = P;

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

	public void end(int p, boolean exit) {
		JMenue.frame.dispose();
		Start.M.setVisible(true);
		JMenue.stopper = true;// MenueSound wieder abspielen wenn tot/neustart
								// etc
		Thread lala = new Sounds();
		lala.start();
		JFeld.exit = false;
		TBomb.radius[0] = 2;
		TBomb.radius[1] = 2;
		Control.maxbomb[0] = 1;
		Control.maxbomb[1] = 1;
		if (!exit) {
			if (p == 1) {

			} else {
				System.out.println("Bild kommt noch: Suicide 2P");
			}

		} else {
			m = 3;
		}
		TMeldung meld = new TMeldung(m);
		meld.start();
	}

	public void check(FieldEntry[][] map, int x, int y) {
		if (map[x][y].getImage() == 3) {
			end(P, true);
		}
		// Check Flamme
		if (map[x][y].getImage() == 5) {
			end(P, false);
		}
		if (map[x][y].getImage() == 6) {
			map[x][y] = JFeld.entry[1];
			if (P == 1) {
				TBomb.radius[0]++;
			} else {
				TBomb.radius[1]++;
			}
		}
		if (map[x][y].getImage() == 7) {
			map[x][y] = JFeld.entry[1];
			if (P == 1) {
				Control.maxbomb[0]++;
			} else {
				Control.maxbomb[1]++;
			}
		}
	}

	public void rechts(FieldEntry[][] map) {
		// Ueberprueft ob Feld frei ist
		if (map[getxPosition() + 1][getyPosition()].getWalk() == true) {
			this.setxPosition(getxPosition() + 1);
			// Check Exit
			check(map, getxPosition(), getyPosition());
		}
	}

	public void links(FieldEntry[][] map) {
		if (map[getxPosition() - 1][getyPosition()].getWalk() == true) {
			this.setxPosition(getxPosition() - 1);
			check(map, getxPosition(), getyPosition());
		}
	}

	public void unten(FieldEntry[][] map) {
		if (map[getxPosition()][getyPosition() + 1].getWalk() == true) {
			this.setyPosition(getyPosition() + 1);
			check(map, getxPosition(), getyPosition());
		}
	}

	public void oben(FieldEntry[][] map) {
		if (map[getxPosition()][getyPosition() - 1].getWalk() == true) {
			this.setyPosition(getyPosition() - 1);
			check(map, getxPosition(), getyPosition());
		}
	}

}
