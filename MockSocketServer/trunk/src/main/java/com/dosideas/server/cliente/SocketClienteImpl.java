package com.dosideas.server.cliente;

import java.io.IOException;
import java.net.Socket;

/**
 *  Cliente TCP.
 * @author dosIdeas
 */
public class SocketClienteImpl {

    private static final int TAMANIO_BUFFER = 1024;

    public String send(String server, int port, String request) {
        byte[] response = new byte[TAMANIO_BUFFER];
        int tamanio = 0;

        try {
            Socket socket = new Socket(server, port);

            socket.getOutputStream().write(request.getBytes());

            socket.getOutputStream().flush();

            tamanio = socket.getInputStream().read(response);
            
            // socket cerrado.
            if (tamanio == -1)
                throw new IOException();

            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new String(response, 0, tamanio);
    }
}
