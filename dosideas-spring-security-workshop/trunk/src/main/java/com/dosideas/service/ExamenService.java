/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.service;

import com.dosideas.domain.Examen;
import java.util.Date;

/**
 *
 * @author ldeseta
 */
public interface ExamenService {

    Date consultarFechaDeExamen(long idExamen);
    
    long inscribirAlumnoAlExamen(String alumno, long idExamen);
    
    int obtenerNotaDeExamen(long idExamen);
    
    void crearExamen(Examen examen);
}
