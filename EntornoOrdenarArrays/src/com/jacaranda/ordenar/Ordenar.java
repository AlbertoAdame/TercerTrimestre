package com.jacaranda.ordenar;

public class Ordenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numeros[]= new int[10];
		
//		numeros[0]=0;
		numeros[1]=5;
		numeros[2]=4;
		numeros[3]=2;
		numeros[4]=1;
		numeros[5]=6;
		numeros[6]=8;
		numeros[7]=2;
		numeros[8]=8;
		numeros[9]=1;
		
//		Si ordenamos un array vacio pone todo ceros
//		Con un solo elemtento no da error
//		Con dos no da error
//		Si queda uno sin poner no da error
		
		
		
		
		System.out.println(ordenar(numeros));
//		probamos con array vacio, un elemento, dos elementes, ordenar todos menos 1, otro ordenar todos, y otro que no me acuerdo

	}
	
	public static String ordenar(int numeros[]) {
        int i, j, menor, pos, tmp;
        String resultado="";
        for (i = 0; i < numeros.length - 1; i++) {      
              menor = numeros[i];                                       
              pos = i;                        
              for (j = i + 1; j < numeros.length; j++){
                    if (numeros[j] < menor) {          
                        menor = numeros[j];           
                        pos = j;
                    }
              }
              if (pos != i){                                            
                  tmp = numeros[i];
                  numeros[i] = numeros[pos];
                  numeros[pos] = tmp;
                  
              }
             
        }for (int k = 0; k < numeros.length; k++) {
        	 resultado+=numeros[k]+"\n";
		}
        return resultado;
}
	


	
	
}
