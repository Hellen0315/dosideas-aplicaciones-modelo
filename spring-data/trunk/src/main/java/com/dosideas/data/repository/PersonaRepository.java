package com.dosideas.data.repository;

import com.dosideas.data.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Esta interfaz no tiene implementación en el proyecto. Se implementará
 * automáticamente por Spring Data en tiempo de ejecución. La implementación de
 * los métodos se deducirá de acuerdo al nombre del mismo, o usando el query
 * asociado con @Query.
 *
 * Leer más en http://static.springsource.org/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods
 *
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    /**
     * Busca todas las instancias de Persona con el apellido dado. Este método
     * se implementará automáticamente, deduciendo la implemetnación a partir
     * del nombre del método.
     */
    List<Persona> findByApellido(String apellido);

    /**
     * Busca todas las instancias de Persona con un nombre y apellido igual
     * al dados.
     */
    List<Persona> findByNombreAndApellido(String nombre, String apellido);

    /**
     * Busca todas las instancias de Persona que pertenecen al pais indicado,
     * segun su nombre.
     * Esta implementación usa un Query específico para resolverse.
     */
    @Query("select p from Persona p where p.pais.nombre = ?1")
    List<Persona> findByPais(String pais);
}

