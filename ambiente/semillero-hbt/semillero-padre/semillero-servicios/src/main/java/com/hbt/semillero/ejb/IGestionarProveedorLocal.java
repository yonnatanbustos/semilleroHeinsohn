/**
 * IGestionarProveedorLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
public interface IGestionarProveedorLocal {

	
	
	/**
	 * 
	 * Metodo encargado de crear un proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param proveedorDTO
	 * @return
	 */
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO);
	
	
	
	/**
	 * 
	 * Metodo encargado de listar todos los proveedores
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @return
	 */
	public List<ProveedorDTO> consultarProveedores();
	
	/**
	 * 
	 * Metodo encargado de modificar un proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 * @param nombreProveedor
	 * @param montoCredito
	 */
	public void modificarProveedor(Long idProveedor, String nombreProveedor, Double montoCredito);
	
	
	/**
	 * 
	 * Metodo encargado de consultar un proveedor por un id
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 * @return
	 */
	public ProveedorDTO consultarProveedor(Long idProveedor);
	
	/**
	 * 
	 * Metodo encargado de cambiar de estado a un proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @param idProveedor
	 */
	public void cambiarEstadoProveedor(Long idProveedor, String estadoNuevo);
	
	/**
	 * 
	 * Metodo encargado de determinar la vigencia del contrato del proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @return
	 */
	public Boolean isContratoVigente(Long idProveedor);
	
	
	
}
