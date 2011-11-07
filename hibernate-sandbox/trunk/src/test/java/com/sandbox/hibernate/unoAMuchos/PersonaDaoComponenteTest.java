package com.sandbox.hibernate.unoAMuchos;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.unoAMuchos.dao.PersonaDao;
import com.sandbox.hibernate.unoAMuchos.domain.Apodo;
import com.sandbox.hibernate.unoAMuchos.domain.Persona;
import com.sandbox.hibernate.util.BaseComponenteTest;


@ContextConfiguration(locations = {"unoAMuchos-app-context.xml"})
@Transactional
public class PersonaDaoComponenteTest extends BaseComponenteTest {
    
    @Autowired
    private PersonaDao instancia;
    
    @Test
    public void buscaPorId_conPersonaConDosAlias_retornaPersonaConDosAlias() {
        //setUp
        Long id = new Long(2L);
        
        //ejercitamos
        Persona resultado = instancia.buscarPorId(id);
        
        //verificamos
        Assert.assertNotNull(resultado);
        Assert.assertEquals(id.longValue(), resultado.getId().longValue());
        Assert.assertEquals(2, resultado.getApodos().size());
    }

    @Test
    public void guardar_conPersonaConUnAlias_persisteUnaPersonaConUnAlias() {
        //setUp
        Persona unaPersonaNueva = new Persona();
        unaPersonaNueva.setNombre("Juan");
        Apodo unApodo = new Apodo();
        unApodo.setDescripcion("sapoPepe");
        ArrayList<Apodo> apodos = new ArrayList<Apodo>();
        apodos.add(unApodo);        
        unaPersonaNueva.setApodos(apodos);
        
        int cantidadPersonasAntes = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAMuchos.Persona");
        int cantidadApodosAntes = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAMuchos.Apodo");
        
        //ejercitamos
        instancia.guardar(unaPersonaNueva);
        
        //verificamos
        int cantidadPersonasDespues = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAMuchos.Persona");
        int cantidadApodosDespues = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "UnoAMuchos.Apodo");
        
        Assert.assertEquals(cantidadPersonasAntes + 1, cantidadPersonasDespues);
        Assert.assertEquals(cantidadApodosAntes + 1, cantidadApodosDespues);
        
    }
}
