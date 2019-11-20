/**
 * GestionarProveedorBean.java
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

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina la gestion del proveedor
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rdoriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarProveedorBean  implements IGestionarProveedorLocal{

	
	@PersistenceContext
	private EntityManager em;

	
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#crearProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Se creao el proveedor");
		
		Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
		em.persist(proveedor);		
		
		return resultadoDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedores()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ProveedorDTO> consultarProveedores() {

		List<ProveedorDTO> resultadosProveedorDTO = new ArrayList<ProveedorDTO>();
		
		String consulta = "select p from Tc_proveedor p";
		
		List<Proveedor> resultados = em.createQuery(consulta).getResultList();
		
		for (Proveedor proveedor : resultados) {
			resultadosProveedorDTO.add(convertirProveedorToProveedorDTO(proveedor));
		}
		
		return resultadosProveedorDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#modificarProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 */
	@Override
	public void modificarProveedor(Long idProveedor, String nombreProveedor, Double montoCredito) {
		
		ProveedorDTO proveedorDTO = consultarProveedor(idProveedor);
		
		Proveedor proveedorModificar = null;
		if(proveedorDTO!=null) {
			proveedorModificar = convertirProveedorDTOToProveedor(proveedorDTO);
			proveedorModificar.setNombre(nombreProveedor);
			proveedorModificar.setMontoCredito(montoCredito);
			em.merge(proveedorModificar);
		}else {
			throw new NullPointerException();
		}
		
		
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#consultarProveedor(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(Long idProveedor) {
		
		Proveedor proveedor = em.find(Proveedor.class, idProveedor);
		
		ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);
		return proveedorDTO;
		
	}
	
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#eliminarProveedor(java.lang.Long)
	 */
	@Override
	public void cambiarEstadoProveedor(Long idProveedor, String estadoNuevo) {
		ProveedorDTO proveedorDTO = consultarProveedor(idProveedor);
		if(proveedorDTO!=null) {
			Proveedor proveedorCambiarEstado = convertirProveedorDTOToProveedor(proveedorDTO);
			if(estadoNuevo.equals("ACTIVO")) {
				proveedorCambiarEstado.setEstadoEnum(EstadoEnum.ACTIVO);
			}else {
				proveedorCambiarEstado.setEstadoEnum(EstadoEnum.INACTIVO);
			}
			em.merge(proveedorCambiarEstado);
		}else {
			throw new NullPointerException();
		}
		
		
	}
	
	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#isContratoVigente()
	 */
	@Override
	public Boolean isContratoVigente(Long idProveedor) {
		ProveedorDTO proveedorDTO = consultarProveedor(idProveedor);
		if(proveedorDTO!=null) {
			Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
			//return proveedor.isContratoVigente();
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
		
		
	
	}
	
	
	/**
	 * 
	 * Metodo encargado de convertir un proveedorDTO a proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {
		
		Proveedor proveedor = new Proveedor();
		
		if(proveedorDTO.getId()!=null) {
			proveedor.setId(proveedorDTO.getId());
		}
		proveedor.setNombre(proveedorDTO.getNombre());
		proveedor.setNumIdentificacion(proveedorDTO.getNumIdentificacion());
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setEstadoEnum(proveedorDTO.getEstadoEnum());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		
		return proveedor;
		
	}
	
	/**
	 * 
	 * Metodo encargado de convertir un proveedor a un proveedorDTO
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param proveedor
	 * @return
	 */
	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		
		proveedorDTO.setId(proveedor.getId());
		proveedorDTO.setNombre(proveedor.getNombre());
		proveedorDTO.setNumIdentificacion(proveedor.getNumIdentificacion());
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setEstadoEnum(proveedorDTO.getEstadoEnum());
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());
		
		return proveedorDTO;
	}

}
