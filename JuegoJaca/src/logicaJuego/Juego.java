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
		crearTablero();
		int contador = 0;
		while(Constantes.NUM_JUGADORES!= contador) {
			if(crearJugador(jugadores[contador])) {//si crearJugador devuelve true es que el jugador se ha aÒadido correctamente, si no, deber· volverlo a repetir
				contador++;
			}
		}

//		this.dado = dado;
	}

	private void crearTablero() {
		crearRocas();
		crearDinero();
		crearGemas();
		crearPociones();

	}
	
	private boolean crearJugador(PlayerType tipo) {
		boolean resultado = false;
		Jugador j = new Jugador(tipo);
		Coordenada c = new Coordenada();
		if(!coordenadaJugadores.contains(c)) {
			resultado = true;
			tablero.put(c, j);
			coordenadaJugadores.add(c);
		}
		
		return resultado;
		
	}

	private void crearRocas() {
		int contador = 0;
		while (contador != Constantes.NUM_ROCAS) {
			Coordenada c = new Coordenada();
			if (!tablero.containsKey(c)) {
				Element roca = new Element(ElementType.ROCA);
				tablero.put(c, roca);
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
	 * Escribe el tablero en formato no gr√°fico. Devuelve el string con la
	 * informaci√≥n
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

	public String imprimeNombreJugadores() {
		StringBuilder resultado = new StringBuilder();
		int contador = 1;
		for (Coordenada c : coordenadaJugadores) {
			Jugador j = (Jugador) tablero.get(c);
			resultado.append("El jugador " + contador + " es un " + j.getNombre() + " ");
			contador++;
		}

		return resultado.toString();
	}
	
	public String imprimeValoreJugadores() {
		StringBuilder resultado = new StringBuilder();
		for(Coordenada c : coordenadaJugadores) {
			if(tablero.containsKey(c)) {
				Jugador j = (Jugador) tablero.get(c);
				resultado.append(j.resumen()+ "\n");
			}
		}
		return resultado.toString();
	}

	private void eliminarJugador(Coordenada coor) {							
		if (tablero.containsKey(coor) && coordenadaJugadores.contains(coor)) {
			Jugador j = (Jugador) tablero.get(coor);
			tablero.remove(coor, j);
			coordenadaJugadores.remove(coor);
		}

	}

	private Coordenada getNextPosition(char direction) throws JuegoException {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);// Porque no queremos cambiar la posicion real
		c = c.CoordenadaClonado();
		if (direction == 'N') {
			c.goUp();
		} else if (direction == 'S') {
			c.goDown();
		} else if (direction == 'E') {
			c.goRight();
		} else if (direction == 'O') {
			c.goLeft();
		} else
			throw new JuegoException("DirecciÛn no v·lida.");

		return c;

	}

	private void cambiaJugadorAPosicion(Coordenada coor) {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);//obtener la coordenada actual de jugador
		Jugador j = (Jugador) tablero.get(c);//y el jugador

		tablero.remove(c);//Borrar del tablero la coordenada actual
		tablero.put(coor, j);//insertar el jugador en la nueva coordenada
		coordenadaJugadores.set(jugadorJuega, coor);//por ˙ltimo hay que actualizar las coordenadas

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
		// Si no es una direcci√≥n v√°lida, mando un exception
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
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una p√≥cima al enemigo";
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
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una p√≥cima al jugador";
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
				// Despu√©s de la lucha los jugadores no se mueven
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
		if (coordenadaJugadores.size() - 1 == jugadorJuega) { // me dio problemas, ya que no tenemos que comparar el
																// size sin m·s, tendremos que compararlo el tamaÒo
																// menos 1
			// ademas estaba intentando usar la constante del numero de jugadores, pero hay
			// veces que no est·n todos los jugadores en la partida
			jugadorJuega = 0;
		} else
			jugadorJuega++;// si no entra en el if simplemente incrementar· la siguiente jugador
	}

	public String getGanador() {
		String resultado = "";
		Jugador j = null;
		if (coordenadaJugadores.size() == 1) {
			j = (Jugador) tablero.get(coordenadaJugadores.get(0));
			resultado = "\n" + j.getNombre();
		}
		
		else {
			for(Coordenada c : coordenadaJugadores) {
				j = (Jugador) tablero.get(c); 
				if(j.getDinero()==Constantes.NUM_DINERO)
					resultado= "\n" +  j.getNombre();
			}
		}

		return resultado;

	}

	public String getNombreJuegadorQueJuega() {// Tener en cuenta que el nombre en el documento tiene una errata, y podrÌa darnos problemas en el futuro
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		return j.getNombre();

	}

	public int getMovimientoJugador() {
		Coordenada c = coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) tablero.get(c);
		return j.getVelocidadParaLuchar();
	}

	public int getValorDado() {
		return dado;
	}

	public void decrementaDado() {
		dado--;
	}

	public void setDado() {
		this.dado=getMovimientoJugador();

	}

	public Element obtenerElementoTablero(Coordenada coor) {
		return tablero.get(coor);
	}

	public Coordenada obtenerCoordenadaJugadorJuega() {
		return coordenadaJugadores.get(jugadorJuega);
	}


	
	
}
