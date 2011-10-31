package com.sandbox.hibernate.unoAMuchos.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Persona", schema = "UnoAMuchos")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId")
    private Long id;
    
    /**
     * descripcion
     */
    @Column(name = "personaNombre")
    private String nombre;
    
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="personaId")
    private Collection<Apodo> apodos; 

    /**
     * @return the apodos
     */
    public Collection<Apodo> getApodos() {
        return apodos;
    }

    /**
     * @param apodos the apodos to set
     */
    public void setApodos(Collection<Apodo> apodos) {
        this.apodos = apodos;
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
    
    
}
