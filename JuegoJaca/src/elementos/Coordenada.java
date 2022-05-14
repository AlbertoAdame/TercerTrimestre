package elementos;

import java.util.Objects;

import logicaJuego.Constantes;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada() {
		super();
		this.x = (int) (Math.random()*Constantes.TAMANNO);
		this.y = (int) (Math.random()*Constantes.TAMANNO);
	}
	
	public Coordenada(int x, int y) {
		super();
		if(y<0 || y> Constantes.TAMANNO || x<0 || x> Constantes.TAMANNO) {
			x=0;
			y=0;
		}

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean goRight() {
		boolean resultado=false;
		if(this.x!=Constantes.TAMANNO) {
			this.x++;
			resultado=true;
		}

		return resultado;
	}
	
	public boolean goLeft() {
		boolean resultado=false;
		if(this.x!=0) {
			this.x--;
			resultado=true;
		}
		return resultado;
	}
	
	public boolean goUp() {
		
		boolean resultado=false;
		if(this.y!=0) {
			this.y--;
			resultado=true;
		}
		return resultado;
	}
	
	public boolean goDown() {
		boolean resultado=false;
		if(this.y!=Constantes.TAMANNO) {
			this.y++;
			resultado=true;
		}
		return resultado;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Coordenada resultado = new Coordenada();
		resultado.x=this.x;
		resultado.y=this.y;
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Coordenadas [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
