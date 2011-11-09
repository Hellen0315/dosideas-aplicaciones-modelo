/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.demo1.service;

import com.dosideas.domain.Examen;
import java.util.Date;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Esta es la clase de negocio, cuyos métodos se encuentran segurizados 
 * con la anotación @PreAuthorize de Spring Security. 
 * 
 * Spring Security intercepta la invocación al método y realiza la validación
 * seguridad indicada en @PreAuthorize antes de ejecutar el método.
 * 
 */
@Service
public class ExamenServiceImpl implements ExamenService {

    /**
     * Este método sólo puede ejecutarse si el usuario está autenticado 
     * en el sistema (es decir, hay un usuario logueado). 
     */
    @Override
    @PreAuthorize("isAuthenticated()")
    public Date consultarFechaDeExamen(long idExamen) {
        return new Date();
    }

    /**
     * Este método sólo puede ejecutarse si el parámetro "alumno" es igual
     * al nombre del usuario logueado. De esta manera, sólo el usuario logueado
     * puede inscribirse a un examen.
     */
    @PreAuthorize("#alumno == authentication.name")
    @Override
    public long inscribirAlumnoAlExamen(String alumno, long idExamen) {
        return 777;
    }
    
    /**
     * Este método pueden ejecutarlo aquellos usuarios que tengan asignado el
     * rol "PROFESOR" o el rol "ALUMNO". 
     */
    @Override
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ALUMNO')")
    public int obtenerNotaDeExamen(long idExamen) {
        return 7;
    }

    /**
     * Este método sólo puede ser ejecutado por usuarios autenticados que tengan
     * asignado el rol "PROFESOR". Además, el profesor asignado al examen tiene
     * que ser el mismo usuario logueado.
     */
    @Override
    @PreAuthorize("hasRole('PROFESOR') and #examen.profesor == authentication.name ")
    public void crearExamen(Examen examen) {
        examen.setFecha(new Date());
    }

}
