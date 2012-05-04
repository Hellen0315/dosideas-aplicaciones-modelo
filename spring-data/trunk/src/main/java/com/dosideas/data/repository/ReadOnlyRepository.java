/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 * Es posible crear una interfaz genérica propia para sólo exponer algunos
 * métodos en particular.
 */
public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    List<T> findAll();

    T findOne(ID id);

}
