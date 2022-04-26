package com.jacaranda.persona;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Persona {

	private String nombre;
	private int edad;
	protected List<Mensaje> recibidos;
	protected List<Mensaje> enviados;

	protected Persona(String nombre, int edad) throws PersonaException {
		super();
		this.nombre = nombre;
		setEdad(edad);
		this.recibidos = new LinkedList<>();
		this.enviados = new LinkedList<>();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad < 0)
			throw new PersonaException("No pueden haber edades negativas.");
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public abstract boolean enviarMensaje(String texto, Persona nombre) throws AlumnoException;

	public String getMensajesRecibidos() {
		return recibidos.toString();
	}

	public String getMensajesEnviados() {
		return enviados.toString();
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
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return nombre + ", edad= " + edad + " ";
	}

}
