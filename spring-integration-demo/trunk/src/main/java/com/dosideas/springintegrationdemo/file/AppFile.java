package com.dosideas.springintegrationdemo.file;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo de manejo de archivos con Spring Integration.
 * En el archivo file-context.xml hay configurado un file:inbound-channel-adapter
 * sobre el directorio tmp y un file:outbound-channel-adapter sobre el directorio archivos.
 * La idea es mover los archivos que llegan al directorio tmp al directorio archivos.
 * 1) Correr la clase.
 * 2) Mover los archivo del directorio archivos al directorio tmp.
 * 3) En un segundo deben aparecer nuevamente en el directorio archivos.
 *
 */
public class AppFile 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:file-context.xml");
    }
}
