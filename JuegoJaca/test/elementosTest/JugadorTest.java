package elementosTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class JugadorTest {

	@Test
	public void getFuerzaParaLucharTest() {
		Jugador j = new Jugador(PlayerType.ELFO);
		int resultado = j.getFuerzaParaLuchar();
		assertTrue(resultado > 0 && resultado < Constantes.ELFO_FUERZA);

	}

	@Test
	public void getMagiaParaLucharTest() {
		Jugador j = new Jugador(PlayerType.GUERRERO);
		int resultado = j.getMagiaParaLuchar();
		assertTrue(resultado > 0 && resultado < Constantes.GUERRERO_MAGIA);

	}

	@Test
	public void getVelocidadParaLucharTest() {
		Jugador j = new Jugador(PlayerType.MAGO);
		int resultado = j.getVelocidadParaLuchar();
		assertTrue(resultado > 0 && resultado < Constantes.MAGO_VELOCIDAD);

	}

	@Test
	public void setDineroCeroTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setDinero(0);
		int actual = j.getDinero();
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	public void setDineroConstanteTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		j.setDinero(Constantes.DINERO);
		int actual = j.getDinero();
		int expected = Constantes.DINERO;
		assertEquals(expected, actual);

	}

	@Test
	public void setDineroExceptionTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		int actual = j.getDinero();
		int expected = Constantes.DINERO;
		try {
			j.setDinero(-1);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println("La exception ha saltado");
		}

	}

	@Test
	public void setPocionesCeroTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setPociones(0);
		int actual = j.getPociones();
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	public void setPocionesConstanteTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		j.setPociones(Constantes.POCION);
		int actual = j.getPociones();
		int expected = Constantes.POCION;
		assertEquals(expected, actual);

	}

	@Test
	public void setPocionesExceptionTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		int actual = j.getPociones();
		int expected = Constantes.POCION;
		try {
			j.setPociones(-1);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println("La exception ha saltado");
		}

	}

	@Test
	public void setGemaCeroTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);
		j.setGemas(0);
		int actual = j.getGemas();
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	public void setGemasConstanteTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		j.setGemas(Constantes.GEMA);
		int actual = j.getGemas();
		int expected = Constantes.GEMA;
		assertEquals(expected, actual);

	}

	@Test
	public void setGemaExceptionTest() throws JugadorException {
		Jugador j = new Jugador(PlayerType.OGRO);

		int actual = j.getGemas();
		int expected = Constantes.GEMA;
		try {
			j.setGemas(-1);
			assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println("La exception ha saltado");
		}

	}

	/**
	 * public static final int EMPATE=0; //Hay empate ninguno de los dos gana la
	 * lucha public static final int GANA_USA_POCIMA= 1; //Gana el jugador y se
	 * utiliza pocima del enemigo para que no muera public static final int
	 * GANA_DINERO=2; //Gana el jugador y se lleva todo el dinero del enemigo public
	 * static final int GANA_MUERE=3; //Gana el jugador y el enemigo muere public
	 * static final int PIERDE_USA_POCIMA= 4; //Gana el enemigo y se utiliza pocima
	 * del jugador para que no muera public static final int PIERDE_DINERO=5; //Gana
	 * el enemigo y se lleva todo el dinero del jugador public static final int
	 * PIERDE_MUERE=6; //Gana el enemigo y el jugador muere
	 * 
	 * @throws JugadorException
	 */

	@Test
	public void luchaSinNadaGanaTest() throws JugadorException {// Usaremos al ejemplo del ogro y el elfo, pq la gran
																// mayoría de veces ganará el ogro, no sé como hacerlo
																// de otra forma
		Jugador j = new Jugador(PlayerType.OGRO);
		Jugador j1 = new Jugador(PlayerType.ELFO);

		int actual = j.lucha(j1);
		int expected = Constantes.GANA_MUERE;
		assertEquals(expected, actual);

	}
	
	@Test
	public void luchaSinNadaPierdeTest() throws JugadorException {// Usaremos al ejemplo del ogro y el elfo, pq la gran
																// mayoría de veces ganará el ogro, no sé como hacerlo
																// de otra forma
		Jugador j = new Jugador(PlayerType.OGRO);
		Jugador j1 = new Jugador(PlayerType.ELFO);

		int actual = j1.lucha(j);
		int expected = Constantes.PIERDE_MUERE;
		assertEquals(expected, actual);

	}

	@Test
	public void luchaConDineroGanaTest() throws JugadorException {// Usaremos al ejemplo del ogro y el elfo, pq la gran
																	// mayoría de veces ganará el ogro, no sé como
																	// hacerlo de otra forma
		Jugador j = new Jugador(PlayerType.OGRO);
		Jugador j1 = new Jugador(PlayerType.ELFO);
		j1.setDinero(1);

		int actual = j1.lucha(j);
		int expected = Constantes.PIERDE_DINERO;
		assertEquals(expected, actual);
		assertTrue(j1.getDinero()==0);

	}
	
	@Test
	public void luchaConPocionGanaTest() throws JugadorException {// Usaremos al ejemplo del ogro y el elfo, pq la gran
																	// mayoría de veces ganará el ogro, no sé como
																	// hacerlo de otra forma
		Jugador j = new Jugador(PlayerType.OGRO);
		Jugador j1 = new Jugador(PlayerType.ELFO);
		j1.setPociones(1);

		int actual = j1.lucha(j);
		int expected = Constantes.PIERDE_USA_POCIMA;
		assertEquals(expected, actual);
		assertTrue(j1.getPociones()==0);

	}

}
