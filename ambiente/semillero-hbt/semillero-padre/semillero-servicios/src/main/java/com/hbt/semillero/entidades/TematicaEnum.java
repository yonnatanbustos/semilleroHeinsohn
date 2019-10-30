/**
 * TematicaEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Asus
 * @version 
 */
public enum TematicaEnum {
	
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	HUMORISTICO("enum.tematica.humoristico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.ciencia_ficcion"),
	HISTORICO("enum.tematica.historico"),
	HORROR("enum.tematica.horror");
	private String codidoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codidoMensaje
	 */
	private TematicaEnum(String codidoMensaje) {
		this.codidoMensaje = codidoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codidoMensaje
	 * @return El codidoMensaje asociado a la clase
	 */
	public String getCodidoMensaje() {
		return codidoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codidoMensaje
	 * @param codidoMensaje El nuevo codidoMensaje a modificar.
	 */
	public void setCodidoMensaje(String codidoMensaje) {
		this.codidoMensaje = codidoMensaje;
	}
	
	

}
