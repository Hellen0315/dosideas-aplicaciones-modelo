package com.sandbox.hibernate.unoAMuchos.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.hibernate.unoAMuchos.dao.PersonaDao;
import com.sandbox.hibernate.unoAMuchos.domain.Persona;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Persona buscarPorId(Long id) {
        return (Persona) sessionFactory.getCurrentSession().get(Persona.class, id);
    }


}
