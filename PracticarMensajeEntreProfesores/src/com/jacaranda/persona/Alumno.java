package com.jacaranda.persona;

import java.util.Iterator;

import com.jacaranda.mensaje.Mensaje;

public class Alumno extends Persona {

	public Alumno(String dni, String nombre, int edad) throws PersonaException {
		super(dni, nombre, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean enviarMensaje(Persona persona, String mensaje) throws AlumnoException {
		if(super.getEdad()<18 && persona instanceof Alumno)
			throw new AlumnoException("No le puedes enviar un mensaje a otro alumno.");
		Mensaje m = new Mensaje(super.getNombre(), "hola buenas tardes", persona.getNombre());
		super.enviados.add(m);
		persona.recibidos.add(m);
		

		return false;
	}

	@Override
	public String toString() {
		return "Alumno [getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + "]";
	}

	
	
	
}
