package com.jacaranda.utilities.pueblo;

import java.util.Objects;

import com.jacaranda.utilities.provincia.ProvinciaException;

public class Pueblo implements Comparable<Pueblo> {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
	}

	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();	
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	@Override
	public int compareTo(Pueblo other) {
		return this.nombre.compareTo(other.nombre);
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

	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (numeroHabitantes < 0)
			throw new PuebloException("No puede ser negativo");
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita < 0)
			throw new PuebloException("No puede ser un valor negativo");
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie < 0)
			throw new PuebloException("Este valor no puede ser negativo");
		this.superficie = superficie;
	}

	public String getNombre() {
		return nombre;
	}

	private void setCodigo(String codigo) throws PuebloException {
		if (codigo==null)
			throw new PuebloException("El código no puede ser nulo");
		if (codigo.length() < 5) {
			throw new PuebloException("La longitud del pueblo debe ser mayor que cinco.");
		}
		for (int i = 0; i < codigo.length(); i++) {
			char caracter = codigo.charAt(i);
			if (!Character.isDigit(caracter))
				throw new PuebloException("Tienen que ser dígitos.");
		}
		this.codigo = codigo;
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
