package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;

public class Diccionario {

	private HashMap<String, HashSet<String>> palabras;

	public Diccionario() {

		this.palabras = new HashMap<>();

	}

	public boolean anadirPalabra(String palabra, String significado) {
		boolean resultado = true;
		HashSet<String> valor = this.palabras.get(palabra);

		if (valor == null) {
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if (this.palabras.put(palabra, significados) == null)
				resultado = false;
		} else {
			resultado = valor.add(significado);
		}
		return resultado;
	}

	public boolean borrarPalabra(String palabra) {
		boolean resultado = true;
		if (this.palabras.remove(palabra) == null)
			resultado = false;
		return resultado;
	}

	public boolean borrarSignificado(String palabra, String significado) {
		boolean resultado = true;
		HashSet<String> valor = this.palabras.get(palabra);
		resultado = valor.remove(significado);

		return resultado;

	}
	

	@Override
	public String toString() {
		return "palabras=" + palabras;
	}

}
