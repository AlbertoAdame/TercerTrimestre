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

	public static LinkedList<Alumnado> alumnos = new LinkedList<>();
	public static HashSet<Modulo> modulos = new HashSet<>();
	public static ArrayList<Nota> notas = new ArrayList<>();

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leerFicheroAlumno("ficheros//alumnado.txt");
		leerFicheroModulo("ficheros//modulo.txt");
		leerFicheroNota("ficheros//nota.txt");

		int opc = 0;

		do {

			menu();
			opc = leerInt("Que quieres hacer: ");

			switch (opc) {
			case 1:// "1.Alta alumno
				String nombre = leerString("Dame el nombre del alumno: ");
				String dni = leerString("Dame el dni: ");
				String correo = leerString("Dame el correo: ");

				Alumnado a = new Alumnado(nombre, dni, correo);

				alumnos.add(a);

				break;
			case 2:// Alta modulo
				nombre = leerString("Dame el nombre del modudlo: ");
				int horas = leerInt("Dame el numeor de horas semanales: ");
				int creditos = leerInt("Dame el numero de creditos: ");

				Modulo m = new Modulo(nombre, horas, creditos);

				break;
			case 3:// Registrar nota
				Modulo resultado = null;
				double nota = leerDouble("Dame la nota: ");
				LocalDate fecha = LocalDate.parse(leerString("Dame la fecha (yyyy-mm-dd): "));

				dni = leerString("Dame el dni del alumno: ");
				a = new Alumnado("nada", dni, "nada");
				a = alumnos.get(alumnos.indexOf(a));

				nombre = leerString("Dame el nombre del modulo: ");

				boolean encontrado = false;
				Iterator<Modulo> siguiente = modulos.iterator();
				while (siguiente.hasNext() && !encontrado) {
					m = siguiente.next();
					if (m.getNombre().equalsIgnoreCase(nombre)) {
						encontrado = true;
						resultado = m;
					}

				}
				
				Nota n = new Nota(nota, fecha, a, resultado);
				

				break;
			case 4:// Listar las notas de todos los alumnos.
				for(Nota n1 : notas) {
					System.out.println(n1);
				}
				
				break;
			case 5:// Listar todos los alumnos
				for(Alumnado a1 : alumnos) {
					System.out.println(a1);
				}
				
				break;
			case 6:// Listar todos los modulos.
				for(Modulo m1 : modulos) {
					System.out.println(m1);
				}
				break;

			case 7:// Escribir
				escribirEnFicheroAlumno("ficheros//alumnado.txt");
				escribirEnFicheroModulo("ficheros//modulo.txt");
				escribirEnFicheroNota("ficheros//nota.txt");
				break;

			default:
				System.out.println("No te he entendido.");
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

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
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
				alumnos.add(alu);

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
				Modulo m = new Modulo(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]));
				modulos.add(m);

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

	private static void leerFicheroNota(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos

				String[] campos = linea.split(",");

				Alumnado a = new Alumnado("nada", campos[2], "nada");
				alumnos.get(alumnos.indexOf(a));

				Modulo m = new Modulo(campos[3], 0, 0);

				Boolean encontrado = false;

				Iterator<Modulo> siguiente = modulos.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Modulo m1 = siguiente.next();
					if (m1.equals(m)) {
						encontrado = true;
						m = m1;
					}

				}

				Nota n = new Nota(Double.parseDouble(campos[0]), LocalDate.parse(campos[1]), a, m);
				notas.add(n);

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
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Nota n : notas) {

				filtroEscritura.println(n.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroModulo(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Modulo m : modulos) {

				filtroEscritura.println(m.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroAlumno(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Alumnado a : alumnos) {

				filtroEscritura.println(a.escribeFichero());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
