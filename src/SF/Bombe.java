//Variablennamen bitte KLEIN!

package SF;

import java.util.Date;

public class Bombe {

	public Bombe(int x, int y, Feld f) {
		// Radius ist Standardmässig 1.
		int radius = 1;
		FieldEntry[][] map = f.getmap();
		f.setmap(x, y, 4);// Bombe legen

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
				f.setmap(x + i, y, 5);
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
				f.setmap(x, y + i, 5);
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
				f.setmap(x - i, y, 5);
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
				f.setmap(x, y - i, 5);
			} else
				break;
		}
		// Countdown2 bis Abklingen der Explosion
		double Start1 = new Date().getTime();
		double zeit1 = 0;

		while (zeit1 <= Start1 + 200) {
			zeit1 = new Date().getTime();
		}
		// Feuer entfernen
		for (int i = 0; i <= radius; i++) {
			if (map[x + i][y].getImage() == 5) {
				f.setmap(x + i, y, 1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x - i][y].getImage() == 5) {
				f.setmap(x - i, y, 1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x][y + i].getImage() == 5) {
				f.setmap(x, y + i, 1);
			} else
				break;
		}
		for (int i = 0; i <= radius; i++) {
			if (map[x][y - i].getImage() == 5) {
				f.setmap(x, y - i, 1);
			} else
				break;
		}
	}
}
