/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import com.dosideas.data.domain.Persona;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ldeseta
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml",
    "classpath:datasource.xml"
})
@Transactional
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    public void findOne_idExistente_retornaPersona() {
        long id = 1L;

        Persona result = personaRepository.findOne(id);

        assertNotNull(result);
        assertEquals(id, result.getId().longValue());
    }

    @Test
    public void findByApellido_apellidoUnico_returnaUnaPersona() {
        String apellido = "Trout";

        Collection<Persona> personas = personaRepository.findByApellido(apellido);

        assertNotNull(personas);
        assertTrue(personas.size() == 1);

        Persona persona = personas.iterator().next();
        assertEquals(apellido, persona.getApellido());
        assertNotNull(persona.getPais());
        assertNotNull(persona.getPais().getNombre());

        Collection<Hobbie> hobbies = persona.getHobbies();
        assertNotNull(hobbies);
        assertTrue(hobbies.size() > 0);
        for (Hobbie hobbie : hobbies) {
            assertNotNull(hobbie.getDescripcion());
        }
    }

    @Test
    public void findByNombreAndApellido_existe_returnaPersonas() {
        String nombre = "Kilgore";
        String apellido = "Trout";

        List<Persona> personas = personaRepository.findByNombreAndApellido(nombre, apellido);

        assertNotNull(personas);
        assertTrue(personas.size() == 1);

        Persona persona = personas.iterator().next();
        assertEquals(apellido, persona.getApellido());
        assertEquals(nombre, persona.getNombre());
    }

    @Test
    public void findByPais_existe_returnaPersonas() {
        String pais = "Argentina";

        List<Persona> personas = personaRepository.findByPais(pais);
        assertNotNull(personas);
        assertTrue(personas.size() > 0);

        for (Persona persona : personas) {
            assertNotNull(persona.getPais());
            assertEquals(pais, persona.getPais().getNombre());
        }
    }

    @Test
    public void setNombreForPersona_nombreOk_retornaUnoComoCantidadDeFilasAfectadas() {
        Long id = 1L;
        String nombre = "Nuevo nombre";

        int filasAfectadas = personaRepository.setNombreForPersona(id, nombre);

        assertEquals(1, filasAfectadas);
        Persona persona = personaRepository.findOne(id);

        assertEquals(nombre, persona.getNombre());
    }

}

