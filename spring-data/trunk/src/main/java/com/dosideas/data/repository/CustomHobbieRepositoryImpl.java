/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.data.repository;

import com.dosideas.data.domain.Hobbie;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ldeseta
 */
@Repository
public class CustomHobbieRepositoryImpl implements CustomHobbieRepository {

    @Override
    public Collection<Hobbie> findByDescripcion(String descripcion) {

        //realizar la implementación real acá...

        Hobbie hobbie = new Hobbie();
        hobbie.setId(1L);
        hobbie.setDescripcion(descripcion);
        Collection<Hobbie> hobbies = new ArrayList<Hobbie>();
        hobbies.add(hobbie);
        return hobbies;
    }

}
