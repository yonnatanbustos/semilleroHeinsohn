/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina la gestion del comicPOJO.
 * <b>Caso de Uso:<b>
 * 
 * @author Yonnatan Eduardo Bustos Rdoriguez <yonnatanbustos97@gmail.com>
 * @version
 */
public class GestionarComicPOJO {

	
	/**
	 * Variable que almacena los comicDTO
	 */
	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de crear un comicDTO 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param id - identificador del comicDTO
	 * @param nombre - nombre del comicDTO
	 * @param editorial - editorial del comicDTO
	 * @param tematica - tematica del comicDTO
	 * @param coleccion - coleccion del comicDTO
	 * @param numeroPaginas - numero de paginas del comicDTO
	 * @param precio - precio del comicDTO
	 * @param autores - autores del comicDTO
	 * @param color - TRUE si el comicDTO es a color o FALSE si el comicDTO no es a color
	 * @param fechaVenta - fecha de venta del comicDTO
	 * @param estado - estado del comicDTO {ACTIVO o INACTIVO}
	 * @param cantidad - cantidad de comicDTO
	 * @return comicDTO
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoEnum estado, Long cantidad) {

		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematica, coleccion, numeroPaginas, precio, autores,
				color, fechaVenta, estado, cantidad);

		return comicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de agregar un comicDTO a la lista.
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param comicDTO - comic que se agregara a la lista
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if(listaComics== null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
		
	}

	/**
	 * 
	 * Metodo encargado de crear un comicDTO 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("101");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);

	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre un comicDTO de la lista. 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param id - identificador del comicDTO
	 * @param nombre - nombre nuevo del comicDTO
	 * @return retorno - indica si el comicDTO se pudo modificar o no.
	 */
	public String modificarComicDTO(String id, String nombre) {
		String retorno = "No se modifico";
		for(int i=0;i<listaComics.size();i++) {
			if(listaComics.get(i).getId().equals(id)) {
				listaComics.get(i).setNombre(nombre);
				retorno = "Si se modifico";
				return retorno;				
			}
		}
		return retorno;
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un comicDTO de la lista. 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param id - identificador del comicDTO
	 */
	public void eliminarComicDTO(String id) {
		int i=0;
		while(i<listaComics.size()) {
			if(listaComics.get(i).getId().equals(id)) {
				listaComics.remove(i);
				return;
			}
			i++;
		}
	}
	
	/**
	 * 
	 * Metodo encargado de de buscar un comicDTO por el id.
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param id - identificador del comicDTO
	 * @return comicDTO - si existe un comic con ese id.
	 * @return null - si el comic no existe con ese id.
	 */
	public ComicDTO buscarComicDTO(String id) {
		for(ComicDTO comicDTO: getListaComics()) {
			if(comicDTO.getId().equals(id)) {
				return comicDTO;
			}
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
