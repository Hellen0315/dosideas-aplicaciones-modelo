package com.sandbox.hibernate.dummy.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.hibernate.dummy.dao.DummyDao;
import com.sandbox.hibernate.dummy.domain.Dummy;

@Repository
public class DummyDaoImpl implements DummyDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Dummy> buscar() {       
        Session session = sessionFactory.getCurrentSession();
        
        return session.createCriteria(Dummy.class).list();
    }

    
}
