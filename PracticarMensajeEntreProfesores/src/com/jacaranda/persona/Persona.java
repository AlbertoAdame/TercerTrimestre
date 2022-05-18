package com.jacaranda.persona;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.mensaje.Mensaje;

public abstract class Persona {

	private String dni;
	private String nombre;
	private int edad;
	protected List<Mensaje> recibidos;
	protected List<Mensaje> enviados;

	protected Persona(String dni, String nombre, int edad) throws PersonaException {
		super();
		this.setDni(dni);
		setNombre(nombre);
		setEdad(edad);
		this.recibidos = new LinkedList<>();
		this.enviados = new LinkedList<>();
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) throws PersonaException {
		if (dni == null || dni.isBlank())
			throw new PersonaException("Ese dni no es válido.");
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) throws PersonaException {
		if (nombre == null || nombre.isBlank())
			throw new PersonaException("Ese nombre no es válido.");
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) throws PersonaException {
		if (edad < 0)
			throw new PersonaException("Esta edad no es válido.");
		this.edad = edad;
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
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	protected abstract boolean enviarMensaje(Persona destinatario, String mensaje) throws AlumnoException;
	
	public String verEnviados() throws PersonaException {
		if(enviados.isEmpty())
			throw new PersonaException("No tienes mensajes enviados");
		StringBuilder resultado = new StringBuilder();
		for(Mensaje m : enviados) {
			resultado.append("Mensaje " + m.getNumero() + " : Para " + m.getDestinatario() + "\n" + m.getMensaje() + "\nFecha y hora: " + m.getFecha());
		}
		return resultado.toString();
	}
	
	public String verRecibidos() throws PersonaException {
		if(recibidos.size()==1)
			throw new PersonaException("No tienes mensajes recibidos");
		StringBuilder resultado = new StringBuilder();
		for(Mensaje m : recibidos) {
			resultado.append("Mensaje " + m.getNumero() + " : De " + m.getRemitente() + "\n" + m.getMensaje() + "\nFecha y hora: " + m.getFecha());
		}
		return resultado.toString();
	}
	
	public String verRecibidosOrdenadosPorRemitente() throws PersonaException {
		if(recibidos.size()==1)
			throw new PersonaException("No tienes mensajes recibidos");
		
		Collections.sort(recibidos);
		
		StringBuilder resultado = new StringBuilder();
		for(Mensaje m : recibidos) {
			resultado.append("Mensaje " + m.getNumero() + " : De " + m.getRemitente() + "\n" + m.getMensaje() + "\nFecha y hora: " + m.getFecha());
		}
		return resultado.toString();
	}
	
	public String verRecibidosOrdenadosPorFecha() throws PersonaException {
		if(recibidos.size()==1)
			throw new PersonaException("No tienes mensajes recibidos");
		
		Collections.sort(recibidos, new OrdenarPorFecha());
		
		StringBuilder resultado = new StringBuilder();
		for(Mensaje m : recibidos) {
			resultado.append("Mensaje " + m.getNumero() + " : De " + m.getRemitente() + "\n" + m.getMensaje() + "\nFecha y hora: " + m.getFecha());
		}
		return resultado.toString();
	}

	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	

}
