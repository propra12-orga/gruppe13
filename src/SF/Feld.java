package SF;

import java.awt.Graphics;
import java.awt.Image;

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
	// Felder initialisieren
	private FieldEntry[] entry = { new FieldEntry(0, false), // hard
			new FieldEntry(1, true), // grass
			new FieldEntry(2, false), // soft
			new FieldEntry(3, true), // exit
			new FieldEntry(4, false), // bombe
			new FieldEntry(5, true) // feuer
	};
	private Image figur;

	public Feld(int mapWidth, int mapHeight, int tileWidth, int tileHeight,
			String level) {
		// Erstellung ObjectArray
		this.map = new FieldEntry[mapWidth][mapHeight];

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
		this.figur = new ImageIcon(this.getClass().getResource(
				"/images/exp.gif")).getImage();

		// Kartenerstellung:
		this.generateMap();

	}

	// Kartenerstellung
	public void generateMap() {
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

					} else if (((i == 1) && (j == 3)) || ((i == 3) && (j == 1))) {
						map[i][j] = entry[2];
					} else if ((i == mapHeight - 2) && (j == mapWidth - 2)) {
						map[i][j] = entry[0];
					}

					else {
						if (this.level.equals("random")) {
							map[i][j] = entry[this.Random(1, 2)];
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

	// ganzzahliger Zufallsgenerator
	public int Random(int l, int h) {
		h++;
		return (int) (Math.random() * (h - l) + l);
	}

	// Getter fuer Kachelgroesse (wird in Glasspane verwendet)
	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	// Getter fuer Image der Figur (wird in GP verwendet)
	public Image getFigur() {
		return figur;
	}

	// setmap Methode fuer die Bombe
	public void setmap(int X, int Y, int n) {
		this.map[X][Y].setImage(n);
	}

	public FieldEntry[][] getmap() {
		return this.map;
	}

}
