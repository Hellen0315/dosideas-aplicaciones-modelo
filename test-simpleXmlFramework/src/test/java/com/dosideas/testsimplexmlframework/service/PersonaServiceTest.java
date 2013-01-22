/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:46hs.
 */
package com.dosideas.testsimplexmlframework.service;

import com.dosideas.testsimplexmlframework.domain.Persona;
import com.dosideas.testsimplexmlframework.service.impl.PersonaServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Clase de test para el servicio {@link PersonaService}.
 *
 * @author Nahuel Barrios.
 */
public class PersonaServiceTest {

    /**
     * Service que estamos testeando.
     */
    private PersonaService personaService;

    @Before
    public void setUp() {
        personaService = new PersonaServiceImpl();
    }

    /**
     * Test method for obtenerXml.
     */
    @Test
    public void obtenerXml_conPersonaConIdentidadYEdad_retornaXmlEsperado() throws Exception {
        //  Preparo

        String xmlEsperado = "<persona>\n" +
                                     "   <identidad>34123456</identidad>\n" +
                                     "   <edad>15</edad>\n" +
                                     "</persona>";

        Persona unaPersona = new Persona();
        unaPersona.setIdentidad("34123456");
        unaPersona.setEdad(15);

        //  Ejecuto
        String xmlObtenido = personaService.obtenerXml(unaPersona);

        assertNotNull("El XML obtenido NO deberia ser nulo", xmlObtenido);
        assertEquals(xmlEsperado, xmlObtenido);
    }

    /**
     * Test method for obtenerXml.
     */
    @Test
    public void crear_conXmlconPersonaConIdentidadYEdad_retornaEntidadBienCreada() throws Exception {
        String xmlPersona = "<persona>\n" +
                                    "   <identidad>34123456</identidad>\n" +
                                    "   <edad>15</edad>\n" +
                                    "</persona>";

        Persona personaCreada = personaService.crear(xmlPersona);

        assertNotNull("La entidad " + personaCreada.getClass().getSimpleName() + " creada NO deberia ser nula", personaCreada);
        assertEquals("34123456", personaCreada.getIdentidad());
        assertEquals(15, personaCreada.getEdad());
    }

}
