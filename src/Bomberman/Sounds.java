package Bomberman;

/**
 * Menue Sound
 */
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class Sounds extends Thread {
	public void run() {
		try {
			URL defaultSound = getClass().getResource("/sounds/lauf3.wav");
			File file1 = new File(defaultSound.toURI());

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
						AudioFormat.Encoding.PCM_SIGNED, af.getSampleRate(),
						af.getSampleSizeInBits() * 2, af.getChannels(),
						af.getFrameSize() * 2, af.getFrameRate(), true);
				audioInputStream = AudioSystem.getAudioInputStream(tmp,
						audioInputStream);
				af = tmp;
			}
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
					if (JMenue.stopper) {// beenden falls Menue zu
						Byteslesen = audioInputStream.read(sampledData, 0,
								sampledData.length);
						if (Byteslesen >= 0) {
							line.write(sampledData, 0, Byteslesen);
						}
					} else if (!JMenue.stopper) {
						line.close();
					}
				}
			} while (line.isActive());
		}

<<<<<<< HEAD
   		  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file1);
             AudioFormat af = audioInputStream.getFormat();
             if ((af.getEncoding() == AudioFormat.Encoding.ULAW)|| (af.getEncoding() == AudioFormat.Encoding.ALAW) )
             {//encodierung da sonst nicht mehr als 30kb abspielen
           	 AudioFormat tmp = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, af.getSampleRate(), af.getSampleSizeInBits()*2, af.getChannels(), af.getFrameSize()*2, af.getFrameRate(), true);
             audioInputStream = AudioSystem.getAudioInputStream(tmp, audioInputStream);
             af = tmp;	    
             }
             SourceDataLine line =null;
             DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
             line = (SourceDataLine) AudioSystem.getLine(info);
         	 line.open(af);
             line.start();
             int BUFFER_SIZE =64* 1024;
             int Byteslesen = 0;
//             System.out.println(
//                     "encoding: " + af.getEncoding());
//                   System.out.println(
//                     "frame rate: " + af.getFrameRate());
//                   System.out.println(
//                     "frame size: " + af.getFrameSize() + "(bytes)");
//                   System.out.println(
//                     "sample rate: " + af.getSampleRate());
//                   System.out.println(
//                     "sample size: " + af.getSampleSizeInBits() + "(bits)");
//                   System.out.println(
//                     "channels: " + af.getChannels());
//                   System.out.println(
//                     "big endian: " + af.isBigEndian());

             byte[] sampledData = new byte[BUFFER_SIZE];
             do{
             while (Byteslesen != -1) {
            	if (JMenue.stopper ==true){//beenden falls Menue zu
            		Byteslesen = audioInputStream.read(sampledData, 0, sampledData.length);
                if (Byteslesen >= 0) {
                   line.write(sampledData, 0, Byteslesen);
                }}
            	else if(JMenue.stopper== false){
            		line.close();
            	}
             }
             }while(line.isActive());
             }
   	  		
           catch(Exception e){
                              e.printStackTrace();}
           return;
     }
=======
		catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
>>>>>>> 48d8a01b3acb1ecbcf9285c76d8771cb15aad7d8
}