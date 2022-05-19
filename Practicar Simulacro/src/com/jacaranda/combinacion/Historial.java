package com.jacaranda.combinacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Historial{

	private HashMap<LocalDate, Combinacion> combinaciones  ;

	public Historial() {
		super();
		this.combinaciones = new HashMap<>();
	}

	public boolean addSorteo(LocalDate fecha, Combinacion combinacion) {
		boolean resultado = true;
		if (combinaciones.containsKey(fecha))
			resultado = false;
		else {
			combinaciones.put(fecha, combinacion);
		}
		return resultado;
	}

	public void actualizarSorteo(LocalDate fecha, Combinacion combinacion) {
		if (combinaciones.containsKey(fecha)) {
			combinaciones.replace(fecha, combinacion);
		}

	}

	public void borrarSorteo(LocalDate fecha) {
		if (combinaciones.containsKey(fecha))
			combinaciones.remove(fecha);
	}

	public int comprobarAciertos(LocalDate fecha, Combinacion combinacion) {
		int resultado = -1;
		if(combinaciones.containsKey(fecha)) {
			Combinacion c = combinaciones.get(fecha);
			 resultado =c.aciertos(combinacion);
		}
		return resultado;
	}
	
	public String imprimirHistorialAsc() {
		StringBuilder resultado = new StringBuilder("Ascendente\n");
		ArrayList<LocalDate> clave = new ArrayList<>(this.combinaciones.keySet());
		
		Collections.sort(clave);
		
		for(LocalDate l : clave) {
			resultado.append(l + ": " + this.combinaciones.get(l));
		}
		return resultado.toString();
	}
	
	public String imprimirHistorialDesc() {
		StringBuilder resultado = new StringBuilder("Descendente\n");
		ArrayList<LocalDate> clave = new ArrayList<>(this.combinaciones.keySet());
		
		OrdenarDescendente orden = new OrdenarDescendente();
		Collections.sort(clave, orden);
		
		for(LocalDate l : clave) {
			resultado.append(l + ": " + this.combinaciones.get(l));
		}
		return resultado.toString();
	}

	public String sorteosMes(int mes) {
		StringBuilder resultado = new StringBuilder();
		for(LocalDate l : combinaciones.keySet()) {
			if(l.getDayOfMonth()==mes)
				resultado.append(l + " : " + combinaciones.get(l).imprimirCadena()+"\n");
		}
		return resultado.toString();
		
	}
	
	public String practicarImprimirDesc(int mes) {
		StringBuilder resultado = new StringBuilder("Descendente\n");
		ArrayList<LocalDate> claves = new ArrayList<>(combinaciones.keySet());
		
		OrdenarDescendente orden = new OrdenarDescendente();
		Collections.sort(claves, orden);
		
		for(LocalDate l : claves) {
			if(l.getDayOfMonth()==mes)
				resultado.append(l + " : " + this.combinaciones.get(l));
		}
		
		return resultado.toString();
		
	}

	@Override
	public String toString() {
		return "Historial [combinaciones=" + combinaciones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(combinaciones);
	}  

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historial other = (Historial) obj;
		return Objects.equals(combinaciones, other.combinaciones);
	}
	
	
	
}
