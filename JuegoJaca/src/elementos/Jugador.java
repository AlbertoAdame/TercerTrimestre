package elementos;

import logicaJuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;

	public Jugador(PlayerType player) {
		super(ElementType.valueOf(player.name()));
		this.dinero = 0;
		this.pociones = 0;
		this.gemas = 0;
		this.player = player;
	}

	public String getNombre() {
		return player.name();
	}

	public int getFuerzaParaLuchar() {
		return (int) (Math.random() * (player.getFuerza()-1)+1);
	}

	private int getFuerza() {
		return player.getFuerza();
	}

	private int getMagia() {
		return player.getMagia();
	}

	public int getMagiaParaLuchar() {
		return (int) (Math.random() * (player.getMagia()-1)+1);
	}

	private int getVelocidad() {
		return player.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		return (int) (Math.random() * (player.getVelocidad()-1)+1);
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) throws JugadorException {
		if (dinero < 0 || dinero > Constantes.DINERO)
			throw new JugadorException("Cantidad de dinero no v�lida");
		this.dinero = dinero;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		if (pociones < 0 || pociones > Constantes.NUM_POCIONES)
			throw new JugadorException("Cantidad de pociones no v�lida");
		this.pociones = pociones;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		if (gemas < 0 || gemas > Constantes.NUM_GEMAS)
			throw new JugadorException("Cantidad de gemas no v�lida");
		this.gemas = gemas;
	}

	public String resumen() {
		return "-" + getNombre() + "\nDinero: " + getDinero() + "\nPociones: " + getPociones() + "\nGemas: "
				+ getGemas();
	}

	public PlayerType getPlayer() {
		return player;
	}

	public int lucha(Jugador jugador) throws JugadorException {
		int fuerzaThisJugador = this.getFuerzaParaLuchar();
		int fuerzaOtroJugador = jugador.getFuerzaParaLuchar();
		int resultado;

		if (fuerzaThisJugador > fuerzaOtroJugador)
			if (jugador.getPociones() > 0) {
				jugador.setPociones(jugador.getPociones() - 1);
				resultado = Constantes.GANA_USA_POCIMA;
			} else if (jugador.getDinero() > 0) {
				this.setDinero(jugador.getDinero() + this.getDinero());
				jugador.setDinero(0);
				resultado = Constantes.GANA_DINERO;
			} else
				resultado = Constantes.GANA_MUERE;
		else if (fuerzaThisJugador < fuerzaOtroJugador)
			if (this.getPociones() > 0) {
				this.setPociones(this.getPociones() - 1);
				resultado = Constantes.PIERDE_USA_POCIMA;
			} else if (this.getDinero() > 0) {
				jugador.setDinero(this.getDinero() + jugador.getDinero());
				this.setDinero(0);
				resultado = Constantes.PIERDE_DINERO;
			} else
				resultado = Constantes.PIERDE_MUERE;
		else {
			resultado = Constantes.EMPATE;
		}

		return resultado;
	}

	public int encuentraRoca() throws JugadorException {
		int resultado = 0;
		if (this.getGemas() > 0) {
			resultado = Constantes.ROMPE_ROCA_CON_GEMA;
			this.setGemas(this.getGemas() - 1);
		} else {
			if (this.getMagiaParaLuchar() > 4)
				resultado = Constantes.GANA_A_LA_ROCA;
			if (this.getMagiaParaLuchar() <= 4)
				resultado = Constantes.PIERDE_A_LA_ROCA;
		}
		return resultado;
	}

	public void encuentraDinero() throws JugadorException {
		this.setDinero(this.getDinero() + 1);

	}

	public void encuentraPocion() throws JugadorException {
		this.setPociones(this.getPociones() + 1);

	}

	public void encuentraGema() throws JugadorException {
		this.setGemas(this.getGemas() + 1);

	}

}
