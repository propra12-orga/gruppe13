package multiplayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Bomberman.Control;
import Bomberman.Figur;
import Bomberman.JJFrame;

public class MyServerSocket implements MySockets {
	private ServerSocket server;
	// festgelegter Port
	private int port = 43935;

	// Variablen für den Socket und die Streams
	private Socket socket = null;
	private ObjectInputStream oistream = null;
	private ObjectOutputStream oosstream = null;

	// Klassenvariablen, um auf Control und bm2
	// zugreifen zu können
	private Control control;
	private Figur bm2;
	
	// Konstruktor für den Server
	public MyServerSocket(Figur bm2) {
		this.bm2 = bm2;
		try {
			// neuen Socket erstellen
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.handleConnection();
	}

	// Methode ruft neue Objekte ab, die
	// an den Server gesendet wurden
	public void handleConnection() {
		try {
			// einmalig auf den Client warten
			socket = server.accept();

			// die Streams vom Socket auf
			// oos/ois setzen
			oosstream = new ObjectOutputStream(socket.getOutputStream());
			oistream = new ObjectInputStream(socket.getInputStream());
			
			// Thread in anonymer Klasse
			new Thread(new Runnable() {

				@Override
				public void run() {
					boolean error = false;
					// solange kein Fehler auftritt
					// in Schleife auf Nachrichten warten
					// und bearbeiten
					while (!error) {
						try {
							if (socket.isConnected()) {
								// nächstes ankommende Objekt holen
								Object message = oistream.readObject();
								// falls das Objekt die Figur ist
								if (message instanceof Figur) {
									Figur bmC = (Figur) message;
									// die Figur des Clients beim Server
									// auf die übergebene Position setzen
									MyServerSocket.this.bm2.setxPosition(bmC.getxPosition());
									MyServerSocket.this.bm2.setyPosition(bmC.getyPosition());
								// und wenn ein String übergeben wurde
								} else if (message instanceof String) {
									String msg = (String) message;
									// prüfen, ob die Bombe gelegt werden soll
									if (msg.equals("Bombe")) {
										// im Control-Objekt die Bombe an der Stelle
										// des BM des Clients legen
										control.bombeLegen(MyServerSocket.this.bm2);
									}
								}
							}
							
						} catch (IOException e) {
							// wenn z.B. der Client die Verbindung
							// abbricht / das Spiel beendet.
							error = true;
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	// Methode zum Senden von Objekten an den Client
	public void send(Object object, boolean bomb) {
		try {
			// falls bomb=true, soll eine Bombe
			// gelegt werden
			if (bomb) {
				// entsprechendes Objekt abschicken
				oosstream.writeObject("Bombe");
			// ansonsten die Position des eigenen
			// bm an den Client übermitteln
			} else {
				oosstream.writeObject(object);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Setter für die Control-Instanz
	public void setControl(Control control) {
		this.control = control;
	}
	
}
