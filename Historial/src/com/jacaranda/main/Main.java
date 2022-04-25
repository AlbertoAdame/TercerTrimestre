package com.jacaranda.main;

import java.util.Scanner;

import com.jacaranda.web.Historial;
import com.jacaranda.web.HistorialException;

public class Main {
	
	public static Scanner teclado = new Scanner(System.in);
	public static Historial h = new Historial();

	public static void main(String[] args) {
		int opcion=0;

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
				System.out.println(h.toString());//Ver pq me imprime una coma
				break;
				
			case 3:
				
				break;
				
			case 4:
				h.borrarHistorial();
				break;

			}
		} while (opcion!=4);
		
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
		System.out.println("1. Nueva página.\n" 
				+ "2. Consultar historial completo.\n"
				+ "3. Consultar historial de un día.\n" 
				+ "4. Borrar");

	}
}