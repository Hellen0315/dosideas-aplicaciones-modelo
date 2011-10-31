package com.sandbox.hibernate.dummy;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.dummy.dao.DummyDao;
import com.sandbox.hibernate.dummy.domain.Dummy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"dummy-app-context.xml"})
@Transactional
public class DummyComponenteTest {

    @Autowired
    private DummyDao instancia;
    
    @Test
    public void buscar_conTresInstanciasExistente_retornaListaConTresInstancias() {
        //ejercitamos
        Collection<Dummy> resultado = instancia.buscar();
        
        //verificamos
        Assert.assertNotNull(resultado);
        Assert.assertFalse(resultado.isEmpty());
        Assert.assertEquals(3L, resultado.size());
    }
    
}
