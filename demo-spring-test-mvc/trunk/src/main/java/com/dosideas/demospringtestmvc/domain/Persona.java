/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.demospringtestmvc.domain;

/**
 *
 * @author parivero
 */
public class Persona {
    
   
    private int id;
    private String nombre;
   

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

       
}
