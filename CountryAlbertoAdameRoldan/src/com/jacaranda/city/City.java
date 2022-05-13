package com.jacaranda.city;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.address.Address;

public class City implements Comparable<City> {

	private String city;
	private int cityId;
	private List<Address> direcciones;

	public City(String city, int cityId) {
		super();
		this.city = city;
		this.cityId = cityId;
		
		this.direcciones = new LinkedList<>();// utilizaremos linkedList, pq arrayList renta cuando hay muchas cosas qeu borrar, y aqui no borraremos
	}

	public void addAddress(Address direccion) throws ExceptionCity {
		if (direccion == null)
			throw new ExceptionCity("La direccion es nula");
		direcciones.add(direccion);
	}
	
	public String getCity() {
		return city;
	}

	public int getCityId() {
		return cityId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(cityId, other.cityId);
	}

	@Override
	public String toString() {
		return "Ciudad: " + city + "\nCityId: " + cityId + "\nDirecciones: " + direcciones.toString() + "/n";
	}

	public String escribirFichero() {
		return this.city + ": " + direcciones.size() + "\n";
	}

	@Override
	public int compareTo(City o) {
		int resultado =o.direcciones.size()-this.direcciones.size();
		if(resultado==0)
			resultado=this.city.compareTo(o.city);
		return resultado;
	}
	
	public String escribirDirecciones() {
		StringBuilder resultado = new StringBuilder();
		String todo;
		for(Address a : direcciones) {
			resultado.append( a.getAddress() + "  ");
		}
		todo=("Ciudad: "+ this.getCity() + " Direcciones: " + resultado + "\n");
		return todo;
	}
}
