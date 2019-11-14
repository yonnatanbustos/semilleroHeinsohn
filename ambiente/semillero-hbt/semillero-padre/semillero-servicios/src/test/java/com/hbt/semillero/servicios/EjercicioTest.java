/**
 * EjercicioTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;

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
	
	
	@Test(enabled=false)
	public static void ejercicio2() {
		//WaterBottle wb = new WaterBottle();
		System.out.println("Empty= "+empty);
		System.out.println("Brand= "+brand);
	}
	@Test(enabled=false)
	public void ejercicio1() {
		
	}
	
	/**
	 * 
	 * Metodo encargado de de la prueba de un numero primo
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test(enabled=false)
	public void ejercicio3() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(5));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(222));
		Assert.assertTrue(ejerciciosPOJO.ejercicio3(0));
	}
	
	/**
	 * 
	 * Metodo encargado de validar la prueba unitaria del año
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void ejercicio4() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();

		LocalDate fechaNacimiento = LocalDate.of(1997, 01, 14);
		int resultado = ejerciciosPOJO.ejercicio4(fechaNacimiento);
		Assert.assertEquals(resultado, 2019);
	}
	
	/**
	 * 
	 * Metodo encargado de hacer la prueba unitaria del ordenamiento del arreglo
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test(enabled=false)
	public void ejercicio5() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		 
		ejerciciosPOJO.ingresarValores(50);
		ejerciciosPOJO.ingresarValores(1);
		ejerciciosPOJO.ingresarValores(249);
		ejerciciosPOJO.ingresarValores(-2);
		
		ejerciciosPOJO.ejercicio5();
		int resultado1= ejerciciosPOJO.arreglo[0];
		int resultado2= ejerciciosPOJO.arreglo[ejerciciosPOJO.arreglo.length];
		
		
		Assert.assertEquals(resultado1, -2);
		Assert.assertEquals(resultado2, 249);
		

	}
	
	/**
	 * 
	 * Metodo encargado de hacer la prueba unitaria de un partido de tenis
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test
	public void ejercicio7() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();

		int federer[]= {3,2};
		int thiem []= {6,6};
		
		int resultado = ejerciciosPOJO.ejercicio7(federer, thiem);
		
		// 1 si ganado federer o 0 si gano thiem
		Assert.assertEquals(1, resultado);
		Assert.assertEquals(0, resultado);
		
	}
	
	/**
	 * 
	 * Metodo encargado de hacer la prueba unitaria 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	@Test
	public void ejercicio8() {
		
	}
	
	

}
