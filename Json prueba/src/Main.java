import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fichero = leerFichero("ficheros//prueba2.json");
		System.out.println("**********************************");
		System.out.println(fichero);

		// Creamos un objeto Gson
		Gson gson = new Gson();
		// Para obtener cada una de las propiedad del objeto
		// Recordad que no funcionario si tenemos un array.
//		Properties properties = gson.fromJson(fichero, Properties.class);
//		// Mostrarmos cada una de las propiedades.
//		System.out.println(properties.get("nombre"));
//		System.out.println(properties.get("apellidos"));
//		System.out.println(properties.get("edad"));

//		Persona p1 =gson.fromJson(fichero, Persona.class);
//		System.out.println(p1);

		ArrayList<Persona> personas = gson.fromJson(fichero, new TypeToken<ArrayList<Persona>>(){}.getType());
		// TypeToken nos sirve para obtener la clase del objeto a crear.
		// Podemos trabajar ya con el ArrayList
		for (Persona aux : personas) {
			System.out.println(aux.toString());
		}

		Persona p1 = new Persona("pepe", "adame", 65);
		personas.add(p1);
		personas.remove(0);

//		String salida = gson.toJson(personas);
//		System.out.println("Información del String");
//		System.out.println(salida);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String salida = prettyGson.toJson(personas);

		escribirEnFicheroJson("ficheros//prueba3.json", salida);

	}

	private static void escribirEnFicheroJson(String nombre, String contenido) {

		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);

			filtroEscritura.println(contenido);

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();
			while (linea != null) {

				// Esto es lo que modificaremos

				resultado.append(linea);
				System.out.println(linea);

				// Lee otra linea

				linea = filtroLectura.readLine();
			}

			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}
}
