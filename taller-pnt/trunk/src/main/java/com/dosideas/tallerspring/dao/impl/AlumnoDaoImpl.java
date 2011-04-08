/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.tallerspring.dao.impl;

import com.dosideas.tallerspring.dao.AlumnoDao;
import com.dosideas.tallerspring.domain.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author parivero
 */
@Repository
public class AlumnoDaoImpl implements AlumnoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void guardar(Alumno alumno) {
        sessionFactory.getCurrentSession().save(alumno);

    }

    public Alumno buscarPorId(Long id) {
        return (Alumno) sessionFactory.getCurrentSession().get(Alumno.class, id);
    }


    public void borrarPorId(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        
        Alumno alumno = (Alumno) session.get(Alumno.class, id);

        session.delete(alumno);
    }
}
