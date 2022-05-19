package com.jacaranda.address;

import java.util.Objects;

public class Address {

	private int id_address;
	private String address;

	public Address(int id_address, String address) {
		super();
		this.id_address = id_address;
		this.address = address;
	}

	public int getId_address() {
		return id_address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_address);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id_address == other.id_address;
	}

	
	
	@Override
	public String toString() {
		return "id_address=" + id_address + ", address= " + address + "\n";
	}

}
