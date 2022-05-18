package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Diccionario d= new Diccionario();
		d.anadirPalabra("Hola", "significado 1");
		d.anadirPalabra("Adios", "significado 3");
		d.anadirPalabra("Holograma", "significado 10");
		System.out.println(d);
		d.anadirPalabra("Hola", "significado 3");
		System.out.println(d);
		System.out.println(d.buscarPalabra("Hola"));
		System.out.println(d.empiezanPor("H"));
		
	}

}
