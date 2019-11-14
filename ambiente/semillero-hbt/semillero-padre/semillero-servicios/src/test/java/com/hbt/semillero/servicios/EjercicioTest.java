/**
 * EjercicioTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina los ejercicios de la maraton de programacion.
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
public class EjercicioTest {
	private static String brand;
	private static boolean empty;
	
	
	@Test
	public static void ejercicio2() {
		//WaterBottle wb = new WaterBottle();
		System.out.println("Empty= "+empty);
		System.out.println("Brand= "+brand);
	}
	@Test
	public void ejercicio1() {
		
	}
	
	/**
	 * 
	 * Metodo encargado de de la prueba de un numero primo
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test
	public void ejercicio3() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(5));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(222));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(0));
	}
	
	

}
