package com.jacaranda.Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.jacaranda.address.Address;
import com.jacaranda.city.City;
import com.jacaranda.country.CiudadException;
import com.jacaranda.country.Country;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static ArrayList<Country> countries = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		leerFicheroCountry("ficheros//country.txt");
		leerFicheroCity("ficheros//city.txt");
		leerFicheroAddress("ficheros//address2.txt");

		escribirEnFicheroTodo("ficheros//todoDatos.txt");
		escribirEnFicheroNumeros("ficheros//numeroCiudades.txt");

	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	private static void leerFicheroAddress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");
				Address a = new Address(Integer.parseInt(campos[0]), campos[1]);
				int id_ciudad = Integer.parseInt(campos[4]);
				boolean encontrado = false;
				Iterator<Country> siguiente = countries.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Country c = siguiente.next();
					if (c.encontrarCiudad(id_ciudad) != null) {
						encontrado = true;
						c.encontrarCiudad(id_ciudad).addAddress(a);
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

	private static void leerFicheroCity(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");

				City ci = new City(Integer.parseInt(campos[0]), campos[1]);
				Country c = new Country(Integer.parseInt(campos[2]), "nada");

				if (countries.contains(c)) {
					countries.get(countries.indexOf(c)).addCiudad(ci);
				}

				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (CiudadException e) {

			System.out.println(e.getMessage());
		}
	}

	private static void leerFicheroCountry(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				String[] campos = linea.split(",");

				Country c = new Country(Integer.parseInt(campos[0]), campos[1]);
				countries.add(c);

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

	private static void escribirEnFicheroTodo(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Country c : countries) {

				filtroEscritura.println(c.imprimirTodo());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFicheroNumeros(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			for (Country c : countries) {

				filtroEscritura.println(c.imprimirCantidadCiudades());

			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
