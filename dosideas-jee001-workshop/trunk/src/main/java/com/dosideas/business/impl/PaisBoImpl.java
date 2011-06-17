/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.business.impl;

import com.dosideas.business.PaisBo;
import com.dosideas.dao.PaisDao;
import com.dosideas.domain.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ldeseta
 */
@Service
@Transactional
public class PaisBoImpl implements PaisBo {

    @Autowired
    private PaisDao paisDao;

    public PaisDao getPaisDao() {
        return paisDao;
    }

    public void setPaisDao(PaisDao paisDao) {
        this.paisDao = paisDao;
    }
    
    public Pais buscarPaisPorId(Long id) {
        return paisDao.buscarPaisPorId(id);
    }   
    
}
