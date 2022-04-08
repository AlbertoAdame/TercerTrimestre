package com.jacaranda.palabrasEmpiezan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.palabra.Palabra;
import com.jacaranda.palabra.PalabraException;

public class PalabrasEmpiezan {

	private char letra;
	private List<Palabra> palabras;

	public PalabrasEmpiezan(char letra) {
		super();
		this.letra = letra;
		this.palabras = new LinkedList<>();
	}

	public char getLetra() {
		return letra;
	}

	public void addPalabra(String palabra, String significado) throws PalabrasEmpiezanException {

		if (palabra == null)
			throw new PalabrasEmpiezanException("La palabra no puede ser nula.");

		if (significado == null)
			throw new PalabrasEmpiezanException("El significado no puede ser nulo.");

		Palabra p;
		try {
			
			p = new Palabra(palabra, significado);

		} catch (PalabraException e) {
			throw new PalabrasEmpiezanException(e.getMessage());

		}
		if (this.palabras.contains(p)) {
			throw new PalabrasEmpiezanException("Esta palabra ya existe.");
		} else if (!palabras.add(p))
			throw new PalabrasEmpiezanException("No se puede añadir la palabra");
	}

	public void delPalabra(String palabra) throws PalabrasEmpiezanException {
		boolean encontrado = false;
		if (palabra == null)
			throw new PalabrasEmpiezanException("La palabra no puede ser nula.");

		Iterator<Palabra> siguiente = this.palabras.iterator();

		while (siguiente.hasNext() && !encontrado) {
			Palabra p = siguiente.next();
			
			if (p.getPalabra().equalsIgnoreCase(palabra)) {
				this.palabras.remove(p);
				encontrado = true;
			}
		}
	}

	@Override
	public String toString() {
		return "Letra " + letra + ", Palabras: "+ palabras;
	}

	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabrasEmpiezan other = (PalabrasEmpiezan) obj;
		return letra == other.letra;
	}

	
}
