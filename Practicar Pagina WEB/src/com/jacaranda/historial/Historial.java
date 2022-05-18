package com.jacaranda.historial;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jacaranda.web.Web;

public class Historial {

	private List<Web> paginas;

	public Historial() {
		super();
		this.paginas = new ArrayList<>();//Usaremos un arrayList para acceder al índice de la lista, y pq da igual que se repitan.
	}

	public void anadirPagina(String url) {
		Web w = new Web(url);
		paginas.add(w);
	}
	
	public String imprimirHistorialCompleto() {
		StringBuilder resultado = new StringBuilder();
		for(Web w : paginas) {
			resultado.append(w.toString());
		}
		return resultado.toString();
	}
	
	
	public String imprimirHistorialDia(LocalDate dia) {
		boolean salir = false;
		StringBuilder resultado = new StringBuilder();
		Iterator<Web> siguiente = paginas.iterator();
		while(siguiente.hasNext() && !salir) {
			Web w = siguiente.next();
			LocalDate fecha = w.getFecha().toLocalDate();
			if(fecha.isAfter(dia)) {
				salir=true;
			}
			else if (fecha.equals(dia))
				resultado.append(w);
				
			}
			return resultado.toString();
		}
		
		
		
//		for(Web w : paginas) {
//			LocalDate fecha = w.getFecha().toLocalDate();
//			if(fecha.equals(dia))
//				resultado.append(w.toString());
//		}

	
	public void borrarHistorial() {
		try {
			this.paginas.removeAll(paginas);
		} catch (Exception e) {
			System.out.println("No se ha podido borrar el historial.");
		}
	}
	
	
	@Override
	public String toString() {
		return "" + paginas;
	}
	
	
	
	
	
	
}
