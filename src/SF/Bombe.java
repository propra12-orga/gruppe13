//Variablennamen bitte KLEIN!

package SF;

import java.util.Date;

public class Bombe {

	public Bombe(int X, int Y, Feld f) {
		// Radius ist Standardmässig 1.
		int Radius = 1;
		FieldEntry[][] map = f.getmap();
		f.setmap(X, Y, 4);// Bombe legen

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
		for (int i = 0; i <= Radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == X + i)
					&& (StartBomberman.bomberman.getyPosition() == Y)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[X + i][Y].getImage() != 0)
					&& (map[X + i][Y].getImage() != 3)) {
				f.setmap(X + i, Y, 5);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == X)
					&& (StartBomberman.bomberman.getyPosition() == Y + i)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[X][Y + i].getImage() != 0)
					&& (map[X][Y + i].getImage() != 3)) {
				f.setmap(X, Y + i, 5);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == X - i)
					&& (StartBomberman.bomberman.getyPosition() == Y)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[X - i][Y].getImage() != 0)
					&& (map[X - i][Y].getImage() != 3)) {
				f.setmap(X - i, Y, 5);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if ((StartBomberman.bomberman.getxPosition() == X)
					&& (StartBomberman.bomberman.getyPosition() == Y - i)) {
				StartBomberman.frame.setVisible(false);
				// Statt das Menue aufzurufen, sollte noch eine Meldung
				// implementiert werden in Form eines JDialog.
				StartBomberman.menu.setVisible(true);
			}
			if ((map[X][Y - i].getImage() != 0)
					&& (map[X][Y - i].getImage() != 3)) {
				f.setmap(X, Y - i, 5);
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
		for (int i = 0; i <= Radius; i++) {
			if (map[X + i][Y].getImage() == 5) {
				f.setmap(X + i, Y, 1);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if (map[X - i][Y].getImage() == 5) {
				f.setmap(X - i, Y, 1);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if (map[X][Y + i].getImage() == 5) {
				f.setmap(X, Y + i, 1);
			} else
				break;
		}
		for (int i = 0; i <= Radius; i++) {
			if (map[X][Y - i].getImage() == 5) {
				f.setmap(X, Y - i, 1);
			} else
				break;
		}
	}
}
