package Bomberman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mapreader {
	/**
	 * Kartenverzeichnis
	 */
	private static String mapdir = "src/maps/";
	private static String savevz = "src/saves/";
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

	public Mapreader(String level, boolean load) {
		String vz = mapdir;

		if (level.equals("tut") && load == false) {
			map = "tut";
		} else if (Integer.parseInt(level) < 0 && load == false) {
			random = true;
			level = level.substring(1, level.length());
		} else if (load == false) {
			map = "level" + level;
		} else {
			map = level;
			vz = savevz;
		}
		try {
			BufferedReader file = new BufferedReader(new FileReader(vz + map
					+ ".txt"));
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
	
	public int[] pos(){
		int[] xy = new int[2];
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(savevz+"position/" + map + ".txt"));
			
			String zeile = null;
			int k = 1;

			while ((zeile = file.readLine()) != null && k == 1) {
				name = zeile;
				k++;
			xy[0] = Integer.parseInt(zeile.split(" ")[0]);
			xy[1] = Integer.parseInt(zeile.split(" ")[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xy;
	}
}
