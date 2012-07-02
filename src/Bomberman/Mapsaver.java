package Bomberman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JOptionPane;

/**
 * Spielspeichern
 */
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
		boolean machs = false;

		if (new File("src/saves/" + filename + ".txt").exists()) {
			machs = abfrage();
		}
		if (machs) {

			String s = filename + "\n" + h + " " + w + "\n";
			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					int hilf = map[i][j].getImage();
					s = s + hilf + " ";
				}
				s = s + "\n";
			}
			// da ein Umbruch und ein Leerzeichen am Ende zu viel sind
			s = s.substring(0, s.length() - 2);
			this.createTXT(filename, s, "src/saves/");
			this.createTXT(filename, this.x + " " + this.y,
					"src/saves/position/");
			JOptionPane.showMessageDialog(null,
					"Das Spiel wurde im Ordner /src/saves/ gespeichert.");
		} else {
			// filename = JOptionPane
			// .showInputDialog("Bitte benennen Sie ihren Spielstand um.");
			// start();
			JOptionPane
					.showMessageDialog(
							null,
							"Ihr Spielstand wurde nicht gespeichert."
									+ "\n"
									+ "Bitte speichern Sie erneut unter einem anderem Namen.");
		}

	}

	/**
	 * .txt Datei anlegen
	 */
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

	/**
	 * Abfrage, ob Spielstand ueberschrieben werden soll
	 */
	private boolean abfrage() {
		System.out.println("Mich gibt es schon!");

		int eingabe = JOptionPane.showConfirmDialog(null,
				"Wollen Sie den Spielstand ueberschreiben?",
				"Gleichnamiger Spielstand", JOptionPane.YES_NO_OPTION);
		if (eingabe == JOptionPane.YES_OPTION) {
			return true;

		}
		return false;
	}
}
