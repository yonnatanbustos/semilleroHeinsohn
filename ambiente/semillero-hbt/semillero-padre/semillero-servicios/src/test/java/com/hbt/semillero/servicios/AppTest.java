package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias. <b>Caso de
 * Uso:<b>
 * 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version
 */
public class AppTest {

	/**
	 * 
	 * Metodo encargado de realizar la prueba unitaria para la suma de dos numeros.
	 * <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	/**
	 * 
	 * Metodo encargado de invertir una cadena. <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 * 
	 * @param cadena - cadena que se desea invertir
	 * @return cadena - cadena invertida
	 */
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;

	}

	/**
	 * 
	 * Metodo encargado de realizar la prueba unitaria para una cadena invertida.
	 * <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void segundaPU() {
		String cadena = "hola mundo";
		String cadenaInvertida = "odnum aloh";
		String cadenaEsperada = invertirCadena(cadena);
		Assert.assertEquals(cadenaInvertida, cadenaEsperada);
		Assert.assertNotEquals(cadena, cadenaEsperada);
	}

	/**
	 * 
	 * Metodo encargado de realizar la prueba unitaria haciendo uso del metodo
	 * toString. 
	 * <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void testToStringComic() {
		Comic comic = new Comic();
		comic.setId(1L);
		comic.setNombre("EL EJERCITO DEL CAPITAN AMERICA");
		comic.setAutores("Phillippe Briones, Roger Stern");
		comic.setEditorial("Panini Comics");
		comic.setColeccion("BIBLIOTECA MARVEL");
		comic.setColor(Boolean.TRUE);
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
	@Test(enabled = false)
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

	/**
	 * 
	 * Metodo encargado de realizar la prueba de la sesion tres. <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void creartComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		// Creando el primer comic
		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000),
				"Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);

		comicDTO = new ComicDTO();

		comicDTO.setId("102");
		comicDTO.setNombre("Dragon ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(144);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() > 1);

		comicDTO = new ComicDTO();

		comicDTO.setId("103");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Panini Comic");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
	}
	
	@Test
	public void pruebaString() {
		String s1 = "street";
		String s2 = new String("street");
		//Assert.assertEquals(s1, s1);
		Assert.assertTrue(s1.equals(s2));
		
	}

}
