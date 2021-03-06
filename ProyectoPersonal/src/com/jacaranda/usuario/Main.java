package com.jacaranda.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static HashSet<Premiun> premiuns = new HashSet<>();// SOLO USAREMOS ESTAS COLLECTIONS PARA OBTENER LISTADO DE
																// USUARIO
	public static HashSet<Free> frees = new HashSet<>();

	public static void main(String[] args) throws SQLException {

		Connection conexion = null;

		Usuario usuario = null;

//		SELECT * FROM USUARIO WHERE LOGIN = 'Alberto';
//
//		SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1;
//		SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1;
		
//		USUARIO DE PRUEBA = Alberto CONTRASEÑA: pass

		try {
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "dummy",
					"dummy");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Statement instruccion = conexion.createStatement();
		ResultSet resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1");
		while (resultado.next()) {
			Free f = new Free(resultado.getString("LOGIN"), resultado.getString("PASS"));
//			System.out.println(f.toString());
			frees.add(f);
		}

		instruccion = conexion.createStatement();
		resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1");
		while (resultado.next()) {
			Premiun p = new Premiun(resultado.getString("LOGIN"), resultado.getString("PASS"));
//			System.out.println(p.toString());
			premiuns.add(p);
		}

		int opc = 0;
		do {
			menu();
			opc = leerInt("Que quieres hacer: ");

			switch (opc) {
			case 1:// registrarse

				char valor;
				do {
					valor = leerChar("¿Va ser tipo Premiun o Free? (P/F)");
				} while (valor != 'F' && valor != 'P' && valor != 'f' && valor != 'p');

				if (valor == 'P' || valor == 'p') {

					String login = leerString("Dame tu nombre de usuario: ");

					while (login.isBlank()) {
						login = leerString("Dame tu nombre de usuario: ");
					}

					String pass = leerString("Dame tu nueva contraseña: ");

					while (pass.isBlank()) {
						pass = leerString("Dame tu nueva contraseña: ");
					}

					usuario = new Premiun(login, pass);

					instruccion = conexion.createStatement();
//					System.out.println("SELECT * FROM USUARIO WHERE LOGIN = '" + login + "'");
					resultado = instruccion.executeQuery("SELECT count(*) FROM USUARIO WHERE LOGIN = '" + login + "'");
					resultado.next();

					if (resultado.getInt(1) != 0) {
						usuario = null;
						System.out.println("Esta cuenta ya existe.");
					} else {
						premiuns.add((Premiun) usuario);

						instruccion = conexion.createStatement();
						resultado = instruccion
								.executeQuery("INSERT INTO USUARIO VALUES ('" + login + "','" + pass + "',0)");
						System.out.println("Cuenta creada satisfactoriamente\n");

					}

				}

				else {//Esta opcion es para las cuentas frees

					String login = leerString("Dame tu nombre de usuario: ");

					while (login.isBlank()) {
						login = leerString("Dame tu nombre de usuario: ");
					}

					String pass = leerString("Dame tu nueva contraseña: ");

					while (pass.isBlank()) {
						pass = leerString("Dame tu nueva contraseña: ");
					}

					usuario = new Free(login, pass);

					instruccion = conexion.createStatement();
					resultado = instruccion.executeQuery("SELECT COUNT(*) FROM USUARIO WHERE LOGIN = '" + login + "'");
					resultado.next();

					if (resultado.getInt(1) != 0) {// comprobar como arriba
						usuario = null;
						System.out.println("Esta cuenta ya existe.");
					} else {
						frees.add((Free) usuario);

						instruccion = conexion.createStatement();
						resultado = instruccion
								.executeQuery("INSERT INTO USUARIO VALUES ('" + login + "','" + pass + "',-1)");
						System.out.println("Cuenta creada satisfactoriamente\n");
					}

				}

				break;
			case 2:// login

				String login = leerString("Dame tu nombre de usuario: ");

				while (login.isBlank()) {
					System.out.println("No puede tener un usuario vacío.");
					login = leerString("Dame tu nombre de usuario: ");
				}

				String pass = leerString("Dame tu nueva contraseña: ");

				while (pass.isBlank()) {
					System.out.println("No puede tener una contraseña vacío.");
					pass = leerString("Dame tu nueva contraseña: ");
				}

				usuario = new Premiun(login, pass);

				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT COUNT(*) FROM USUARIO WHERE LOGIN = '" + login + "'");
				resultado.next();

				if (resultado.getInt(1) == 0) {
					System.out.println("Este usuario no existe");
				} else {
					instruccion = conexion.createStatement();
					resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = '" + login + "'");
					resultado.next();

					if (resultado.getString("LOGIN").equals(login) && resultado.getInt("NUMEROIMAGENES") != -1) {

						usuario = new Premiun(resultado.getString("LOGIN"), resultado.getString("LOGIN"));
						System.out.println("Logueado correctamente. Usuario premiun.");
					} else if (resultado.getString("LOGIN").equals(login) && resultado.getInt("NUMEROIMAGENES") == -1) {

						usuario = new Free(resultado.getString("LOGIN"), resultado.getString("LOGIN"));
						System.out.println("Logueado correctamente. Usuario Free.");

					}
				}

				break;
			case 3:// Modificar contraseña
				boolean salir = false;
				if (usuario == null) {
					System.out.println("Debes loguearte o registrarte antes.");
				} else {
					instruccion = conexion.createStatement();
					resultado = instruccion
							.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = '" + usuario.getLogin() + "'");
					resultado.next();

					String passOld = leerString("Introduce la contraseña antigua: ");

					if (passOld.equals(resultado.getString("PASS"))) {
						do {
							String passNew = leerString("Introduce la nueva contraseña: ");
							if (passOld.equals(passNew)) {
								System.out.println("Error no puedes elegir la misma contraseña.");

							} else {
								salir = true;

								instruccion = conexion.createStatement();
								resultado = instruccion.executeQuery("UPDATE USUARIO SET PASS = '" + passNew
										+ "' WHERE LOGIN = '" + usuario.getLogin() + "'");

								instruccion = conexion.createStatement();
								resultado = instruccion.executeQuery(
										"SELECT * FROM USUARIO WHERE LOGIN = '" + usuario.getLogin() + "'");
								resultado.next();

								if (resultado.getInt("NUMEROIMAGENES") == -1) {
																				
									boolean encontrado = false;

									Iterator<Free> siguiente = frees.iterator();
									while (siguiente.hasNext() && !encontrado) {
										Free fre = siguiente.next();
										if (usuario.equals(fre)) {
											encontrado = true;
											fre.setPass(passNew);
											System.out.println("Contraseña cambiada");

										}

									}

								} else if (resultado.getInt("NUMEROIMAGENES") != -1) {
																						
									boolean encontrado = false;

									Iterator<Premiun> siguiente = premiuns.iterator();
									while (siguiente.hasNext() && !encontrado) {
										Premiun pre = siguiente.next();
										if (usuario.equals(pre)) {
											encontrado = true;
											pre.setPass(passNew);
											System.out.println("Contraseña cambiada");

										}

									}

								}

							}

						} while (!salir);

					}

				}

				break;
			case 4:// Borrar Cuenta

				if (usuario == null) {
					System.out.println("Debes registrarte");
				} else {
					String afirmar = leerString("¿Estas seguro que quieres borrar tu cuenta?(SI/NO)").toUpperCase();

					if (afirmar.equals("SI")) {

						instruccion = conexion.createStatement();
						resultado = instruccion
								.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = '" + usuario.getLogin() + "'");
						resultado.next();

						if (resultado.getInt("NUMEROIMAGENES") == -1) {
							boolean encontrado = false;

							Iterator<Free> siguiente = frees.iterator();
							while (siguiente.hasNext() && !encontrado) {
								Free fre = siguiente.next();
								if (usuario.equals(fre)) {
									encontrado = true;
									frees.remove(fre);

									instruccion = conexion.createStatement();
									instruccion.executeQuery(
											"DELETE FROM USUARIO WHERE LOGIN = '" + usuario.getLogin() + "'");
									System.out.println("Cuenta borrada");
									usuario = null;

								}

							}

						} else if (resultado.getInt("NUMEROIMAGENES") != -1) {
							boolean encontrado = false;

							Iterator<Premiun> siguiente = premiuns.iterator();
							while (siguiente.hasNext() && !encontrado) {
								Premiun pre = siguiente.next();
								if (usuario.equals(pre)) {
									encontrado = true;
									premiuns.remove(pre);

									instruccion = conexion.createStatement();
									resultado = instruccion.executeQuery(
											"DELETE FROM USUARIO WHERE LOGIN = '" + usuario.getLogin() + "'");
									System.out.println("Cuenta borrada");
									usuario = null;

								}

							}

						}
					}
				}

				break;

			case 5:// Ver que cuenta hay actualmente

				if (usuario == null) {
					System.out.println("No hay ninguna cuenta asociada.\n");
				} else {
					System.out.println("Usuario: " + usuario.getLogin() + "\n");
				}

				break;

			case 6:// Listar usuario premiuns

				System.out.println("Premiun\n");
				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1");
				while (resultado.next()) {
					Premiun p = new Premiun(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(p.toString());

				}

				break;

			case 7:// Listar usuario free

				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1");
				System.out.println("Free\n");
				while (resultado.next()) {
					Free f = new Free(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(f.toString());

				}

				break;

			case 8:// Listar todos los usuarios

				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1");
				System.out.println("\nFree\n");
				while (resultado.next()) {
					Free f = new Free(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(f.toString());

				}

				System.out.println("\nPremiun\n");
				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1");
				while (resultado.next()) {
					Premiun p = new Premiun(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(p.toString());

				}

				break;
			case 9:
				System.out.println("Vuelva pronto.");
				break;

			default:
				System.out.println("No has introducido una opcion válida");
				break;
			}

		} while (opc != 9);

//			"1.Registrarse"
//			+ "\n2.Login"
//			+ "\n3.Modifica Contraseña"
//			+ "\n4.Borrar Cuenta"
//			+ "\n5.Ver que cuenta hay actualmente"
//			+ "\n6.Listar usuarios premiun"
//			+ "\n7.Listar usuarios free"
//			+ "\n8.Listar todos los usuarios"
//			+ "\n9.Salir");

		conexion.close();
	}

	public static void menu() {
		System.out.println("1.Registrarse" + "\n2.Login" + "\n3.Modifica Contraseña" + "\n4.Borrar Cuenta"
				+ "\n5.Ver que cuenta hay actualmente" + "\n6.Listar usuarios premiun" + "\n7.Listar usuarios free"
				+ "\n8.Listar todos los usuarios" + "\n9.Salir");
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
