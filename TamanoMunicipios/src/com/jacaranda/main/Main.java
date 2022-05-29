package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.jacaranda.tamano.TamanoMunicipioComunidad;

public class Main {

	public static TamanoMunicipioComunidad tamanios = new TamanoMunicipioComunidad();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		String info = leerJson("tamanoMunicipioComunidad.json");
		tamanios.cargarDatos(info);

		int opc;

		do {
			menu();
			opc = leerInt("Que quieres hacer: ");

			switch (opc) {
			case 1:// Mostrar todos los datos de un año
				int anio = leerInt("Dame un año: ");
				System.out.println(tamanios.mostrarComunidad(anio));

				break;
			case 2:// Mostrar todos los datos de un año y una comunidad
				anio = leerInt("Dame un año: ");
				String comunidad = leerString("Dame el nombre de la comunidad: ");
				System.out.println(tamanios.mostrarComunidadAno(anio, comunidad));

				break;
			case 3:// Añadir dato
				comunidad = leerString("Dame el nombre de la comunidad: ");
				anio = leerInt("Dame un año: ");
				String descripcion = leerString("Dame la descripcion: ");
				int dato = leerInt("Dame un dato: ");

				boolean introducido = tamanios.addDato(comunidad, descripcion, anio, dato);

				if (introducido)
					System.out.println("El dato se ha introducido favorablemente.");
				else
					System.out.println("Ha habido un problema al añadir el dato");

				break;
			case 4:// Comprobar totales
				anio = leerInt("Dame un año: ");
				comunidad = leerString("Dame el nombre de la comunidad: ");
				System.out.println(tamanios.comparar(comunidad, anio));

				break;
			case 5:// Salir
				String respuesta = leerString("¿Quieres guardar los datos en un fichero nuevo(S/N)? ");
				if (respuesta.equalsIgnoreCase("S")) {
					tamanios.guardarDatos("nuevo.json");
					System.out.println("Datos guardados.");
				}

				break;

			default:
				System.out.println("Valor no válido.\n");
				break;
			}

		} while (opc != 5);

	}

	public static void menu() {
		System.out.println(
				"1.Mostrar todos los datos de un año " + "\n" + "2.Mostrar todos los datos de un año y una comunidad"
						+ "\n" + "3.Añadir dato " + "\n" + "4.Comprobar totales " + "\n" + "5.Salir " + "\n");
	}

	private static String leerJson(String nombreFichero) {
		StringBuilder resultado = new StringBuilder();
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resultado.append(linea);
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

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
