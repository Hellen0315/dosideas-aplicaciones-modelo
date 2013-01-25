/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:46hs.
 */
package com.dosideas.testsimplexmlframework.service;

import com.dosideas.testsimplexmlframework.domain.Persona;
import com.dosideas.testsimplexmlframework.service.impl.XmlServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de test para el servicio {@link XmlService}.
 *
 * @author Nahuel Barrios.
 */
public class XmlServicePersonaTest {

    /**
     * Service que estamos testeando.
     */
    private final XmlService xmlService = new XmlServiceImpl();

    /**
     * Test method for obtenerXml.
     */
    @Test
    public void obtenerXml_conPersonaConIdentidadYEdad_retornaXmlEsperado() throws Exception {
        String xmlEsperado = "<persona>\n" +
                             "   <identidad>34123456</identidad>\n" +
                             "   <edad>15</edad>\n" +
                             "</persona>";

        Persona unaPersona = new Persona();
        unaPersona.setIdentidad("34123456");
        unaPersona.setEdad(15);

        String xmlObtenido = xmlService.obtenerXml(unaPersona);

        assertNotNull("El XML obtenido NO deberia ser nulo", xmlObtenido);
        assertEquals(xmlEsperado, xmlObtenido);
    }

    /**
     * Test method for obtenerXml.
     */
    @Test
    public void crear_conXmlConPersonaConIdentidadYEdad_retornaEntidadBienCreada() throws Exception {
        String xmlPersona = "<persona>\n" +
                            "   <identidad>34123456</identidad>\n" +
                            "   <edad>15</edad>\n" +
                            "</persona>";

        Persona personaCreada = xmlService.crear(Persona.class, xmlPersona);

        assertNotNull("La entidad persona creada NO deberia ser nula", personaCreada);
        assertEquals("34123456", personaCreada.getIdentidad());
        assertEquals(15, personaCreada.getEdad());
    }

}
