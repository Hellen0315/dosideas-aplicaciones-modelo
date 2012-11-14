/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.service.impl;

import com.dosideas.dao.PaisDao;
import com.dosideas.domain.Pais;
import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
 * de dominio Pais.
 *
 * La anotación @Service es de Spring, y le indica a Spring que
 * esta clase deberá ser tratada como clase de servicios. Spring registrará esta
 * clase para ser inyectada en donde sea necesario.
 *
 * La anotación @Transactional indica que todos los métodos de esta clase
 * deberán ser transaccionales (necesario para Hibernate).
 *
 * La anotación @Autowired del atributo paisDao le indica a Spring que
 * deberá inyectar en dicho atributo una implementación de PaisDao (que
 * es la clase de acceso a datos para Pais).
 *
 *
 * @author ldeseta
 */
@Service
@Transactional
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisDao paisDao;

    public PaisDao getPaisDao() {
        return paisDao;
    }

    public void setPaisDao(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    @Override
    public Pais buscarPorId(Long id) {
        return paisDao.buscarPorId(id);
    }

}
