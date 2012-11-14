package com.dosideas.service.impl;

import com.dosideas.dao.PaisDao;
import com.dosideas.domain.Pais;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Esta clase representa un test de unitario. Los tests de unitarios
 * se encargan de testear una clase en forma aislada al resto de sus
 * dependencias. Para lograr esto se "simulan" las dependencias con
 * objetos falsos que funcionan según nuestras necesidades (Mock Objects).
 *
 * Los tests unitarios funcionan en forma aislada sin ningún otro
 * requerimiento de entorno, ya que todas las dependencias y entorno
 * son simulados.
 *
 * Para ejecutar este test en NetBeans:
 *    click derecho > "Test File" (CTRL + F6)
 *
 * @author ldeseta
 */
public class PaisServiceImplTest {

    /** La instancia bajo test */
    private PaisServiceImpl instance;
    /** El mock del Dao, que inyectaremos a la instancia bajo test */
    @Mock
    private PaisDao paisDaoMock;

    /**
     * Este método se ejecuta antes de iniciar la ejecución de cada
     * método de test. Aquí se realizan preparaciones generales para
     * la ejecución del test.
     * En este caso, se crea un nuevo mock y una nueva instancia de
     * PaisBo, y se inyecta este Dao a PaisBo. De esta manera,
     * nos aseguramos que empezamos cada test con un mock "limpio".
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance = new PaisServiceImpl();
        instance.setPaisDao(paisDaoMock);
    }

    /**
     * Este método se ejecuta luego de finalizar la ejecucación
     * de cada método de test.
     * Cualquier tarea de limpieza se ubica aquí.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarPorId method, of class PaisBoImpl.
     *
     * Este test se encargará de preparar el Mock del Dao para
     * esperar que se lo invoque con el mismo ID que se invoca a PaisBo,
     * y luego devuelva un objeto de Pais.
     *
     * Por último, se verifica que al invocar a paisBo se devuelva la
     * misma instancia que devolvió el Dao.
     *
     */
    @Test
    public void buscarPorId_ConIdExistente_returnaPaisConEseId() {
        Long id = 1L;
        Pais pais = new Pais();
        pais.setId(id);
        pais.setNombre("Pais Mock");

        //preparación del mock
        doReturn(pais).when(paisDaoMock).buscarPorId(id);

        //ejecución
        Pais result = instance.buscarPorId(id);

        //verificamos
        assertEquals(pais, result);
        verify(paisDaoMock).buscarPorId(id);
    }

    /**
     * Test de buscarPorId method con un id existente.
     * El metodo debe encontrar un Pais con el id buscado.
     */
    @Test
    public void buscarPorId_ConIdInexistente_retonraNull() {
        Long id = 1L;

        doReturn(null).when(paisDaoMock).buscarPorId(id);

        Pais pais = instance.buscarPorId(id);

        assertNull(pais);
        verify(paisDaoMock).buscarPorId(id);
    }

    /**
     * Test de buscarPorId method con un id null.
     * El metodo debe tirar una IllegalArgumentException al intengar invocar
     * al metodo con un null.
     */
    @Test(expected = IllegalArgumentException.class)
    public void buscarPorId_ConIdNull_lanzaExcepcion() {

        doThrow(new IllegalArgumentException()).when(paisDaoMock).buscarPorId(null);

        instance.buscarPorId(null);

        fail("Debería haberse lanzado una excepcion.");
    }
}
