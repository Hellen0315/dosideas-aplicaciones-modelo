/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.app.dao.impl;

import com.dosideas.app.dao.PersonaDao;
import com.dosideas.app.domain.Persona;
import java.util.Collection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DosIdeas
 */
@Repository
public class PersonaDaoImpl implements PersonaDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void guardar(Persona persona) {
        sessionFactory.getCurrentSession().save(persona).toString();
    }

    public Persona buscarPorId(Long id) {
        return (Persona) sessionFactory.getCurrentSession().get(Persona.class, id);
    }

    public Collection<Persona> buscarTodos() {
        return sessionFactory.getCurrentSession().createQuery("from Persona p").list();
    }



}
