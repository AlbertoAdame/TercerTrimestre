package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;
import com.jacaranda.diccionario.DiccionarioException;
import com.jacaranda.palabrasEmpiezan.PalabrasEmpiezanException;

public class Main {

	public static void main(String[] args) throws DiccionarioException {
		// TODO Auto-generated method stub

		Diccionario d= new Diccionario();
		
		System.out.println(d.listarDiccionario());
		d.addPalabra("Tornillo", "va atornillado");
		
	}

}
