package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}
	
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;

	}
	/**
	 * Prueba unitaria para una cadena invertida
	 */
	@Test
	public void segundaPU() {
		String cadena = "hola mundo";
		String cadenaInvertida = "odnum aloh";
		String cadenaEsperada = invertirCadena(cadena);
		Assert.assertEquals(cadenaInvertida, cadenaEsperada);
		Assert.assertNotEquals(cadena, cadenaEsperada);

}

	
	
}
