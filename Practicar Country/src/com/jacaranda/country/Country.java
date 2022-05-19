package com.jacaranda.country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import com.jacaranda.city.City;

public class Country {

	private int country_id;
	private String country;
	private ArrayList<City> ciudades;

	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.ciudades = new ArrayList<>();
	}
	
	public void addCiudad(City ciudad) throws CiudadException {
		if(ciudad == null)
			throw new CiudadException("Esta ciudad es nula");
		else
			ciudades.add(ciudad);
	}

	public int getCountry_id() {
		return country_id;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id);
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
		return country_id == other.country_id;
	}

	public City encontrarCiudad(int id_ciudad) {
		City c = new City(id_ciudad, "nada");
		City resultado = null;
		if(ciudades.contains(c))
			resultado = ciudades.get(ciudades.indexOf(c));
		return resultado;
	}
	
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", ciudades=" + ciudades.toString() + "]";
	}

	public String imprimirCantidadCiudades() {
		int cantidad = 0;
		
		Collections.sort(ciudades);
		
		StringBuilder resultado = new StringBuilder();
		for(City c : ciudades) {
			resultado.append( c.imprimirCantidadAddress() + " ");
		}
		
		return this.country + " NumeroCiudades: " + ciudades.size() +"\n" + resultado + "\n"; 
		
	}

	public String imprimirTodo() {
		int cantidad = 0;
		
		OrdenarSoloNombre ordenar = new OrdenarSoloNombre();
		Collections.sort(ciudades, ordenar);
		
		StringBuilder resultado = new StringBuilder();
		for(City c : ciudades) {
			resultado.append(c.imprimirTodoAddress());
		}
		
		return this.country + ", id: " + this.country_id  +"\n" + resultado ; 
		
	}
	
}
