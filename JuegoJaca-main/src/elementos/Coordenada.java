package elementos;

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

	public boolean goRight() {//Incompleto
		
		boolean resultado=false;
		return resultado;
	}
	
	public boolean goLeft() {//Incompleto
		
		boolean resultado=false;
		return resultado;
	}
	
	public boolean goUp() {//Incompleto
		
		boolean resultado=false;
		return resultado;
	}
	
	public boolean goDown() {//Incompleto
		
		boolean resultado=false;
		return resultado;
	}
	
	
	
	
	
	
	
	
}
