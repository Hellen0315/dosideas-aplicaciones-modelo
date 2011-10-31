package com.sandbox.hibernate.unoAUno.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Corazon", schema = "UnoAUno")
public class Corazon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corazonId")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="cuerpoId")
    private Cuerpo cuerpo;
    
    
    /**
     * descripcion
     */
    @Column(name = "corazonDescripcion")
    private String descripcion;

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
     * @return the cuerpo
     */
    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }

   
    
}
