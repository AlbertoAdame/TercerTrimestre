package com.jacaranda.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.jacaranda.web.Historial;
import com.jacaranda.web.HistorialException;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	public static Historial h = new Historial();

	public static void main(String[] args) {
		int opcion=0;
		
		Historial h = new Historial();
		try {
			h.anadirPagina("google");
		} catch (HistorialException e1) {
			e1.printStackTrace();
		}
		
		try {
			h.anadirPagina("facebook");
		} catch (HistorialException e1) {
			e1.printStackTrace();
		}

		do {
			menu();
			try {
				opcion=leerInt("Que quieres hacer: ");
			} catch (Exception e) {
				System.out.println("Opcion no valida.");
			}
			
			
			switch (opcion) {
			case 1:
				String pagina=leerString("Dame la pagina web");
				
				try {
					h.anadirPagina(pagina);
				} catch (HistorialException e) {
					e.getMessage();
				}

				break;
				
			case 2:
				System.out.println(h.toString());
				break;
				
			case 3:
				String dia=leerString("Dame el día (yyyy-mm-dd): ");
				LocalDate fecha = LocalDate.parse(dia);
				System.out.println(h.consultarHistorial(fecha)); 
				break;
				
			case 4:
				h.borrarHistorial();
				break;
				

			}
		} while (opcion!=5);
		
	}
	
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	public static void menu() {
		System.out.println("1. Nueva p�gina.\n" 
				+ "2. Consultar historial completo.\n"
				+ "3. Consultar historial de un d�a.\n" 
				+ "4. Borrar\n"
				+ "5.Salir");

	}
}