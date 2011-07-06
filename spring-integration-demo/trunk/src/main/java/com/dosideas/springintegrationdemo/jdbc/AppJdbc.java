package com.dosideas.springintegrationdemo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo de manejo de sql con Spring Integration.
 * En el archivo jdbc-context.xml hay configurado un jdbc:inbound-channel-adapter
 * que mediante una consulta sql obtiene un mensaje con la colección de registros 
 * de una tabla. La colección del mensaje se divide en mensajes individuales y 
 * dependiendo del valor de una columna se serializa de determinada manera.
 * Se utiliza una base de datos en memoria HQL.
 * 1) Correr la clase.
 * 2) Controlar que por consola se muestren los registros serializados según 
 *    el valor de la columna formato.
 */
public class AppJdbc 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:jdbc/jdbc-context.xml","classpath:jdbc/jdbc-db.xml"});
    }
}
