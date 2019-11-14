/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para GestionarComicPOJO. 
 * <b>Caso de Uso:<b>
 * 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version
 */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * Metodo encargado de realizar la prueba de la sesion tres. 
	 * <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 *
	 */
	@Test(enabled = false)
	public void crearComicDTOTest() {
		//Creando el primer comicDTO
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());

		
		//Creando el segundo comicDTO
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("102");
		comicDTO.setNombre("Captain America Corps 1-5 USA");
		comicDTO.setEditorial("Panini Comics");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("BIBLIOTECA MARVEL");
		comicDTO.setNumeroPaginas(128);
		comicDTO.setPrecio(new BigDecimal(5000));
		comicDTO.setAutores("Phillippe Briones, Roger Stern");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(5L);
		
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		
		//Creando el tercer comicDTO
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
		System.out.println(gestionarComicPOJO.getListaComics().size());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
		
		//Modificar el comicDTO con el id=102, con el nombre=EL EJERCITO DEL CAPITAN AMERICA
		String nombreNuevo= "EL EJERCITO DEL CAPITAN AMERICA";
		String valorEsperado = "Si se modifico";
		String valorReal = gestionarComicPOJO.modificarComicDTO("102", nombreNuevo);
		Assert.assertEquals(valorReal, valorEsperado);
		
		//Eliminar el comitDTO con el id =101
		comicDTO = gestionarComicPOJO.buscarComicDTO("101");
		Assert.assertNotNull(comicDTO);
		gestionarComicPOJO.eliminarComicDTO("101");
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==2, "Se elimino correctamente");
		comicDTO = gestionarComicPOJO.buscarComicDTO("101");
		Assert.assertNull(comicDTO);
		
		
	}
	


}
