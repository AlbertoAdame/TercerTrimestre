package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;

	public Pueblo(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.numeroHabitantes = numeroHabitantes;
		this.rentaPerCapita = rentaPerCapita;
		this.superficie = superficie;
	}

	
	@Override
	public int compareTo(Pueblo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) {
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	

}
