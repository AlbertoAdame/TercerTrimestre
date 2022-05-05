package com.jacaranda.combinacion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Combinacion {
	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	private static final int MAXIMONUMEROS = 50;
	private static final int MAXIMOESTRELLAS = 12;
	private static final int NUMERODENUMEROS = 5;
	private static final int NUMERODEESTRELLAS = 2;

	public Combinacion(int numeroUno, int numeroDos, int numeroTres, int numeroCuatro, int numeroCinco, int estrellaUno,
			int estrellasDos) throws CombinacionException {
		super();
		this.numeros = new HashSet<>(); // Hemos escogido un hashSet pq no necesitamos una enumeacion (lista), ni borrar
										// cosas del centro
		addNumero(numeroUno);
		addNumero(numeroDos);
		addNumero(numeroTres);
		addNumero(numeroCuatro);
		addNumero(numeroCinco);
		this.estrellas = new HashSet<>();
		addEstrella(estrellaUno);
		addEstrella(estrellasDos);
	}

	private void addNumero(int numero) throws CombinacionException {
		if (numero < 0 || numero > MAXIMONUMEROS)
			throw new CombinacionException("Numero no válido");
		this.numeros.add(numero);
	}

	private void addEstrella(int numero) throws CombinacionException {
		if (numero < 0 || numero > MAXIMOESTRELLAS)
			throw new CombinacionException("Numero de estrellas no válido");
		this.estrellas.add(numero);
	}

	public String toStringNumeros() {
		StringBuilder resultado = new StringBuilder("Numeros\n");

//		Iterator<Integer> siguiente = numeros.iterator();
//		while (siguiente.hasNext()) {
//			Integer i = siguiente.next();
//			resultado.append(i + "-");
//
//		}

		int i = 0; // De esta forma es más correcto, pq el iterator se usa para cuando queremos
					// salir cuando lo encontremos
		for (Integer num : numeros) {
			if (i == 0) {
				resultado.append(num);
				i++;
			} else
				resultado.append("-" + num);
		}

		return resultado.toString();

	}

	public String toStringEstrellas() {
		StringBuilder resultado = new StringBuilder("Estrellas\n");

//		Iterator<Integer> siguiente = estrellas.iterator();
//		while (siguiente.hasNext()) {
//			Integer i = siguiente.next();
//			resultado.append(i + "-");
//
//		}

		int i = 0; // De esta forma es más correcto, pq el iterator se usa para cuando queremos
					// salir cuando lo encontremos
		for (Integer num : estrellas) {
			if (i == 0) {
				resultado.append(estrellas);
				i++;
			} else
				resultado.append("-" + estrellas);
		}

		return resultado.toString();
	}

	public String toStringCompleto() {

		return this.toStringNumeros() + " Estrellas: " + this.toStringEstrellas();
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

	public int comprobarAciertos(Combinacion combinacion) {
//		int contador = 0;
//
//		Iterator<Integer> siguiente = combinacion.numeros.iterator();
//		while (siguiente.hasNext()) {
//			Integer i = siguiente.next();
//			if ((this.numeros.contains(i)))
//				contador++;
//
//		}
//
//		Iterator<Integer> siguienteDos = combinacion.estrellas.iterator();
//		while (siguienteDos.hasNext()) {
//			Integer i = siguienteDos.next();
//			if ((this.estrellas.contains(i)))
//				contador++;
//
//		}
		
		int resultado=0;
		for(Integer num: combinacion.numeros) {
			if(this.numeros.contains(num))
				resultado++;
		}
		
		for(Integer num: combinacion.estrellas) {
			if(this.estrellas.contains(num))
				resultado++;
		}
		return resultado;
	}
}
