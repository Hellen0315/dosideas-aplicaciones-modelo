package com.dosideas.domain;

import java.io.Serializable;

/**
 *
 * @author ldeseta
 */
public class Pais implements Serializable {

    private Long id;
    private String nombre;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
