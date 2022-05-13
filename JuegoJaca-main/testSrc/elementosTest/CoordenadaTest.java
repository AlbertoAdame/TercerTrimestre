package elementosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoordenadaTest {

	@Test
	public void constructorTest() {
		Coordenada c= new Coordenada(-1, 0);
		int actual = c.getX();
		assertEquals(0, actual);
	}

}
