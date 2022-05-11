package com.jacaranda.casetas;

import java.util.Objects;

public class Caseta {

	private String titulo;
	private String calle;
	private String numero;
	private String modulos;
	private String clase;
	private String entidad;
	private String id;
	private String idCalle;

	public Caseta(String titulo, String calle, String numero, String modulos, String clase, String entidad, String id,
			String idCalle) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.idCalle = idCalle;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCalle() {
		return calle;
	}

	public String getNumero() {
		return numero;
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

	public String getIdCalle() {
		return idCalle;
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
		return id == other.id;
	}

	@Override
	public String toString() {
		return "\nTitulo: " + titulo + "\nCalle: " + calle + "\nNnumero: " + numero + "\nModulos: " + modulos
				+ "\nClase: " + clase + "\nEntidad: " + entidad + "\nId: " + id + "\nId de la Calle: " + idCalle;
	}

}
