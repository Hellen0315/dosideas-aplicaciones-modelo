package com.sandbox.hibernate.unoAUno.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.hibernate.unoAUno.dao.CorazonDao;
import com.sandbox.hibernate.unoAUno.domain.Corazon;

@Repository
public class CorazonDaoImpl implements CorazonDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Corazon buscarPorId(Long id) {
        return (Corazon) sessionFactory.getCurrentSession().get(Corazon.class, id);
    }

}
