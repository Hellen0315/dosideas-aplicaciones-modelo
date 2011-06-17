/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.dao.impl;

import com.dosideas.dao.PaisDao;
import com.dosideas.domain.Pais;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ldeseta
 */
@Repository
public class PaisDaoImpl implements PaisDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Pais buscarPaisPorId(Long id) {
        return (Pais) sessionFactory.getCurrentSession().get(Pais.class, id);
    }
}
