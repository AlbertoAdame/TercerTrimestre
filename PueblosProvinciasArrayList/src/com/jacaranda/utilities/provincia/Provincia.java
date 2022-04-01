package com.jacaranda.utilities.provincia;

import java.util.ArrayList;

import java.util.Iterator;

import com.jacaranda.utilities.pueblo.Pueblo;
import com.jacaranda.utilities.pueblo.PuebloException;

public class Provincia {

	String nombre;
	String codigo;
	int numeroHabitantes;
	double rentaPerCapita;
	double superficie;
	private ArrayList<Pueblo> listado;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		if (nombre == null)
			throw new ProvinciaException("El nombre de la provincia no puede ser null");
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
		this.listado = new ArrayList<>();
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo == null)
			throw new ProvinciaException("El código no puede ser nulo");

		if (codigo.length() < 5) {
			throw new ProvinciaException("La longitud de codigo pueblo debe ser mayor que cinco.");
		}

		for (int i = 0; i < codigo.length(); i++) {
			char caracter = codigo.charAt(i);
			if (!Character.isDigit(caracter))
				throw new ProvinciaException("Tienen que ser dígitos.");
		}
		this.codigo = codigo;
	}

	private boolean existePueblo(String nombre) {
		boolean resultado = false;
		Iterator<Pueblo> siguiente = listado.iterator();
		while (siguiente.hasNext() && !resultado) {
			Pueblo pueblo = (Pueblo) siguiente.next();
			if (pueblo.getNombre().equalsIgnoreCase(nombre))
				resultado = true;
		}
		return resultado;
	}

	public boolean addPueblo(String nombrePueblo, String codigo, int numeroHabitantes, double rentaPerCapita,
			double superficie) throws ProvinciaException {
		boolean resultado = false;
		if (nombrePueblo == null)
			throw new ProvinciaException("El nombre del pueblo es nulo");

		if (codigo == null)
			throw new ProvinciaException("El codigo del pueblo es nulo");
		String codigoPueblo = this.codigo.concat(codigo);
		Pueblo p;
		try {
			p = new Pueblo(nombrePueblo.toUpperCase(), codigoPueblo, numeroHabitantes, rentaPerCapita, superficie);
		} catch (PuebloException e) {
			throw new ProvinciaException(e.getMessage());
		}

		if (existePueblo(nombrePueblo))
			throw new ProvinciaException("Este pueblo ya existe.");
		if (!listado.add(p))
			throw new ProvinciaException("No se puede añadir el pueblo");
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public String listadoNombresPueblos() {
		StringBuilder resultado = new StringBuilder("Listado Nombres");
		Iterator<Pueblo> siguiente = listado.iterator();
		while (siguiente.hasNext()) {
			Pueblo pueblo = siguiente.next();
			resultado.append(pueblo.getNombre() + "\n");
		}
		return resultado.toString();
	}

	public String listadoPueblos() {
		StringBuilder resultado = new StringBuilder("Listado Nombres");

		Iterator<Pueblo> siguiente = listado.iterator();
		while (siguiente.hasNext()) {
			Pueblo pueblo = siguiente.next();
			resultado.append(pueblo.toString() + "\n");
		}
		return resultado.toString();
	}

//	public boolean delPueblo(String nombre) throws ProvinciaException {
//		if (nombre == null)
//			throw new ProvinciaException("Este nombre es nulo");
//		Iterator<Pueblo> siguiente = this.listado.iterator();
//		boolean encontrado = false;
//		while (siguiente.hasNext() && !encontrado) {
//			Pueblo p = siguiente.next();
//			if (p.getNombre().equalsIgnoreCase(nombre)) {
//				this.listado.remove(p);
//				encontrado = true;
//			}
//
//		}
//		return encontrado;
//
//	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String nombre, int numeroHabitantes) throws ProvinciaException {
		if (numeroHabitantes < 0)
			throw new ProvinciaException("No puede ser negativo el numero de habitantes");
		Iterator<Pueblo> siguiente = this.listado.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Pueblo p = siguiente.next();
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.numeroHabitantes -= p.getNumeroHabitantes();
				try {
					p.setNumeroHabitantes(numeroHabitantes);
					encontrado = true;
				} catch (PuebloException e) {
					throw new ProvinciaException(e.getMessage());

				}
				this.numeroHabitantes += numeroHabitantes;
			}

		}

		return encontrado;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws ProvinciaException {
		if (rentaPerCapita < 0)
			throw new ProvinciaException("No puede ser una renta per capita negativa");
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws ProvinciaException {
		if (superficie < 0)
			throw new ProvinciaException("Este valor no puede ser una superficie negativa");
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}

	public String getInFormacionPueblo(String nombre) throws ProvinciaException {
		String resultado = "";
		if (nombre == null)
			throw new ProvinciaException("Este nombre es nulo");
		Iterator<Pueblo> siguiente = this.listado.iterator();
		while (siguiente.hasNext()) {
			Pueblo p = siguiente.next();
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				resultado = p.toString();

			}

		}
		return resultado;
	}

}
