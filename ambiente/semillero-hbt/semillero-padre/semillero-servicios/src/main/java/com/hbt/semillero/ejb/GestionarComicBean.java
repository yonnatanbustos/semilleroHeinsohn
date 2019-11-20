/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import javax.ws.rs.QueryParam;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina la gestion del comic desde la base de
 * datos. <b>Caso de Uso:<b>
 * 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * Variable que permite acceder a la base de datos.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * Metodo encargado de crear un comic.
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = convertirComicDTOToComic(comicDTO);
		em.persist(comic);
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicNuevo) {
		Comic comicModificar = null;
		if(comicNuevo!= null) {
			comicModificar = convertirComicDTOToComic(comicNuevo);
			em.merge(comicModificar);
		}
		
		//if (comicNuevo == null) {
			//comicModificar = em.find(Comic.class, id);
		//} else {
			//comicModificar = convertirComicDTOToComic(comicNuevo);
		//}
		//if (comicModificar != null) {
			//comicModificar.setNombre(nombre);
			//em.merge(comicModificar);
		//}

	}

	/**
	 * Metodo encargado de consultar un comic por el id.
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {

		Comic comic = em.find(Comic.class, Long.parseLong(idComic));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComic(@QueryParam("idComic")Long idComic) {
		JOptionPane.showMessageDialog(null, "El ID es: "+idComic);
		ComicDTO comicDTO = consultarComic(idComic.toString());
		if (comicDTO != null) {
			Comic comicEliminar = convertirComicDTOToComic(comicDTO);
			em.remove(comicEliminar);
		}
		
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {

		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		String consulta = "select c from Comic c";
		List<Comic> resultados = em.createQuery(consulta).getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * 
	 * Metodo encargado de convertir un comicDTO a un Comic <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 * 
	 * @param comicDTO - comicDTO que se desea convertir.
	 * @return comic - el comic convertido con los datos del comicDTO
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {

		Comic comic = new Comic();
		if (comicDTO.getId() != null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstado());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	/**
	 * 
	 * Metodo encargado de convertir comic a un comicDTO <b>Caso de Uso</b>
	 * 
	 * @author Asus
	 * 
	 * @param comic - comic que se desea convertir
	 * @return comicDTO - comicDTO convertido con los datos del comic
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstado(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

}
