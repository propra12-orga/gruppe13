package Bomberman;

public class TBomb extends Thread {
	/**
	 * Braucht mehr Kommentare?
	 */

	public static int radius = 2;
	private int[] xpos = new int[2];
	private int[] ypos = new int[2];
	private FieldEntry[][] map;
	private boolean checkl = true, checkr = true, checko = true, checku = true,
			iteml = false, itemr = false, itemo = false, itemu = false;
	private int r = -1, l = -1, u = -1, o = -1, itemrr, itemll, itemuu, itemoo,
			b;
	private int m = 0;
	private boolean death1P = false;
	private boolean death2P = false;
	private boolean suicide1P = false;
	private boolean suicide2P = false;

	public TBomb(int xpos, int ypos, FieldEntry[][] map, int b) {
		this.xpos[b] = xpos;
		this.ypos[b] = ypos;
		this.map = map;
		this.b = b;
	}

	public void kill() {
		// Suicide 1P
		if (JMenue.bm1.getxPosition() == xpos[0]
				&& JMenue.bm1.getyPosition() == ypos[0]) {
			suicide1P = true;
		} else {
			for (int i = 0; i <= radius; i++) {
				if (i <= r) {
					if (JMenue.bm1.getxPosition() == xpos[0] + i
							&& JMenue.bm1.getyPosition() == ypos[0]) {
						suicide1P = true;
					}
				}

				if (i <= l) {
					if (JMenue.bm1.getxPosition() == xpos[0] - i
							&& JMenue.bm1.getyPosition() == ypos[0]) {
						suicide1P = true;
					}

				}
				if (i <= u) {
					if (JMenue.bm1.getxPosition() == xpos[0]
							&& JMenue.bm1.getyPosition() == ypos[0] + i) {
						suicide1P = true;
					}

				}
				if (i <= o) {
					if (JMenue.bm1.getxPosition() == xpos[0]
							&& JMenue.bm1.getyPosition() == ypos[0] - i) {
						suicide1P = true;
					}

				}
			}
		}
		if (JFeld.multi == true) {
			if (JMenue.bm2.getxPosition() == xpos[1]
					&& JMenue.bm2.getyPosition() == ypos[1]) {
				suicide2P = true;// "Suicide 2P"
			} else {
				for (int i = 0; i <= radius; i++) {
					if (i <= r) {
						if (JMenue.bm2.getxPosition() == xpos[1] + i
								&& JMenue.bm2.getyPosition() == ypos[1]) {
							suicide2P = true;// "Suicide 2P"
						}
						if (JMenue.bm1.getxPosition() == xpos[1] + i
								&& JMenue.bm1.getyPosition() == ypos[1]) {
							death1P = true;// PLAYER 2 GEWINNT!
						}
						if (JMenue.bm2.getxPosition() == xpos[0] + i
								&& JMenue.bm2.getyPosition() == ypos[0]) {
							death2P = true;// PLAYER 1 GEWINNT!
						}

					}
					if (i <= l) {
						if (JMenue.bm2.getxPosition() == xpos[1] - i
								&& JMenue.bm2.getyPosition() == ypos[1]) {
							suicide2P = true;
						}
						if (JMenue.bm1.getxPosition() == xpos[1] - i
								&& JMenue.bm1.getyPosition() == ypos[1]) {
							death1P = true;
						}
						if (JMenue.bm2.getxPosition() == xpos[0] - i
								&& JMenue.bm2.getyPosition() == ypos[0]) {
							death2P = true;
						}

					}
					if (i <= u) {
						if (JMenue.bm2.getxPosition() == xpos[1]
								&& JMenue.bm2.getyPosition() == ypos[1] + i) {
							suicide2P = true;
						}
						if (JMenue.bm1.getxPosition() == xpos[1]
								&& JMenue.bm1.getyPosition() == ypos[1] + i) {
							death1P = true;
						}
						if (JMenue.bm2.getxPosition() == xpos[0]
								&& JMenue.bm2.getyPosition() == ypos[0] + i) {
							death2P = true;
						}

					}
					if (i <= o) {
						if (JMenue.bm2.getxPosition() == xpos[1]
								&& JMenue.bm2.getyPosition() == ypos[1] - i) {
							suicide2P = true;
						}
						if (JMenue.bm1.getxPosition() == xpos[1]
								&& JMenue.bm1.getyPosition() == ypos[1] - i) {
							death1P = true;
						}
						if (JMenue.bm2.getxPosition() == xpos[0]
								&& JMenue.bm2.getyPosition() == ypos[0] - i) {
							death2P = true;
						}

					}
				}
			}
		}
		if (death1P || death2P || suicide1P || suicide2P) {
			end(death1P, death2P, suicide1P, suicide2P);
		}
	}

