package com.jacaranda.usuario;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static HashSet<Premiun> premiuns = new HashSet<>();//SOLO USAREMOS ESTAS COLLECTIONS PARA OBTENER LISTADO DE USUARIO
	public static HashSet<Free> frees = new HashSet<>(); 

	public static void main(String[] args) throws SQLException {

		Connection conexion=null;

		Usuario usuario = null;
		
//		SELECT * FROM USUARIO WHERE LOGIN = 'Alberto';
//
//		SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1;
//		SELECT * FROM USUARIO WHERE NUMEROIMAGENES !=-1;

		try {
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain", "dummy","dummy");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			Statement instruccionUno= conexion.createStatement();
			ResultSet resultado = instruccionUno.executeQuery("SELECT * FROM USUARIO WHERE NUMEROIMAGENES =-1");
			while(resultado.next()) {
				Free f = new Free(resultado.getString("LOGIN"), resultado.getString("PASS"));
				System.out.println(f.toString());
			}
			
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

						while (login.isBlank()) {
							login = leerString("Dame tu nombre de usuario: ");
						}

						String pass = leerString("Dame tu nueva contraseña: ");

						while (!pass.isBlank()) {
							pass = leerString("Dame tu nueva contraseña: ");
						}
						
						usuario = new Premiun(login,pass);
						
						Statement instruccion = conexion.createStatement();
						String query = "SELECT * FROM USUARIO WHERE LOGIN = ("+login+")";
						

						if (premiuns.contains(usuario)) {
							usuario=null;
							System.out.println("Esta cuenta ya existe.");
						} else {
							premiuns.add((Premiun) usuario);
							//añadir tb en la base de datos
							
							//mi programa ti
							
							//hacer el de registrar, borrarte la cuenta, modificar una sesion, y un switch que te de una lista de datos
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

						usuario = new Free(login,pass);

						if (frees.contains(usuario)) {
							usuario=null;
							System.out.println("Esta cuenta ya existe.");
						} else {
							frees.add((Free) usuario);
						}

					}

					break;
				case 2:

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
					

//					if (premiuns.contains(usuario)) {
//						tipo_cuenta = 1;
//						p.setLogin(login);
//						p.setPass(pass);
//					} else if (frees.contains(usuario)) {
//						tipo_cuenta = 0;
//						f.setLogin(login);
//						f.setPass(pass);
//					}

					break;
				case 3:// Hacerse Premiun" Simulará que pagas la inscripcion, y pasas de free a premiun

					
					break;
				case 4:

					break;

				default:
					break;
				}

			} while (usuario != null);

//			"1.Registrarse"
//			+ "\n2.Login"
//			+ "\n3.Hacerse Preimun"
//			+ "\n4.Buscar foto"
//			+ "\n5.Salir");

		
		
		
		
		//******************************************+
		
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
