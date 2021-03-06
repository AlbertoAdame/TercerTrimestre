package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listaAlumnos = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		int opc;
		leerFicheroAlumno("ficheros//alumnado.txt");
		leerFicheroModulo("ficheros//modulo.txt");
		leerFicheroNota("ficheros//nota.txt");

		do {

			menu();
			opc = leerInt("Que quieres hacer: ");

			switch (opc) {
			case 1:
				String nombre = leerString("Introduce un nombre: ");
				String dni = leerString("Introduce un dni: ");
				String correo = leerString("Introduce un correo: ");
				listaAlumnos.add(new Alumnado(nombre, dni, correo));

				break;

			case 2:

				nombre = leerString("Introduce el nombre del modulo: ");
				int horas = leerInt("Introduce el numero de horas: ");
				int creditos = leerInt("Introduce los creditos: ");
				listaModulos.add(new Modulo(nombre, horas, creditos));

				break;

			case 3:
	
				dni = leerString("Introduce su dni: ");
				double notaAlumno = leerDouble("Dame la nota del examen: ");
				LocalDate fecha = LocalDate.parse(leerString("Dame la fecha (yyyy-mm-dd): "));
				String modulo = leerString("Dame el nombre del modulo: ");

				Alumnado a = new Alumnado("kk", dni);
				int posicion = listaAlumnos.indexOf(a);
				if (posicion == -1) {
					System.out.println("El alumno no existe");
				}else {
					
					boolean encontrado = false;
					Modulo resultado = null;
					
					Iterator<Modulo> siguiente = listaModulos.iterator();
					while (siguiente.hasNext() && !encontrado) { 
						resultado = siguiente.next();
						if (resultado.getNombre().equals(modulo)) {
							encontrado = true;
						}
					}
					if (encontrado == false) {
						System.out.println("Error el modulo no existe");
					}else{					
						Nota n = new Nota(notaAlumno, fecha, listaAlumnos.get(posicion), resultado);
						listaNota.add(n);
					}
		
				}
							
				System.out.println("adios");
				break;

			case 4:
				for (Nota nota : listaNota) {
					System.out.println(nota);
				}
				break;

			case 5:
				for (Alumnado alu : listaAlumnos) {
					System.out.println(alu);
				}
				break;

			case 6:
				for (Modulo mo : listaModulos) 
					System.out.println(mo);

				break;
				
			case 7:
				escribirEnFicheroAlumnado("ficheros//alumnado.txt");
				escribirEnFicheroModulo("ficheros//modulo.txt");
				escribirEnFicheroNota("ficheros//nota.txt");

				break;

			default:
				System.out.println("Valor no v??lido");
				break;
			}
		} while (opc != 7);

	}

	public static void menu() {
		System.out.println("1.Alta alumno.");
		System.out.println("2.Alta modulo.");
		System.out.println("3.Registrar nota.");
		System.out.println("4.Listar las notas de todos los alumnos.");
		System.out.println("5.Listar todos los alumnos.");
		System.out.println("6.Listar todos los modulos.");
		System.out.println("7.Salir.");

	}

	private static void leerFicheroAlumno(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos

				String[] campos = linea.split(",");
				Alumnado alu = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnos.add(alu);

				// Lee otra linea

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerFicheroModulo(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos

				String[] campos = linea.split(",");
				Modulo m = new Modulo(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]));// hay que
																											// parsearlo
				listaModulos.add(m);

				// Lee otra linea

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerFicheroNota(String nombreFichero) throws Exception {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos
				
				

				String[] campos = linea.split(",");

				String dni = campos[2];
				Alumnado a = new Alumnado("kk", dni);
				int posicion = listaAlumnos.indexOf(a);

					a = listaAlumnos.get(posicion);

					String nombreAsignatura = campos[3];
					Modulo m1 = new Modulo(nombreAsignatura);
					
					boolean encontrado = false;
					Modulo resultado = null;
					
					Iterator<Modulo> siguiente = listaModulos.iterator();
					while (siguiente.hasNext() && !encontrado) { //Mejor hacerlo de la otra forma
						resultado = siguiente.next();
						if (resultado.getNombre().equals(nombreAsignatura)) {
							encontrado = true;
						}
					}

					Nota n = new Nota(Double.parseDouble(campos[0]), LocalDate.parse(campos[1]), a, resultado);
					listaNota.add(n);
				

				// Lee otra linea

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroNota(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Nota n : listaNota) {

				filtroEscritura.println(n.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroModulo(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Modulo mod : listaModulos) {

				filtroEscritura.println(mod.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroAlumnado(String nombre) {
		String cadena;
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			// Hemos modificado este for, ademas de crear escribeFichero en la clase
			// Alumnado

			for (Alumnado alu : listaAlumnos) {

				filtroEscritura.println(alu.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

}
