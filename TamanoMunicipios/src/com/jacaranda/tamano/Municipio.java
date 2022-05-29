package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

public class Municipio {

	private String descrip;
	ArrayList<Datos> datos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		datos = new ArrayList<>();
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int numeroDatos(int anno) {
		int total=0;
		
		for (Datos d:this.datos) {
			if(d.getAno()==anno) {
				total=d.getDato();
			}
		}
		return total;
	}


	public String mostrar(int anno) {
		StringBuilder resultado = new StringBuilder();
		for (Datos d : this.datos) {
			if (d.getAno() == anno) {
				resultado.append(d + "\n");
			}
		}
		return resultado.toString();
	}

	public void addDato(int anno, int dato) {
		boolean encontrado = false;
		
		Iterator<Datos> siguiente = this.datos.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Datos d = siguiente.next();
			if (d.getAno() == anno) {
				d.setDato(dato);
				encontrado = true;
			}
		}
		if (!encontrado) {
			Datos nuevo = new Datos(anno, dato);
			this.datos.add(nuevo);
		}
	}
}
