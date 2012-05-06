import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Spielfeld extends JPanel {

	//Spielfeldgroesse:
	private int mapWidth = 19;
	private int mapHeight = 19;
	//Kachelgroesse (Standard: 32x32 Pixel):
	private int tileWidth = 32;
	private int tileHeight = 32;
	//Beispiel-Map:
	
	//0 wiese/freies Feld
	//1 unzerstoerbare Mauer
	//2 zerstöoerbare Mauer
	//3 Ausgang
	
	//wird zu 2dim umgeschrieben
	private final int[] map =  {	  
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,2,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
	};
	private final Image[] tileImage;

	//Spielfeld:
	public Spielfeld(int mapWidth, int mapHeight, int tileWidth, int tileHeight) {
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		//Die verschiedenen Kachelarten:
		this.tileImage = new Image[4];
		this.tileImage[0] = new ImageIcon(this.getClass().getResource("/images/grass.png")).getImage();
		this.tileImage[1] = new ImageIcon(this.getClass().getResource("/images/hard.png")).getImage();
		this.tileImage[2] = new ImageIcon(this.getClass().getResource("/images/soft.png")).getImage();
		this.tileImage[3] = new ImageIcon(this.getClass().getResource("/images/exit.png")).getImage();

	}

	@Override
	public void paint(Graphics g) {
		int posX = 0;
		int posY = 0;
		super.paint(g);
		
		//Karte zeichnen:
		int index = 0; //Index der Map
		while (index < (mapWidth * mapHeight)) {
			for (int i = 0; i < mapWidth; i++) {
				for (int j = 0; j < mapHeight; j++) {
					g.drawImage(tileImage[map[index]], posX, posY, null);
					posX += tileWidth;
					index++;
				}
				posX = 0;
				posY += tileHeight;
			}
			posY = 0;
		}
	}
}
