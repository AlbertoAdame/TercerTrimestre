package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.persona.Alumno;
import com.jacaranda.persona.AlumnoException;
import com.jacaranda.persona.PersonaException;
import com.jacaranda.persona.Profesor;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws PersonaException, AlumnoException {
		// TODO Auto-generated method stub

		Alumno a1 = new Alumno("1","Juan", 12);
		Profesor p = new Profesor("2","Pepe", 30);
		Alumno a2 = new Alumno("3","Luis", 25);
		try {
			a1.enviarMensaje(a2, "Prueba");
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		try {
			a1.enviarMensaje(p, "Hola profesor");
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		try {
			a2.enviarMensaje(a1, "Soy un alumno mayor");
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}

		p.enviarMensaje(a1, "Soy un profesor");

		System.out.println(a1.verEnviados());
		System.out.println(a1.verRecibidos());

		System.out.println(a1);
		System.out.println(a2);
		System.out.println(p);
		
		
		
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
}