	public void end(boolean d1, boolean d2, boolean s1, boolean s2) {
		JMenue.frame.dispose();
		Start.M.setVisible(true);
		JFeld.exit = false;

		// Suicide 1P
		if (d1 == false && d2 == false && s1 == true && s2 == false) {

		}
		// Suicide 2P
		if (d1 == false && d2 == false && s1 == false && s2 == true) {
			System.out.println("Bild kommt noch: Suicide 2P");
		}
		// 2P kills 1P
		if (d1 == true && d2 == false && s1 == false && s2 == false) {
			m = 2;
		}
		// 1P kills 2P
		if (d1 == false && d2 == true && s1 == false && s2 == false) {
			m = 1;
		}
		if ((d1 == true && d2 == false && s1 == false && s2 == true)
				|| (d1 == false && d2 == true && s1 == true && s2 == false)) {
			System.out.println("Bild kommt noch: Doppel-KO");
		}
		TMeldung meld = new TMeldung(m);
		meld.start();
	}

	public void run() {
		map[xpos[b]][ypos[b]] = JFeld.entry[4];
		for (int i = 0; i < 1500; i++) {
			if (map[xpos[b]][ypos[b]] == JFeld.entry[5]) {
				i = 1500;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i <= radius; i++) {
			/**
			 * Explosion nach Rechts
			 */
			if (checkr == true) {
				/**
				 * Zertoerbarer Block
				 */
				if (map[xpos[b] + i][ypos[b]].getImage() == 2) {
					// Item speichern
					itemrr = map[xpos[b] + i][ypos[b]].getItem();
					// Flamme
					map[xpos[b] + i][ypos[b]] = JFeld.entry[5];
					// Explosion stoppen
					checkr = false;
					// Itemcounter true
					itemr = true;
					/**
					 * Laenge der Explosion
					 */
					r++;
				}
				/**
				 * Unzerstoerbarer Block bzw. Exit
				 */
				else if (map[xpos[b] + i][ypos[b]].getImage() == 0
						|| map[xpos[b] + i][ypos[b]].getImage() == 3) {
					/**
					 * Explosion stoppen
					 */
					checkr = false;

				}
				/**
				 * Explosion in alles Andere
				 */
				else {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[5];
					r++;
				}
			}
			/**
			 * Explosion nach Links
			 */
			if (checkl == true) {
				if (map[xpos[b] - i][ypos[b]].getImage() == 2) {
					itemll = map[xpos[b] - i][ypos[b]].getItem();
					map[xpos[b] - i][ypos[b]] = JFeld.entry[5];
					checkl = false;
					iteml = true;
					l++;
				} else if (map[xpos[b] - i][ypos[b]].getImage() == 0
						|| map[xpos[b] - i][ypos[b]].getImage() == 3) {
					checkl = false;
				} else {
					map[xpos[b] - i][ypos[b]] = JFeld.entry[5];
					l++;
				}
			}
			/**
			 * Explosion nach Unten
			 */
			if (checku == true) {
				if (map[xpos[b]][ypos[b] + i].getImage() == 2) {
					itemuu = map[xpos[b]][ypos[b] + i].getItem();
					map[xpos[b]][ypos[b] + i] = JFeld.entry[5];
					checku = false;
					itemu = true;
					u++;
				} else if (map[xpos[b]][ypos[b] + i].getImage() == 0
						|| map[xpos[b]][ypos[b] + i].getImage() == 3) {
					checku = false;
				}
				/**
				 * Explosion in alles Andere
				 */
				else {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[5];
					u++;
				}
			}
			/**
			 * Explosion nach Oben
			 */
			if (checko == true) {
				if (map[xpos[b]][ypos[b] - i].getImage() == 2) {
					itemoo = map[xpos[b]][ypos[b] - i].getItem();
					map[xpos[b]][ypos[b] - i] = JFeld.entry[5];
					checko = false;
					itemo = true;
					o++;
				} else if (map[xpos[b]][ypos[b] - i].getImage() == 0
						|| map[xpos[b]][ypos[b] - i].getImage() == 3) {
					checko = false;

				} else {
					map[xpos[b]][ypos[b] - i] = JFeld.entry[5];
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
		this.kill();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Nach der Explosion
		 */
		for (int i = 0; i <= radius; i++) {
			if (i <= r) {
				if (i == r && itemr == true) {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[itemrr];
				} else {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[1];
				}
			}
			if (i <= l) {
				if (i == l && iteml == true) {
					map[xpos[b] - i][ypos[b]] = JFeld.entry[itemll];
				} else {
					map[xpos[b] - i][ypos[b]] = JFeld.entry[1];
				}
			}
			if (i <= o) {
				if (i == o && itemo == true) {
					map[xpos[b]][ypos[b] - i] = JFeld.entry[itemoo];
				} else {
					map[xpos[b]][ypos[b] - i] = JFeld.entry[1];
				}

			}
			if (i <= u) {
				if (i == u && itemu == true) {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[itemuu];
				} else {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[1];
				}
			}

		}
		Control.counter[b]--;

	}
}
