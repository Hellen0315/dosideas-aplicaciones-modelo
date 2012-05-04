/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import java.util.Collection;

/**
 * Esta es una interfaz propia de la aplicación para Hobbie, que contiene
 * implementaciones propias.
 */
public interface CustomHobbieRepository {

    Collection<Hobbie> findByDescripcion(String descripcion);

}
