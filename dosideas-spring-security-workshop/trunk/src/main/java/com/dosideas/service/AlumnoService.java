/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.service;

import com.dosideas.domain.Alumno;

/**
 *
 * @author ldeseta
 */
public interface AlumnoService {

    Alumno consultarAlumnoPorLegajo(long legajo);
    
}
