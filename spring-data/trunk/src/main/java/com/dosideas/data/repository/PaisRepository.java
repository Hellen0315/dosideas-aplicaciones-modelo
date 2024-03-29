/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Pais;

/**
 * Esta interfaz no tiene implementación en el proyecto. En tiempo de ejecución
 * se implementaran los métodos expuestos en esta interfaz y los expuestos en la
 * interfaz "ReadOnlyRepository", los autogenerados por Spring Data, definidos en
 * esta interfaz y los namedQuery definidos en la entidad.
 *
 * Leer más en
 * http://static.springsource.org/spring-data/data-jpa/docs/1.0.3.RELEASE/reference/html/#repositories.definition-tuning
 *
 */
public interface PaisRepository extends ReadOnlyRepository<Pais, Long> {
    
    Pais buscarPorNombre(String nombre);
    
}
