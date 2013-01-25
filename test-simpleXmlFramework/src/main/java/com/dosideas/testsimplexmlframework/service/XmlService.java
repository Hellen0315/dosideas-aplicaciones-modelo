/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:45hs.
 */
package com.dosideas.testsimplexmlframework.service;

import com.dosideas.testsimplexmlframework.domain.Persona;

/**
 * Servicio de la entidad {@link Persona}.
 *
 * @author Nahuel Barrios.
 */
public interface XmlService {

    /**
     * Crea un XML en formato String a partir de la {@code persona} que le pasamos como parámetro.
     *
     * @param persona
     *         La persona a convertir en formato XML.
     *
     * @return Una persona en formato XML.
     *
     * @throws Exception
     *         Cuando ocurra algún error al serializar el objeto.
     */
    <T> String obtenerXml(T persona) throws Exception;

    /**
     * Crea una entidad Persona a partir del String en formato XML que le pasamos.
     *
     * @param xml
     *         Un String en formato XML conteniendo los atributos de la persona.
     *
     * @return La {@link Persona} creada.
     *
     * @throws Exception
     *         Cuando ocurra algún error al deserializar el objeto.
     */
    <T> T crear(Class<T> clase, String xml) throws Exception;

}
