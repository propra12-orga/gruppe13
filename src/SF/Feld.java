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
	private Image[] tileImage;
	private FieldEntry[][] map;

	public Feld(int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
		// Erstellung ObjectArray
		this.map = new FieldEntry[mapWidth][mapHeight];
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				map[i][j] = new FieldEntry();
			}
		}
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
		// Kartenerstellung:
		for (int i = 0; i < mapWidth; i++) {
			map[0][i].setImag(0);
			map[mapHeight - 1][i].setImag(0);
		}
		for (int i = 0; i < mapHeight; i++) {
			map[i][0].setImag(0);
			map[i][mapWidth - 1].setImag(0);
		}
		Random dice = new Random();
		for (int i = 1; i < mapHeight - 1; i++) {
			for (int j = 1; j < mapWidth - 1; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					map[i][j].setImag(0);
				} else {
					if (((i == 1) && (j == 1)) || ((i == 1) && (j == 2))
							|| ((i == 2) && (j == 1))) {
						map[i][j].setImag(1);

					} else if (((i == 1) && (j == 3)) || ((i == 3) && (j == 1))) {
						map[i][j].setImag(2);
					} else if ((i == mapHeight - 2) && (j == mapWidth - 2)) {
						map[i][j].setImag(3);
					}

					else {

						map[i][j].setImag(1 + dice.nextInt(2));

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

	// Gibt die map zurueck.
	public FieldEntry[][] getmap() {
		return this.map;
	}

}
