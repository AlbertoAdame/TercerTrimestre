package com.jacaranda.city;

import java.util.ArrayList;
import java.util.Objects;

import com.jacaranda.address.Address;

public class City implements Comparable<City> {

	private int city_id;
	private String city;
	private ArrayList<Address> direcciones;

	public City(int city_id, String city) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.direcciones = new ArrayList<>();
	}

	public void addAddress(Address direccion) {
		direcciones.add(direccion);
	}

	public int getCity_id() {
		return city_id;
	}

	public String getCity() {
		return city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city_id);
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
		return city_id == other.city_id;
	}

	@Override
	public String toString() {
		return "city_id=" + city_id + ", city=" + city + ", direcciones=" + direcciones.toString() + "]";
	}

	public String imprimirCantidadAddress() {
		return this.city + " numeroDirecciones: " + direcciones.size() + "\n";

	}

	public String imprimirTodoAddress() {
		StringBuilder resultado = new StringBuilder();
		for (Address a : direcciones) {
			resultado.append(a.toString());
		}
		return this.city + " id: " + this.city_id + "\n" + resultado;
	}

	@Override
	public int compareTo(City o) {
		int resultado;
		resultado = o.direcciones.size()-this.direcciones.size();
		if(resultado ==0)
			 resultado =this.getCity().compareTo(o.getCity());
			
		return resultado;
	}

}
