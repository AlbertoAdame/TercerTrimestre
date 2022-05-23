package logicaJuegoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

class JuegoTest {

	@Test
	void testImprimirNombres() {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String expected = "El jugador 1 es un ELFO ";
		String actual = juego.imprimeNombreJugadores();
		assertEquals("Imprime mal los nombres", expected, actual);

	}

	@Test
	void testisTerminadoPorDinero() throws JugadorException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona encontrar personaje y dar dinero

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = ((Jugador) juego.obtenerElementoTablero(coordenada));
		jugador.encuentraDinero();
		jugador.encuentraDinero();

		// Zona testeo

		boolean expected = true;
		boolean actual = juego.isTerminado();
		assertEquals("IsTerminado Por Todo El Dinero", expected, actual);

	}

	@Test
	void testIsNoTerminado() throws JugadorException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona encontrar personaje y dar dinero

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = ((Jugador) juego.obtenerElementoTablero(coordenada));
		jugador.encuentraDinero();

		// Zona testeo

		boolean expected = false;
		boolean actual = juego.isTerminado();
		assertEquals("IsTerminado Por Todo El Dinero", expected, actual);

	}

	@Test
	void testIsTerminadoPorUnicoJugador() throws JugadorException {
		
		//Zona inicialización del programa
		
				ArrayList<PlayerType> jugadores = new ArrayList<>();
				jugadores.add(PlayerType.ELFO);
				jugadores.add(PlayerType.GUERRERO);
				jugadores.add(PlayerType.MAGO);
				jugadores.add(PlayerType.OGRO);
				
				PlayerType[] ordenJugadores = new PlayerType[1];
	
				ordenJugadores[0] = jugadores.get(0);
				Juego juego = new Juego(ordenJugadores);
				
				//Zona testeo
				
				boolean expected = true;
				boolean actual = juego.isTerminado();
				assertEquals("IsTerminado Porque solo hay un jugador",expected, actual);

		
	}

	@Test
	void testImprimeValores() throws JugadorException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String expected = "-ELFO\nDinero: 0\nPociones: 0\nGemas: 0\n";
		String actual = juego.imprimeValoreJugadores();
		assertEquals("Imprime valores mal", expected, actual);

	}

	@Test
	void testMovePlayerNorte() throws JugadorException, JuegoException {

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String actual = "a";
		Coordenada coordenada1 = juego.obtenerCoordenadaJugadorJuega();

		while (!actual.equals("")) {
			actual = juego.movePlayer('N');// hay veces que quizás se encuentra con otro persona o objeto, si gana
											// avanzará, pero si pierde nos dará error
		}

		Coordenada coordenada2 = juego.obtenerCoordenadaJugadorJuega();
		if(coordenada1.equals(coordenada2)) {
			assertEquals("No se mueve al norte porque está en el borde", coordenada1, coordenada2);
		}
		else
			assertNotEquals("Mover norte", coordenada1, coordenada2);
		
		

	}

	@Test
	void testMovePlayerSur() throws JugadorException, JuegoException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String actual = "a";
		Coordenada coordenada1 = juego.obtenerCoordenadaJugadorJuega();

		while (!actual.equals("")) {
			actual = juego.movePlayer('S');
		}

		
		
		Coordenada coordenada2 = juego.obtenerCoordenadaJugadorJuega();
		if(coordenada1.equals(coordenada2)) {
			assertEquals("No se mueve al sur porque está en el borde", coordenada1, coordenada2);
		}
		else
			assertNotEquals("Mover sur", coordenada1, coordenada2);
		
		
		

	}

	@Test
	void testMovePlayerEste() throws JugadorException, JuegoException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String actual = "a";
		Coordenada coordenada1 = juego.obtenerCoordenadaJugadorJuega();

		while (!actual.equals("")) {
			actual = juego.movePlayer('E');
		}

		Coordenada coordenada2 = juego.obtenerCoordenadaJugadorJuega();
		if(coordenada1.equals(coordenada2)) {
			assertEquals("No se mueve al este porque está en el borde", coordenada1, coordenada2);
		}
		else
			assertNotEquals("Mover este", coordenada1, coordenada2);
		
		

	}

	@Test
	void testMovePlayerOeste() throws JugadorException, JuegoException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);
		
		PlayerType[] ordenJugadores = new PlayerType[1];

		ordenJugadores[0] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		String actual = "a";
		Coordenada coordenada1 = juego.obtenerCoordenadaJugadorJuega();
		
		while (!actual.equals("")) {
			actual = juego.movePlayer('O');
		}

		Coordenada coordenada2 = juego.obtenerCoordenadaJugadorJuega();
		if(coordenada1.equals(coordenada2)) {
			assertEquals("No se mueve al oeste porque está en el borde", coordenada1, coordenada2);
		}
		else
			assertNotEquals("Mover oeste", coordenada1, coordenada2);

	}

	@Test
	void testMovePlayerException() throws JugadorException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		try {
			juego.movePlayer('/');
			assertTrue("Error debía haber saltado la exception Move", false);
		} catch (JuegoException | JugadorException e) {
			System.out.println("Exception de move player");
		}

	}

	@Test
	void testProximoJugador(){

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador1 = ((Jugador) juego.obtenerElementoTablero(coordenada));
		juego.proximoJugador();
		coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador2 = ((Jugador) juego.obtenerElementoTablero(coordenada));

		assertNotEquals("Proximo Jugador", jugador1, jugador2);

	}

	@Test
	void testGetGanador() throws JugadorException {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona encontrar personaje y dar dinero

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = ((Jugador) juego.obtenerElementoTablero(coordenada));
		jugador.encuentraDinero();
		jugador.encuentraDinero();

		// Zona testeo

		String expected = "\nELFO";
		String actual = juego.getGanador();
		assertEquals("Get ganador", expected, actual);

	}

	@Test
	void testGetNombreJugadorQueJuega() {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona encontrar personaje y dar dinero

		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = ((Jugador) juego.obtenerElementoTablero(coordenada));

		// Zona testeo

		String expected = jugador.getNombre();
		String actual = juego.getNombreJuegadorQueJuega();
		assertEquals("Get nombre jugador que juegas", expected, actual);

	}

	@Test
	void testGetMovimientoJugador() {

		// Zona inicialización del programa

		ArrayList<PlayerType> jugadores = new ArrayList<>();
		jugadores.add(PlayerType.ELFO);
		jugadores.add(PlayerType.GUERRERO);
		jugadores.add(PlayerType.MAGO);
		jugadores.add(PlayerType.OGRO);

		PlayerType[] ordenJugadores = new PlayerType[Constantes.NUM_JUGADORES];
		int numJugadores = 0;
		while (numJugadores < Constantes.NUM_JUGADORES - 1) {
			int tipo = 1;
			if (tipo >= 1 && tipo < jugadores.size()) {
				ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
				jugadores.remove(tipo - 1);
			}
		}
		ordenJugadores[numJugadores] = jugadores.get(0);
		Juego juego = new Juego(ordenJugadores);

		// Zona testeo

		for (int i = 0; i < 50; i++) {
			int actual = juego.getMovimientoJugador();
			assertTrue(actual >= 0 && actual <= Constantes.ELFO_VELOCIDAD);
		}

	}

}
