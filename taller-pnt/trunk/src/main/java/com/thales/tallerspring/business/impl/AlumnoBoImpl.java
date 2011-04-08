/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.tallerspring.business.impl;

import com.thales.tallerspring.business.AlumnoBo;
import com.thales.tallerspring.dao.AlumnoDao;
import com.thales.tallerspring.domain.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author parivero
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

    public void borrarPorId(Long id) {
        alumnoDao.borrarPorId(id);
    }
    
    

}
