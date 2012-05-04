/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz contiene los métodos comunes implementados por Spring Data a
 * través de la interfaz CrudRepository, y además suma una interfaz propia
 * de la aplicación que contiene una implementación.
 * La implementación final contendrá los métodos implementados por CustomHobbieRepositoryImpl
 * sumados a los métodos implementados automáticamente por Spring Data.
 *
 */
public interface HobbieRepository extends CrudRepository<Hobbie, Long>, CustomHobbieRepository {

}
