package multiplayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Bomberman.Control;
import Bomberman.Figur;

/**
 * Der Client fuer Netzwerk
 */
public class MyClientSocket implements MySockets {

	/**
	 * Klassenvariablen fuer Socken und die Streams
	 */
	private Socket socket = null;
	private ObjectInputStream oistream = null;
	private ObjectOutputStream oostream = null;

	/**
	 * Variablen fuer den BM des Servers!
	 */
	private Figur bm1;
	/**
	 * die Control Instanz
	 */
	private Control control;

	public MyClientSocket(String ip, Figur bm) {
		this.bm1 = bm;
		try {
			InetAddress host = InetAddress.getByName(ip);
			// Verbindung mit dem Server mit der übergebenen
			// IP-Adresse bzw. Hosts, Port ist festgelegt
			socket = new Socket(host.getHostName(), 43935);

			// Der InputStream zum Lesen neuer Objete
			// vom Server
			oistream = new ObjectInputStream(socket.getInputStream());

			// Der Stream zum senden von Objekten an den Server
			oostream = new ObjectOutputStream(socket.getOutputStream());

			// Thread liest ankommende Objekte vom Server
			new Thread(new Runnable() {
				@Override
				public void run() {
					// Solange kein Fehler auftritt
					boolean error = false;
					while (!error) {
						try {
							if (socket.isConnected()) {
								// Nächstes Objekt aus dem Stream holen
								Object message = oistream.readObject();
								// Falls das Objekt vom Typ Figur ist
								if (message instanceof Figur) {
									Figur bmS = (Figur) message;
									// Position des BM des Clients auf dem
									// eigenen
									// Spielfeld setzen
									MyClientSocket.this.bm1.setxPosition(bmS
											.getxPosition());
									MyClientSocket.this.bm1.setyPosition(bmS
											.getyPosition());
									// falls das Objekt vom Typ String ist
								} else if (message instanceof String) {
									String msg = (String) message;
									// überprüfen, ob er "Bombe" enthält
									if (msg.equals("Bombe")) {
										// die Bombe an der Stelle des
										// Server-BMs legen
										control
												.bombeLegen(MyClientSocket.this.bm1);
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

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methode zum Senden von Objekten an den Server
	 */
	public void send(Object object, boolean bomb) {
		try {
			// falls bomb=true, wird auf dem Server
			// an der Stelle des Client-BM eine Bombe gelegt
			if (bomb) {
				oostream.writeObject("Bombe");
			} else {
				// ansonsten wird die Client-Position
				// übergeben
				oostream.writeObject(object);
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