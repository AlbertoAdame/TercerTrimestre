package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.jacaranda.combinacion.Combinacion;

public class Historial {

	private HashMap<LocalDate, Combinacion> ganadora;

	public Historial() {

		this.ganadora = new HashMap<>();

	}

	public boolean addSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		boolean resultado = false;
		if (fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");

		if (!this.ganadora.containsKey(fecha)) {
			this.ganadora.put(fecha, c);
			resultado = true;
		}

		return resultado;
	}

	public boolean actualizarSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		boolean resultado = false;
		if (fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");

		if (this.ganadora.containsKey(fecha)) {
			this.ganadora.put(fecha, c);
			resultado = true;
		}

		return resultado;
	}

	public boolean borrarSorteo(LocalDate fecha) throws HistorialException {
		boolean resultado = false;
		if (fecha == null)
			throw new HistorialException("Fecha nula");

		if (this.ganadora.containsKey(fecha)) {
			this.ganadora.remove(fecha);
			resultado=true;
		}
			
		return resultado;
	}

	public int numeroAciertos(LocalDate fecha, Combinacion c) throws HistorialException {
		int resultado = -1;
		if (fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");

		if (this.ganadora.get(fecha) != null)
			resultado = this.ganadora.get(fecha).comprobarAciertos(c);
		return resultado;

	}

	public String toStringAscendente() {
		StringBuilder resultado = new StringBuilder("Combinaciones Asc\n");
		ArrayList<LocalDate> clave= new ArrayList<>(this.ganadora.keySet());
		
		Collections.sort(clave);
		
		for(LocalDate fecha: clave) {
			resultado.append(fecha+ ": "+ this.ganadora.get(fecha).toString()+"\n");
		}

		return resultado.toString();
	}
	
	public String toStringDescendente() {
		StringBuilder resultado = new StringBuilder("Combinaciones Desc\n");
		ArrayList<LocalDate> clave= new ArrayList<>(this.ganadora.keySet());
		
		ComprobarDescendente orden=new ComprobarDescendente();
		Collections.sort(clave, orden);
		
		for(LocalDate fecha: clave) {
			resultado.append(fecha+ ": "+ this.ganadora.get(fecha).toString()+"\n");
		}

		return resultado.toString();
	}

	public String getResultado(int mes) {
		StringBuilder resultado = new StringBuilder();
		ArrayList <LocalDate> clave = new ArrayList<>(this.ganadora.keySet());
		
		Iterator<LocalDate> siguiente= clave.iterator();
		boolean encontradoMayor=false;
		while(siguiente.hasNext() && !encontradoMayor){
			LocalDate fecha= siguiente.next();
			
			if(fecha.getMonthValue()==mes)
				resultado.append(fecha+": "+ this.ganadora.get(fecha).toString() + "\n");
			else if(fecha.getMonthValue()>mes)
				encontradoMayor=true;
			
		}
		return resultado.toString();
	}
	
}
