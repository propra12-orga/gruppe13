package SF;

public class Synchroniser {
	public Synchroniser() {
	}

	// jede Klasse sollte eine Methode
	// haben, welche die Änderungen
	// wiedergibt, welche dann hier
	// abgefragt werden.
	public static Feld feldaktualisierung() {
		Feld feld = Bombe.aktualisierungBombe();
		return feld;
	}

}
