package com.jacaranda.historial;

import java.time.LocalDate;
import java.util.Comparator;

public class ComprobarDescendente implements Comparator<LocalDate> {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		// TODO Auto-generated method stub
		return -o1.compareTo(o2);
	}

}
