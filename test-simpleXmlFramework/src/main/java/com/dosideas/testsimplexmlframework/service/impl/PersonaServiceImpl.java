/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:49hs.
 */
package com.dosideas.testsimplexmlframework.service.impl;

import java.io.ByteArrayOutputStream;

import com.dosideas.testsimplexmlframework.domain.Persona;
import com.dosideas.testsimplexmlframework.service.PersonaService;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * Implementación de la interfaz {@link PersonaService} que utiliza un {@link Serializer} de Simple XML Framework para la des/serialización de
 * XML.
 *
 * @author Nahuel Barrios.
 */
public class PersonaServiceImpl implements PersonaService {

    /**
     * {@inheritDoc}
     */
    public String obtenerXml(Persona persona) throws Exception {

        Serializer serializer = new Persister();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        serializer.write(persona, outputStream);

        return outputStream.toString();
    }

    /**
     * {@inheritDoc}
     */
    public Persona crear(String xml) throws Exception {
        return new Persister().read(Persona.class, xml);
    }

}
