package com.jacaranda.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static HashSet<Premiun> premiuns = new HashSet<>();
	public static HashSet<Free> frees = new HashSet<>();

	public static void main(String[] args) {

		Connection conexion;
		try {
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "dummy",
					"dummy");

			int opc = 0;
			do {
				menu();
				opc = leerInt("Que quieres hacer: ");

				switch (opc) {
				case 1:

					char valor;
					do {
						valor = leerChar("¿Va ser tipo Premiun o Free? (P/F)");
					} while (valor != 'F' || valor != 'P' || valor != 'f' || valor != 'p');

					if (valor == 'P' || valor == 'p') {
						String login = leerString("Dame tu nombre de usuario: ");

						Premiun up = new Premiun(login, "");

						while (!login.isBlank() || !premiuns.contains(up)) {
							login = leerString("Dame tu nombre de usuario: ");
						}

						String pass = leerString("Dame tu nueva contraseña: ");
						
						while (!pass.isBlank()) {
							pass = leerString("Dame tu nueva contraseña: ");
						}
					}

					

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;

				default:
					break;
				}

			} while (opc != 5);

//			"1.Registrarse"
//			+ "\n2.Login"
//			+ "\n3.Hacerse Preimun"
//			+ "\n4.Buscar foto"
//			+ "\n5.Salir");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void menu() {
		System.out.println("1.Registrarse" + "\n2.Login" + "\n3.Hacerse Preimun" + "\n4.Buscar foto" + "\n5.Salir");
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
