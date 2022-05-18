package com.jacaranda.combinacion;

import java.util.HashSet;
import java.util.Objects;

public class Combinacion {

	private HashSet<Integer> numeros;
	private HashSet<Integer> estrellas;
	public static final int NUMEROMENOR = 1;
	public static final int ESTRELLAMENOR = 1;
	public static final int NUMEROMAYOR = 50;
	public static final int ESTRELLAMAYOR = 12;

	public Combinacion(int uno, int dos, int tres, int cuatro, int cinco, int estrellauno, int estrellados) {
		super();
		this.numeros = new HashSet<>();
		esNumero(uno);
		esNumero(dos);
		esNumero(tres);
		esNumero(cuatro);
		esNumero(cinco);

		this.estrellas = new HashSet<>();
		esEstrella(estrellauno);
		esEstrella(estrellados);
	}

	public void esNumero(int numero) {
		if (numero >= NUMEROMENOR && numero <= NUMEROMAYOR)
			numeros.add(numero);

	}

	public void esEstrella(int numero) {
		if (numero >= ESTRELLAMENOR && numero <= ESTRELLAMAYOR)
			estrellas.add(numero);
	}

	public String imprimirNumeros() {
		String resultado = "";
		int contador = 0;
		for (Integer i : numeros) {
			if (contador == 0) {
				resultado += i;
				contador++;
			}

			else
				resultado += "-" + i;
		}
		return resultado;

	}

	public String imprimirEstrellas() {
		String resultado = "";
		int contador = 0;
		for (Integer i : estrellas) {

			if (contador == 0) {
				resultado += i;
				contador++;
			} else
				resultado += "-" + i;
			contador++;
		}
		return resultado;

	}

	public String imprimirCadena() {
		return imprimirCadena() + " Estrellas: " + imprimirEstrellas();
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}

	public int aciertos(Combinacion combinacion) {
		int resultado = 0;

		for (Integer i : combinacion.numeros) {
			if (numeros.contains(i)) {
				resultado++;
			}

		}

		for (Integer i : combinacion.estrellas) {
			if (estrellas.contains(i)) {
				resultado++;
			}

		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Combinacion [numeros=" + numeros + ", estrellas=" + estrellas + "]";
	}
	
	

}
