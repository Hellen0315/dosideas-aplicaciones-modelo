package com.dosideas.springintegrationdemo.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.message.GenericMessage;

/**
 * Demo de manejo de JMS con Spring Integration.
 * Se utiliza Apache ActiveMQ en memoria como servidor de mensajería. la 
 * configuración esta en el archivo jms-config.xml.
 * En el archivo jms-context.xml hay dos adaptadores JMS uno para publicar 
 * mensajes y otro para consumirlos.
 * La idea es que el texto que ingresamos por consola se envíe a la queue y 
 * sea consumido y mostrado por consola.
 * 1) Correr la clase.
 * 2) Mediante la consola ingresar cualquier texto.
 * 3) En la misma consola se tiene que loggear el envio como INFO y
 *    el consumo del mensaje como 
 */
public class AppJms 
{
    public static void main( String[] args ) throws IOException
    {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:jms/jms-config.xml","classpath:jms/jms-context.xml"});
        ctx.registerShutdownHook();
        
        DirectChannel channel = (DirectChannel) ctx.getBean("mensajeEntrada");

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
