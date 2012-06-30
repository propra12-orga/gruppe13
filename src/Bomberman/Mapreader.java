package Bomberman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapreader {
	/**
	 * Kartenverzeichnus
	 */
	private static String mapdir = "src/maps/";
	/**
	 * Kartenname
	 */
	private static String map;
	private String name;
	/**
	 * Groesse der Karte
	 */
	private int width;
	private int height;
	/**
	 * Feldeintraege
	 */
	private int[][] entry;
	boolean random = false;

	public Mapreader(String level) {
		if (level.equals("tut")) {
			map = "tut";
		} else if (Integer.parseInt(level) < 0) {
			random = true;
			level = level.substring(1, level.length());
		} else {
			map = "level" + level;
		}
		try {
			BufferedReader file = new BufferedReader(new FileReader(mapdir
					+ map + ".txt"));
			String zeile = null;
			int k = 1;

			while ((zeile = file.readLine()) != null && k == 1) {
				name = zeile;
				k++;
			}
			this.width = Integer.parseInt(zeile.split(" ")[0]);
			this.height = Integer.parseInt(zeile.split(" ")[1]);
			this.entry = new int[width][height];
			int i = 0;
			while ((zeile = file.readLine()) != null && k == 2) {
				for (int j = 0; j < height; j++) {
					this.entry[j][i] = Integer.parseInt(zeile.split(" ")[j]);
					if (Integer.parseInt(zeile.split(" ")[j]) == 3) {
						JFeld.exit_reader = true;
					}
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean random() {
		return random;
	}

	public int getEntry(int i, int j) {
		return this.entry[i][j];
	}

	public String getName() {
		return this.name;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
