/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.demo1.service;

import com.dosideas.domain.Alumno;
import com.dosideas.domain.Examen;
import java.util.Date;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Esta es la clase de negocio, cuyos métodos se encuentran segurizados 
 * con la anotación @PostAuthorize de Spring Security. 
 * 
 * Spring Security intercepta la invocación al método, ejecuta el método en 
 * cuestión y luego ejecuta la validación de seguridad indicada en @PostAuthorize. 
 * Si esta validación falla, no se devuelve el valor de retorno y se lanza
 * una excepción de seguridad. 
 * 
 */
@Service
public class AlumnoServiceImpl implements AlumnoService {

    
    /** La información del alumno es confidencial. Por esto, solamente pueden
     * consultarla los profesores, o el mismo alumno.
     */
    @Override
    @PostAuthorize("hasRole('PROFESOR') or returnObject.nombre == authentication.name")
    public Alumno consultarAlumnoPorLegajo(long legajo) {
        Alumno alumno = new Alumno();
        alumno.setLegajo(legajo);
        
        //esto es para pruebas.
        if (legajo > 0) {
            alumno.setNombre("bart");
        } 
        else {
            alumno.setNombre("lisa");
        }
        
        return alumno;
    }

}
