package elementosTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

public class CoordenadaTest {

	@Test
	public void ConstructorTest() {
		Coordenada target= new Coordenada(-1, 0);
		
		assertEquals(0,0, target.getX());
	}
}
