package com.sandbox.hibernate.unoAMuchos;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.unoAMuchos.dao.PersonaDao;
import com.sandbox.hibernate.unoAMuchos.domain.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"unoAMuchos-app-context.xml"})
@Transactional
public class PersonaDaoComponenteTest {
    
    @Autowired
    private PersonaDao instancia;
    
    @Test
    public void buscaPorId_conPersonaConDosAlias_retornaPersonaConDosAlias() {
        
        Long id = new Long(2L);
        
        Persona resultado = instancia.buscarPorId(id);
        
        Assert.assertNotNull(resultado);
        Assert.assertEquals(id.longValue(), resultado.getId().longValue());
        Assert.assertEquals(2, resultado.getApodos().size());
    }
}
