package com.sandbox.hibernate.dummy.dao;

import java.util.List;

import com.sandbox.hibernate.dummy.domain.Dummy;

public interface DummyDao {

    List<Dummy> buscar();

}