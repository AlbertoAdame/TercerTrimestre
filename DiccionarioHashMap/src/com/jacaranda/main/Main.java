package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;

public class Main {

	public static void main(String[] args) {
		Diccionario d= new Diccionario();
		d.anadirPalabra("Hola", "significado 1");
		d.anadirPalabra("Adios", "significado 3");
		System.out.println(d);
		d.anadirPalabra("Hola", "significado 3");
		System.out.println(d);
		
		

	}

}
