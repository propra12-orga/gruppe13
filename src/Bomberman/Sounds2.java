package Bomberman;

/**
 * Bombensound
 */
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class Sounds2 extends Thread {
	public void run() {
		try {
			int a = (int) (Math.random() * 4) + 1;// Bombensound zufällig
			String pfad1 = "/sounds/bomb";
			String pfad2 = ".wav";
			String zusammen = pfad1 + a + pfad2;// Pfad konstruieren
			URL defaultSound = getClass().getResource(zusammen);
			File file1 = new File(defaultSound.toURI());// notwendig damit der
														// aus Package die
														// Sounds liesst
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(file1);
			AudioFormat af = audioInputStream.getFormat();
			if ((af.getEncoding() == AudioFormat.Encoding.ULAW)
					|| (af.getEncoding() == AudioFormat.Encoding.ALAW)) {// encodierung
																			// da
																			// sonst
																			// nicht
																			// mehr
																			// als
																			// 30kb
																			// abspielen
				AudioFormat tmp = new AudioFormat(
						AudioFormat.Encoding.PCM_SIGNED, af.getSampleRate(), af
								.getSampleSizeInBits() * 2, af.getChannels(),
						af.getFrameSize() * 2, af.getFrameRate(), true);
				audioInputStream = AudioSystem.getAudioInputStream(tmp,
						audioInputStream);
				af = tmp;
			}
			SourceDataLine line = null;// SourceDataline damit groesser als 30kb
										// abspielbar
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(af);
			line.start();
			int BUFFER_SIZE = 64 * 1024;// Buffer und untere notwendig zum
										// abspielen
			int Byteslesen = 0;
			byte[] sampledData = new byte[BUFFER_SIZE];
			while (Byteslesen != -1) {

				Byteslesen = audioInputStream.read(sampledData, 0,
						sampledData.length);
				if (Byteslesen >= 0) {
					line.write(sampledData, 0, Byteslesen);
				}
			}
			line.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}