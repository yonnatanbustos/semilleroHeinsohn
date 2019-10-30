package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

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

	// TODO
	/**
	 * Pendiente hacer un metodo que use el metodo toSting() de la entidad COMIC
	 */
	@Test
	public void testToStringComic() {
		Comic comic = new Comic();
		comic.setId("1");
		comic.setNombre("EL EJERCITO DEL CAPITAN AMERICA");
		comic.setAutores("Phillippe Briones, Roger Stern");
		comic.setEditorial("Panini Comics");
		comic.setColeccion("BIBLIOTECA MARVEL");
		comic.setColor(true);
		comic.setCantidad(1L);
		comic.setEstadoEnum(EstadoEnum.ACTIVO);
		comic.setFechaVenta(LocalDate.now());
		comic.setPrecio(new BigDecimal(12.83));
		comic.setNumeroPaginas(114);
		comic.setTematicaEnum(TematicaEnum.FANTASTICO);

		comic.toString();
		System.out.println(comic.toString());
	}

	/**
	 * 
	 * Metodo encargado de realizar la prueba unitaria del enum EstadoEnum <b>Caso
	 * de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test
	public void testEstadoEnum() {
		// Instancia del EstadoEnum
		EstadoEnum estadoEnumActivo = EstadoEnum.ACTIVO;
		EstadoEnum estadoEnumInactivo = EstadoEnum.INACTIVO;

		// Devuelve el nombre de la constante
		String nombreConstante = estadoEnumActivo.name();

		// Devuelve el nombre de la constante de toString
		String nombreToString = estadoEnumActivo.toString();

		// Devuelve el la posicion del enum
		int posicion = estadoEnumActivo.ordinal();

		// Comparacion entre enum
		int estadoComparacion = estadoEnumActivo.compareTo(estadoEnumInactivo);

		// Devuelve el array con todos los enum
		EstadoEnum array[] = EstadoEnum.values();

		Assert.assertEquals(estadoEnumActivo, estadoEnumInactivo);
		Assert.assertNotEquals(estadoEnumActivo, estadoEnumInactivo);

	}

}
