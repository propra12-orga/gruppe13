package Bomberman;

public class TBomb extends Thread {
	/**
	 * Braucht mehr Kommentare?
	 */

	public static int[] radius = new int[] { 1, 1 };
	private int[] xpos = new int[2];
	private int[] ypos = new int[2];
	private FieldEntry[][] map;
	private boolean checkl = true, checkr = true, checko = true, checku = true,
			iteml = false, itemr = false, itemo = false, itemu = false;
	private int r = -1, l = -1, u = -1, o = -1, itemrr, itemll, itemuu, itemoo,
			b;
	private int m = 0;
	public static boolean death1P = false;
	public static boolean death2P = false;
	public static boolean suicide1P = false;
	public static boolean suicide2P = false;

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
		}
		for (int i = 0; i <= radius[b]; i++) {
			if (i <= r) {
				if (JMenue.bm1.getxPosition() == xpos[0] + i
						&& JMenue.bm1.getyPosition() == ypos[0]) {
					suicide1P = true;
				}
				if (JFeld.multi) {
					if (JMenue.bm2.getxPosition() == xpos[0] + i
							&& JMenue.bm2.getyPosition() == ypos[0]) {
						death2P = true;// PLAYER 1 GEWINNT!
					}
				}
			}

			if (i <= l) {
				if (JMenue.bm1.getxPosition() == xpos[0] - i
						&& JMenue.bm1.getyPosition() == ypos[0]) {
					suicide1P = true;
				}
				if (JFeld.multi) {
					if (JMenue.bm2.getxPosition() == xpos[0] - i
							&& JMenue.bm2.getyPosition() == ypos[0]) {
						death2P = true;
					}
				}

			}
			if (i <= u) {
				if (JMenue.bm1.getxPosition() == xpos[0]
						&& JMenue.bm1.getyPosition() == ypos[0] + i) {
					suicide1P = true;
				}
				if (JFeld.multi) {
					if (JMenue.bm2.getxPosition() == xpos[0]
							&& JMenue.bm2.getyPosition() == ypos[0] + i) {
						death2P = true;
					}
				}

			}
			if (i <= o) {
				if (JMenue.bm1.getxPosition() == xpos[0]
						&& JMenue.bm1.getyPosition() == ypos[0] - i) {
					suicide1P = true;
				}
				if (JFeld.multi) {
					if (JMenue.bm2.getxPosition() == xpos[0]
							&& JMenue.bm2.getyPosition() == ypos[0] - i) {
						death2P = true;
					}
				}

			}
		}

		if (JFeld.multi) {
			if (JMenue.bm2.getxPosition() == xpos[1]
					&& JMenue.bm2.getyPosition() == ypos[1]) {
				suicide2P = true;// "Suicide 2P"
			}

			for (int i = 0; i <= radius[b]; i++) {
				if (i <= r) {
					if (JMenue.bm2.getxPosition() == xpos[1] + i
							&& JMenue.bm2.getyPosition() == ypos[1]) {
						suicide2P = true;// "Suicide 2P"
					}
					if (JMenue.bm1.getxPosition() == xpos[1] + i
							&& JMenue.bm1.getyPosition() == ypos[1]) {
						death1P = true;// PLAYER 2 GEWINNT!
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
		JMenue.stopper = true;// MenueSound wieder abspielen wenn tot/neustart
								// etc
		Thread lala = new Sounds();
		lala.start();
		JFeld.exit = false;
		TBomb.radius[0] = 1;
		TBomb.radius[1] = 1;
		Control.maxbomb[0] = 1;
		Control.maxbomb[1] = 1;
		death1P = false;
		death2P = false;
		suicide1P = false;
		suicide2P = false;

		// Suicide 1P
		if (!d1 && !d2 && s1 && !s2) {
			m = 1;

		}
		// Suicide 2P
		if (!d1 && !d2 && !s1 && s2) {
			System.out.println("Bild kommt noch: Suicide 2P");
		}
		// 2P kills 1P
		if (d1 && !d2 && !s1 && !s2) {
			m = 2;
		}
		// 1P kills 2P
		if (!d1 && d2 && !s1 && !s2) {
			m = 3;
		}
		if ((d1 && !d2 && !s1 && s2) || (!d1 && d2 && s1 && !s2)) {
			m = 4;
		}
		TMeldung meld = new TMeldung(m);
		meld.start();
	}

	@SuppressWarnings("deprecation")
	public void run() {
		map[xpos[b]][ypos[b]] = JFeld.entry[4];
		for (int i = 0; i < 1500; i++) {
			if (TBomb.death1P || TBomb.death2P || TBomb.suicide1P
					|| TBomb.suicide2P) {
				this.stop();
			}
			if (map[xpos[b]][ypos[b]] == JFeld.entry[5]) {
				i = 1499;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i <= radius[b]; i++) {
			/**
			 * Explosion nach Rechts
			 */
			if (checkr) {
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
			if (checkl) {
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
			if (checku) {
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
			if (checko) {
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
		for (int i = 0; i <= radius[b]; i++) {
			if (i <= r) {
				if (i == r && itemr) {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[itemrr];
				} else {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[1];
				}
			}
			if (i <= l) {
				if (i == l && iteml) {
					map[xpos[b] - i][ypos[b]] = JFeld.entry[itemll];
				} else {
					map[xpos[b] - i][ypos[b]] = JFeld.entry[1];
				}
			}
			if (i <= o) {
				if (i == o && itemo) {
					map[xpos[b]][ypos[b] - i] = JFeld.entry[itemoo];
				} else {
					map[xpos[b]][ypos[b] - i] = JFeld.entry[1];
				}

			}
			if (i <= u) {
				if (i == u && itemu) {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[itemuu];
				} else {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[1];
				}
			}

		}
		Control.counter[b]--;

	}
}
