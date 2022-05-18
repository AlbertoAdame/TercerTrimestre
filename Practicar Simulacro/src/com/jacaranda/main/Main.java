package com.jacaranda.main;

import java.time.LocalDate;

import com.jacaranda.combinacion.Combinacion;
import com.jacaranda.combinacion.Historial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combinacion comb = null;
		Combinacion ganadora = null;

			comb = new Combinacion(4, 8, 50, 10, 2, 1, 5);

		
		
		System.out.println("Números: " + comb.imprimirNumeros());
		System.out.println("Estrellas: " + comb.imprimirEstrellas());
		System.out.println(comb.toString());

		ganadora = new Combinacion(28, 5, 48, 10, 2, 3, 4);

		
		
	
		System.out.println("Aciertos: " + comb.aciertos(ganadora));

		Historial historial = new Historial();
			historial.addSorteo(LocalDate.parse("2022-01-07"), ganadora);
			historial.addSorteo(LocalDate.parse("2022-01-08"), ganadora);
//			historial.actualizarSorteo(LocalDate.parse("2022-01-07"), comb);
//			historial.removeSorteo(LocalDate.parse("2022-01-08"));
//			System.out.println(historial.compruebaAciertos(LocalDate.parse("2022-01-08"), comb));
//			System.out.println(historial.compruebaAciertos(LocalDate.parse("2022-01-07"), null));
			historial.addSorteo(LocalDate.parse("2022-01-05"), comb);
			historial.addSorteo(LocalDate.parse("2022-01-25"), comb);
//			System.out.println(historial.sorteosDeMes(2));
//			System.out.println(historial.sorteosDeMes(1));
			System.out.println(historial.imprimirHistorialAsc());
			System.out.println(historial.imprimirHistorialDesc());

		System.out.println(historial.toString());
	
		
	}

}
