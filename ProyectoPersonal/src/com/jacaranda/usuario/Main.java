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
			System.out.println(f.toString());
			frees.add(f);
		}

		instruccion = conexion.createStatement();
		resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1");
		while (resultado.next()) {
			Premiun p = new Premiun(resultado.getString("LOGIN"), resultado.getString("PASS"));
			System.out.println(p.toString());
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
				} while (valor != 'F' || valor != 'P' || valor != 'f' || valor != 'p');

				if (valor == 'P' || valor == 'p') {

					String login = leerString("Dame tu nombre de usuario: ");

					while (login.isBlank()) {
						login = leerString("Dame tu nombre de usuario: ");
					}

					String pass = leerString("Dame tu nueva contraseña: ");

					while (!pass.isBlank()) {
						pass = leerString("Dame tu nueva contraseña: ");
					}

					usuario = new Premiun(login, pass);

					instruccion = conexion.createStatement();
					resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = (" + login + ")");

					if (resultado.getString("LOGIN").equals(login)) {// ver si funciona, si no, poner que no sea null
						usuario = null;
						System.out.println("Esta cuenta ya existe.");
					} else {
						premiuns.add((Premiun) usuario);

						instruccion = conexion.createStatement();
						resultado = instruccion
								.executeQuery("INSERT INTO USUARIO VALUES ('" + login + "','" + pass + "',0)");

						// añadir tb en la base de datos

						// mi programa ti

						// hacer el de registrar, borrarte la cuenta, modificar una sesion, y un switch
						// que te de una lista de datos
					}

				}

				else {

					String login = leerString("Dame tu nombre de usuario: ");

					while (login.isBlank()) {
						login = leerString("Dame tu nombre de usuario: ");
					}

					String pass = leerString("Dame tu nueva contraseña: ");

					while (!pass.isBlank()) {
						pass = leerString("Dame tu nueva contraseña: ");
					}

					usuario = new Free(login, pass);

					instruccion = conexion.createStatement();
					resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = (" + login + ")");

					if (resultado.getString("LOGIN").equals(login)) {// comprobar como arriba
						usuario = null;
						System.out.println("Esta cuenta ya existe.");
					} else {
						frees.add((Free) usuario);

						instruccion = conexion.createStatement();
						resultado = instruccion
								.executeQuery("INSERT INTO USUARIO VALUES ('" + login + "','" + pass + "',-1)");
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

				while (!pass.isBlank()) {
					System.out.println("No puede tener una contraseña vacío.");
					pass = leerString("Dame tu nueva contraseña: ");
				}

				usuario = new Premiun(login, pass);

				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = (" + login + ")");

				if (resultado.getString("LOGIN").equals(login) && resultado.getInt("NUMEROIMAGENES") != -1) {// comprobar
																												// como
																												// arriba,
																												// comprobar
																												// si
																												// NUMEROIMAGENES
																												// es
																												// correcto
					usuario = new Premiun(resultado.getString("LOGIN"), resultado.getString("LOGIN"));
					System.out.println("Logueado correctamente. Usuario premiun.");
				} else if (resultado.getString("LOGIN").equals(login) && resultado.getInt("NUMEROIMAGENES") == -1) {// comprobar
																													// como
																													// arriba,
																													// comprobar
																													// si
																													// NUMEROIMAGENES
																													// es
																													// correcto
					usuario = new Free(resultado.getString("LOGIN"), resultado.getString("LOGIN"));
					System.out.println("Logueado correctamente. Usuario Free.");

				}

				break;
			case 3:// Modificar contraseña
				boolean salir = false;
				if (usuario == null) {
					System.out.println("Debes loguearte o registrarte antes.");
				} else {
					instruccion = conexion.createStatement();
					resultado = instruccion
							.executeQuery("SELECT * FROM USUARIO WHERE LOGIN = (" + usuario.getLogin() + ")");

					String passOld = leerString("Introduce la contraseña antigua: ");

					if (passOld.equals(resultado.getString("PASS"))) {
						do {
							String passNew = leerString("Introduce la nueva contraseña: ");
							if (passOld.equals(passNew)) {
								System.out.println("Error no puedes elegir la misma contraseña.");

							} else {
								salir = true;
								
								
								instruccion = conexion.createStatement();
								resultado = instruccion
										.executeQuery("UPDATE USUARIO SET PASS = '" + passNew + "' WHERE LOGIN = '"+ usuario.getLogin() + "'");
								
								
								if(resultado.getInt("NUMEROIMAGENES")==-1){//COMPROBAR QUE SE ESCRIBE ASI NUMERO IMAGENES
									boolean encontrado = false;
									
									Iterator<Free> siguiente = frees.iterator();
									while (siguiente.hasNext() && !encontrado) {
										Free fre = siguiente.next();
										if (usuario.equals(fre)) {
											encontrado = true;
											fre.setPass(passNew);

										}
						
									}
									
								}
								else if(resultado.getInt("NUMEROIMAGENES")!=-1){//COMPROBAR QUE SE ESCRIBE ASI NUMERO IMAGENES
									boolean encontrado = false;
									
									Iterator<Premiun> siguiente = premiuns.iterator();
									while (siguiente.hasNext() && !encontrado) {
										Premiun pre = siguiente.next();
										if (usuario.equals(pre)) {
											encontrado = true;
											pre.setPass(passNew);

										}
						
									}
									
								}
								
							}
								
								
						} while (!salir);

					}

				}

				break;
			case 4:// Borrar Cuenta

				break;

			case 5:// Ver que cuenta hay actualmente

				if (usuario == null) {
					System.out.println("No hay ninguna cuenta asociada.");
				} else {
					System.out.println("Usuario: " + usuario.getLogin());
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
				System.out.println("Free\n");
				while (resultado.next()) {
					Free f = new Free(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(f.toString());

				}

				System.out.println("Premiun\n");
				instruccion = conexion.createStatement();
				resultado = instruccion.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1");
				while (resultado.next()) {
					Premiun p = new Premiun(resultado.getString("LOGIN"), resultado.getString("PASS"));
					System.out.println(p.toString());

				}

				break;

			default:
				System.out.println("No has introducido una opcion válida");
				break;
			}

		} while (opc != 9);

//			"1.Registrarse"
//			+ "\n2.Login"
//			+ "\n3.Hacerse Preimun"
//			+ "\n4.Buscar foto"
//			+ "\n5.Salir");

		// ******************************************+

//		String pagado = leerString("¿Has pagado la inscripcion? (SI/NO)").toUpperCase();
//		if (tipo_cuenta == -1)
//			System.out.println("No estas logueado");
//		else if (pagado == "SI" && tipo_cuenta == 1) {
//			System.out.println("Ya tienes la cuenta premiun.");
//		} else if (pagado == "SI" && tipo_cuenta == 0) {
//			tipo_cuenta = 1;
//			p.setLogin(f.getLogin());
//			p.setPass(f.getPass());
//
//			boolean encontrado = false;
//			Iterator<Free> siguiente = frees.iterator();
//			while (siguiente.hasNext() && !encontrado) {
//				Free fre = siguiente.next();
//				if (f.equals(fre)) {
//					encontrado = true;
//					frees.remove(fre);
//				}
//
//			}
//			if (encontrado) {
//				premiuns.add(p);
//			}
//
//		}
		conexion.close();
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

	public static void addUsuario(Usuario usuario) {

	}
}
