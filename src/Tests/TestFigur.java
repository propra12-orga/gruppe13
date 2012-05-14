package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import SF.Figur;

public class TestFigur {

	@Test
	public void test() {
		Figur a = new Figur();
		   a.setxPosition(5);
		   int b = a.getxPosition();
		   assertTrue(5==b);
	}

}
