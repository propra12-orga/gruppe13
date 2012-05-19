package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import SF.Feld;
import SF.Figur;

public class TestFigur {

	// Feld initialisieren
	// Falls du wissen willst, wie das Testfeld aussieht: StartBomberman Zeile
	// 21 "random" zu "test" aendern und ausfuehren!

	@Test
	public void tgetx1() {
		Figur a = new Figur(1, 1);
		int b = a.getxPosition();
		assertEquals(1, b);
	}

	@Test
	public void tgetx2() {
		Figur a = new Figur(0, 6);
		int b = a.getxPosition();
		assertEquals(0, b);
	}

	@Test
	public void tsetx1() {
		Figur a = new Figur(1, 1);
		a.setxPosition(5);
		int b = a.getxPosition();
		assertEquals(5, b);
	}

	@Test
	public void tsetx2() {
		Figur a = new Figur(0, 10);
		a.setxPosition(0);
		int b = a.getxPosition();
		assertEquals(0, b);
	}

	@Test
	public void tgety1() {
		Figur a = new Figur(1, 1);
		int b = a.getxPosition();
		assertEquals(1, b);
	}

	@Test
	public void tgety2() {
		Figur a = new Figur(0, 0);
		int b = a.getxPosition();
		assertEquals(0, b);
	}

	@Test
	public void tsety1() {
		Figur a = new Figur(1, 1);
		a.setyPosition(5);
		int b = a.getyPosition();
		assertEquals(5, b);
	}

	@Test
	public void tsety2() {
		Figur a = new Figur(0, 10);
		a.setyPosition(0);
		int b = a.getyPosition();
		assertEquals(0, b);
	}

	Feld f = new Feld(5, 5, 32, 32, "test");

	@Test
	public void tfeldfrei1() {
		Figur a = new Figur(1, 1);
		boolean b = a.feldfrei(1, 1, f.getmap());
		assertEquals(true, b);
	}

	@Test
	public void tfeldfrei2() {
		Figur a = new Figur(1, 1);
		boolean b = a.feldfrei(0, 0, f.getmap());
		assertEquals(false, b);
	}

	@Test
	public void tfeldfrei3() {
		Figur a = new Figur(1, 1);
		boolean b = a.feldfrei(2, 2, f.getmap());
		assertEquals(false, b);
	}

	@Test
	public void tfeldfrei4() {
		Figur a = new Figur(1, 1);
		boolean b = a.feldfrei(3, 3, f.getmap());
		assertEquals(true, b);
	}

	/*
	 * @Test public void tlinks1() { Figur a = new Figur(2, 1); a.links(f); int
	 * b = a.getxPosition(); int c = a.getyPosition(); assertEquals(1, b);
	 * assertEquals(1, c); }
	 * 
	 * @Test public void trechts1() { Figur a = new Figur(1, 1); a.rechts(f);
	 * int b = a.getxPosition(); int c = a.getyPosition(); assertEquals(1, b);
	 * assertEquals(1, c); }
	 */
}
