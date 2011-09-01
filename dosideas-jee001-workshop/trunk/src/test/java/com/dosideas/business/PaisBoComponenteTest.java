package com.dosideas.business;

import com.dosideas.domain.Pais;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

/**
 * Esta clase representa un test de componente. Los tests de componentes
 * se encargan de testear una clase en particular, y todas las dependencias
 * que la misma tiene. 
 * 
 * Este test comprueba el funcionamiento de la clase PaisDao. Esta clase
 * utiliza Hibernate para acceder a la base de datos. Es necesario tener
 * entonces la base de datos iniciada, con el modelo de datos del workshop
 * cargado (ver archivo "Instrucciones para crear la BD").
 *
 * Para iniciar la base de datos: 
 *   Ir al menu Window > Services > Databases > Java DB > Click derecho > Start server
 * 
 * Para ejecutar este test en NetBeans: 
 *    click derecho > "Test File" (CTRL + F6)
 * 
 * @author ldeseta
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "/application-db.xml",
    "/application-dao.xml",
    "/application-business.xml",
    "/application-hibernate.xml"
})
@Transactional
public class PaisBoComponenteTest {

    /** La instancia bajo test. 
     *  La anotación @Autowired hará que Spring la inyecte automáticamente 
     */
    @Autowired
    private PaisBo instance;

    /**
     * Test de buscarPaisPorId method con un id existente. 
     * El metodo debe encontrar un Pais con el id buscado.
     */
    @Test
    public void buscarPaisPorIdConIdExistente() {
        Long id = 1L;

        Pais pais = instance.buscarPaisPorId(id);

        assertNotNull(pais);
        assertEquals(id, pais.getId());
        assertEquals("Argentina", pais.getNombre());
    }

    /**
     * Test de buscarPaisPorId method con un id inexistente. 
     * El metodo debe devolver null al buscar un id que no existe.
     */
    @Test
    public void buscarPaisPorIdConIdInexistente() {
        Long id = 21L;

        Pais pais = instance.buscarPaisPorId(id);

        assertNull(pais);
    }

    /**
     * Test de buscarPaisPorId method con un id null. 
     * El metodo debe tirar una IllegalArgumentException al intengar invocar
     * al metodo con un null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void buscarPaisPorIdConIdNull() {
        instance.buscarPaisPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
}
