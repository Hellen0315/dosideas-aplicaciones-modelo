package com.dosideas.controller;

import com.dosideas.domain.Pais;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Esta clase de test funcionará de cliente para consumir los servicios expuestos
 * por medio del controlador.
 *
 * Para poder correr los test (y que pasen los mismos) deberemos iniciar la base de datos
 * y desplegar la aplicación en un servidor de aplicaciones.
 *
 * Para iniciar la base de datos:
 *   Ir al menu Window > Services > Databases > Java DB > Click derecho > Start server
 *
 * Para desplegar en un servidor de aplicaciones deberemos asociar el proyecto
 * a dicho servidor de aplicaciones y apuntar la URL que esta escrita en cada test
 * a dicha ubicación.
 *
 * Por default, el proyecto esta asociado al servidor de aplicaciones Tomcat, así que
 * para desplegarlo (y que levante el servidor automáticamente) debemos ir a Run > Run Project.
 *
 * Para ejecutar este test en NetBeans:
 *    click derecho > "Test File" (CTRL + F6)
 *
 * @author ldeseta
 */
public class PaisControllerTest {

    /**
     * Por medio de esta clase invocaremos a los servicios rest.
     */
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws IOException {
        restTemplate = new RestTemplate();
    }

    @Test
    public void buscarPaisPorId_conIdPaisExistente_retornaPais() {
        Long id = 1L;
        Pais pais = restTemplate.getForObject("http://localhost:8080/dosideas-jee001-workshop/app/pais/" + id.toString(), Pais.class);
        Assert.assertNotNull(pais);
    }

    @Test
    public void buscarPaisPorId_conIdPaisInexistente_retornaStatusNotFound() {

        try {
            restTemplate.getForObject("http://localhost:8080/dosideas-jee001-workshop/app/pais/1001", Pais.class);
            Assert.fail();
        } catch (HttpClientErrorException ex) {
            Assert.assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        }
    }

}
