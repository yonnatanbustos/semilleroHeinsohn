/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author 
 * @version 
 */
public class EjerciciosPOJO {
	public int [] arreglo =new  int [4];
	int i=0;

	public boolean ejercicio1(String identificador) {
		boolean estado=false;
		if(identificador == null || identificador.indexOf(" ")==-1
				|| Character.isDigit(identificador.charAt(0))) {
			return false;
		}else {
			for(int i=0;i<identificador.length();i++) {
			if(identificador.charAt(i)=='.') {
					estado = false;
				}
			}
			if(identificador.equals("true")||identificador.equals("true")) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Metodo encargado de saber si un numero es primo 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param numero
	 * @return
	 */
	public boolean ejercicio3(int numero) {
		int i =0;
		int cont=0;
		while(i<numero) {
			if(numero%i==0) {
				cont++;
			}
			i++;
		}
		
		if(cont>2) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * Metodo encargado de validar la suma de la fecha de nacimiento y la edad
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	public int ejercicio4(LocalDate fehcaNacimiento) {
		
		int edad = 22;
		
		return fehcaNacimiento.getYear()+edad;
		
		
		
	}
	
	/**
	 * 
	 * Metodo encargado de ordenar un arreglo
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	public void ejercicio5() {
		
		for(int j=0;j<arreglo.length;j++) {
			for(int k=0;k<arreglo.length-1;k++) {
				if(arreglo[k]>arreglo[k+1]) {
					int aux = arreglo[k];
					arreglo[k]=arreglo[k+1];
					arreglo[k+1]= aux;
				}
			}
		}
	}
	
	/**
	 * Metodo encargado de ingresar valores al arreglo
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param numero
	 */
	public void ingresarValores(int numero) {
		arreglo[i]= numero;
	}
	
	

	
}
