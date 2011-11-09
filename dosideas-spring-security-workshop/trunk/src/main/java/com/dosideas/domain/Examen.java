/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.domain;

import java.util.Date;

/**
 *
 * @author ldeseta
 */
public class Examen {
    
    private String profesor;
    private String tema;
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
