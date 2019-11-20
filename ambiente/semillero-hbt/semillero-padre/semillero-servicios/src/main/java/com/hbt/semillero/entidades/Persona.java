/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <b>Descripción:<b> Clase que determina los atributos de la persona
 * <b>Caso de Uso:<b> 
 * @author Yonnatan Eduardo Bustos Rodriguez <yonnatanbustos97@gmail.com>
 * @version 
 */
@Entity	
@Table(name="TC_PERSONA",
uniqueConstraints= @UniqueConstraint(columnNames = { "SCNOMBRE" }))
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona  implements Serializable{

	
	/**
	 * Atributo que hace referencai al id de una persona
	 */
	private Long id;
	
	/**
	 * Atributo que hace referencia al nombre de una persona
	 */
	private String nombre;
	
	/**
	 * Atributo que hace referencia al numero de identificacion de una persona
	 */
	private String numIdentificacion;
	
	
	
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
		
	}




	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param numIdentificacion
	 */
	public Persona(Long id, String nombre, String numIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numIdentificacion = numIdentificacion;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name="SPID")
	@SequenceGenerator(allocationSize = 1, name = "TC_PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TC_PERSONA_SPID_GENERATOR")
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
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name= "SCNOMBRE")
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
	@Column(name="SCNUMIDENTIFICACION")
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




	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numIdentificacion == null) ? 0 : numIdentificacion.hashCode());
		return result;
	}




	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numIdentificacion == null) {
			if (other.numIdentificacion != null)
				return false;
		} else if (!numIdentificacion.equals(other.numIdentificacion))
			return false;
		return true;
	}




	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", numIdentificacion=" + numIdentificacion + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
