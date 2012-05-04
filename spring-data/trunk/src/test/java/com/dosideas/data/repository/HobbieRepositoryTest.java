/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml",
    "classpath:datasource.xml"
})
@Transactional
public class HobbieRepositoryTest {

    @Autowired
    private HobbieRepository hobbieRepository;

    @Test
    public void findOne_idExistente_retornaPersona() {
        String descripcion = "magic";
        Collection<Hobbie> hobbies = hobbieRepository.findByDescripcion(descripcion);

        assertNotNull(hobbies);
        assertTrue(hobbies.size() > 0);
        for (Hobbie hobbie : hobbies) {
            assertEquals(descripcion, hobbie.getDescripcion());
        }
    }

}
