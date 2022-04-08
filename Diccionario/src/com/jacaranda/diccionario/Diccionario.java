package com.jacaranda.diccionario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jacaranda.palabrasEmpiezan.PalabrasEmpiezan;
import com.jacaranda.palabrasEmpiezan.PalabrasEmpiezanException;

public class Diccionario {

	private List<PalabrasEmpiezan> diccionario;

	public Diccionario() {
		super();
		this.diccionario = new ArrayList<>();
		addLetras();
	}

	private void addLetras() {
		int ascii = 65;
		while (ascii != 91) {
			diccionario.add(new PalabrasEmpiezan((char) ascii));
			ascii++;
		}
	}

	public String listarDiccionario() {
		StringBuilder resultado = new StringBuilder("Diccionario\n");

		Iterator<PalabrasEmpiezan> siguiente = diccionario.iterator();
		while (siguiente.hasNext()) {
			PalabrasEmpiezan palabra = siguiente.next();
			resultado.append(palabra + "\n");
		}
		return resultado.toString();

	}

//	public String buscarSignificado(String palabra) {
//		
//	}

	public void addPalabra(String palabra, String significado) throws DiccionarioException {
		if (palabra == null)
			throw new DiccionarioException("La palabra no puede ser nula.");

		if (significado == null)
			throw new DiccionarioException("El significado no puede ser nulo.");

		PalabrasEmpiezan aux = new PalabrasEmpiezan(palabra.charAt(0));
		try {
			this.diccionario.get(this.diccionario.indexOf(aux)).addPalabra(palabra, significado);
		} catch (PalabrasEmpiezanException e) {
			throw new DiccionarioException(e.getMessage());
		}

	}

//	public void addSignificado(String palabra, String significado) throws PalabrasEmpiezanException {
//
//	}

	
}
