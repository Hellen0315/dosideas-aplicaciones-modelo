package com.sandbox.hibernate.unoAUno.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    
    /**
     * @see <ahref="http://download.oracle.com/javaee/5/api/javax/persistence/OneToOne.html">OneToOne</a>
     * <ul>
     *  <li>
     *   <strong>cascade</strong> (Opcional) Las operaciones que deben ser propagados en cascada con el objetivo de la asociacion.
     *  </li>
     *  <li> 
     *    <strong>mappedBy</strong> (Opcional) El atributo del objetivo de la asociacion que posee la relacion.
     *  <li>
     * </ul>
     * @see <a href="http://download.oracle.com/javaee/5/api/javax/persistence/CascadeType.html">CascadeType</a>
     * <ul>
     *  <li>  
     *    <strong>ALL<strong> Propaga todas las operaciones.
     *  </li>
     * <ul>     
     */
    @OneToOne(mappedBy = "cuerpo", cascade = CascadeType.ALL)
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
        corazon.setCuerpo(this);
        this.corazon = corazon;
    } 

    
    
}
