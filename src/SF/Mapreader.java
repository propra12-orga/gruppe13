package SF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapreader {

	// Kartenverzeichnis
	private static String mapdir = "src/maps/";
	// Kartenname
	private static String map;
	private static String name;
	// Groesse der Karte
	private static int width;
	private static int height;
	// Feldeintraege
	private static int[][] entry;

	public static int[][] readmap(String[] args) {
		map = args[0];
		try {
			BufferedReader file = new BufferedReader(new FileReader(mapdir
					+ map + ".txt"));
			String zeile = null;
			int k = 1;

			while ((zeile = file.readLine()) != null && k == 1) {
				name = zeile;
				k++;
			}
			width = Integer.parseInt(zeile.split(" ")[0]);
			height = Integer.parseInt(zeile.split(" ")[1]);
			entry = new int[width][height];
			int i = 0;
			while ((zeile = file.readLine()) != null && k == 2) {
				for (int j = 0; j < height; j++) {
					entry[i][j] = Integer.parseInt(zeile.split(" ")[j]);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entry;
	}

	public static String getName() {
		return name;
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}
}
