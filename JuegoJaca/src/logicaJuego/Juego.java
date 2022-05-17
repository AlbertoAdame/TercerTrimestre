package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	public Juego(PlayerType[] jugadores) {
		super();
		this.tablero = new HashMap<>();
		this.coordenadaJugadores = new ArrayList<>();

//		for (int i = 0; i < 4; i++) {
//			crearJugador(jugadores(i));
//		}
//		this.dado = dado;
	}

	private void crearTablero() {
		crearRocas();
		crearDinero();
		crearGemas();
		crearPociones();

	}

	private void crearRocas() {
		int contador = 0;
		while (contador != Constantes.NUM_ROCAS) {
			Coordenada coordenada = new Coordenada();
			if (!tablero.containsKey(coordenada)) {
				Element roca = new Element(ElementType.ROCA);
				tablero.put(coordenada, roca);
				contador++;
			}

		}
	}

	private void crearGemas() {
		int contador = 0;
		while (contador != Constantes.NUM_GEMAS) {
			Coordenada coordenada = new Coordenada();
			if (!tablero.containsKey(coordenada)) {
				Element gema = new Element(ElementType.GEMA);
				tablero.put(coordenada, gema);
				contador++;
			}

		}
	}

	private void crearPociones() {
		int contador = 0;
		while (contador != Constantes.NUM_POCIONES) {
			Coordenada coordenada = new Coordenada();
			if (!tablero.containsKey(coordenada)) {
				Element pocion = new Element(ElementType.POCION);
				tablero.put(coordenada, pocion);
				contador++;
			}

		}
	}

	private void crearDinero() {
		int contador = 0;
		while (contador != Constantes.NUM_DINERO) {
			Coordenada coordenada = new Coordenada();
			if (!tablero.containsKey(coordenada)) {
				Element dinero = new Element(ElementType.DINERO);
				tablero.put(coordenada, dinero);
				contador++;
			}

		}
	}

	/**
	 * Escribe el tablero en formato no grÃ¡fico. Devuelve el string con la
	 * informaciÃ³n
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	public boolean isTerminado() {
		boolean terminado = false;
		if (coordenadaJugadores.size() == 1) {
			terminado = true;
		} else {
			Iterator<Coordenada> siguiente = coordenadaJugadores.iterator();
			while (siguiente.hasNext() && !terminado) {
				Coordenada c = siguiente.next();
				Jugador j = (Jugador) tablero.get(c);
				if (j.getDinero() == Constantes.NUM_DINERO)
					terminado = true;

			}

		}
		return terminado;

	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	public String imprimeNombreJugador() {
		StringBuilder resultado = new StringBuilder();
		int contador = 1;
		for (Coordenada c : coordenadaJugadores) {
			Jugador j = (Jugador) tablero.get(c);
			resultado.append("El jugador " + contador + "es un " + j.getNombre() + "\n");
			contador++;
		}

		return resultado.toString();
	}

	private void eliminarJugador(Coordenada coor) {// comprobar con los test, deberemos dar por sentado que todo está
													// bien?
		if (tablero.containsKey(coor) && coordenadaJugadores.contains(coor)) {
			Jugador j = (Jugador) tablero.get(coor);
			tablero.remove(coor, j);
			coordenadaJugadores.remove(coor);
		}

	}

	private Coordenada getNextPosition(char direction) throws JuegoException {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		c = c.clone;// Porque no queremos cambiar la posicion real
		if (direction == 'N') {
			c.goUp();
		} else if (direction == 'S') {
			c.goDown();
		} else if (direction == 'E') {
			c.goRight();
		} else if (direction == 'O') {
			c.goLeft();
		} else
			throw new JuegoException("Dirección no válida.");

		return c;

	}
	
	private void cambiaJugadorAPosicion(Coordenada coor) {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		
		tablero.remove(c, j);
		tablero.put(c, j);
		coordenadaJugadores.set(jugadorJuega, c);
		
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una direcciÃ³n vÃ¡lida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pÃ³cima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pÃ³cima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// DespuÃ©s de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}
	
	public void proximoJugador() {
		
	}
	
	public String getGanador() {
		
	}
	
	public String getNombreJugadorQueQueda() {//Tener en cuenta que el nombre en el documento tiene una errata, y podría darnos problemas en el futuro
		
	}
	
	public int getMovimientoJugador() {
		
	}
	
	public int getValorDado() {
		
	}
	
	public void decrementoDado() {
		
	}
	
	public void setDado() {
		
	}
	
	public Element obtenerElementoTablero(Coordenada coor) {
		
	}
	
	public Coordenada obtenerCoordenadaJugadorJuega() {
		
	}

}
