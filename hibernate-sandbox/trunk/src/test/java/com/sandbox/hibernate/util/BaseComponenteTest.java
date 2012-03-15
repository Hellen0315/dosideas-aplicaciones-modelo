package com.sandbox.hibernate.util;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BaseComponenteTest {
    @Autowired
    protected DataSource dataSource;

    protected SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Autowired
    protected SessionFactory sessionFactory;
    
    @Before
    public void setUp() {
        simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
}
