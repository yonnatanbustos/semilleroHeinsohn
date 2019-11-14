/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author 
 * @version 
 */
public class EjerciciosPOJO {

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
	
	

	
}
