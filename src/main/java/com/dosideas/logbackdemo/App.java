package com.dosideas.logbackdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            logPrueba("leito", i++);
            logPrueba("zim", i++);
            logPrueba("gir", i++);
            Thread.sleep(500);
        }
    }

    private static void logPrueba(String usuario, int i) {
        MDC.put("usuario", usuario);
        logger.debug("Hola mundo como DEBUG, {}", i);
        logger.info("Hola mundo como INFO, {}", i);
        logger.error("Hola mundo como ERROR, {}", i);
        MDC.remove("usuario");
    }
}
