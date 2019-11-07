/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.res;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	/**
	 * variable que permite gestionar el comic
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/**
	 * 
	 * Metodo encargado de mostrar un saludo 
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
	/**
	 * 
	 * Metodo encargado de consultar un comic por el id
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic !=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
		
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un comic
	 * <b>Caso de Uso</b>
	 * @author Asus
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public String eliminarComic(@QueryParam("idComic") Long idComic) {
		String mensaje = "No se elimino el comic";
		if(idComic != null) {
			gestionarComicEJB.eliminarComic(idComic);
			mensaje = "Comic eliminado";
			return mensaje;
		}
		return mensaje;		
	}
}
