/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Pais;
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
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml",
    "classpath:datasource.xml"
})
@Transactional
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository paisRepository;

    @Test
    public void findOne_idExistente_retornaPersona() {
        long id = 1L;

        Pais result = paisRepository.findOne(id);

        assertNotNull(result);
        assertEquals(id, result.getId().longValue());
    }

    @Test
    public void findAll_hayPaises_retornaListaDePaises() {
        List<Pais> result = paisRepository.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

}
