package com.sandbox.hibernate.unoAUno;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.unoAUno.dao.CorazonDao;
import com.sandbox.hibernate.unoAUno.dao.CuerpoDao;
import com.sandbox.hibernate.unoAUno.domain.Corazon;
import com.sandbox.hibernate.unoAUno.domain.Cuerpo;
import com.sandbox.hibernate.util.BaseComponenteTest;

/**
 * http://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/associations.html#assoc-bidirectional-121
 * Bidirectional associations One-to-one
 * 
 * http://download.oracle.com/javaee/5/api/javax/persistence/OneToOne.html
 * One-to-one association that maps a foreign key column
 */
@ContextConfiguration(locations = {"unoAUno-app-context.xml"})
@Transactional
public class UnoAUnoForeignKeyComponenteTest extends BaseComponenteTest {
    
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
        Assert.assertEquals(3L, resultado.getCuerpo().getId().longValue());
    }
    
    
    @Test
    public void guardar_conCuerpoConUnCorazon_persisteUnaPersonaConUnCorazon() {
        //setUp
        Cuerpo unCuerpoNuevo = new Cuerpo();
        unCuerpoNuevo.setDescripcion("elCuerpoDeAlguien");
        Corazon unCorazon = new Corazon();
        unCorazon.setDescripcion("es un corazon sano");
        unCuerpoNuevo.setCorazon(unCorazon);
        
        
        int cantidadCuerposAntes = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAUno.Cuerpo");
        int cantidadCorazonesAntes = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAUno.Corazon");
        
        //ejercitamos
        cuerpoDao.guardar(unCuerpoNuevo);
        
        //verificamos
        int cantidadCuerposDespues = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAUno.Cuerpo");
        int cantidadCorazonesDespues = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAUno.Corazon");
        
        Assert.assertEquals(cantidadCuerposAntes + 1, cantidadCuerposDespues);
        Assert.assertEquals(cantidadCorazonesAntes + 1, cantidadCorazonesDespues);
        
    }
}
