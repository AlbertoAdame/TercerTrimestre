package elementos;

public class Jugador extends Element {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType player;

	public Jugador(ElementType type, int dinero, int pociones, int gemas, PlayerType player) {
		super(type);
		this.dinero = dinero;
		this.pociones = pociones;
		this.gemas = gemas;
		this.player = player;
	}

	public String getNombre() {
		return player.name();
	}

	public int getFuerzaParaLuchar() {
		return (int) (Math.random() * (player.getFuerza()));
	}

	private int getFuerza() {
		return player.getFuerza();
	}

	private int getMagia() {
		return player.getMagia();
	}

	public int getMagiaParaLuchar() {
		return (int) (Math.random() * (player.getMagia()));
	}

	private int getVelocidad() {
		return player.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		return (int) (Math.random() * (player.getVelocidad()));
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}
	
	public String resumen() {
		return "" + getNombre()+ getDinero() + getPociones() + getGemas();
	}

	public PlayerType getPlayer() {
		return player;
	}
	
	public int lucha (Jugador jugador) {
		return resultado;
	}
	
	

}
