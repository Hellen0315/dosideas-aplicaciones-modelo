package com.sandbox.hibernate.unoAUno.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.hibernate.unoAUno.dao.CuerpoDao;
import com.sandbox.hibernate.unoAUno.domain.Cuerpo;

@Repository
public class CuerpoDaoImpl implements CuerpoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Cuerpo buscarPorId(Long id) {
        return (Cuerpo) sessionFactory.getCurrentSession().get(Cuerpo.class, id);
    }

    @Override
    public void guardar(Cuerpo cuerpo) {
        sessionFactory.getCurrentSession().save(cuerpo);            
    }

}
