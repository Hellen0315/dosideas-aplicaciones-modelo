package com.sandbox.hibernate.unoAUno.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.hibernate.unoAUno.dao.CuerpoDao;
import com.sandbox.hibernate.unoAUno.domain.Cuerpo;

@Repository
@Transactional
public class CuerpoDaoImpl implements CuerpoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Cuerpo buscarPorId(Long id) {
        return (Cuerpo) sessionFactory.getCurrentSession().get(Cuerpo.class, id);
    }

    public void guardar(Cuerpo cuerpo) {
        sessionFactory.getCurrentSession().save(cuerpo);            
    }

    public void eliminar(Cuerpo cuerpo) {
        sessionFactory.getCurrentSession().delete(cuerpo);
    }

}
