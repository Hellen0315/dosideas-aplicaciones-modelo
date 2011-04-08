/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.tallerspring.business;

import com.thales.tallerspring.domain.Alumno;
import com.thales.tallerspring.domain.Curso;
import com.thales.tallerspring.domain.Materia;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import org.junit.Assert;
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

/**
 *
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:tallerSpring-context.xml",
    "classpath:tallerSpring-hibernate.xml",
    "classpath:tallerSpring-transaction.xml",
    "classpath:tallerSpring-db-test.xml"})
public class AlumnoBoTest {

    @Autowired
    private AlumnoBo instance;
    
    @Autowired
    private DataSource dataSource;
    
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Before
    public void setUp() {
        simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
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
                     
        int filasFinAlumnos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumnos");
        int filasFinAlumnoCurso = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "alumno_curso");
        int filasFinCursos = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "cursos");
        int filasFinMaterias = SimpleJdbcTestUtils.countRowsInTable(simpleJdbcTemplate, "materias");
                
        Assert.assertEquals(filasIniAlumnos - 1, filasFinAlumnos);
        Assert.assertEquals(filasIniAlumnoCurso -2 , filasFinAlumnoCurso);
        Assert.assertEquals(filasIniCursos , filasFinCursos);
        Assert.assertEquals(filasIniMaterias , filasFinMaterias);
    }

    
}
