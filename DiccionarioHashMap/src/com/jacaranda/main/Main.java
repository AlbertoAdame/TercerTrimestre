package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;
import com.jacaranda.diccionario.DiccionarioException;

public class Main {

	public static void main(String[] args) throws DiccionarioException {
		Diccionario d= new Diccionario();
		d.anadirPalabra("Hola", "significado 1");
		d.anadirPalabra("Adios", "significado 3");
		d.anadirPalabra("Holograma", "significado 10");
		System.out.println(d);
		d.anadirPalabra("Hola", "significado 3");
		System.out.println(d);
		System.out.println(d.listarUnaPalabra("Hola"));
		System.out.println(d.listarPalabrasEmpiezanPor("H"));
		

	}

}
