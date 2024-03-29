package com.sandbox.hibernate.unoAUno.dao;

import com.sandbox.hibernate.unoAUno.domain.Cuerpo;

public interface CuerpoDao {

    Cuerpo buscarPorId(Long id);

    void guardar(Cuerpo unCuerpo);

    void eliminar(Cuerpo cuerpo);

}