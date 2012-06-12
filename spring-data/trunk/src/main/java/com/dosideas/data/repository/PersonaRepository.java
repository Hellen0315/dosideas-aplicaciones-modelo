package com.dosideas.data.repository;

import com.dosideas.data.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;


/**
 * Esta interfaz no tiene implementación en el proyecto. Se implementará
 * automáticamente por Spring Data en tiempo de ejecución. La implementación de
 * los métodos se deducirá de acuerdo al nombre del mismo, o usando el query
 * asociado con @Query.
 *
 * La interfaz CrudRepository ya incluye varios métodos comunes de acceso a
 * datos para buscar, guardar, actualizar y eliminar un objeto. 
 *
 * Leer más en
 * http://static.springsource.org/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods
 * 
 * MVC-REST
 * Mediante la anotación RestResource se indica el path por el cual se quiere 
 * exponer el metodo como servicio REST y con la anotación Param se indica el 
 * nombre de los paramatros que debe recibir.
 *
 */
@RestResource(path="persona")
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    /**
     * Busca todas las instancias de Persona con el apellido dado. Este método
     * se implementará automáticamente, deduciendo la implemetnación a partir
     * del nombre del método.
     * Url por la cual se puede invocar el servicio REST.
     * http://localhost:8080/spring-data/persona/search/apellido?apellido=Trout
     */
    @RestResource(path="apellido",rel="porApellido")
    List<Persona> findByApellido(@Param("apellido") String apellido);

    /**
     * Busca todas las instancias de Persona con un nombre y apellido igual al
     * dados.
     * 
     * MVC-REST
     * Url por la cual se puede invocar el servicio REST.
     * http://localhost:8080/spring-data/persona/search/nombreApellido?apellido=Trout&nombre=Kilgore
     */
    @RestResource(path="nombreApellido",rel="porNombreYApellido")
    List<Persona> findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido")  String apellido);

    /**
     * Busca todas las instancias de Persona que pertenecen al pais indicado,
     * segun su nombre. Esta implementación usa un Query específico para
     * resolverse.
     * 
     * MVC-REST
     * Url por la cual se puede invocar el servicio REST.
     * http://localhost:8080/spring-data/persona/search/findByPais?pais=Argentina
     */
    @Query("from Persona p where p.pais.nombre = :pais")
    List<Persona> findByPais(@Param("pais") String pais);

    /**
     * Cambia el nombre de una Persona.
     * La anotación @Modifying indica que este es un query de actualización, por
     * lo tanto los valores posibles de retorno del método son void, int o Integer
     * (que indican la cantidad de filas actualizadas).
     * Los métodos de actualización tienen que ser transaccionales, ya sea
     * anotados con @Transacional o ser ejecutados dentro de una transacción.
     */
    @Modifying
    @Query("update Persona p set p.nombre = ?2 where p.id = ?1")
    int setNombreForPersona(long id, String nombre);

    /**
     * Cambia el apellido de una Persona.
     * Los parametros pueden pasarse también por nombre, usando la anotación @Param
     * para indicar el nombre de cada parámetro.
     */
    @Modifying
    @Query("update Persona p set p.apellido = :nombre where p.id = :id")
    int setApellidoForPersona(@Param("id") long id, @Param("nombre") String nombre);
}
