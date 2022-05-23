package elementosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class JugadorTest {

	@Test
	public void testGetFuerzaParaLuchar() {
		Jugador j = new Jugador(PlayerType.ELFO);
		for (int i = 0; i < 50; i++) {
			int resultado = j.getFuerzaParaLuchar();
			assertTrue(resultado >= 0 && resultado <= Constantes.ELFO_FUERZA);
		}

	}

	@Test
	public void testGetMagiaParaLuchar() {
		Jugador j = new Jugador(PlayerType.GUERRERO);
		for (int i = 0; i < 50; i++) {
			int resultado = j.getMagiaParaLuchar();
			assertTrue(resultado >= 0 && resultado <= Constantes.GUERRERO_MAGIA);
		}

	}

	@Test
	public void testGetVelocidadParaLuchar() {
		Jugador j = new Jugador(PlayerType.MAGO);
		for (int i = 0; i < 50; i++) {
			int resultado = j.getVelocidadParaLuchar();
			assertTrue(resultado >= 0 && resultado <= Constantes.MAGO_VELOCIDAD);
		}

	}

	@Test
	public void testSetDineroCeroConstante() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setDinero(0);
		int actual = j.getDinero();
		int expected = 0;
		assertEquals("setDinero", expected, actual);

		j.setDinero(Constantes.NUM_DINERO);
		actual = j.getDinero();
		expected = Constantes.NUM_DINERO;
		assertEquals(expected, actual);

	}

	@Test
	public void testSetDineroException() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		try {
			j.setDinero(-1);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception inferior setDinero ha saltado");
		}

		try {
			j.setDinero(3);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception superior setDinero ha saltado");
		}

	}

	@Test
	public void testSetPocionesCeroConstante() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setPociones(0);
		int actual = j.getPociones();
		int expected = 0;
		assertEquals(expected, actual);

		j.setPociones(Constantes.POCION);
		actual = j.getPociones();
		expected = Constantes.POCION;
		assertEquals(expected, actual);

	}

	@Test
	public void testSetPocionesException() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		try {
			j.setPociones(-1);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception inferior setPociones ha saltado");
		}

		try {
			j.setPociones(4);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception superior setPociones ha saltado");
		}

	}

	@Test
	public void testSetGemaCeroConstante() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setGemas(0);
		int actual = j.getGemas();
		int expected = 0;
		assertEquals(expected, actual);

		j.setGemas(Constantes.GEMA);
		actual = j.getGemas();
		expected = Constantes.GEMA;
		assertEquals(expected, actual);

	}
	
	@Test
	public void testSetGemaException() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		try {
			j.setGemas(-1);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception inferior setGemas ha saltado");
		}

		try {
			j.setGemas(6);
			assertTrue("Error debía haber saltado la exception", false);
		} catch (Exception e) {
			System.out.println("La exception superior setGemas ha saltado");
		}

	}

	@Test
	public void testLucha() throws JugadorException {
		Jugador j1 = new Jugador(PlayerType.OGRO);
		Jugador j2 = new Jugador(PlayerType.GUERRERO);
		int resultado;
		for (int i = 0; i < 50; i++) {
			resultado = j1.lucha(j2);
			assertTrue(resultado == 3 || resultado == 6 || resultado == 0);
		}

	}

	@Test
	public void testLuchaConPocion() throws JugadorException {// No hará falta probar todos los personajes, ya que
																// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		Jugador j2 = new Jugador(PlayerType.MAGO);
		int resultado;
		for (int i = 0; i < 50; i++) {
			j1.setPociones(1);
			j2.setPociones(1);
			resultado = j1.lucha(j2);
			if (resultado == 1) {
				assertTrue(j2.getPociones() == 0);
			} else if (resultado == 0) {
				assertTrue(j1.getPociones() == 1 && j2.getPociones() == 1);
			} else if (resultado == 4) {
				assertTrue(j1.getPociones() == 0);
			}
		}

	}

	@Test
	public void testLuchaConDinero() throws JugadorException {// No hará falta probar todos los personajes, ya que
																// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		Jugador j2 = new Jugador(PlayerType.MAGO);
		int resultado;
		for (int i = 0; i < 50; i++) {
			j1.setDinero(1);
			j2.setDinero(1);
			resultado = j1.lucha(j2);
			if (resultado == 2) {
				assertTrue(j2.getDinero() == 0 && j1.getDinero() == 2);
			} else if (resultado == 0) {
				assertTrue(j1.getDinero() == 1 && j2.getDinero() == 1);
			} else if (resultado == 5) {
				assertTrue(j1.getDinero() == 0 && j2.getDinero() == 2);
			}
		}

	}

	@Test
	public void testEncuentraRocaConGema() throws JugadorException {// No hará falta probar todos los personajes, ya que
		// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		int resultado;
		j1.setGemas(1);
		resultado = j1.encuentraRoca();
		assertTrue(resultado == 0 && j1.getGemas() == 0);

	}

	@Test
	public void testEncuentraRocaSinGema() throws JugadorException {// No hará falta probar todos los personajes, ya que
		// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		int resultado;
		for (int i = 0; i < 50; i++) {
			resultado = j1.encuentraRoca();
			assertTrue(resultado == 2 || resultado == 1);
		}

	}

	@Test
	public void testEncuentraDinero() throws JugadorException {// No hará falta probar todos los personajes, ya que
																// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		int resultado = 0;
		for (int i = 0; i < Constantes.NUM_DINERO; i++) {
			j1.encuentraDinero();
			resultado++;
			assertTrue(j1.getDinero() == resultado);
		}

	}

	@Test
	public void testEncuentraDineroException() {// No hará falta probar todos los personajes, ya que
												// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		for (int i = 0; i < Constantes.NUM_DINERO+1; i++) {
			try {
				j1.encuentraDinero();
				assertTrue(j1.getDinero() <= Constantes.NUM_DINERO);
			} catch (JugadorException e) {
				System.out.println("Cantidad de dinero por encima de la constante");
			}

		}

	}
	
	@Test
	public void testEncuentraGema() throws JugadorException {// No hará falta probar todos los personajes, ya que
																// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		int resultado = 0;
		for (int i = 0; i < Constantes.NUM_GEMAS; i++) {
			j1.encuentraGema();
			resultado++;
			assertTrue(j1.getGemas() == resultado);
		}

	}

	@Test
	public void testEncuentraGemaException() {// No hará falta probar todos los personajes, ya que
												// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		for (int i = 0; i < Constantes.NUM_GEMAS+1; i++) {
			try {
				j1.encuentraGema();
				assertTrue(j1.getGemas() <= Constantes.NUM_GEMAS);
			} catch (JugadorException e) {
				System.out.println("Cantidad de gemas por encima de la constante");
			}

		}

	}
	
	@Test
	public void testEncuentraPocion() throws JugadorException {// No hará falta probar todos los personajes, ya que
																// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		int resultado = 0;
		for (int i = 0; i < Constantes.NUM_POCIONES; i++) {
			j1.encuentraPocion();
			resultado++;
			assertTrue(j1.getPociones() == resultado);
		}

	}

	@Test
	public void testEncuentraPocionException() {// No hará falta probar todos los personajes, ya que
												// saltará independientemente del personaje que usemos
		Jugador j1 = new Jugador(PlayerType.ELFO);
		for (int i = 0; i < Constantes.NUM_POCIONES+1; i++) {
			try {
				j1.encuentraPocion();
				assertTrue(j1.getPociones() <= Constantes.NUM_POCIONES);
			} catch (JugadorException e) {
				System.out.println("Cantidad de gemas por encima de la constante");
			}

		}

	}

}
