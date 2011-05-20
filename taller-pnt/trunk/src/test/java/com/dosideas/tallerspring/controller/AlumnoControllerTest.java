/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.tallerspring.controller;

import com.dosideas.tallerspring.domain.Alumno;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.restlet.resource.ClientResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DosIdeas
 */
public class AlumnoControllerTest {

    private ClientResource clientResource;
    private RestTemplate restTemplate;
    private static String URL = "http://localhost:8080/tallerSpring-3/app/alumno/";
    private int cantidadAlumnos = 0;

    @Before
    public void setUp() throws IOException {
        restTemplate = new RestTemplate();
        cantidadAlumnos = cantidadAlumnos();
    }

    @Test
    public void buscarPorId_conIdCorrecto_retornaAlumno() {
        Long id = 1L;
        Alumno alumno = restTemplate.getForObject(URL + id, Alumno.class);
        Assert.assertNotNull(alumno);
    }

    @Test
    public void buscarPorId_conIdInCorrecto_retornaNOT_FOUND() {
        Long id = 1001L;
        try {
            restTemplate.getForObject(URL + id, Alumno.class);
            Assert.fail();
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        }
    }

    @Test
    public void alta_conAlumnoCorrecto() throws IOException {
        Alumno alumno = new Alumno();
        alumno.setNombre("Test");
        alumno.setApellido("Test");
        alumno.setEmail("Test@test.com");
        
        Alumno alumnoRetorno = restTemplate.postForObject(URL + "alta", alumno, Alumno.class);
        
        Assert.assertNotNull(alumnoRetorno);
    }
    
    @Test
    public void alta_conAlumnoIncorrecto_retornaBAD_REQUEST() throws IOException {
        Alumno alumno = new Alumno();
        alumno.setNombre("Test");
        alumno.setApellido("Test");
        alumno.setEmail("Test test.com");
        
        try {
            restTemplate.postForObject(URL + "alta", alumno, Alumno.class);
            Assert.fail();
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
        }
    }

//    @Test
//    public void eliminar_conIdCorrecto() throws IOException {
//        Long id = 2L;
//        restTemplate.delete(URL + id + "/eliminar");
//        Assert.assertEquals(cantidadAlumnos - 1, cantidadAlumnos());
//    }

    private int cantidadAlumnos() throws IOException {
        
        return restTemplate.getForObject(URL + "todos", Alumno[].class).length;
        
        
    }
    
    
}
