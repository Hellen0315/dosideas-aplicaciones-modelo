/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:49hs.
 */
package com.dosideas.testsimplexmlframework.service.impl;

import com.dosideas.testsimplexmlframework.service.XmlService;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;

/**
 * Implementación de la interfaz {@link com.dosideas.testsimplexmlframework.service.XmlService} que utiliza un {@link Serializer} de Simple XML
 * Framework para la des/serialización de XML.
 *
 * @author Nahuel Barrios.
 */
public class XmlServiceImpl implements XmlService {

    public <T> String obtenerXml(T persona) throws Exception {

        Serializer serializer = new Persister();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        serializer.write(persona, outputStream);

        return outputStream.toString();
    }

    public <T> T crear(Class<T> clase, String xml) throws Exception {
        return new Persister().read(clase, xml);
    }

}
