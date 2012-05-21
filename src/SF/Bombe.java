package SF;

public class Bombe extends Thread {

	private int xpos;
	private int ypos;
	private Feld f;

	public Bombe(int xposition, int yposition, Feld f) {
		this.xpos = xposition;
		this.ypos = yposition;
		this.f = f;
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
			if ((StartBomberman.bomberman.getxPosition() == x + i)
					&& (StartBomberman.bomberman.getyPosition() == y)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[x + i][y].getImage() != 0)
					&& (map[x + i][y].getImage() != 3)) {
				map[x + i][y].setImage(5);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == x)
					&& (StartBomberman.bomberman.getyPosition() == y + i)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[x][y + i].getImage() != 0)
					&& (map[x][y + i].getImage() != 3)) {
				map[x][y + i].setImage(5);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == x - i)
					&& (StartBomberman.bomberman.getyPosition() == y)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[x - i][y].getImage() != 0)
					&& (map[x - i][y].getImage() != 3)) {
				map[x - i][y].setImage(5);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == x)
					&& (StartBomberman.bomberman.getyPosition() == y - i)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[x][y - i].getImage() != 0)
					&& (map[x][y - i].getImage() != 3)) {
				map[x][y - i].setImage(5);
			} else
				break;
		}
		// Countdown2 bis Abklingen der Explosion
		// double Start1 = new Date().getTime();
		// double zeit1 = 0;

		// PROBLEMKIND! WIr brauchen Threads oder eine andere lösung
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
}
