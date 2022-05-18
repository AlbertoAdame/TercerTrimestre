package com.jacaranda.main;

import java.time.LocalDate;

import java.util.Scanner;

import com.jacaranda.historial.Historial;

public class Main {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc = 0;
		Historial h = new Historial();
		do {

			menu();
			opc = leerInt("Que quieres hacer: ");
			
			h.anadirPagina("Googele");
			h.anadirPagina("Googele");
			h.anadirPagina("Googele");

			switch (opc) {
			case 1:
				String pagina = leerString("Dame el nombre de la web: ");
				h.anadirPagina(pagina);
				break;
			case 2:
				System.out.println(h.imprimirHistorialCompleto());
				break;
			case 3:
				String dia = leerString("Dame la fecha (yyyy-mm-dd): ");
				LocalDate fecha = LocalDate.parse(dia);
				if (fecha.isAfter(LocalDate.now()))
					System.out.println("Esta fecha no es válida.");
				else {
					System.out.println(h.imprimirHistorialDia(fecha)); 
				}
				break;
			case 4:
				h.borrarHistorial();
				System.out.println("Borrado");
				break;

			default:
				System.out.println("No he entendido.");
				break;
			}
		} while (opc != 5);

	}

	public static void menu() {
		System.out.println("1. Nueva página consultada\r\n" + "2. Consultar historial completo.\r\n"
				+ "3. Consultar historial de un día.\r\n" + "4. Borrar historial completo.\r\n" + "5. Salir.\r\n");
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
