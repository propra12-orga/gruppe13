package Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import SF.Feld;
import SF.Figur;

public class TestFigur {

	// Feld initialisieren
	// Falls du wissen willst, wie das Testfeld aussieht: StartBomberman Zeile
	// 21 "random" zu "test" aendern und ausfuehren!
	Feld f = new Feld(5, 5, 32, 32, "test");

	@Test
	public void test() {
		Figur a = new Figur();
		a.setxPosition(5);
		int b = a.getxPosition();
		assertTrue(5 == b);
	}

}
