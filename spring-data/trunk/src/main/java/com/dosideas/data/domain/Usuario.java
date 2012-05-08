package com.dosideas.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad que mapea un usuario.
 * 
 * @author nbarrios
 */
@Entity
public class Usuario implements Serializable {

    /**
     * @author nbarrios
     */
    private static final long serialVersionUID = -2888612228793674396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author nbarrios
     * @since 09/05/2012.
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the attribute of the entity.
     * 
     * @author nbarrios
     * @param id
     *            the id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author nbarrios
     * @since 09/05/2012.
     * @return the nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter for the attribute of the entity.
     * 
     * @author nbarrios
     * @param nombre
     *            the nombre to set.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author nbarrios
     * @since 09/05/2012.
     * @return the apellido.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter for the attribute of the entity.
     * 
     * @author nbarrios
     * @param apellido
     *            the apellido to set.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Accessor for the attribute of the entity.
     * 
     * @author nbarrios
     * @since 09/05/2012.
     * @return the nombreUsuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Setter for the attribute of the entity.
     * 
     * @author nbarrios
     * @param nombreUsuario
     *            the nombreUsuario to set.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
