/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thales.tallerspring.business;

import com.thales.tallerspring.domain.Alumno;

/**
 *
 * @author parivero
 */
public interface AlumnoBo {

    public void guardar(Alumno alumno);
    public Alumno buscarPorId(Long id);
    public void borrarPorId(Long id);

}
