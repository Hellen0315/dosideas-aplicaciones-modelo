package com.sandbox.hibernate.dummy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Dummy", schema = "base")
public class Dummy {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dummyId")
    private Long id;
    
    /**
     * descripcion
     */
    @Column(name = "dummyDescripcion")
    private String descripcion;
    
    @Transient
    private String pepe;
   
}
