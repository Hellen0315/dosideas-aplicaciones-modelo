package com.sandbox.hibernate.unoAUno.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Corazon", schema = "UnoAUno")
public class Corazon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corazonId")
    private Long id;
    
    
    /**
     * @see <a href="http://download.oracle.com/javaee/5/api/javax/persistence/OneToOne.html">OneToOne</a>
     * <ul>
     * <li><strong>optional</strong> (Optional) Si la asociacion es opcional.</li>
     * </ul>
     * @see <a href="http://download.oracle.com/javaee/5/api/javax/persistence/JoinColumn.html">JoinColumn</a>
     * <ul>
     * <li><strong>name</strong>    (Optional)El nombre de la  foreign key.</li>
     * <li><strong>unique</strong>  (Optional) La columna es una unique key.</li>
     * <li><strong>nullable</strong>  (Optional) La columna permite null .</li>
     * <li><strong>updatable</strong> (Optional) Si la columna es tenida en cuenta para el SQL UPDATE generado por el motor de persistencia.</li>
     * </ul>
     */
    @OneToOne(optional=false)
    @JoinColumn(
            name="cuerpoId", unique=true, nullable=false, updatable=false)
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
