package Bomberman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JOptionPane;

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

			String s = filename + "\n" + h + " " + w + "\n";
			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					int hilf = map[j][i].getImage();
					s = s + hilf + " ";
				}
				s = s + "\n";
			}
			// da ein Umbruch und ein Leerzeichen am Ende zu viel sind
			s = s.substring(0, s.length() - 2);
			this.createTXT(filename, s, "src/saves/");
			this.createTXT(filename, this.x + " " + this.y,
					"src/saves/position/");

		}

	}

	private void createTXT(String filename, String s, String ort) {
		File f = new File(ort + filename + ".txt");
		f.setWritable(true);
		Writer fw = null;

		try {
			fw = new FileWriter(f);
			fw.write(s);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Die Datei konnte nicht erstellt werden.");
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		f.setWritable(false);
	}

	private boolean existent(String name) {
		// ueberprueft, ob gleichnamig schon vorhanden.
		return false;
	}

}
