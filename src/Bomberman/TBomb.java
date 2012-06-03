package Bomberman;

public class TBomb extends Thread {

	public static int radius = 2;
	private int xpos, ypos;
	private FieldEntry[][] map;
	private boolean checkl = true, checkr = true, checko = true, checku = true,
			iteml = false, itemr = false, itemo = false, itemu = false;
	private int r = -1, l = -1, u = -1, o = -1, itemrr, itemll, itemuu, itemoo;

	public TBomb(int xpos, int ypos, FieldEntry[][] map) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.map = map;
	}

	public void suicide() {
		boolean ckr = true, ckl = true, cko = true, cku = true;
		if (JMenue.bm1.getxPosition() == xpos
				&& JMenue.bm1.getyPosition() == ypos) {
			JMenue.frame.dispose();
			Start.M.setVisible(true);
			JFeld.exit = false;
		}
		for (int i = 0; i <= radius; i++) {

			if (ckr == true) {
				if (map[xpos + i][ypos].getImage() == 2
						|| map[xpos + i][ypos].getImage() == 0
						|| map[xpos + i][ypos].getImage() == 3) {
					ckr = false;
				}
				if (JMenue.bm1.getxPosition() == xpos + i
						&& JMenue.bm1.getyPosition() == ypos) {
					JMenue.frame.dispose();
					Start.M.setVisible(true);
					JFeld.exit = false;
				}

			}
			if (ckl == true) {
				if (map[xpos - i][ypos].getImage() == 2
						|| map[xpos - i][ypos].getImage() == 0
						|| map[xpos - i][ypos].getImage() == 3) {
					ckl = false;
				}
				if (JMenue.bm1.getxPosition() == xpos - i
						&& JMenue.bm1.getyPosition() == ypos) {
					JMenue.frame.dispose();
					Start.M.setVisible(true);
					JFeld.exit = false;
				}

			}
			if (cku == true) {
				if (map[xpos][ypos + i].getImage() == 2
						|| map[xpos][ypos + i].getImage() == 0
						|| map[xpos][ypos + i].getImage() == 3) {
					cku = false;
				}
				if (JMenue.bm1.getxPosition() == xpos
						&& JMenue.bm1.getyPosition() == ypos + i) {
					JMenue.frame.dispose();
					Start.M.setVisible(true);
					JFeld.exit = false;
				}

			}
			if (cko == true) {
				if (map[xpos][ypos - i].getImage() == 2
						|| map[xpos][ypos - i].getImage() == 0
						|| map[xpos][ypos - i].getImage() == 3) {
					cko = false;
				}
				if (JMenue.bm1.getxPosition() == xpos
						&& JMenue.bm1.getyPosition() == ypos - i) {
					JMenue.frame.dispose();
					Start.M.setVisible(true);
					JFeld.exit = false;
				}

			}

		}
	}

	public void run() {
		map[xpos][ypos] = JFeld.entry[4];
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i <= radius; i++) {
			// Explosion nach rechts
			if (checkr == true) {
				// Zertörbarer Block
				if (map[xpos + i][ypos].getImage() == 2) {
					// Item speichern
					itemrr = map[xpos + i][ypos].getItem();
					// Flamme
					map[xpos + i][ypos] = JFeld.entry[5];
					// Explosion stoppen
					checkr = false;
					// Itemcounter true
					itemr = true;
					// Länge der Explosion
					r++;
				}
				// Unzerstörbarer Block / Exit
				else if (map[xpos + i][ypos].getImage() == 0
						|| map[xpos + i][ypos].getImage() == 3) {
					// Explosion stoppen
					checkr = false;

				}
				// Explosion in alles Andere
				else {
					map[xpos + i][ypos] = JFeld.entry[5];
					r++;
				}
			}
			// Explosion nach links
			if (checkl == true) {
				if (map[xpos - i][ypos].getImage() == 2) {
					itemll = map[xpos - i][ypos].getItem();
					map[xpos - i][ypos] = JFeld.entry[5];
					checkl = false;
					iteml = true;
					l++;
				} else if (map[xpos - i][ypos].getImage() == 0
						|| map[xpos - i][ypos].getImage() == 3) {
					checkl = false;
				} else {
					map[xpos - i][ypos] = JFeld.entry[5];
					l++;
				}
			}
			// Explosion nach unten
			if (checku == true) {
				if (map[xpos][ypos + i].getImage() == 2) {
					itemuu = map[xpos][ypos + i].getItem();
					map[xpos][ypos + i] = JFeld.entry[5];
					checku = false;
					itemu = true;
					u++;
				} else if (map[xpos][ypos + i].getImage() == 0
						|| map[xpos][ypos + i].getImage() == 3) {
					checku = false;
				}
				// Explosion in alles Andere
				else {
					map[xpos][ypos + i] = JFeld.entry[5];
					u++;
				}
			}
			// Explosion nach oben
			if (checko == true) {
				if (map[xpos][ypos - i].getImage() == 2) {
					itemoo = map[xpos][ypos - i].getItem();
					map[xpos][ypos - i] = JFeld.entry[5];
					checko = false;
					itemo = true;
					o++;
				} else if (map[xpos][ypos - i].getImage() == 0
						|| map[xpos][ypos - i].getImage() == 3) {
					checko = false;

				} else {
					map[xpos][ypos - i] = JFeld.entry[5];
					o++;
				}
			}

		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.suicide();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Nach der Explosion
		for (int i = 0; i <= radius; i++) {
			if (i <= r) {
				if (i == r && itemr == true) {
					map[xpos + i][ypos] = JFeld.entry[itemrr];
				} else {
					map[xpos + i][ypos] = JFeld.entry[1];
				}
			}
			if (i <= l) {
				if (i == l && iteml == true) {
					map[xpos - i][ypos] = JFeld.entry[itemll];
				} else {
					map[xpos - i][ypos] = JFeld.entry[1];
				}
			}
			if (i <= o) {
				if (i == o && itemo == true) {
					map[xpos][ypos - i] = JFeld.entry[itemoo];
				} else {
					map[xpos][ypos - i] = JFeld.entry[1];
				}

			}
			if (i <= u) {
				if (i == u && itemu == true) {
					map[xpos][ypos + i] = JFeld.entry[itemuu];
				} else {
					map[xpos][ypos + i] = JFeld.entry[1];
				}
			}

		}
	}
}
