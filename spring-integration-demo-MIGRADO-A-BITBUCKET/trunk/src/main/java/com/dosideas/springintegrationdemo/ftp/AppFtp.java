package com.dosideas.springintegrationdemo.ftp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo de FTP de archivos con Spring Integration.
 * En el archivo ftp-context.xml hay configurado un ftp:inbound-channel-adapter,
 * sobre el directorio remoto de salida, que realiza el ftp al directorio tmp 
 * local, un publish-subscribe-channel, asociado a un ftp:inbound-channel-adapter 
 * sobre el directorio tmp, con dos suscriptores, un ftp:outbound-channel-adapter 
 * que realiza el ftp al directorio remoto de entrada y un file:outbound-channel-adapter 
 * que mueve el archivo al directorio local archivos.
 * La idea es crear un archivo en el directorio remoto de salida, este se 
 * transmitirá al directorio local tmp y luego nuevamente se transmitirá al 
 * directorio remoto de entrada. Por ultimo se moverá al directorio local archivos.
 * 1) Correr la clase.
 * 2) Crear el archivo en el directorio de salida remoto.
 * 3) Este archivo se trasfiere al directorio local tmp y luego al directorio 
 *    remosto de entrada.
 * 4) Por ultimo se mueve al directorio de archivos.
 */
public class AppFtp 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ftp/ftp-context.xml");
    }
}
