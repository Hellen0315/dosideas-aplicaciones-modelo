/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:46hs.
 */
package com.dosideas.testsimplexmlframework.service;

import com.dosideas.testsimplexmlframework.domain.Auto;
import com.dosideas.testsimplexmlframework.domain.Modelo;
import com.dosideas.testsimplexmlframework.domain.Rueda;
import com.dosideas.testsimplexmlframework.service.impl.XmlServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de test para el servicio {@link com.dosideas.testsimplexmlframework.service.XmlService}.
 *
 * @author Nahuel Barrios.
 */
public class XmlServiceAutoTest {

    /**
     * Service que estamos testeando.
     */
    private final XmlService xmlService = new XmlServiceImpl();

    /**
     * Test method for obtenerXml.
     */
    @Test
    public void obtenerXml_conPersonaConIdentidadYEdad_retornaXmlEsperado() throws Exception {
        String xmlEsperado = "<auto usado=\"false\">\n" +
                             "   <modelo>\n" +
                             "      <marca>Volkswagen</marca>\n" +
                             "      <nombre>Gol</nombre>\n" +
                             "   </modelo>\n" +
                             "   <ruedas class=\"java.util.ArrayList\">\n" +
                             "      <rueda>\n" +
                             "         <tamaño>15</tamaño>\n" +
                             "         <marca>Firestone</marca>\n" +
                             "      </rueda>\n" +
                             "      <rueda>\n" +
                             "         <tamaño>15</tamaño>\n" +
                             "         <marca>Firestone</marca>\n" +
                             "      </rueda>\n" +
                             "      <rueda>\n" +
                             "         <tamaño>15</tamaño>\n" +
                             "         <marca>Firestone</marca>\n" +
                             "      </rueda>\n" +
                             "      <rueda>\n" +
                             "         <tamaño>15</tamaño>\n" +
                             "         <marca>Firestone</marca>\n" +
                             "      </rueda>\n" +
                             "   </ruedas>\n" +
                             "   <ruedasDeAuxilio class=\"java.util.ArrayList\">\n" +
                             "      <rueda>\n" +
                             "         <tamaño>13</tamaño>\n" +
                             "         <marca>Pirelli</marca>\n" +
                             "      </rueda>\n" +
                             "   </ruedasDeAuxilio>\n" +
                             "</auto>";

        Rueda unaRueda = new Rueda();
        unaRueda.setDiametro(13);
        unaRueda.setMarca("Pirelli");

        List<Rueda> ruedasAuxiliares = new ArrayList<Rueda>();
        ruedasAuxiliares.add(unaRueda);

        List<Rueda> ruedas = new ArrayList<Rueda>();
        for (int cantidadRuedas = 1; cantidadRuedas <= 4; cantidadRuedas++) {
            unaRueda = new Rueda();
            unaRueda.setDiametro(15);
            unaRueda.setMarca("Firestone");
            ruedas.add(unaRueda);
        }

        Modelo modeloAuto = new Modelo();
        modeloAuto.setMarca("Volkswagen");
        modeloAuto.setNombre("Gol");

        Auto auto = new Auto();
        auto.setModelo(modeloAuto);
        auto.setRuedas(ruedas);
        auto.setRuedasAuxiliares(ruedasAuxiliares);


        String xmlObtenido = xmlService.obtenerXml(auto);

        assertNotNull("El XML obtenido NO deberia ser nulo", xmlObtenido);
        assertEquals(xmlEsperado, xmlObtenido);
    }

    /**
     * Test method for crear().
     */
    @Test
    public void crear_conXmlConAutoConTodosSusAtributos_retornaEntidadBienCreada() throws Exception {
        String xmlAuto = "<esteEsUnAuto usado=\"true\">\n" +
                         "<modelo>\n" +
                         "<marca>Volkswagen</marca>\n" +
                         "<nombre>Gol</nombre>\n" +
                         "</modelo>\n" +
                         "<ruedas>\n" +
                         "<rueda>\n" +
                         "<tamaño>15</tamaño>\n" +
                         "<marca>Firestone</marca>\n" +
                         "</rueda>\n" +
                         "<rueda>\n" +
                         "<tamaño>15</tamaño>\n" +
                         "<marca>Firestone</marca>\n" +
                         "</rueda>\n" +
                         "<rueda>\n" +
                         "<tamaño>15</tamaño>\n" +
                         "<marca>Firestone</marca>\n" +
                         "</rueda>\n" +
                         "<rueda>\n" +
                         "<tamaño>15</tamaño>\n" +
                         "<marca>Firestone</marca>\n" +
                         "</rueda>\n" +
                         "</ruedas>\n" +
                         "<ruedasDeAuxilio>\n" +
                         "<rueda>\n" +
                         "<tamaño>13</tamaño>\n" +
                         "<marca>Pirelli</marca>\n" +
                         "</rueda>\n" +
                         "</ruedasDeAuxilio>\n" +
                         "</esteEsUnAuto>";

        Auto autoCreado = xmlService.crear(Auto.class, xmlAuto);

        assertNotNull("La entidad auto creada NO deberia ser nula", autoCreado);

        assertTrue("El auto creado debería ser usado.", autoCreado.esUsado());

        Modelo modelo = autoCreado.getModelo();
        assertNotNull("El modelo del auto creado NO deberia ser nulo", modelo);
        assertEquals("Volkswagen", modelo.getMarca());
        assertEquals("Gol", modelo.getNombre());

        List<Rueda> ruedasPuestas = autoCreado.getRuedas();
        assertNotNull("El listado de ruedas puestas NO deberia ser nulo", ruedasPuestas);
        assertFalse("El listado de ruedas puestas NO puede estar vacío", ruedasPuestas.isEmpty());

        Rueda unaRuedaPuesta = ruedasPuestas.get(0);
        assertEquals(15, unaRuedaPuesta.getDiametro());
        assertEquals("Firestone", unaRuedaPuesta.getMarca());

        List<Rueda> ruedasAuxiliares = autoCreado.getRuedasAuxiliares();
        assertNotNull("El listado de ruedas auxiliares NO deberia ser nulo", ruedasAuxiliares);
        assertEquals(1, ruedasAuxiliares.size());

        Rueda ruedaAuxiliar = ruedasAuxiliares.get(0);
        assertEquals(13, ruedaAuxiliar.getDiametro());
        assertEquals("Pirelli", ruedaAuxiliar.getMarca());
    }

}
