package com.jacaranda.combinacion;

import java.time.LocalDate;
import java.util.Comparator;

public class OrdenarDescendente implements Comparator<LocalDate> {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		if(o1== null || o2==null)
			return -1;
		return -o1.compareTo(o2);
	}

}
