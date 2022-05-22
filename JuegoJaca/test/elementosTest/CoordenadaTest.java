package elementosTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


import elementos.Coordenada;
import logicaJuego.Constantes;

class CoordenadaTest {

	@Test
	void constructorNegativosTest() {
		Coordenada c = new Coordenada(-1, 0);
		int expected = 0;
		int actual = c.getX();
		assertEquals("X valor negativo",expected, actual);

		c = new Coordenada(0, -1);
		expected = 0;
		actual = c.getY();
		assertEquals("Y valor negativo",expected, actual);
	}

	@Test
	void constructorConstantesTest() {
		Coordenada c = new Coordenada(0, Constantes.TAMANNO);
		int expected = Constantes.TAMANNO;
		int actual = c.getY();
		assertEquals("Constante y",expected, actual);

		c = new Coordenada(Constantes.TAMANNO, 0);
		actual = c.getX();
		assertEquals("Constante x",expected, actual);
	}
	
	@Test
	void constructorSuperiorConstantesTest() {
		Coordenada c = new Coordenada(0, Constantes.TAMANNO+1);
		int expected = 0;
		int actual = c.getY();
		assertEquals("Constante y",expected, actual);

		c = new Coordenada(Constantes.TAMANNO+1, 0);
		expected = 0;
		actual = c.getX();
		assertEquals("Constante x",expected, actual);
	}

	@Test
	void goLeftTest() {
		Coordenada c = new Coordenada(0, 0);
		boolean expected = false;		
		boolean actual = c.goLeft();
		assertEquals("Valor 0 goLeft",expected, actual);
		
		c = new Coordenada(10, 0);
		expected = true;		
		actual = c.goLeft();
		assertEquals("Valor 10 goLeft",expected, actual);

	}

	@Test
	void goRightTest() {
		Coordenada c = new Coordenada(10, 0);
		boolean expected = false;		
		boolean actual = c.goRight();
		assertEquals("Valor 10 goRight", expected, actual);
		
		c = new Coordenada(0, 0);
		expected = true;		
		actual = c.goRight();
		assertEquals("Valor 0 goRight",expected, actual);

	}
	
	@Test
	void goDownTest() {
		Coordenada c = new Coordenada(0, 10);
		boolean expected = false;		
		boolean actual = c.goDown();
		assertEquals("Valor 10 doDown",expected, actual);
		
		c = new Coordenada(0, 0);
		expected = true;		
		actual = c.goDown();
		assertEquals("Valor 0 goDown",expected, actual);

	}

	@Test
	void goUpTest() {
		Coordenada c = new Coordenada(0, 0);
		boolean expected = false;		
		boolean actual = c.goUp();
		assertEquals("Valor 0 goUp",expected, actual);

		c = new Coordenada(0, 10);
		expected = true;		
		actual = c.goUp();
		assertEquals("Valor 10 goUp",expected, actual);
	}
	
	
	

}
