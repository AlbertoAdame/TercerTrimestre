package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.jacaranda.address.Address;
import com.jacaranda.city.City;
import com.jacaranda.city.ExceptionCity;
import com.jacaranda.country.Country;
import com.jacaranda.country.CountryException;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static List<Country> paises = new LinkedList<>();// // utilizaremos linkedList, pq arrayList renta cuando hay
															// muchas cosas que borrar, y aqui no borraremos

	public static void main(String[] args) throws CountryException, ExceptionCity {

		leerFicheroCountry("ficheros//country.txt");
//		System.out.println(paises.toString());
		leerFicheroCity("ficheros//city.txt");
		leerFicheroAddress("ficheros//address2.txt");
		escribirFichero("ficheros//nuevoFichero.txt");
		escribirFicheroCiudades("ficheros//todaInfo.txt");

	}

	public static void leerFicheroCountry(String nombreFichero) {

		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");
				Country c = new Country(campos[1], Integer.parseInt(campos[0]));
				paises.add(c);

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

	public static void leerFicheroCity(String nombreFichero) throws CountryException {

		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");
				City c = new City(campos[1], Integer.parseInt(campos[0]));
				Country c1 = new Country("", Integer.parseInt(campos[2]));// es mas óptimo esto? o crear un nuevo
																			// constructor solo con el
																			// id?
				if (paises.contains(c1)) {
					paises.get(paises.indexOf(c1)).addCiudad(c);
				}

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

	public static void leerFicheroAddress(String nombreFichero) throws ExceptionCity {

		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				boolean encontrado = false;
				String[] campos = linea.split(",");
				Address a = new Address(campos[1], Integer.parseInt(campos[0]));
				int idCity = Integer.parseInt(campos[4]);

				Iterator<Country> siguiente = paises.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Country c = siguiente.next();
					if (c.encontrarCiudad(idCity) != null) {
						encontrado = true;
						City ciudad = c.encontrarCiudad(idCity);
						ciudad.addAddress(a);
					}

				}
				if (!encontrado)
					System.out.println("No se ha encontrado la ciudad");

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

	private static void escribirFichero(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Country c : paises) {
				filtroEscritura.println(c.escribirFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void escribirFicheroCiudades(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Country c : paises) {
				filtroEscritura.println(c.escribirCiudades());
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
