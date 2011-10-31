package com.sandbox.hibernate.unoAMuchos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Apodo", schema = "UnoAMuchos")
public class Apodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apodoId")
    private Long id;
    
    /**
     * descripcion
     */
    @Column(name = "apodoDescripcion")
    private String descripcion;
}
