package com.sandbox.hibernate.unoAUno;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.unoAUno.dao.CorazonDao;
import com.sandbox.hibernate.unoAUno.dao.CuerpoDao;
import com.sandbox.hibernate.unoAUno.domain.Corazon;
import com.sandbox.hibernate.unoAUno.domain.Cuerpo;

/**
 * http://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/associations.html#assoc-bidirectional-121
 * Bidirectional associations One-to-one
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"unoAUno-app-context.xml"})
@Transactional
public class UnoAUnoForeignKeyComponenteTest {
    
    @Autowired
    private CuerpoDao cuerpoDao;
    
    @Autowired
    private CorazonDao corazonDao;
    
    @Test
    public void buscaPorId_conCuepoConUnCorazon_retornaCuerpoConUnCorazon() {
        
        Long id = new Long(2L);
        
        Cuerpo resultado = cuerpoDao.buscarPorId(id);
        
        Assert.assertNotNull(resultado);
        Assert.assertEquals(id.longValue(), resultado.getId().longValue());
        Assert.assertNotNull(resultado.getCorazon());
        Assert.assertEquals(3L, resultado.getCorazon().getId().longValue());
    }
    
    
    @Test
    public void buscaPorId_unCorazonExistente_retornaUnCorazon() {
        
        Long id = new Long(2L);
        
        Corazon resultado = corazonDao.buscarPorId(id);
        
        Assert.assertNotNull(resultado);
        Assert.assertEquals(id.longValue(), resultado.getId().longValue());
        Assert.assertEquals("corazon 2", resultado.getDescripcion());
        //Assert.assertEquals(3L, resultado.getCuerpoId().longValue());
    }
}
