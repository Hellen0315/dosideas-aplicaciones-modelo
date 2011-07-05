package com.dosideas.springintegrationdemo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.message.GenericMessage;

/**
 * Demo de manejo de socket TCP con Spring Integration.
 * En el archivo socket-context.xml hay dos factory tcp una cliente y otra server
 * relacionadas con distintos canales.
 * La idea es realizar una interacción entre el cliente y el server.
 * 1) Correr la clase.
 * 2) Mediante la consola ingresar cualquier texto.
 * 3) En la misma consola se tiene que loggear la respuesta del server 
 *    que en este caso es la longitud del texto enviado.
 */
public class AppSocket 
{
    public static void main( String[] args ) throws IOException
    {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:socket-context.xml");
        ctx.registerShutdownHook();
        
        DirectChannel channel = (DirectChannel) ctx.getBean("peticionCliente");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            if (br.ready()) {
                try {
                    Message<String> m = new GenericMessage<String>(br.readLine());
                    System.out.println("Enviando mensaje: "+ m.getPayload());
                    channel.send(m);
                } catch (Exception ex) {
                    System.out.println("Error enviando mensaje " + ex.getMessage());
                    ex.printStackTrace();
                }


            }
        }
    }
}
