/**
 * ProveedorDTO.java
 */
package com.hbt.semillero.dto;

import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el proveedorDTO
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
public class ProveedorDTO {

	/**
	 * Atributo que hace referecia al id del proveedorDTO
	 */
	private Long id;
	
	/**
	 * Atributo que hace referencia al nombre del proveedorDTO
	 */
	private String nombre;
	
	/**
	 * Atributo que hace referencia al numero de identificacion del proveedorDTO
	 */
	private String numIdentificacion;
	
	/**
	 * Atributo que hace referencia a la direccion del proveedorDTO
	 */
	private String direccion;
	
	/**
	 * Atributo que hace referencia a la fecha de creacion del proveedorDTO
	 */
	private LocalDate fechaCreacion;
	
	/**
	 * Atributo que hace referencia al estado del proveedorDTO
	 */
	private EstadoEnum estadoEnum;
	
	
	/**
	 * Atributo que hace referencia al monto del credito del proveedorDTO 
	 */
	private Double montoCredito;


	/**
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param idPersona
	 * @param montoCredito
	 */
	public ProveedorDTO(Long id, String direccion, LocalDate fechaCreacion, EstadoEnum estadoEnum, Long idPersona,
			Double montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.montoCredito = montoCredito;
	}





	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}





	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	public Double getMontoCredito() {
		return montoCredito;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numIdentificacion
	 * @return El numIdentificacion asociado a la clase
	 */
	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numIdentificacion
	 * @param numIdentificacion El nuevo numIdentificacion a modificar.
	 */
	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	
	
	
	
	
	
	 
}
