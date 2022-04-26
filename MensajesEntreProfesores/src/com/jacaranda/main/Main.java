package com.jacaranda.main;

import com.jacaranda.persona.Alumno;
import com.jacaranda.persona.AlumnoException;
import com.jacaranda.persona.PersonaException;
import com.jacaranda.persona.Profesor;

public class Main {

	public static void main(String[] args) throws PersonaException {

		Alumno a1 = new Alumno("Juan", 12);
		Profesor p = new Profesor("Pepe", 30);
		Alumno a2 = new Alumno("Luis", 25);
		try {
			a1.enviarMensaje("Hola", a2);
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		try {
			a1.enviarMensaje("Hola", p);
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		try {
			a2.enviarMensaje("Soy un alumno mayor", a1);
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		p.enviarMensaje("Soy un profesor", a1);

		System.out.println(a1.getMensajesEnviados());
		System.out.println(a1.getMensajesRecibidos());

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(p);

	}

}
