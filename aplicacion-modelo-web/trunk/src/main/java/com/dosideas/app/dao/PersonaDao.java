/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.app.dao;


import com.dosideas.app.domain.Persona;
import java.util.Collection;

/**
 *
 * @author DosIdeas
 */
public interface PersonaDao {

    public void guardar(Persona persona);
    public Persona buscarPorId(Long id);
    public Collection<Persona> buscarTodos();

}
