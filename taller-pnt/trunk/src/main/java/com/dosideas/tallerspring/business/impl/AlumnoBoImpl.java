/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.tallerspring.business.impl;

import com.dosideas.tallerspring.business.AlumnoBo;
import com.dosideas.tallerspring.dao.AlumnoDao;
import com.dosideas.tallerspring.domain.Alumno;
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
public class AlumnoBoImpl implements AlumnoBo {

    @Autowired
    private AlumnoDao alumnoDao;

    
    public void guardar(Alumno alumno) {
        alumnoDao.guardar(alumno);
    }

    public Alumno buscarPorId(Long id) {
        return alumnoDao.buscarPorId(id);
    }

    public void eliminarPorId(Long id) {
        alumnoDao.eliminarPorId(id);
    }

    public Collection<Alumno> buscarTodos() {
        return alumnoDao.buscarTodos();
    }
    
    

}
