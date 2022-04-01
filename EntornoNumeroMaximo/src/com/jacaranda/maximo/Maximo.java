package com.jacaranda.maximo;

import java.util.Scanner;

public class Maximo {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a, b, c;

		a = leerInt("Dame el valor de a: ");
		b = leerInt("Dame el valor de b: ");
		c = leerInt("Dame el valor de c: ");

		System.out.println(maximo(a, b, c));

	}

	public static int maximo(int a, int b, int c) {

		int resultado;
		if (a > b) {
			if (a > c) {
				resultado = a;
			} else {
				resultado = c;
			}

		}

		else {
			if (b > c) {
				resultado = b;
			} else {
				resultado = c;
			}
		}
		return resultado;
	}

	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

}
