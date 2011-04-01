package com.dosideas.app.business;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dosideas.app.domain.Persona;
import java.util.Collection;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

/**
 *
 * @author DosIdeas
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml",
    "classpath:app-hibernate.xml",
    "classpath:app-transaction.xml",
    "classpath:app-db-test.xml"})
public class PersonaBoTest {

    @Autowired
    private PersonaBo instance;
    @Autowired
    private DataSource dataSource;
    private SimpleJdbcTemplate simpleJdbcTemplate;
    @Autowired
    private ResourceDatabasePopulator databasePopulator;

    @Before
    public void setUp() throws Exception {

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setEnabled(true);
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.afterPropertiesSet();

        simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);

    }

    @Test
    public void guardar() {

        Persona persona = new Persona();
        persona.setNombre("Sapo");
        persona.setApellido("Pepe");
        persona.setEmail("pepe@sapo.com");

        int beforeCount = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "personas");

        instance.guardar(persona);

        int afterCount = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "personas");

        Assert.assertNotNull(persona.getId());
        Assert.assertEquals(beforeCount + 1, afterCount);


    }

    @Test
    public void buscarPorId() {

        Long id = 200L;

        Persona persona = instance.buscarPorId(id);

        Assert.assertNotNull(persona.getId());
        Assert.assertEquals(id, persona.getId());
        Assert.assertEquals("registro_2", persona.getNombre());
        Assert.assertEquals("registro_2", persona.getApellido());
        Assert.assertEquals("registro_2@registro_2.com", persona.getEmail());

    }

    @Test
    public void buscarPorId_noRetornaPersona() {

        Long id = 103L;

        Persona persona = instance.buscarPorId(id);

        Assert.assertNull(persona);

    }

    @Test
    public void buscarTodos_RetornaTodos() {


        int beforeCount = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "personas");

        Collection<Persona> personas = instance.buscarTodos();

        Assert.assertEquals(beforeCount, personas.size());



    }

    @Test(expected=ConstraintViolationException.class)
    public void guardar_conEmailIncorrecto_lanzaInvalidStateException() {
        Persona persona = new Persona();
        persona.setNombre("Sapo");
        persona.setApellido("Pepe");
        persona.setEmail("pepe sapo.com");
        try {
            instance.guardar(persona);
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation error : ex.getConstraintViolations()) {
                Assert.assertEquals("Email invalido", error.getMessage());
                Assert.assertEquals(persona.getEmail(), error.getInvalidValue());
            }
            throw ex;
        }
    }

    @Test(expected=ConstraintViolationException.class)
    public void guardar_conEmailVacio_lanzaInvalidStateException() {
        Persona persona = new Persona();
        persona.setNombre("Sapo");
        persona.setApellido("Pepe");
        persona.setEmail("");
        try {
            instance.guardar(persona);
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation error : ex.getConstraintViolations()) {
                Assert.assertEquals("Email obligatorio", error.getMessage());
                Assert.assertEquals(persona.getEmail(), error.getInvalidValue());
            }
            
            throw ex;
        }
    }
}
