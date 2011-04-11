/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.app.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author parivero
 */
@Entity
@Table(name="materias")
public class Materia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "curso_materia", joinColumns = {
        @JoinColumn(name = "id_materia")},
    inverseJoinColumns = {
        @JoinColumn(name = "id_curso")})
    @Fetch(FetchMode.SUBSELECT)
    private Collection<Curso> cursos;

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
