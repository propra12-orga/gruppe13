package SF;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Feld extends JPanel {

	private final int mapWidth;
	private final int mapHeight;
	private final int tileWidth;
	private final int tileHeight;
	private final Image[] tileImage;
	private final int[][] map;

	public Feld(int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
		this.map = new int[mapWidth][mapHeight];
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
			map[0][i] = 0;
			map[mapHeight - 1][i] = 0;
		}
		for (int i = 0; i < mapHeight; i++) {
			map[i][0] = 0;
			map[i][mapWidth - 1] = 0;
		}
		
		for (int i = 1; i < mapHeight - 1; i++) {
			for (int j = 1; j < mapWidth - 1; j++) {
				if ((i % 2 == 0) && (j % 2 == 0)) {
					map[i][j] = 0;
				} else {
					if (((i == 1) && (j == 1)) || ((i == 1) && (j == 2))
							|| ((i == 2) && (j == 1))) {
						map[i][j] = 1;

					} else if (((i == 1) && (j == 3)) || ((i == 3) && (j == 1))) {
						map[i][j] = 2;
					} else if ((i == mapHeight - 2) && (j == mapWidth - 2)) {
						map[i][j] = 3;
					}

					else {

						map[i][j] = this.Random(1, 2);

					}
				}
			}
		}

	}
	//ganzzahliger Zufallsgenerator
	public int Random(int l ,int h){
		h++;
		return (int)(Math.random()*(h-l)+l);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				g.drawImage(tileImage[map[j][i]], i * tileWidth,
						j * tileHeight, null);
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
	
	//Gibt die map zurueck.
	public int[][] getmap(){
		return this.map;
	}

}
