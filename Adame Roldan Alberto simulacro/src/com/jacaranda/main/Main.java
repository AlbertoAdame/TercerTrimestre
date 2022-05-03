package com.jacaranda.main;

import com.jacaranda.combinacion.Combinacion;
import com.jacaranda.combinacion.CombinacionException;
import com.jacaranda.historial.Historial;

public class Main {

	public static void main(String[] args) throws CombinacionException {
		// TODO Auto-generated method stub
		
		Combinacion c = new Combinacion(0, 4, 5, 7, 2, 1, 9);
		Combinacion c1 = new Combinacion(0, 4, 5, 7, 3, 1, 9);
		System.out.println(c.toStringNumeros());
		System.out.println(c.toStringEstrellas());
		System.out.println(c.toStringCompleto());
		System.out.println(c.comprobarAciertos(c1));
		
		Historial h = new Historial();
		
		
	}

}
