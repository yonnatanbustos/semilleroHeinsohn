/**
 * AplicacionPrueba.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;

import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Asus
 * @version 
 */
public class AplicacionPrueba {

	
	public static void main(String[] args) {
		Proveedor p = new Proveedor();
		LocalDate fecha = LocalDate.of(2018, 11, 15);
		p.setFechaCreacion(fecha);
		Boolean res =p.isContratoVigente();
		System.out.println(res);
	}
}
