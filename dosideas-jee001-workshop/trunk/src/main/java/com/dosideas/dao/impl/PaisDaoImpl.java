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
 * Esta clase se encarga de acceder al medio donde se almacenan los datos referidos
 * a un Pais. Esta implementación utiliza Hibernate para acceder a dichos datos.
 *
 * La anotación @Repository es de Spring, y le indica a Spring que
 * esta clase deberá ser tratada como clase de acceso a datos. Spring registrará
 * esta clase para ser inyectada en donde sea necesario.
 *
 * La anotación @Autowired del atributo sessionFactory le indica a Spring que
 * deberá inyectar en dicho atributo una implementación de SessionFactory (que
 * es la clase base de Hibernate para interactuar con las entidades).
 *
 * @author ldeseta
 */
@Repository
public class PaisDaoImpl implements PaisDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Pais buscarPorId(Long id) {
        return (Pais) sessionFactory.getCurrentSession().get(Pais.class, id);
    }
}
