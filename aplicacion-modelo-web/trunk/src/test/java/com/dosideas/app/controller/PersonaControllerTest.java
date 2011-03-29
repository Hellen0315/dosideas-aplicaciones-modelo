/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.app.controller;

import com.dosideas.app.domain.Persona;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author DosIdeas
 */
public class PersonaControllerTest {

    private static final String URL = "http://localhost:8084/aplicacion-modelo-web/app/persona/";

    private RestTemplate restTemplate;

    @Before
    public void setUp() {

        restTemplate = new RestTemplate();
    }

    @Test
    public void buscarPorId() {

        Persona persona = restTemplate.getForObject(URL + "100", Persona.class);

        Assert.assertNotNull(persona);
        Assert.assertEquals("registro_1", persona.getNombre());
        Assert.assertEquals("registro_1", persona.getApellido());
        Assert.assertEquals("registro_1@registro_1.com", persona.getEmail());

    }

    @Test
    public void guardar() {
        Persona persona = new Persona();
        persona.setNombre("Roberto");
        persona.setApellido("Carlos");
        persona.setEmail("Roberto@Carlos.com");

        String respuesta = restTemplate.postForObject(URL + "guardar", persona, String.class);

        Assert.assertEquals("Ok", respuesta);

    }

    @Test
    public void buscarTodos() throws NoSuchFieldException {

    
        /**
         * Workaround de Colecciones tipadas en restTemplate
         * En lugar de una collection ponemos una Array del objeto.
         * https://jira.springsource.org/browse/SPR-7002
         */
        Persona[] personas = restTemplate.getForObject(URL + "todos", Persona[].class);

        Assert.assertNotNull(personas);

    }



}
