package com.jacaranda.persona;

import java.util.Comparator;

import com.jacaranda.mensaje.Mensaje;

public class OrdenarPorFecha implements Comparator<Mensaje> {

	@Override
	public int compare(Mensaje o1, Mensaje o2) {
		if(o1 == null || o2==null)
			return -1;
		return -o1.getFecha().compareTo(o2.getFecha());
	}

}
