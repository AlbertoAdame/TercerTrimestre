package com.jacaranda.palabra;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Palabra {

	private String palabra;
	private String significado;
	private Set<String> significados;

	public Palabra(String palabra) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados = new HashSet<>();
	}

	public Palabra(String palabra, String significado) throws PalabraException {
		super();
		setPalabra(palabra);
		this.significados = new HashSet<>();
		this.significados.add(significado);
	}

	public void addSignificado(String significado) throws PalabraException {

		if (significado == null)
			throw new PalabraException("El significado no puede ser nulo.");

		if (this.significado.contains(significado)) {
			throw new PalabraException("Este significado ya existe.");

		}

		significados.add(significado);

	}
	
	public void delSignficado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("El significado es nulo.");
		} else {
			Iterator<String> siguiente = this.significados.iterator();
			boolean encontrado = false;
			while (siguiente.hasNext() && !encontrado) {
				String s = siguiente.next();
				if (!(s.equalsIgnoreCase(significado))) {
					throw new PalabraException("El significado no existe.");
				} else {
					this.significados.remove(significado);
					encontrado=true;
				}
			}
		}
	}

	@Override
	public String toString() {
		return palabra + " : " + significado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}

	public String getPalabra() {
		return palabra;
	}
	
	

	private void setPalabra(String palabra) throws PalabraException {
		if(palabra==null)
			throw new PalabraException("La palabra no puede ser nulo.");
		this.palabra = palabra;
	}

	public Character getInicialPalabra() {
		return this.palabra.charAt(0);
	}

}
