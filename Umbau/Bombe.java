public class Bombe extends Thread {

	private int xpos;
	private int ypos;
	private static Feld f;

	public Bombe(int xposition, int yposition, Feld f) {
		this.xpos = xposition;
		this.ypos = yposition;
		Bombe.f = f;
	}

	// zuendet die Bombe
	public void run() {
		int x = this.xpos;
		int y = this.ypos;

		// Radius ist Standardmaessig 1.
		int radius = 1;
		FieldEntry[][] map = f.getmap();
		map[x][y].setImage(4);// Bombe legen
		// Countdown bis zur Explosion starten
		/*
		 * double Start = new Date().getTime(); double zeit = 0;
		 * 
		 * while (System.currentTimeMillis() <= Start + 2000) { zeit = new
		 * Date().getTime(); }
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("BUMM");

		// Explosion
		for (int i = 0; i <= radius; i++) {
			if ((Start.bomberman.getxPosition() == x + i)
					&& (Start.bomberman.getyPosition() == y)) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
			if ((map[x + i][y].getImage() != 0)
					&& (map[x + i][y].getImage() != 3)) {
				map[x + i][y].setImage(5);
				map[x + i][y].setWalk(true);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((Start.bomberman.getxPosition() == x)
					&& (Start.bomberman.getyPosition() == y + i)) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
			if ((map[x][y + i].getImage() != 0)
					&& (map[x][y + i].getImage() != 3)) {
				map[x][y + i].setImage(5);
				map[x][y + i].setWalk(true);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((Start.bomberman.getxPosition() == x - i)
					&& (Start.bomberman.getyPosition() == y)) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
			if ((map[x - i][y].getImage() != 0)
					&& (map[x - i][y].getImage() != 3)) {
				map[x - i][y].setImage(5);
				map[x - i][y].setWalk(true);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((Start.bomberman.getxPosition() == x)
					&& (Start.bomberman.getyPosition() == y - i)) {
				Start.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				Start.menue.setVisible(true);
			}
			if ((map[x][y - i].getImage() != 0)
					&& (map[x][y - i].getImage() != 3)) {
				map[x][y - i].setImage(5);
				map[x][y - i].setWalk(true);
			} else
				break;
		}
		// Countdown2 bis Abklingen der Explosion
		// double Start1 = new Date().getTime();
		// double zeit1 = 0;

		// PROBLEMKIND! WIr brauchen Threads oder eine andere l�sung
		/*
		 * while (zeit1 <= Start1 + 200) { zeit1 = new Date().getTime(); }
		 */

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Feuer entfernen
		for (int i = 0; i <= radius; i++) {
			if (map[x + i][y].getImage() == 5) {
				map[x + i][y].setImage(1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x - i][y].getImage() == 5) {
				map[x - i][y].setImage(1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x][y + i].getImage() == 5) {
				map[x][y + i].setImage(1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x][y - i].getImage() == 5) {
				map[x][y - i].setImage(1);
			} else
				break;
		}
	}

	public static Feld aktualisierungBombe() { // gibt die �nderungen der Bombe
												// an den Synchroniser weiter
		return f;
	}

}
