package com.jacaranda.persona;

public class Profesor extends Persona {

	public Profesor(String nombre, int edad) throws PersonaException {
		super(nombre, edad);
	}

	@Override
	public boolean enviarMensaje(String texto, Persona nombre) {
		boolean enviado = false;
		try {
			Mensaje m = new Mensaje(super.getNombre(), texto, nombre.getNombre());
			super.enviados.add(m);
			nombre.recibidos.add(m);
			enviado = true;
		} catch (Exception e) {
			System.out.println("Error al enviar mensaje.");
		}

		return enviado;
	}

	@Override
	public String toString() {
		return "\nProfesor: " + super.toString() + "recibidos=" + super.recibidos + ", enviados=" + super.enviados;
	}

}
