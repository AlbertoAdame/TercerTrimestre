package com.jacaranda.casetas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Calle {

	private String nombre;
	private String idCalle;
	private List<Caseta> casetas;

	public Calle(String nombre, String idCalle) {
		super();
		this.nombre = nombre;
		this.idCalle = idCalle;
		this.casetas = new ArrayList<>();
	}

	public String getCalle() {
		return nombre;
	}


	public String getIdCalle() {
		return idCalle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calle other = (Calle) obj;
		return Objects.equals(nombre, other.nombre);
	}

	

	@Override
	public String toString() {
		return "Calle [nombre=" + nombre +  ", idCalle=" + idCalle + "]";
	}

	public String casetasFamiliares() {
		StringBuilder resultado = new StringBuilder();
		for (Caseta c : casetas) {
			if (c.getClase().equalsIgnoreCase("Familiar")) {
				resultado.append(c.toString());
			}
		}
		return resultado.toString();
	}

	public String casetasDistrito() {
		StringBuilder resultado = new StringBuilder();
		for (Caseta c : casetas) {
			if (c.getClase().equalsIgnoreCase("Distrito")) {
				resultado.append("\n" + c.toString());
			}
		}
		return resultado.toString();
	}

	public String casetasNoFamiliaresNoDistrito() {
		StringBuilder resultado = new StringBuilder();
		for (Caseta c : casetas) {
			if (!c.getClase().equalsIgnoreCase("Distrito") && !c.getClase().equalsIgnoreCase("Familiar")) {
				resultado.append("\n" + c.toString());
			}
		}
		return resultado.toString();
	}

	public int contarFamiliares() {
		int contador = 0;
		for (Caseta c : casetas) {
			if (c.getClase().equalsIgnoreCase("Familiar")) {
				contador++;
			}
		}
		return contador;
	}

	public int contarDistrito() {
		int contador = 0;
		for (Caseta c : casetas) {
			if (c.getClase().equalsIgnoreCase("Distrito")) {
				contador++;
			}
		}
		return contador;
	}

	public boolean borrarCaseta(Caseta caseta) {
		boolean resultado = false;

		if (casetas.contains(caseta)) {
			Iterator<Caseta> siguiente = casetas.iterator();
			while (siguiente.hasNext() && !resultado) {
				Caseta c = siguiente.next();
				if (c.equals(caseta)) {
					casetas.remove(c);
					resultado = true;
				}

			}

		}
		return resultado;
	}

	public void addCaseta(Caseta caseta) {
		
		casetas.add(caseta);

	}

	public String mostrarTodasCasetas() {
		StringBuilder resultado = new StringBuilder();
		for (Caseta c : casetas) {
			resultado.append("\n" + c.toString());
		}
		return resultado.toString();
	}
	
	public String mostrarCasetasNombre(String nombre) {
		StringBuilder resultado = new StringBuilder();
		if(this.nombre.equals(nombre)) {
			for (Caseta c : casetas) {
				resultado.append("\n" + c.toString());
			}
		}
		
		return resultado.toString();
	}

}
