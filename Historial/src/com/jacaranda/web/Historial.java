package com.jacaranda.web;

import java.time.LocalDate;
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
		if (url == null)
			throw new HistorialException("La url es nula.");

		else if (url.isEmpty())
			throw new HistorialException("La url esta vacia.");
		else {
			Web w = new Web(url);
			paginasWeb.add(w);
		}
	}

	public void borrarHistorial() {
		this.paginasWeb.removeAll(paginasWeb);
	}

	@Override
	public String toString() {
		return "" + paginasWeb;
	}

	public String consultarHistorial(LocalDate dia) {
		boolean salir = false;
		Web w;
		StringBuilder resultado = new StringBuilder("Historial");
		Iterator<Web> siguiente = this.paginasWeb.iterator();
		while (siguiente.hasNext() && !salir) {
			w = siguiente.next();
			LocalDate localDate = w.getHora().toLocalDate();

			if (localDate.isAfter(dia))
				salir = true;
			else if (localDate.getYear() == dia.getYear() && localDate.getMonth() == dia.getMonth()
					&& localDate.getDayOfMonth() == dia.getDayOfMonth())
				resultado.append(w);

		}

		return resultado.toString();

	}

}
