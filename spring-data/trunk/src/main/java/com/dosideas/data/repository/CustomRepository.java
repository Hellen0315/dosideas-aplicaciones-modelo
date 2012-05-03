/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author parivero
 */
public interface CustomRepository<T, ID extends Serializable> extends Repository<T, ID> {

    List<T> findAll();
    
    T findOne(ID id);

    T save(T entity);
    
    
    
}
