package com.jacaranda.casetas;

import java.util.Objects;

public class Caseta {

	private String titulo;
	private String numero;
	private String modulos;
	private String clase;
	private String entidad;
	private String id;

	public Caseta(String titulo, String modulos, String clase, String entidad, String id, String numero) {
		super();
		this.titulo = titulo;
		this.modulos = modulos;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getModulos() {
		return modulos;
	}

	public String getClase() {
		return clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public String getId() {
		return id;
	}
	
	

	public String getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "\nTitulo: " + titulo + "\nModulos: " + modulos
				+ "\nClase: " + clase + "\nEntidad: " + entidad + "\nId: " + id + "\nNumero: " + numero+ "\n";
	}

}
