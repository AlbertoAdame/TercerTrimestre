package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

import com.jacaranda.combinacion.Combinacion;

public class Historial {
	
	
	private HashMap<LocalDate, Combinacion> ganadora;
	
	public Historial() {

		this.ganadora = new HashMap<>();

	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		boolean resultado = true;
		if(fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");
		
		this.ganadora.put(fecha, c);

		if(this.ganadora.containsKey(fecha))
			resultado=false;
		
		return resultado;
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion c) throws HistorialException {
		boolean resultado = false;
		if(fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");
		

		if(this.ganadora.containsKey(fecha))
			this.ganadora.put(fecha, c);
			resultado = true;
		
		return resultado;
	}
	
	public void borrarSorteo(LocalDate fecha) throws HistorialException {

		if(fecha == null)
			throw new HistorialException("Fecha nula");
		

		if(this.ganadora.containsKey(fecha))
			this.ganadora.remove(fecha);
	
	}
	
	public int numeroAciertos(LocalDate fecha, Combinacion c) throws HistorialException {
		int resultado=-1;
		if(fecha == null || c == null)
			throw new HistorialException("Fecha o combinacion nula");
		
		if(this.ganadora.get(fecha)!=null)	
			resultado= this.ganadora.get(fecha).comprobarAciertos(c);
		return resultado;

	}
	
	public String toString() {
		StringBuilder resultado = new StringBuilder("Combinaciones\n");

		Iterator<LocalDate> siguiente = this.ganadora.keySet().iterator();
		while (siguiente.hasNext()) {
			LocalDate i = siguiente.next();
			resultado.append(i + ganadora.get(i).toStringCompleto() +"\n");
		}


		return resultado.toString();
	}
	
	
	
	
	
	
	
}
