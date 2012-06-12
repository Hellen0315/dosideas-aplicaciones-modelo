/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import java.util.Collection;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * Esta es una interfaz propia de la aplicación para Hobbie, que contiene
 * implementaciones propias.
 * 
 * MVC-REST
 * Mediante la anotación RestResource se indica el path por el cual se quiere 
 * exponer el metodo como servicio REST y con la anotación Param se indica el 
 * nombre de los paramatros que debe recibir.
 *  * 
 */
public interface CustomHobbieRepository {

    /*
     * Url por la cual se puede invocar el servicio REST.
     * http://localhost:8080/spring-data/hobbie/search/descripcion?descripcion=magic
     */
    @RestResource(path="descripcion", rel="descripciones")
    Collection<Hobbie> findByDescripcion(@Param("descripcion") String descripcion);

}
