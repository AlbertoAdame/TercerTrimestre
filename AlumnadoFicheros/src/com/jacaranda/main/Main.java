package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listaAlumnos;
	public static HashSet<Modulo> listaModulos;
	public static ArrayList<Nota> listaNota;
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		leerFicheroAlumno("ficheros//alumando.txt");
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

				break;

			case 4:
				for(Nota nota: listaNotas) {
					System.out.println(nota);
				}
				break;

			case 5:
				for(Alumnado alu: listaAlumnos) {
					System.out.println(alu);
				}
				break;

			case 6:
				escribirEnFichero("ficheros//alumnado.txt");

				break;

			default:
				System.out.println("Valor no válido");
				break;
			}
		} while (opc != 6);
		
		

	}

	public static void menu() {
		System.out.println("1.Alta alumno.");
		System.out.println("2.Alta modulo.");
		System.out.println("3.Registrar nota.");
		System.out.println("4.Listar notas todos los alumnos.");
		System.out.println("5.Listar todos los alumnos.");
		System.out.println("6.Salir.");

	}

	private static void leerFicheroAlumno(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			
			linea = filtroLectura.readLine();
			while (linea != null) {
				
				//Esto es lo que modificaremos
				
				String[] campos = linea.split(",");
				Alumnado alu = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnos.add(alu);
				
				
				//Lee otra linea
				
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
				
				//Esto es lo que modificaremos
				
				String[] campos = linea.split(",");
				Modulo m = new Modulo(campos[0], campos[1], campos[2]);//hay que parsearlo
				listaModulos.add(m);
				
				
				//Lee otra linea
				
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
	
	private static void escribirEnFichero(String nombre) {
		String cadena;
		try {
		FileWriter flujoEscritura=new FileWriter(nombre);
		PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
		//Hemos modificado este for, ademas de crear escribeFichero en la clase Alumnado
		
		for (Alumnado alu: listaAlumnos) {

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
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
		}
	
	}


