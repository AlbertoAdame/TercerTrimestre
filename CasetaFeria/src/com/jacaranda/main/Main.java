package com.jacaranda.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jacaranda.casetas.Calle;
import com.jacaranda.casetas.Caseta;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static ArrayList<Calle> calles = new ArrayList<>();// Esto tiene que ser una lista de calles

	public static void main(String[] args) {

		int opc = 0;
		leerFichero();

		do {
			menu();
			opc = leerInt("Que quieres hacer: ");
			switch (opc) {
			case 1: {
				String calle = leerString("Dame el nombre de la calle: ").toUpperCase();
				for (Calle c : calles) {
					if (c.getCalle().equalsIgnoreCase(calle))
						System.out.println(c.mostrarTodasCasetas());
				}
				break;
			}

			case 2: {// "2. Mostrar todas las casetas de tipo familiar. \r\n"
				for (Calle c : calles) {
					System.out.println(c.casetasFamiliares());
				}

				break;
			}

			case 3: {// 3. Mostrar todas las casetas de tipo Distrito \r\n"
				for (Calle c : calles) {
					System.out.println(c.casetasDistrito());
				}
				break;
			}

			case 4: {// Mostrar todas las casetas que no sean ni familiares ni distritos. \r\n"
				for (Calle c : calles) {
					System.out.println(c.casetasNoFamiliaresNoDistrito());
				}
				break;
			}

			case 5: {// "5. Mostrar para cada una de las calles del recinto ferial el n�mero de
						// casetas de tipo familiar que existen. \r\n"

				for (Calle c : calles) {
					System.out.println(c.getCalle() + ": " + c.contarFamiliares());
				}

				break;
			}

			case 6: {// "6. Mostrar para cada una de las calles del recinto ferial el n�mero de
						// casetas de tipo Distrito que existen. \r\n"

				for (Calle c : calles) {
					System.out.println(c.getCalle() + ": " + c.contarDistrito());
				}

				break;
			}

			case 7: {// 7. Eliminar una caseta
				String idCaseta = leerString("Dame el id de la caseta: ");

				Caseta ca = new Caseta(null, null, null, null, idCaseta, null);

				boolean encontrado = false;
				Iterator<Calle> siguiente = calles.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Calle c = siguiente.next();
					if (c.borrarCaseta(ca)) {
						encontrado = true;
						System.out.println("Se ha borrado la calle existosamente.");
					}

				}

				break;
			}

			case 8: {
//				escribirFichero();
				System.out.println("\nGracias");
				break;
			}

			}
		} while (opc != 8);

	}

//	public static String contarPorCalles(String clase) {
//		HashMap<String, Integer> listaCalles = new HashMap<>();
//		for (Calle c : calles) {
//			Integer numero = 0;
//			if (listaCalles.containsKey(c.getCalle())) {
//				if (c.getClase().equals(clase)) {
//					numero = listaCalles.get(c.getCalle());
//					listaCalles.put(c.getCalle(), numero + 1);
//				}
//
//			} else if (c.getClase().equals(clase)) {
//				listaCalles.put(c.getCalle(), 1);
//			} else
//				listaCalles.put(c.getCalle(), 0);
//
//		}
//
//		return listaCalles.toString();
//	}

	public static void menu() {
		System.out.println("\n1. Mostrar todas las casetas existentes en una calle. \r\n"
				+ "2. Mostrar todas las casetas de tipo familiar. \r\n"
				+ "3. Mostrar todas las casetas de tipo Distrito \r\n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \r\n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo familiar que existen. \r\n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el n�mero de casetas de tipo Distrito que existen. \r\n"
				+ "7. Eliminar una caseta.\r\n" + "8. Salir.");
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static void leerFichero() {
		File fileLectura = new File("ficheros//casetasferia.xml");

		Calle c = null;
		Caseta ca = null;
		String titulo = "";
		String calle = "";
		String numero = "";
		String modulos = "";
		String clase = "";
		String entidad = "";
		String id = "";
		String idCalle = "";

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fileLectura);
			// Normalizamos el documento
			doc.getDocumentElement().normalize();

			// Tenemos que obtener la lista de nodos
			NodeList listaCalles = doc.getElementsByTagName("DatosLeidos");

			// Y recorrer los nodos
			for (int temp = 0; temp < listaCalles.getLength(); temp++) {

				// Cogemos el nodo del padre
				Node hijo = listaCalles.item(temp);

				// Si el nodo es de tipo elemento, lo obtenemos
				if (hijo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) hijo;

					NodeList p1 = elemento.getElementsByTagName("TITULO");
					if (p1.getLength() != 0) {
//						System.out.println("Titulo: " + elemento.getElementsByTagName("TITULO").item(0).getTextContent());
						titulo = elemento.getElementsByTagName("TITULO").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("CALLE");
					if (p1.getLength() != 0) {
//						System.out.println("Calle: " + elemento.getElementsByTagName("CALLE").item(0).getTextContent());
						calle = elemento.getElementsByTagName("CALLE").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("NUMERO");
					if (p1.getLength() != 0) {
//						System.out.println("Numero: " + elemento.getElementsByTagName("NUMERO").item(0).getTextContent());
						numero = elemento.getElementsByTagName("NUMERO").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("MODULOS");
					if (p1.getLength() != 0) {
//						System.out.println("Modulos: " + elemento.getElementsByTagName("MODULOS").item(0).getTextContent());
						modulos = elemento.getElementsByTagName("MODULOS").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("CLASE");
					if (p1.getLength() != 0) {
//						System.out.println("Clase: " + elemento.getElementsByTagName("CLASE").item(0).getTextContent());
						clase = elemento.getElementsByTagName("CLASE").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("ENTIDAD");
					if (p1.getLength() != 0) {
//						System.out.println("Entidad: " + elemento.getElementsByTagName("ENTIDAD").item(0).getTextContent());
						entidad = elemento.getElementsByTagName("ENTIDAD").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("ID");
					if (p1.getLength() != 0) {
//						System.out.println("ID: " + elemento.getElementsByTagName("ID").item(0).getTextContent());
						id = elemento.getElementsByTagName("ID").item(0).getTextContent();
					}

					p1 = elemento.getElementsByTagName("ID_CALLE");
					if (p1.getLength() != 0) {
//						System.out.println("ID de la calle: "+ elemento.getElementsByTagName("ID_CALLE").item(0).getTextContent());
						idCalle = elemento.getElementsByTagName("ID_CALLE").item(0).getTextContent();
					}

//					System.out.println("\n");

					c = new Calle(calle, idCalle);
					if (!calles.contains(c)) {
						calles.add(c);
//						System.out.println(c.toString());
					}

					ca = new Caseta(titulo, modulos, clase, entidad, id, numero);
					for (Calle cal : calles) {
						if (cal.getIdCalle().equals(idCalle)) {
							cal.addCaseta(ca);
//							System.out.println(ca.toString());
						}

					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

//	public static void escribirFichero() {
//
//		File fileEscritura = new File("ficheros//casetasferia.xml");
//
//		try {
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//			// El documento que vamos a crear
//			Document docEscritura = docBuilder.parse(fileEscritura);
//
////			Element rootElement = docEscritura.createElement("Primero"); Esto lo he tenido que quitar pq cuando me escribia el xml no me lo leia despues
////			((Node) docEscritura).appendChild(rootElement);
//
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(docEscritura);
//			StreamResult result = new StreamResult(fileEscritura);
//			transformer.transform(source, result);
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}

}
