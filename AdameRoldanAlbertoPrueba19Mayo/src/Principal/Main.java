package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;

public class Main {

	public static Series series = new Series();

	public static void main(String[] args) {

//		Series series = new Series();

		try {
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");

		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		escribirEnFicheroCapitulos("ficheros//Fichero Capitulos.csv");
		escribirEnFicheroSeries("ficheros//Fichero Series.csv");
		escribirEnFicheroTemporada("ficheros//Fichero Temporada.csv");

	}

	public static void escribirEnFicheroSeries(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(series.imprimirSeries());

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribirEnFicheroCapitulos(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(series.imprimirCapitulos());// No me ha dado tiempo de ponerlo en el orden como me
																// pedían en el enunciado

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribirEnFicheroTemporada(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(series.imprimirTemporada());// No me ha dado tiempo de ponerlo en el orden como me
																// pedían en el enunciado

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
