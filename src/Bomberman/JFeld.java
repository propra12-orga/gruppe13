package Bomberman;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JFeld extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;
	private String level; // String für Levelauswahl
	private boolean multi;// true = multiplayer (2 Player) , false =
	// Singleplayer
	private Image[] tileImage;
	private FieldEntry[][] map;
	// Felder initialisieren
	private FieldEntry[] entry = { new FieldEntry(0, false), // hard
			new FieldEntry(1, true), // tafel
			new FieldEntry(2, false), // x
			new FieldEntry(3, true), // exit
			new FieldEntry(4, false), // bombe
			new FieldEntry(5, true) // feuer
	};
	public static Image P1, P2;

	public JFeld(int mapWidth, int mapHeight, int tileWidth, int tileHeight,
			String level, boolean multi) {
		// Erstellung ObjectArray
		this.map = new FieldEntry[mapWidth][mapHeight];
		this.multi = multi;
		this.level = level;
		// Spielfeldgroesse:
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		// Kachelgroesse(Standard: 32x32 Pixel):
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		// Die verschiedenen Kachelarten:
		this.tileImage = new Image[6];

		this.tileImage[0] = new ImageIcon(this.getClass().getResource(
				"/images/cossinx32.gif")).getImage();
		this.tileImage[1] = new ImageIcon(this.getClass().getResource(
				"/images/Tafel32.gif")).getImage();
		this.tileImage[2] = new ImageIcon(this.getClass().getResource(
				"/images/X232.gif")).getImage();
		this.tileImage[3] = new ImageIcon(this.getClass().getResource(
				"/images/qed32.gif")).getImage();
		this.tileImage[4] = new ImageIcon(this.getClass().getResource(
				"/images/AblBombe32.gif")).getImage();
		this.tileImage[5] = new ImageIcon(this.getClass().getResource(
				"/images/Explosion32.gif")).getImage();
		JFeld.P1 = new ImageIcon(this.getClass().getResource("/images/exp.gif"))
				.getImage();
		JFeld.P2 = new ImageIcon(this.getClass().getResource("/images/pi.gif"))
				.getImage();

		// Kartenerstellung:
		this.generateMap();

	}

	// Kartenerstellung (random und multiplayer)
	public void generateMap() {
		if (this.level.equals("random")) {

			for (int i = 0; i < mapWidth; i++) {
				map[0][i] = entry[0];
				map[mapHeight - 1][i] = entry[0];
			}
			for (int i = 0; i < mapHeight; i++) {
				map[i][0] = entry[0];
				map[i][mapWidth - 1] = entry[0];
			}

			for (int i = 1; i < mapHeight - 1; i++) {
				for (int j = 1; j < mapWidth - 1; j++) {
					if ((i % 2 == 0) && (j % 2 == 0)) {
						map[i][j] = entry[0];
					} else {
						if (((i == 1) && (j == 1)) || ((i == 1) && (j == 2))
								|| ((i == 2) && (j == 1))) {
							map[i][j] = entry[1];

						} else if (((i == 1) && (j == 3))
								|| ((i == 3) && (j == 1))) {
							map[i][j] = new FieldEntry(2, false);
						} else if ((i == mapHeight - 2) && (j == mapWidth - 2)) {
							map[i][j] = entry[3];
						}

						else {
							int r = this.Random(1, 2);
							map[i][j] = new FieldEntry(r, false);
						}
					}
				}
				if (multi == true) {
					map[mapHeight - 2][mapWidth - 2] = entry[1];
					map[mapHeight - 3][mapWidth - 2] = entry[1];
					map[mapHeight - 2][mapWidth - 3] = entry[1];
					map[mapHeight - 4][mapWidth - 2] = entry[2];
					map[mapHeight - 2][mapWidth - 4] = entry[2];
				}
			}
			// Wenn nicht Zufall, dann Karte lesen:
		} else {

			Mapreader create = new Mapreader(this.level);
			for (int i = 0; i < create.getWidth(); i++) {
				for (int j = 0; j < create.getHeight(); j++) {
					map[i][j] = entry[create.getEntry(i, j)];
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				g.drawImage(tileImage[map[j][i].getImage()], i * tileWidth, j
						* tileHeight, null);
			}
		}
		g.drawImage(P1, JMenue.bm1.getxPosition() * tileWidth,
				JMenue.bm1.getyPosition() * tileHeight, null);
		if (multi == true) {
			g.drawImage(P2, JMenue.bm2.getxPosition() * tileWidth,
					JMenue.bm2.getyPosition() * tileHeight, null);
		}

	}

	// ganzzahliger Zufallsgenerator
	public int Random(int l, int h) {
		h++;
		return (int) (Math.random() * (h - l) + l);
	}

	public FieldEntry[][] getmap() {
		return map;
	}

	public void setmap(int x, int y, int n) {
		map[x][y] = entry[n];
	}

}
