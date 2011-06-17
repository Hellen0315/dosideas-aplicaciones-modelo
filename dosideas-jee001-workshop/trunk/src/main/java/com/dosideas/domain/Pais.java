package com.dosideas.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ldeseta
 */
@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {
    
    @Id
    @Column(name = "ID_PAIS")
    private Long id;
    
    @Column(name = "NOMBRE")
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
