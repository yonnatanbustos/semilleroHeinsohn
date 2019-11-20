/**
 * Proveedor.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.common.util.impl.Log;

/**
 * <b>Descripción:<b> Clase que determina la entidad del proveedor
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustso97@gmail.com>
 * @version 
 */
@Entity
@Table(name="TC_PROVEEDOR", 
uniqueConstraints= @UniqueConstraint(columnNames = { "SPDIRECCION" }))
public class Proveedor extends Persona implements Serializable{
	
		
	private String direccion;
	
	private LocalDate fechaCreacion;
	
	private EstadoEnum estadoEnum;
		
	private Double montoCredito;
	
	
	
	/**
	 * Constructor de la clase.
	 */
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param numIdentificacion
	 * @param direccion
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param montoCredito
	 */
	public Proveedor(Long id, String nombre, String numIdentificacion, String direccion, LocalDate fechaCreacion, EstadoEnum estadoEnum,
			Double montoCredito) {
		super(id, nombre, numIdentificacion);
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.montoCredito = montoCredito;
		
	}











	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * @return El direccion asociado a la clase
	 */
	@Column(name="SPDIRECCION")
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
	@Column(name="SPFECHA_CREACION")
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
	@Column(name="SPESTADO")
	@Enumerated(value=EnumType.STRING)
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
	@Column(name="SPMONTO_CREDITO")
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
	 * 
	 * Metodo encargado de determinar la vigencia de este proveedor
	 * <b>Caso de Uso</b>
	 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
	 * 
	 * @return
	 */
	public Boolean isContratoVigente() {
		LocalDate fechaActual = LocalDate.now();
		
		if(fechaActual.getYear()>fechaCreacion.getYear()) {
			fechaActual = fechaActual.minusMonths(fechaCreacion.getMonthValue());
			fechaActual = fechaActual.minusDays(fechaCreacion.getDayOfMonth());
			if(fechaActual.getYear()>fechaCreacion.getYear()) {
				System.out.println(fechaActual);
				return Boolean.TRUE;
			}
				
		}
		return Boolean.FALSE;
	}
	
	



	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((montoCredito == null) ? 0 : montoCredito.hashCode());
		return result;
	}



	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estadoEnum != other.estadoEnum)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (montoCredito == null) {
			if (other.montoCredito != null)
				return false;
		} else if (!montoCredito.equals(other.montoCredito))
			return false;
		return true;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Proveedor [direccion=" + direccion + ", fechaCreacion=" + fechaCreacion + ", estadoEnum=" + estadoEnum
				+ ", montoCredito=" + montoCredito + "]";
	}

}
