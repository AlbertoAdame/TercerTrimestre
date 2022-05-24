package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String fichero = leerFichero("tamanoMunicipioComunidad.json");
		System.out.println("**********************************");
		System.out.println(fichero);
		int opc=-1;
		
		do {
			menu();
			opc = leerInt("Que quiere hacer: ");
			
			switch (opc) {
			case 1:
//				Mostrar los datos de todas las comunidades y de España de un año que se pedirá
//				por teclado. Es decir, se mostrarán todos los datos
				
				break;
			case 2:
//				Mostrar los datos de una comunidad y un año. Los datos se pedirán por teclado.
				
				break;
			case 3:
//				Añadir un dato. Se pedirá el nombre de la comunidad y la descripción (descrip).
//				A continuación se pedirá el año y el valor del dato.
//				Si la comunidad y la descripción no existe se mostrará un mensaje de error. Si
//				existe se deberá mirar si existe el año y en este caso modificar el dato. Si el año
//				no existe se deberá añadir junto con el dato.
				
				break;
			case 4:
//				Comprobar que el valor de Total es la suma de todos los valores: Para ello se
//				deberá pedir la comunidad y el año. Se deberá comparar el valor “Total” de ese
//				año con la suma de todos los datos de todos los municipios menos “Total”. Se
//				deberá informar si el valor es igual o en caso de que no sea igual el valor actual
//				y el que debería estar.
				
				break;
			case 5:
//				Al salir del menú pregunte si quiere guardar los nuevos datos (“¿Quieres guardar los
//				datos en un nuevo fichero(S/N)?”) y en caso afirmativo pida el nombre del fichero a
//				guardar. Se guardará en formato json.
				
				break;

			default:
				System.out.println("No ha introducido un valor válido.");
				break;
			}
		} while (opc!=5);
		
		

	}
	
	private static void menu() {
		System.out.println("1. Mostrar los datos de todas las comunidades de España en un año\n"
				+ "2. Mostrar los datos de una comunidad y un año\n"
				+ "3. Añadir un dato.\n"
				+ "4. Comprobar que el valor de Total es la suma de todos los valores\n"
				+ "5.Salir");
	}
	private static void escribirEnFicheroJson(String nombre, String contenido) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(contenido);

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos

				resultado.append(linea);
				System.out.println(linea);

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
		return resultado.toString();
	}
	
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	public static char leerChar(String texto) {
		System.out.println(texto);
		return teclado.nextLine().charAt(0);
	}
}
