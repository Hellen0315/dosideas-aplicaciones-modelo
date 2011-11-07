package com.sandbox.hibernate.unoAMuchos.dao;

import com.sandbox.hibernate.unoAMuchos.domain.Persona;
/**
 * Expone los servicio de PersonaDao.
 * 
 */
public interface PersonaDao {

    /**
     * Busca una persona por Id.
     * @param id identificador de la persona.
     * @return persona encontrada.
     */
    Persona buscarPorId(Long id);

    /**
     * Persiste una nueva persona.
     * @param persona entidad a persistir.
     */
    void guardar(Persona persona);

}