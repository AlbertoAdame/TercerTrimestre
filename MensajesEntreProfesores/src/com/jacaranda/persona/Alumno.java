package com.jacaranda.persona;

public class Alumno extends Persona {

	public Alumno(String nombre, int edad) throws PersonaException {
		super(nombre, edad);

	}

	@Override
	public boolean enviarMensaje(String texto, Persona nombre) throws AlumnoException {
		boolean enviado = false;
		if (nombre instanceof Alumno && super.getEdad() < 18) {
			throw new AlumnoException("No puedes realizar esta accion.");
		} else {
			Mensaje m = new Mensaje(super.getNombre(), texto, nombre.getNombre());
			nombre.recibidos.add(m);
			super.enviados.add(m);
			enviado = true;

		}
		return enviado;

	}

	@Override
	public String toString() {
		return "\nAlumno:" + super.toString() + "recibidos=" + recibidos + ", enviados=" + enviados;
	}

}
