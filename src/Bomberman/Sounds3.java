package Bomberman;

/**
 * Todessound
 */
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class Sounds3 extends Thread {
	public void run() {
		try {
			int a = (int) (Math.random() * 3) + 1;// Bombensound zufällig
			String pfad11 = "/sounds/tod";
			String pfad22 = ".wav";
			String zusammen2 = pfad11 + a + pfad22;// Pfad konstruieren
			URL defaultSound = getClass().getResource(zusammen2);
			File file1 = new File(defaultSound.toURI());

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(file1);
			AudioFormat af = audioInputStream.getFormat();
			SourceDataLine line = null;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(af);
			line.start();
			int BUFFER_SIZE = 64 * 1024;
			int Byteslesen = 0;

			byte[] sampledData = new byte[BUFFER_SIZE];
			do {
				while (Byteslesen != -1) {
					if (JMenue.stopper == true) {// beenden falls Menue zu
						Byteslesen = audioInputStream.read(sampledData, 0,
								sampledData.length);
						if (Byteslesen >= 0) {
							line.write(sampledData, 0, Byteslesen);
						}
					} else if (JMenue.stopper == false) {
						line.close();
					}
				}
			} while (line.isActive());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}