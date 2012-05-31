package SF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapreader {

	private static String mapdir = "src/maps/";
	private static String map;
	private static String name;
	private static int width;
	private static int height;
	private static int[][] entry;

	public static void main(String[] args) {
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
	}
}
