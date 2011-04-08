/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.tallerspring.dao;

import com.dosideas.tallerspring.domain.Alumno;

/**
 *
 * @author parivero
 */
public interface AlumnoDao {

    public void guardar(Alumno alumno);
    public Alumno buscarPorId(Long id);
    public void borrarPorId(Long id);

}
