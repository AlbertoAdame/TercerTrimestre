package elementosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoordenadaTest {

	@Test
	public void constructorNegativosTest() {
		Coordenada c = new Coordenada(-1, 0);
		int expected=0;
		int actual = c.getX();
		assertEquals(expected, actual);
		
		c = new Coordenada(0, -1);
		expected=0;
		actual = c.getY();
		assertEquals(expected, actual);
	}
	
	@Test
	public void constructorConstantesTest() {
		Coordenada c = new Coordenada(0, 100);
		int expected=0;
		int actual = c.getY();
		assertEquals(expected, actual);
		
		c = new Coordenada(100, 0);
		expected=0;
		actual = c.getX();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void cloneTest() {
		Coordenada c = new Coordenada(4, 2);
		int expected=2;
		int actual = c.getY();
		assertEquals(expected, actual);
		
		expected=4;
		actual = c.getX();
		assertEquals(expected, actual);
	}
	
	@Test
	public void goLeftTest() {
		Coordenada c = new Coordenada(1, 1);
		int expected=0;
		c.goLeft();
		int actual = c.getX();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void goRightTest() {
		Coordenada c = new Coordenada(0, 1);
		int expected=1;
		c.goRight();
		int actual = c.getX();
		assertEquals(expected, actual);
		
	}
	
	
	
}
