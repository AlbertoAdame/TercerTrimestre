package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;

	public Comunidad(String descrip) {

		this.nombre = descrip;
		this.listMunicipio = new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public String mostrar(int anno) {
		StringBuilder resultado = new StringBuilder();
		for (Municipio c : listMunicipio) {
			resultado.append(c.getDescrip() + "\n" + c.mostrar(anno));
		}
		return resultado.toString();
	}

	public boolean buscarDescripcion(String descripcion, int anno, int dato) {
		boolean encontrado = false;
		
		Iterator<Municipio> siguiente = listMunicipio.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Municipio m = siguiente.next();
			if (m.getDescrip().equalsIgnoreCase(descripcion)) {
				m.addDato(anno, dato);
				encontrado = true;
			}
		}

		return encontrado;
	}

	public int realDatos(int anno) {
		int total = 0;
		
		for (Municipio m : listMunicipio) {
			if (m.getDescrip().equalsIgnoreCase("TOTAL")) {
				total = m.numeroDatos(anno);
			}
		}
		return total;
	}

	public int actualDatos(int anno) {
		int total = 0;
		
		for (Municipio m : listMunicipio) {
			if (!m.getDescrip().equalsIgnoreCase("TOTAL")) {
				total += m.numeroDatos(anno);
			}
		}
		return total;
	}


}
