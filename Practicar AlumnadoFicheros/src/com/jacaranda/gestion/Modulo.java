package com.jacaranda.gestion;

import java.util.Objects;

public class Modulo {

	private String nombre;
	private int codigo;
	private static int codigoSiguiente = 1;
	private int numHorasSemanales;
	private int creditos;
	
	public Modulo(String nombre, int numHorasSemanales, int creditos) {
		super();
		this.nombre = nombre;
		this.codigo = codigoSiguiente++;
		this.numHorasSemanales = numHorasSemanales;
		this.creditos = creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getNumHorasSemanales() {
		return numHorasSemanales;
	}

	public int getCreditos() {
		return creditos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", codigo=" + codigo + ", numHorasSemanales=" + numHorasSemanales
				+ ", creditos=" + creditos + "]";
	}

	public String escribeFichero() {
		return nombre + "," + codigo + "," + numHorasSemanales + "," + creditos;
	}
	
	
	
	
}
