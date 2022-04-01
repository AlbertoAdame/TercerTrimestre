package com.jacaranda.utilities.main;

import com.jacaranda.utilities.provincia.Provincia;
import com.jacaranda.utilities.provincia.ProvinciaException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Provincia pr1, pr2, pr3, pr4, pr5, pr6, pr7;
		
		try {
			pr1= new Provincia("Malaga", "20561");
//			pr2= new Provincia(null, "20563");
//			pr3= new Provincia("Jaen", null);
//			pr4= new Provincia("Angola", "1");
//			pr5= new Provincia("Angola", "132");
			pr1.addPueblo("Lora", "89", 20561, 1500, 35000);
//			pr1.addPueblo("Lora", "89", 20561, 1500, 35000);
//			pr1.addPueblo("Perno", null, 20561, 1500, 35000);
//			pr1.addPueblo(null, "8961", 20561, 1500, 35000);
//			pr1.setRentaPerCapita(-200);
//			pr1.setSuperficie(-200);
//			pr1.setNumeroHabitantes("Lora", -200);
			System.out.println(pr1.getInFormacionPueblo("Lora"));
			System.out.println(pr1);
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
	}

}
