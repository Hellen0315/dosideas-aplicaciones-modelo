package com.dosideas.customevaluator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.dosideas.service.ExamenService;
import com.dosideas.domain.Examen;
import java.util.Date;
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
 * La clase ExamenService utiliza @PreAuthorize para realizar comprobaciones
 * de seguridad, antes de ejecutar al método.
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "/application-service.xml",
    "/application-security_custom-evaluator.xml"
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

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void borrarExamen_usuarioNoLogueado_excepcionDeSeguridad() {
        instance.borrarExamen(1);
        fail("Debería haber surgido una excepcion de seguridad.");
    }

    @Test(expected = AccessDeniedException.class)
    public void borrarExamen_conIdDeFechaPasada_excepcionDeSeguridad() {
        loginUsuarioProfesor();
        //el evaluador que recibe id siempre crea un examen con fecha pasada,
        //por lo cual este método debería fallar porque sólo se permiten
        //borrar examenes con fechas posteriores a hoy.
        instance.borrarExamen(1);
        fail("Debería haber surgido una excepcion de seguridad.");
    }

    @Test
    public void borrarExamen_conExamenDeFechaFutura_borraElExamen() {
        loginUsuarioProfesor();

        Examen examen = new Examen();
        examen.setId(22);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        examen.setFecha(new Date(cal.getTimeInMillis()));

        //el evaluador que recibe un examen verifica que la fecha del examen
        //sea posterior a la fecha actual, por lo que debería salir todo bien.
        instance.borrarExamen(examen);
    }
    
    @Test(expected=AccessDeniedException.class)
    public void borrarExamen_conExamenDeFechaPasada_excepcionDeSeguridad() {
        loginUsuarioProfesor();

        Examen examen = new Examen();
        examen.setId(22);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -10);
        examen.setFecha(new Date(cal.getTimeInMillis()));

        //el evaluador que recibe un examen verifica que la fecha del examen
        //sea posterior a la fecha actual, por lo que debería salir todo bien.
        instance.borrarExamen(examen);
        fail("Deberia haberse lanzado una excepcion");
    }
    
}
