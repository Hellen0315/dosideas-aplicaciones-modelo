package com.dosideas.data.repository;

import com.dosideas.data.domain.Persona;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldeseta
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    //@Query("select p from Persona p where p.apellido = ?1")
    List<Persona> findByApellido(String nombre);

}
