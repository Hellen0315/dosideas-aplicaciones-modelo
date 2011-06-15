/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.app.dao.impl;


import com.dosideas.app.dao.AlumnoDao;
import com.dosideas.app.domain.Alumno;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DosIdeas
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


    public void eliminarPorId(Long id) {
        
        Session session = sessionFactory.getCurrentSession();
        
        Alumno alumno = (Alumno) session.get(Alumno.class, id);

        session.delete(alumno);
    }

    public Collection<Alumno> buscarTodos() {
        
        Session session = sessionFactory.getCurrentSession();
        
        return session.createCriteria(Alumno.class).list();
    }
}
