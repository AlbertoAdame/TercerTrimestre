package elementosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoordenadaTest {

	@Test
	public void constructorNegativosTest() {
		Coordenada c = new Coordenada(-1, 0);
		int expected = 0;
		int actual = c.getX();
		assertEquals(expected, actual);

		c = new Coordenada(0, -1);
		expected = 0;
		actual = c.getY();
		assertEquals(expected, actual);
	}

	@Test
	public void constructorConstantesTest() {
		Coordenada c = new Coordenada(0, 11);
		int expected = 0;
		int actual = c.getY();
		assertEquals(expected, actual);

		c = new Coordenada(11, 0);
		expected = 0;
		actual = c.getX();
		assertEquals(expected, actual);
	}

	@Test
	public void goLeftTest() {
		Coordenada c = new Coordenada(0, 0);
		boolean expected = false;		
		boolean actual = c.goLeft();
		assertEquals(expected, actual);

	}

	@Test
	public void goRightTest() {
		Coordenada c = new Coordenada(10, 0);
		boolean expected = false;		
		boolean actual = c.goRight();
		assertEquals(expected, actual);

	}
	
	@Test
	public void goDownTest() {
		Coordenada c = new Coordenada(0, 10);
		boolean expected = false;		
		boolean actual = c.goDown();
		assertEquals(expected, actual);

	}

	@Test
	public void goUpTest() {
		Coordenada c = new Coordenada(0, 0);
		boolean expected = false;		
		boolean actual = c.goUp();
		assertEquals(expected, actual);

	}

}
