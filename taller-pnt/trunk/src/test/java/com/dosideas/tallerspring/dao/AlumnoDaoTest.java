/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.tallerspring.dao;

import com.dosideas.tallerspring.domain.Alumno;
import com.dosideas.tallerspring.domain.Curso;
import com.dosideas.tallerspring.domain.Materia;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import junit.framework.Assert;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:tallerSpring-context.xml",
    "classpath:tallerSpring-hibernate.xml",
    "classpath:tallerSpring-transaction.xml",
    "classpath:tallerSpring-db-test.xml"})
@Transactional
public class AlumnoDaoTest {

    @Autowired
    private AlumnoDao instance;
    @Autowired
    private DataSource dataSource;
    private SimpleJdbcTemplate simpleJdbcTemplate;
    @Autowired
    private SessionFactory session;

    @Before
    public void setUp() {
        simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        Resource resourceDropEsquema = new ClassPathResource("tallerSpring-drop-schema.sql");
        Resource resourceEsquema = new ClassPathResource("tallerSpring-schema.sql");
        Resource resourceDatos = new ClassPathResource("tallerSpring-inserta_registros.sql");
        SimpleJdbcTestUtils.executeSqlScript(simpleJdbcTemplate, resourceDropEsquema, false);
        SimpleJdbcTestUtils.executeSqlScript(simpleJdbcTemplate, resourceEsquema, false);
        SimpleJdbcTestUtils.executeSqlScript(simpleJdbcTemplate, resourceDatos, false);

    }

    @Test
    public void guardar_conDatosValidos_casoOk() {

        Alumno alumno = new Alumno();
        alumno.setNombre("Sapo");
        alumno.setApellido("Pepe");
        alumno.setEmail("pepe@sapo");


        Curso curso = new Curso();
        Materia materia = new Materia();
        materia.setNombre("Base de datos");
        curso.setMateria(materia);
        curso.setTitulo("Taller hibernate");

        Collection<Curso> cursos = new ArrayList<Curso>();
        cursos.add(curso);

        alumno.setCursos(cursos);

        int filasIniAlumnos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumnos");
        int filasIniAlumnoCurso = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumno_curso");
        int filasIniCursos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "cursos");
        int filasIniMaterias = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "materias");

        instance.guardar(alumno);
        session.getCurrentSession().flush();

        int filasFinAlumnos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumnos");
        int filasFinAlumnoCurso = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumno_curso");
        int filasFinCursos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "cursos");
        int filasFinMaterias = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "materias");


        Assert.assertNotNull(alumno.getId());

        Assert.assertEquals(filasIniAlumnos + 1, filasFinAlumnos);
        Assert.assertEquals(filasIniAlumnoCurso + 1, filasFinAlumnoCurso);
        Assert.assertEquals(filasIniCursos + 1, filasFinCursos);
        Assert.assertEquals(filasIniMaterias + 1, filasFinMaterias);


    }

    @Test
    public void buscarPorId_conIdValido_retornaAlumno() {

        Alumno alumno = instance.buscarPorId(1L);

        Assert.assertNotNull(alumno);
        Assert.assertEquals("Jose", alumno.getNombre());
        Assert.assertEquals(2, alumno.getCursos().size());


    }

    @Test
    public void borrarPorId_conIdValido_borraAlumno() {

        int filasIniAlumnos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumnos");
        int filasIniAlumnoCurso = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumno_curso");
        int filasIniCursos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "cursos");
        int filasIniMaterias = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "materias");

        instance.borrarPorId(2L);
        session.getCurrentSession().flush();

        int filasFinAlumnos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumnos");
        int filasFinAlumnoCurso = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumno_curso");
        int filasFinCursos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "cursos");
        int filasFinMaterias = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "materias");

        Assert.assertEquals(filasIniAlumnos - 1, filasFinAlumnos);
        Assert.assertEquals(filasIniAlumnoCurso - 2, filasFinAlumnoCurso);
        Assert.assertEquals(filasIniCursos, filasFinCursos);
        Assert.assertEquals(filasIniMaterias, filasFinMaterias);
    }

    @Test
    public void guardar_alumnoConEmailIncorrecto_lanzaConstraintViolationException() {

        Alumno alumno = new Alumno();
        alumno.setNombre("Sapo");
        alumno.setApellido("Pepe");
        alumno.setEmail("pepe sapo");
        try {

            instance.guardar(alumno);
            session.getCurrentSession().flush();
            Assert.fail();
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation error : ex.getConstraintViolations()) {
                Assert.assertEquals("not a well-formed email address", error.getMessage());
                Assert.assertEquals(alumno.getEmail(), error.getInvalidValue());
            }
        }

    }
    
    @Test
    public void guardar_alumnoConVacio_lanzaConstraintViolationException() {

        Alumno alumno = new Alumno();
        alumno.setNombre("Sapo");
        alumno.setApellido("Pepe");
                
        try {

            instance.guardar(alumno);
            session.getCurrentSession().flush();
            Assert.fail();
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation error : ex.getConstraintViolations()) {
                Assert.assertEquals("may not be null", error.getMessage());
                Assert.assertEquals(alumno.getEmail(), error.getInvalidValue());
            }
        }
    }
    
    
}
