package com.jacaranda.persona;

import com.jacaranda.mensaje.Mensaje;

public class Profesor extends Persona {

	public Profesor(String dni, String nombre, int edad) throws PersonaException {
		super(dni, nombre, edad);
	}

	@Override
	public boolean enviarMensaje(Persona destinatario, String mensaje) throws AlumnoException {
		Mensaje m = new Mensaje(super.getNombre(), "Hola alumno", destinatario.getNombre());
		super.enviados.add(m);
		destinatario.recibidos.add(m);
		
		return false;
	}

	@Override
	public String toString() {
		return "Profesor [getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + "]";
	}
	
	

	
}
