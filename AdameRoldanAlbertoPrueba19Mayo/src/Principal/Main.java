package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

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

			Temporada t = new Temporada("This is us");
			t.annadirCapitulo("La faimila");
			t.annadirCapitulo("El mejor padre");
			t.annadirCapitulo("La vida");
			
			t.anadirCapituloDespues("despues", "La faimila");
//			System.out.println("comprobar");
//			
//			System.out.println(t.primerCapituloQueContieneEstaPalabara("La"));
			
			Serie s = new Serie("nombre serie", 1999, Tema.COMEDIA);
			s.annadirTemporada("temporada uno");
			s.annadirTemporada("temporada dos");
//			s.annadirTemporada("temporada uno");
			s.annadirCapituloTemporada("temporada uno", "cap uno");
			s.annadirCapituloTemporada("temporada uno", "cap dos");
			s.annadirCapituloTemporada("temporada uno", "cap uno");
			s.valorarTemporada("temporada uno", 10);
//			s.valorarTemporada("temporada uno", 100);
			s.valorarTemporada("temporada uno", 5);
			System.out.println(s.listadoTemporadasPorNotaMedia());
			System.out.println(s.listadoTemporadasPorNumeroDeCapitulos());

			System.out.println(series.numeroDeTemporadasDeUnaSerie("This is us"));
			series.modificarTema("This is us", Tema.COMEDIA);
//			series.modificarTema("This is us", Tema.DRAMA);
			System.out.println(series.listadoOrdenadoSeriesDeUnTema(Tema.COMEDIA));
			
			
			
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(series.imprimirCapitulos());
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
