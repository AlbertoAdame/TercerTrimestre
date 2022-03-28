package com.jacaranda.utilities.provincia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.jacaranda.utilities.pueblo.Pueblo;
import com.jacaranda.utilities.pueblo.PuebloException;

public class Provincia {

	String nombre;
	String codigo;
	int numeroHabitantes;
	double rentaPerCapita;
	double superficie;
	private Set<Pueblo> listado;

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0;
		this.superficie = 0;
		this.listado = new HashSet<>();
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo.length() < 5) {
			throw new ProvinciaException("La longitud del pueblo debe ser mayor que cinco.");
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
		for (Iterator<Pueblo> iterator = listado.iterator(); iterator.hasNext();) {
			Pueblo pueblo = (Pueblo) iterator.next();
			if (pueblo.getNombre().equals(nombre))
				resultado = true;
		}
		return resultado;
	}

	public boolean addPueblo(String nombrePueblo, String codigo, int numeroHabitantes, double rentaPerCapita,
			double superficie) throws ProvinciaException {
		boolean resultado = false;
		if (nombrePueblo == null)
			throw new ProvinciaException("El nombre del pueblo es nulo");
		String codigoPueblo = this.codigo.concat(codigo);
		Pueblo p;
		try {
			p = new Pueblo(nombrePueblo.toUpperCase(), codigoPueblo, numeroHabitantes, rentaPerCapita, superficie);
		} catch (PuebloException e) {
			throw new ProvinciaException(e.getMessage());
		}

		if (!existePueblo(nombrePueblo))
			throw new ProvinciaException("Este pueblo ya existe.");
		if (!listado.add(p))
			throw new ProvinciaException("Este codigo ya existe.");
		return resultado;
	}

	

	public String getCodigo() {
		return codigo;
	}

	public String listadoNombresPueblos() {
		StringBuilder resultado = new StringBuilder("Listado Nombres");

		for (Iterator<Pueblo> iterator = listado.iterator(); iterator.hasNext();) {
			Pueblo pueblo = iterator.next();
			resultado.append(pueblo.getNombre() + "\n");
		}
		return resultado.toString();
	}

	public String listadoPueblos() {
		StringBuilder resultado = new StringBuilder("Listado Nombres");

		for (Iterator<Pueblo> iterator = listado.iterator(); iterator.hasNext();) {
			Pueblo pueblo = iterator.next();
			resultado.append(pueblo.toString() + "\n");
		}
		return resultado.toString();
	}
	
	public boolean delPueblo(String nombre) throws ProvinciaException {
		if(nombre==null)
			throw new ProvinciaException("Este nombre es nulo");
		for (Iterator<Pueblo> iterator = listado.iterator(); iterator.hasNext();) {
			Pueblo pueblo = (Pueblo) iterator.next();
			
		}
		
		
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) throws ProvinciaException {
		if (numeroHabitantes < 0)
			throw new ProvinciaException("No puede ser negativo");
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws ProvinciaException {
		if (rentaPerCapita < 0)
			throw new ProvinciaException("No puede ser un valor negativo");
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws ProvinciaException {
		if (superficie < 0)
			throw new ProvinciaException("Este valor no puede ser negativo");
		this.superficie = superficie;
	}

}
