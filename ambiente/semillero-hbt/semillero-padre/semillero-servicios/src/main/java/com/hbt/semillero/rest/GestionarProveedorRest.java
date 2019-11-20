/**
 * GestionarProveedorRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;

	/**
	 * 
	 * Metodo encargado de crear un proveedor <b>Caso de Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	@POST
	@Path("/crearProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		return gestionarProveedorEJB.crearProveedor(proveedorDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar un proveedor <b>Caso de Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param proveedorDTO
	 */
	@POST
	@Path("/modificarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarProveedor(@QueryParam("idProveedor") Long idProveedor,
			@QueryParam("nombreProveedor") String nombreProveedor, @QueryParam("montoCredito") Double montoCredito) {
		if (idProveedor != null) {
			gestionarProveedorEJB.modificarProveedor(idProveedor, nombreProveedor, montoCredito);
		}
	}

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor <b>Caso de Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 */
	@POST
	@Path("/cambiarEstadoProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public void cambiarEstadoProveedor(@QueryParam("idProveedor") Long idProveedor, @QueryParam("estadoNuevo")String estadoNuevo) {
		gestionarProveedorEJB.cambiarEstadoProveedor(idProveedor, estadoNuevo);
	}

	/**
	 * 
	 * Metodo encargado de listar todos los proveedores <b>Caso de Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarProveedores")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProveedorDTO> consultarProveedores() {
		return gestionarProveedorEJB.consultarProveedores();
	}

	/**
	 * 
	 * Metodo encargado de consultar un proveedor por un id especifico <b>Caso de
	 * Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 * @return
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			return gestionarProveedorEJB.consultarProveedor(idProveedor);
		}
		return null;
	}

	/**
	 * 
	 * Metodo encargado de determinar si el contrato de un proveedor es vigente o no
	 * <b>Caso de Uso</b>
	 * 
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 * @return
	 */
	@GET
	@Path("/contratoVigente")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean isContratoVigente(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			return gestionarProveedorEJB.isContratoVigente(idProveedor);
		}
		return Boolean.FALSE;
	}
}
