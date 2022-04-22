package com.jacaranda.gestion;

import java.util.Objects;

public class Alumnado {

	private String nombre;
	private String dni;
	private String correo;
	
	public Alumnado(String nombre, String dni, String correo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.correo = correo;
	}

	public Alumnado(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Alumnado [nombre=" + nombre + ", dni=" + dni + ", correo=" + correo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnado other = (Alumnado) obj;
		return Objects.equals(dni, other.dni);
	}
	
	public String escribeFichero() {
		return nombre + "," + dni + "," + correo;
	}
	
}
