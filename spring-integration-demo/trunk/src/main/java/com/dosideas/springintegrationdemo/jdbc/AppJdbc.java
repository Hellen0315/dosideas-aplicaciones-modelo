package com.dosideas.springintegrationdemo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppJdbc 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:jdbc-context.xml","classpath:jdbc-db.xml"});
    }
}
