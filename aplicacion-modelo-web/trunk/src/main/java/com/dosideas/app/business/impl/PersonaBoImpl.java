/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.app.business.impl;

import com.dosideas.app.business.PersonaBo;
import com.dosideas.app.dao.PersonaDao;
import com.dosideas.app.domain.Persona;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DosIdeas
 */
@Service
@Transactional
public class PersonaBoImpl implements PersonaBo {

    @Autowired
    private PersonaDao personaDao;

    public void guardar(Persona persona) {
        personaDao.guardar(persona);
    }

    public Persona buscarPorId(Long id) {
        return personaDao.buscarPorId(id);
    }

    public Collection<Persona> buscarTodos() {
        return personaDao.buscarTodos();
    }

}
