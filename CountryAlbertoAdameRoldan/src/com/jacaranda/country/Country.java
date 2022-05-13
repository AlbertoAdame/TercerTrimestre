package com.jacaranda.country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.lang.Comparable;

import com.jacaranda.city.City;

public class Country {

	private String country;
	private int countryId;
	private List<City> ciudades;

	public Country(String country, int countryId) {
		super();
		this.country = country;
		this.countryId = countryId;
		this.ciudades = new ArrayList<>();// utilizaremos arrayList, pq linkedList renta cuando hay muchas cosas que borrar, y aqui no borraremos
	}

	public void addCiudad(City ciudad) throws CountryException {

		if (ciudades.contains(ciudad))
			throw new CountryException("Esta ciudad ya existe");

		ciudades.add(ciudad);

	}

	public String getCountry() {
		return country;
	}

	public int getCountryId() {
		return countryId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryId, other.countryId);
	}

	@Override
	public String toString() {
		return "Pais: " + country + "\nCountryId: " + countryId + "\nCiudades: " + ciudades.toString() + "\n";
	}

	public City encontrarCiudad(int idCity) {
		boolean encontrado = false;
		City c = new City("", idCity);
		City resultado = null;

		int posicion = ciudades.indexOf(c);

		if (posicion != -1)
			resultado = ciudades.get(posicion);

		return resultado;

	}

	public String escribirFichero() {
		StringBuilder resultado = new StringBuilder();

		Collections.sort(ciudades);
		
		for (City c : ciudades) {
			resultado.append(c.escribirFichero());
		}
		return "Pais: " + country + "\nCountryId: " + countryId + "\nNumeroCiudades: " + ciudades.size() + "\n"
				+ resultado;

	}
	
	public String escribirCiudades() {
		StringBuilder resultado= new StringBuilder();
		String todo;
		
		Collections.sort(ciudades);
		
		for(City c: ciudades) {
			resultado.append(c.escribirDirecciones());
		}
			todo=("Pais: " + country + "\nCountryId: " + countryId + "\n" + resultado);
		return todo;
	}

}
