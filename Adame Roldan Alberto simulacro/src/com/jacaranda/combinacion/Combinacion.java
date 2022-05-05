package com.jacaranda.combinacion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Combinacion {
	private Set<Integer> numeros;
	private Set<Integer> estrellas;

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
		if (numero < 0)
			throw new CombinacionException("No puede ser un numero negativo");
		this.numeros.add(numero);
	}

	private void addEstrella(int numero) throws CombinacionException {
		if (numero < 0)
			throw new CombinacionException("No puede ser un numero negativo");
		this.estrellas.add(numero);
	}

	public String toStringNumeros() {
		StringBuilder resultado = new StringBuilder("Numeros\n");

		Iterator<Integer> siguiente = numeros.iterator();
		while (siguiente.hasNext()) {
			Integer i = siguiente.next();
			resultado.append(i + "-");

		}
		return resultado.toString();

	}

	public String toStringEstrellas() {
		StringBuilder resultado = new StringBuilder("Estrellas\n");

		Iterator<Integer> siguiente = estrellas.iterator();
		while (siguiente.hasNext()) {
			Integer i = siguiente.next();
			resultado.append(i + "-");

		}
		return resultado.toString();
	}

	public String toStringCompleto() {
		StringBuilder resultado = new StringBuilder(" ");

		Iterator<Integer> siguienteDos = numeros.iterator();
		while (siguienteDos.hasNext()) {
			Integer i = siguienteDos.next();
			resultado.append(i + "-");
		}

		Iterator<Integer> siguiente = estrellas.iterator();
		while (siguiente.hasNext()) {
			Integer i = siguiente.next();
			resultado.append(i + "-" );

		}

		return resultado.toString();
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
		int contador = 0;

		Iterator<Integer> siguiente = combinacion.numeros.iterator();
		while (siguiente.hasNext()) {
			Integer i = siguiente.next();
			if ((this.numeros.contains(i)))
				contador++;

		}

		Iterator<Integer> siguienteDos = combinacion.estrellas.iterator();
		while (siguienteDos.hasNext()) {
			Integer i = siguienteDos.next();
			if ((this.estrellas.contains(i)))
				contador++;

		}
		return contador;
	}
}
