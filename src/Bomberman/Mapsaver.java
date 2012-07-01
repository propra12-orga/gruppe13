package Bomberman;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Mapsaver {
	String filename;
	FieldEntry[][] map;
	int h;
	int w;
	int x;
	int y;

	public Mapsaver(String filename, FieldEntry[][] map, int h, int w, int x,
			int y) {
		this.filename = filename;
		this.map = map;
		this.h = h;
		this.w = w;
		this.x = x;
		this.y = y;
	}

	public void start() {

		if (existent(filename)) {

		} else {
			// File f = new File("/savegames/", filename);

			String s = filename + "\n" + h + " " + w + "\n";
			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					int hilf = map[j][i].getImage();
					s = s + hilf + " ";
				}
				s = s + "\n";
			}
			Writer fw = null;

			try {
				fw = new FileWriter("fileWriter.txt");
				fw.write(s);
				fw.append(System.getProperty("line.separator")); // e.g. "\n"
			} catch (IOException e) {
				System.err.println("Konnte Datei nicht erstellen");
			} finally {
				if (fw != null)
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

		}

	}

	private boolean existent(String name) {
		// ueberprueft, ob gleichnamig schon vorhanden.
		return false;
	}

}
