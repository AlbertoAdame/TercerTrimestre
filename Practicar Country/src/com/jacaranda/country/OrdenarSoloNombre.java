package com.jacaranda.country;

import java.util.Comparator;

import com.jacaranda.city.City;

public class OrdenarSoloNombre implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		if(o1 == null || o2 == null)
			return -1;
		
		return o1.getCity().compareTo(o2.getCity());
	}

}
