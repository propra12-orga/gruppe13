package SF;

import java.awt.Graphics;

import javax.swing.JComponent;

// Glasspane-Klasse
public class FeldGP extends JComponent {

	private static final long serialVersionUID = 1L;

	// Instanz von Feld
	private Feld feld;
	
	// Start- und Zielkacheln
	private int xStart = 1;
	private int yStart = 1;
	private int xZiel = 1;
	private int yZiel = 1;
	
	// Zählt die Zwischenschritte
	private int zwSchritt = 0;
	
	// Konstruktur für die GP
	public FeldGP(Feld feld) {
		this.feld = feld;
		this.setVisible(true);
	}
	
	// Methode, um Bomberman über die Kacheln zu bewegen
	public synchronized void walkFigur(int xStart, int yStart, int xZiel, int yZiel) {
		zwSchritt = 0;
		this.xStart = xStart;
		this.yStart = yStart;
		this.xZiel = xZiel;
		this.yZiel = yZiel;
		
		// Startet einen neuen Thread
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// Schleife über die Anzahl der Pixel einer Kachel
				for (int i = 0; i < StartBomberman.getTileWidth(); i++) {
					zwSchritt++;
					// GP soll die Grafike von BM aktualisieren
					feld.repaint();
					// Thread wird 5ms pausiert
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
	}
	
	
	@Override 
	public void paint(Graphics g) {
		super.paint(g);
		// Zeichnet BM auf die GP
		g.drawImage(feld.getFigur(), 
			(int) (feld.getTileWidth() * xStart + zwSchritt * (xZiel - xStart)), 
			(int) (feld.getTileHeight() * yStart + zwSchritt * (yZiel - yStart)), null);
	}
	

}
