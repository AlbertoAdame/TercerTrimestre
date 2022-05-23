import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fichero = leerFichero("ficheros//prueba1.json");
		System.out.println("**********************************");
		System.out.println(fichero);
		
		// Creamos un objeto Gson
		Gson gson = new Gson();
		// Para obtener cada una de las propiedad del objeto
		// Recordad que no funcionario si tenemos un array.
		Properties properties = gson.fromJson(fichero, Properties.class);
		// Mostrarmos cada una de las propiedades.
		System.out.println(properties.get("nombre"));
		System.out.println(properties.get("apellidos"));
		System.out.println(properties.get("edad"));
		
		
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
		}return resultado.toString();
	}
}
