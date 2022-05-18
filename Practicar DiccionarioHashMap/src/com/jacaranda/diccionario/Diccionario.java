package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Diccionario {

	private HashMap<String, HashSet<String>> diccionario;

	public Diccionario() {
		super();
		this.diccionario = new HashMap<>();
	}

	public boolean anadirPalabra(String palabra, String significado) {
		boolean resultado = true;
		HashSet<String> significados = diccionario.get(palabra);
		if (significados != null)
			significados.add(significado);

		else {
			significados = new HashSet<>();
			significados.add(significado);
			if (diccionario.put(palabra, significados) == null)
				resultado = false;
		}
		return resultado;
	}

	public String buscarPalabra(String palabra) {
		String resultado;
		HashSet<String> significados = diccionario.get(palabra);
		if (significados == null)
			resultado = "No tiene significados";

		else {
			resultado = significados.toString();

		}
		return resultado;
	}

	public boolean borrarPalabra(String palabra) {
		boolean resultado = false;
		if (diccionario.containsKey(palabra)) {
			diccionario.remove(palabra);
			resultado = true;
		}
		return resultado;
	}
	
	
	public String empiezanPor(String letra) {
		StringBuilder resultado = new StringBuilder("Empiezan por " + letra + "\n");
		for(String s : diccionario.keySet()) {
			if(s.startsWith(letra)) {
				resultado.append(s+"\n");
			}
		}return resultado.toString();
	}

	@Override
	public String toString() {
		return "Diccionario=" + diccionario ;
	}

	
	
}
