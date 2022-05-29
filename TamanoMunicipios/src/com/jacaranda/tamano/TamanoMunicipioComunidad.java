package com.jacaranda.tamano;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}

	public void cargarDatos(String datos) {
		Gson gson = new Gson();
		lista = gson.fromJson(datos, new TypeToken<ArrayList<Comunidad>>() {
		}.getType());

	}

	public void guardarDatos(String fichero) {
		Gson gsonBonito = new GsonBuilder().setPrettyPrinting().create();
		String ponerloBonito = gsonBonito.toJson(this.lista);
		escribirEnFicheroJson(fichero, ponerloBonito);
	}

	private static void escribirEnFicheroJson(String nombre, String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String mostrarComunidad(int anio) {
		StringBuilder resultado = new StringBuilder();
		for (Comunidad c : lista) {
			resultado.append(c.getNombre() + c.mostrar(anio));
		}
		return resultado.toString();
	}

	public String mostrarComunidadAno(int ano, String comunidad) {
		boolean encontrado = false;

		StringBuilder resultado = new StringBuilder();
		Iterator<Comunidad> siguiente = lista.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if (c.getNombre().equalsIgnoreCase(comunidad)) {
				resultado.append(c.getNombre() + c.mostrar(ano));
				encontrado = true;
			}
		}
		return resultado.toString();
	}

	public boolean addDato(String comunidad, String descripcion, int anno, int dato) {
		boolean encontrado = false;

		Iterator<Comunidad> siguiente = this.lista.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if (c.getNombre().equalsIgnoreCase(comunidad)) {
				c.buscarDescripcion(descripcion, anno, dato);
				encontrado = true;
			}
		}
		return encontrado;
	}

	public String comparar(String comunidad, int anno) {
		String resultado = "";
		int actual = 0;
		int total = 0;
		
		Iterator<Comunidad> siguiente = lista.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Comunidad c = siguiente.next();
			if (c.getNombre().equalsIgnoreCase(comunidad)) {
				encontrado = true;
				actual = c.actualDatos(anno);
				total = c.realDatos(anno);
			}
		}

		if (actual == total) {
			resultado = "Igual\n";
		} else {
			resultado = "Actual: " + actual + " Real: " + total + "\n";
		}
		return resultado;
	}

}
