package com.dosideas.demo3.service;

import com.dosideas.service.*;
import com.dosideas.domain.Alumno;
import org.junit.After;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * La configuración de Spring Security para esta corrida utiliza una base de
 * datos para obtener los usuarios, contraseñas y roles. 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "/application-service.xml",
    "/application-security_jdbc-user-service.xml"
})
public class AlumnoServiceTest {

    /** La instancia bajo test. 
     *  La anotación @Autowired hará que Spring la inyecte automáticamente 
     */
    @Autowired
    private AlumnoService instance;
    
    private void loginUsuarioAlumno() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("bart", "123"));
    }
    
    private void loginUsuarioProfesor() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("edna", "123"));
    }
    
    @After
    public void logout() {
        SecurityContextHolder.clearContext();
    }
    
    @Test
    public void consultarAlumnoPorLegajo_profesorLogueado_retornaAlumno() {
        loginUsuarioProfesor();
        Alumno alumno = instance.consultarAlumnoPorLegajo(999);
        assertNotNull(alumno);
    }   
    
    @Test
    public void consultarAlumnoPorLegajo_profesorAlumnoCoincideLegajo_retornaAlumno() {
        loginUsuarioAlumno();
        Alumno alumno = instance.consultarAlumnoPorLegajo(999);
        assertNotNull(alumno);
    }   
    
    @Test(expected=AccessDeniedException.class)
    public void consultarAlumnoPorLegajo_profesorAlumnoNoCoincideLegajo_excepcionDeSeguridad() {
        loginUsuarioAlumno();
        
        //el usuario logueado es "bart". el usuario "lisa" tiene legajo negativo.
        //la siguiente invocacion deberia fallar, porque "bart" solo tendria
        //que poder consultar su propio legajo.
        instance.consultarAlumnoPorLegajo(-222);
        
        fail("Deberia haberse lanzado una excepcion de seguridad");
    }
    
    @Test(expected=AuthenticationCredentialsNotFoundException.class)
    public void consultarAlumnoPorLegajo_usuarioNoLogueado_retornaAlumno() {
        instance.consultarAlumnoPorLegajo(999);
        fail("Deberia haberse lanzado una excepcion de seguridad");
    }   
    

}
