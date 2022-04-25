package com.jacaranda.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Historial {
	
	private List<Web> paginasWeb;

	public Historial() {
		super();
		this.paginasWeb = new ArrayList<>();
	}
	
	public void anadirPagina(String url) throws HistorialException {
		if(url==null)
			throw new HistorialException("La url es nula.");
		
		else if(url.isEmpty())
			throw new HistorialException("La url esta vacia.");
		else {
			Web w= new Web(url);
			paginasWeb.add(w);
		}
	}

	public void borrarHistorial() {
		this.paginasWeb.removeAll(paginasWeb);
	}
	
	@Override
	public String toString() {
		return ""+paginasWeb;
	}
	

	
	
	
}
