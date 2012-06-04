package Bomberman;

public class TBomb extends Thread {

	public static int radius = 2;
	private int[] xpos = new int[2];
	private int[] ypos = new int[2];
	private FieldEntry[][] map;
	private boolean checkl = true, checkr = true, checko = true, checku = true,
			iteml = false, itemr = false, itemo = false, itemu = false;
	private int r = -1, l = -1, u = -1, o = -1, itemrr, itemll, itemuu, itemoo,
			b;

	public TBomb(int xpos, int ypos, FieldEntry[][] map, int k) {
		this.xpos[k] = xpos;
		this.ypos[k] = ypos;
		this.map = map;
		this.b = k;
	}

	public void suicide() {
		if (JMenue.bm1.getxPosition() == xpos[0]
				&& JMenue.bm1.getyPosition() == ypos[0]) {
			JMenue.frame.dispose();
			Start.M.setVisible(true);
			JFeld.exit = false;
			System.out.println("Suicide Noob 1P");
		} else {
			for (int i = 0; i <= radius; i++) {
				if (i <= r) {
					if (JMenue.bm1.getxPosition() == xpos[0] + i
							&& JMenue.bm1.getyPosition() == ypos[0]) {
						JMenue.frame.dispose();
						Start.M.setVisible(true);
						JFeld.exit = false;
						System.out.println("Suicide Noob 1P");
					}

				}
				if (i <= l) {
					if (JMenue.bm1.getxPosition() == xpos[0] - i
							&& JMenue.bm1.getyPosition() == ypos[0]) {
						JMenue.frame.dispose();
						Start.M.setVisible(true);
						JFeld.exit = false;
						System.out.println("Suicide Noob 1P");
					}

				}
				if (i <= u) {
					if (JMenue.bm1.getxPosition() == xpos[0]
							&& JMenue.bm1.getyPosition() == ypos[0] + i) {
						JMenue.frame.dispose();
						Start.M.setVisible(true);
						JFeld.exit = false;
						System.out.println("Suicide Noob 1P");
					}

				}
				if (i <= o) {
					if (JMenue.bm1.getxPosition() == xpos[0]
							&& JMenue.bm1.getyPosition() == ypos[0] - i) {
						JMenue.frame.dispose();
						Start.M.setVisible(true);
						JFeld.exit = false;
						System.out.println("Suicide Noob 1P");
					}

				}
			}
		}
		if (JFeld.multi == true) {
			if (JMenue.bm2.getxPosition() == xpos[1]
					&& JMenue.bm2.getyPosition() == ypos[1]) {
				JMenue.frame.dispose();
				Start.M.setVisible(true);
				JFeld.exit = false;
				System.out.println("Suicide Noob 2P");
			} else {
				for (int i = 0; i <= radius; i++) {
					if (i <= r) {
						if (JMenue.bm2.getxPosition() == xpos[1] + i
								&& JMenue.bm2.getyPosition() == ypos[1]) {
							JMenue.frame.dispose();
							Start.M.setVisible(true);
							JFeld.exit = false;
							System.out.println("Suicide Noob 2P");
						}

					}
					if (i <= l) {
						if (JMenue.bm2.getxPosition() == xpos[1] - i
								&& JMenue.bm2.getyPosition() == ypos[1]) {
							JMenue.frame.dispose();
							Start.M.setVisible(true);
							JFeld.exit = false;
							System.out.println("Suicide Noob 2P");
						}

					}
					if (i <= u) {
						if (JMenue.bm2.getxPosition() == xpos[1]
								&& JMenue.bm2.getyPosition() == ypos[1] + i) {
							JMenue.frame.dispose();
							Start.M.setVisible(true);
							JFeld.exit = false;
							System.out.println("Suicide Noob 2P");
						}

					}
					if (i <= o) {
						if (JMenue.bm2.getxPosition() == xpos[1]
								&& JMenue.bm2.getyPosition() == ypos[1] - i) {
							JMenue.frame.dispose();
							Start.M.setVisible(true);
							JFeld.exit = false;
							System.out.println("Suicide Noob 2P");
						}

					}
				}
			}
		}
	}

	public void kill() {

	}

	public void run() {
		map[xpos[b]][ypos[b]] = JFeld.entry[4];
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
				if (map[xpos[b] + i][ypos[b]].getImage() == 2) {
					// Item speichern
					itemrr = map[xpos[b] + i][ypos[b]].getItem();
					// Flamme
					map[xpos[b] + i][ypos[b]] = JFeld.entry[5];
					// Explosion stoppen
					checkr = false;
					// Itemcounter true
					itemr = true;
					// Länge der Explosion
					r++;
				}
				// Unzerstörbarer Block / Exit
				else if (map[xpos[b] + i][ypos[b]].getImage() == 0
						|| map[xpos[b] + i][ypos[b]].getImage() == 3) {
					// Explosion stoppen
					checkr = false;

				}
				// Explosion in alles Andere
				else {
					map[xpos[b] + i][ypos[b]] = JFeld.entry[5];
					r++;
				}
			}
			// Explosion nach links
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
			// Explosion nach unten
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
				// Explosion in alles Andere
				else {
					map[xpos[b]][ypos[b] + i] = JFeld.entry[5];
					u++;
				}
			}
			// Explosion nach oben
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
	}
}
