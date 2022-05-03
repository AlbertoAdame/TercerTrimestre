package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

import com.jacaranda.combinacion.Combinacion;

public class Historial {
	
	
	private HashMap<LocalDate, HashSet<Combinacion>> ganadora;
	
	public Historial() {

		this.ganadora = new HashMap<>();

	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion c) {
		boolean resultado = true;
		HashSet<Combinacion> valor = c;

		if (valor == null) {
			HashSet<Combinacion> combinacion = new HashSet<>();
			combinacion.add(c);
			if (this.ganadora.put(fecha, combinacion) == null)
				resultado = false;
		} else {
			resultado = valor.add(c);
		}
		return resultado;
	}
	
}
