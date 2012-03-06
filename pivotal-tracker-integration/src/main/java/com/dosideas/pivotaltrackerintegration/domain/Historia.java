/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.pivotaltrackerintegration.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Clase en la que se mapea la entrada de formato JSON y la salida 
 * de formato XML.
 * @author parivero
 */
@XStreamAlias("story")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Historia {
    @XStreamAlias("story_type")
    private String tipo;
    @XStreamAlias("name")
    private String titulo;
    @XStreamAlias("requested_by")
    private String usuarioPivotal;
    @XStreamAlias("owned_by")
    private String propietario;
    @XStreamAlias("description")
    private String descripcion;
    @XStreamAlias("labels")
    private String usuarioAplicacion;
    @XStreamOmitField
    private String aplicacion;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the usuarioPivotal
     */
    public String getUsuarioPivotal() {
        return usuarioPivotal;
    }

    /**
     * @param usuarioPivotal the usuarioPivotal to set
     */
    public void setUsuarioPivotal(String usuarioPivotal) {
        this.usuarioPivotal = usuarioPivotal;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
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
     * @return the usuarioAplicacion
     */
    public String getUsuarioAplicacion() {
        return usuarioAplicacion;
    }

    /**
     * @param usuarioAplicacion the usuarioAplicacion to set
     */
    public void setUsuarioAplicacion(String usuarioAplicacion) {
        this.usuarioAplicacion = usuarioAplicacion;
    }

    /**
     * @return the aplicacion
     */
    public String getAplicacion() {
        return aplicacion;
    }

    /**
     * @param aplicacion the aplicacion to set
     */
    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    
        
}
