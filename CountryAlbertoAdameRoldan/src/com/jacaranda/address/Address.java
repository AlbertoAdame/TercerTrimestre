package com.jacaranda.address;

import java.util.Objects;

public class Address {
	
	private String address;
	private int addressId;
	
	public Address(String address, int addressId) {
		super();
		this.address = address;
		this.addressId = addressId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(addressId);
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
		return Objects.equals(addressId, other.addressId);
	}

	@Override
	public String toString() {
		return "Direccion: " + address + "\nAddressId: " + addressId + "/n";
	}
	
	
	
	
}
