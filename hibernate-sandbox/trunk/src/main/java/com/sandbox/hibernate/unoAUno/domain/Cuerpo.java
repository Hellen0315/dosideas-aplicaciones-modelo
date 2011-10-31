package com.sandbox.hibernate.unoAUno.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cuerpo", schema = "UnoAUno")
public class Cuerpo {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuerpoId")
    private Long id;
    
    /**
     * descripcion
     */
    @Column(name = "cuerpoDescripcion")
    private String descripcion;
    
    @OneToOne(mappedBy="cuerpo") 
    private Corazon corazon;
    
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }



    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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
     * @return the corazon
     */
    public Corazon getCorazon() {
        return corazon;
    }



    /**
     * @param corazon the corazon to set
     */
    public void setCorazon(Corazon corazon) {
        this.corazon = corazon;
    } 

    
    
}
