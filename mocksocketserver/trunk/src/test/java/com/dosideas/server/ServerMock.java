package com.dosideas.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un servidor TCP para utilizar en los test de componentes.
 * @author dosIdeas
 */
public class ServerMock implements Runnable {

    /**
     * Interfase a mockear.
     */
    private RequestHandle handle;
    /**
     * Puerto
     */
    private int listenPort;
    /**
     * Tamaño maximo del mensaje.
     */
    private static final int TAMANIO_BUFFER = 1024;

    public ServerMock(RequestHandle serverRequestHandle) {
        this.handle = serverRequestHandle;
    }

    /**
     * Metodo para iniciar el server.
     * @throws InterruptedException 
     */
    public void start(int port) throws InterruptedException {
        this.listenPort = port;
        
        (new Thread(this)).start();

        // Esperamos hasta estar en el accept (notify).
        synchronized (this) {
            this.wait();
        }

    }

    @Override
    public void run() {
        try {

            ServerSocket serverSocket = new ServerSocket(listenPort);

            while (serverSocket != null) {
                Socket socket = null;
                System.out.println("Creando socket.");

                // Avisamos que estamos en el accept (sigue a partir del wait).
                synchronized (this) {
                    this.notify();
                }
                socket = serverSocket.accept();
                System.out.println("Conexión de: " + socket.getRemoteSocketAddress().toString());

                String peticion = null;
                String respuesta = null;

                while (true) {
                    byte[] request = new byte[TAMANIO_BUFFER];
                    try {
                        int tamanio = socket.getInputStream().read(request);
                        peticion = new String(request, 0, tamanio);
                        System.out.println("Reuqest: " + peticion);

                        // Invocamos la interface mockeada.
                        respuesta = (String) handle.handleRequest(peticion);

                        System.out.println("Response: " + respuesta.toString());
                        socket.getOutputStream().write(respuesta.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                        // Cerramos el socket para retornar -1.
                        socket.close();
                    }
                    // Volvemos al accept.
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}