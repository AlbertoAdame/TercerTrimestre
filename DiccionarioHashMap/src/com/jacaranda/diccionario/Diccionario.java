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

	public String listarUnaPalabra(String palabra) throws DiccionarioException {
		String resultado;
		if (palabra == null || palabra.isBlank())
			throw new DiccionarioException("Esta palabra no puede ser nula o estar blanco.");

		if (palabras.containsKey(palabra))
			resultado = palabra + ": " + palabras.get(palabra).toString();
		else
			resultado = "Esta palabra no existe.";
		return resultado;
	}

	public String listarPalabrasEmpiezanPor(String letra) throws DiccionarioException {
		StringBuilder resultado = new StringBuilder();
		if (letra == null || letra.isBlank())
			throw new DiccionarioException("La letra no puede estar en blanco.");

		resultado.append("Empiezan por la letra " + letra + ":");
		for (String siguiente : this.palabras.keySet()) {

			if (siguiente.startsWith(letra))
				resultado.append(siguiente + ", ");
		}
		return resultado.toString();

	}

	@Override
	public String toString() {
		return "palabras=" + palabras;
	}

}
