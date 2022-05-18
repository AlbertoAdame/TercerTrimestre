package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.alumno.Alumno;
import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;

public class Main {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws EquipoException {
		// TODO Auto-generated method stub
		
		Alumno a1 = new Alumno("Paco", "1");
		Alumno a2 = new Alumno("Luis", "2");
		Alumno a3 = new Alumno("Mauricio", "3");
		Equipo e = new Equipo("Lora");
		Alumno buscar = new Alumno("", "3");
		e.anadirAlumno(a1);
		e.anadirAlumno(a2);
//		e.borrarAlumno(a3);
		e.anadirAlumno(a3);
		buscar= e.encontrarAlumno(buscar);
		System.out.println(buscar);
		
		
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
