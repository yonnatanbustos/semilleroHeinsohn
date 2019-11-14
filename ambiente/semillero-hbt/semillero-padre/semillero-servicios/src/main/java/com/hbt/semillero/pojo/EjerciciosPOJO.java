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
		
		for(int j=0;j<arreglo.length; j++) {
			System.out.println(arreglo[j] +" ");
		}
		System.out.println(arreglo.length);
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
		i++;
	}
	
	/**
	 * 
	 * Metodo encargado de saber quien es el ganador de un partido de tenis 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param arreglo1
	 * @param arreglo2
	 * @return
	 */
	public int ejercicio7(int arreglo1[], int arreglo2[]) {
		int ganador1=0;
		int ganador2=0;
		for (int i = 0; i < arreglo1.length; i++) {
			if(arreglo1[i]>arreglo2[i]) {
				ganador1++;
			}else {
				ganador2++;
			}
			
		}
		
		if(ganador1>ganador2) {
			return 1;
		}else {
			return 0;
		}
		
		
	}
	
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	public String  ejercicio8(Integer cambio) {
		Integer mil=0;
		Integer quinientos=0;
		Integer docientos=0;
		Integer cien=0;
		Integer cincuenta=0;
		String respuesta = "";
		Double resultado=cambio/1000.0;
		while(resultado>=0) {
			if(resultado>0) {
				mil++;
				resultado = resultado/100;
			}
			if(resultado>=0.5 && resultado<=1) {
				quinientos++;
				resultado = resultado/500;
			}else if(resultado<0.5 && resultado >0.2) {
				docientos++;
				resultado= resultado/200;
			}else if(resultado<0.2&& resultado>0.1) {
				cien ++;
				resultado = resultado/100;
			}else if(resultado<0.1) {
				cincuenta++;
				resultado = resultado/50;
			}
		}
		respuesta = "Mil:"+mil+"Quinientos:"+quinientos+"Docientos:"+docientos+"Cien:"+cien+"cincuenta:"+cincuenta;
		return respuesta;

	}
	
	
	
	/**
	 * 
	 * Metodo encargado de de compilar codigo 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @throws Exception
	 */
	public void ejercicio9() throws Exception {
		
		throw new Exception();
		
		
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de saber la secuencia de numeros
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	public String ejercicio11(Integer numero) {
		
	Double n1 = numero/10.0;
	
	String aux = String.valueOf(n1);
	
	String data[] = aux.split(",");
	
	String respuesta = data[0] + data[1];
	return respuesta;
	
	
	
		
		
	 
		
	}
	
	

	
}
