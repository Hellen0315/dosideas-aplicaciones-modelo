package com.dosideas.demo1.service;

import com.dosideas.domain.Examen;
import java.util.Date;
import org.junit.After;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * La clase ExamenService utiliza @PreAuthorize para realizar comprobaciones
 * de seguridad, antes de ejecutar al método.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "/com/dosideas/demo1/application-service.xml",
    "/com/dosideas/demo1/application-security.xml"
})
public class ExamenServiceTest {

    /** La instancia bajo test. 
     *  La anotación @Autowired hará que Spring la inyecte automáticamente 
     */
    @Autowired
    private ExamenService instance;
    
    private void loginUsuarioAlumno() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("bart", "123"));
    }
    
    private void loginUsuarioProfesor() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("edna", "123"));
    }
    
    private void loginUsuarioEncargado() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("willy", "123"));
    }    

    @After
    public void logout() {
        SecurityContextHolder.clearContext();
    }
    
    @Test
    public void consultarFechaDeExamen_alumnoLogueado_retornaFecha() {
        loginUsuarioAlumno();
        
        Date fecha = instance.consultarFechaDeExamen(1L);
        assertNotNull(fecha);
    }   

    @Test(expected=AuthenticationCredentialsNotFoundException.class)
    public void consultarFechaDeExamen_usuarioNoLogueado_excepcionDeSeguridad() {
        instance.consultarFechaDeExamen(1L);
        fail("Debería haberse lanzado una excepcion de seguridad.");
    }

    @Test
    public void obtenerNotaDeExamen_usuarioAlumnoLogueado_returnaNota() {
        loginUsuarioAlumno();
        
        int nota = instance.obtenerNotaDeExamen(1L);
        assertTrue(nota > 0);
    }
    
    @Test
    public void obtenerNotaDeExamen_usuarioProfesorLogueado_returnaNota() {
        loginUsuarioProfesor();
        
        int nota = instance.obtenerNotaDeExamen(1L);
        assertTrue(nota > 0);
    }
    
    @Test(expected=AccessDeniedException.class)
    public void obtenerNotaDeExamen_usuarioNoProfesorNoAlumnoLogueado_excepcionDeSeguridad() {
        loginUsuarioEncargado();
        
        instance.obtenerNotaDeExamen(1L);
        fail("Debería haberse lanzado una excepción de seguridad.");
    }
    
    @Test(expected=AuthenticationCredentialsNotFoundException.class)
    public void obtenerNotaDeExamen_usuarioNoLogueado_excepcionDeSeguridad() {
        instance.obtenerNotaDeExamen(1L);
        fail("Debería haberse lanzado una excepcion de seguridad.");
    }
    
    @Test
    public void crearExamen_usuarioProfesor_creaElExamen() {
        loginUsuarioProfesor();
        
        //obtenemos el nombre del usuario logueado, que es un profesor
        String profesor = SecurityContextHolder.getContext().getAuthentication().getName();
        
        Examen examen = new Examen();
        examen.setProfesor(profesor);
        
        instance.crearExamen(examen);
        
        assertNotNull(examen.getFecha());
    }
    
    @Test(expected=AccessDeniedException.class)
    public void crearExamen_usuarioProfesorNoCoincideProfesorEnExamen_excepcionDeSeguridad() {
        loginUsuarioProfesor();
                
        Examen examen = new Examen();
        examen.setProfesor("otro profesor");
        
        instance.crearExamen(examen);
        
        fail("Debería haberse lanzado una excepción de seguridad.");
    }

    @Test
    public void inscribirAlumnoAlExamen_usuarioAlumno_excepcionDeSeguridad() {
        loginUsuarioAlumno();
        
        //obtenemos el nombre del usuario logueado, que es un alumno
        String alumno = SecurityContextHolder.getContext().getAuthentication().getName();
        
        long codigoInscripcion = instance.inscribirAlumnoAlExamen(alumno, 11);
        
        assertTrue(codigoInscripcion > 0);
    }
    
    @Test(expected=AccessDeniedException.class)
    public void inscribirAlumnoAlExamen_usuarioAlumnoNoCoincide_excepcionDeSeguridad() {
        loginUsuarioAlumno();
        
        instance.inscribirAlumnoAlExamen("otro alumno", 11);
        fail("Debería haberse lanzado una excepción.");
    }

}
