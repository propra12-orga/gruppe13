package SF;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Feld extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;
	private String level; // String für Levelauswahl
	private Image[] tileImage;
	private FieldEntry[][] map;
	private Image figur;
	// Felder initialisieren
	private FieldEntry[] entry = { new FieldEntry(0, false, 0), // hard
			new FieldEntry(1, true, 0), // grass
			new FieldEntry(2, false, 0), // soft
			new FieldEntry(3, true, 0), // exit
	};

	public Feld(int mapWidth, int mapHeight, int tileWidth, int tileHeight,
			String level) {
		// Erstellung ObjectArray
		this.map = new FieldEntry[mapWidth][mapHeight];
		/*
		 * for (int i = 0; i < mapWidth; i++) { for (int j = 0; j < mapHeight;
		 * j++) { map[i][j] = new FieldEntry(); } }
		 */
		this.level = level;
		// Spielfeldgroesse:
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		// Kachelgroesse(Standard: 32x32 Pixel):
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		// Die verschiedenen Kachelarten:
		this.tileImage = new Image[4];

		this.tileImage[0] = new ImageIcon(this.getClass().getResource(
				"/images/hard.png")).getImage();
		this.tileImage[1] = new ImageIcon(this.getClass().getResource(
				"/images/grass.png")).getImage();
		this.tileImage[2] = new ImageIcon(this.getClass().getResource(
				"/images/soft.png")).getImage();
		this.tileImage[3] = new ImageIcon(this.getClass().getResource(
				"/images/exit.png")).getImage();
		this.tileImage[4] = new ImageIcon(this.getClass().getResource(
				"/images/bombe.png")).getImage();
		this.tileImage[5] = new ImageIcon(this.getClass().getResource(
				"/images/feuer.png")).getImage();
		this.figur = new ImageIcon(this.getClass()
				.getResource("/images/XD.png")).getImage();

		// Kartenerstellung:
		for (int i = 0; i < mapWidth; i++) {
			map[0][i] = entry[0];
			map[mapHeight - 1][i] = entry[0];
		}
		for (int i = 0; i < mapHeight; i++) {
			map[i][0] = entry[0];
			map[i][mapWidth - 1] = entry[0];
		}
		Random dice = new Random();
		for (int i = 1; i < mapHeight - 1; i++) {
			for (int j = 1; j < mapWidth - 1; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					map[i][j] = entry[0];
				} else {
					if (((i == 1) && (j == 1)) || ((i == 1) && (j == 2))
							|| ((i == 2) && (j == 1))) {
						map[i][j] = entry[1];

					} else if (((i == 1) && (j == 3)) || ((i == 3) && (j == 1))) {
						map[i][j] = entry[2];
					} else if ((i == mapHeight - 2) && (j == mapWidth - 2)) {
						map[i][j] = entry[3];
					}

					else {
						if (this.level.equals("random")) {
							map[i][j] = entry[1 + dice.nextInt(2)];
						}
						if (this.level.equals("test")) {
							map[i][j] = entry[1];
						} else {
						}
					}
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
	}

	/*
	 * test*** public void showArray() {
	 * 
	 * for (int i = 1; i < mapWidth; i++) { for (int j = 1; j < mapHeight; j++)
	 * { System.out.println(map[i][j]); } }
	 * 
	 * }
	 */

	// Getter für Kachelgroesse (wird in Glasspane verwendet)
	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	// setmap Methode f�r die Bombe
	public void setmap(int X, int Y, FieldEntry Change) {
		this.map[X][Y] = Change;
	}

	public FieldEntry[][] getmap() {
		return this.map;
	}

}
