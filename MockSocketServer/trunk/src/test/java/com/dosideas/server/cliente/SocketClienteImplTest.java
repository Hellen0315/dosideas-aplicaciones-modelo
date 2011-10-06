package com.dosideas.server.cliente;

import com.dosideas.server.RequestHandle;
import com.dosideas.server.ServerMock;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.mockito.Mockito.*;

/**
 *
 * @author dosIdeas
 */
@RunWith(JUnit4.class)
public class SocketClienteImplTest {

    /*
     * Cliente TCP.
     */
    private SocketClienteImpl instance = new SocketClienteImpl();;
    
    /*
     * Handler de peticiones para el server
     */
    private static RequestHandle handle;
    
    /*
     * Servidor TCP.
     */
    private static ServerMock serverMock;
    
    
    /*
     * Construimos e iniciamos el server.
     */
    @BeforeClass
    public static void setUp() throws InterruptedException {
        handle = mock(RequestHandle.class);
        serverMock = new ServerMock(handle);
        serverMock.start(4444);
    }

    
    @Test
    public void send_conCaracteres_retornaCaracteres() throws IOException {
        
        doReturn("Hola Pablo").when(handle).handleRequest("Pablo");
        String respuesta = instance.send("localhost", 4444, "Pablo");
        Assert.assertEquals("Hola Pablo", respuesta);

    }
    
    @Test
    public void send_conNumeros_retornaNumeros() throws IOException {

        doReturn("100").when(handle).handleRequest("10");
        String respuesta = instance.send("localhost", 4444, "10");
        Assert.assertEquals("100", respuesta);

    }
    
    @Test(expected=RuntimeException.class)
    public void send_conDatosErroneos_lanzaRuntimeException() throws IOException {

        doThrow(new IOException()).when(handle).handleRequest("-1");
        instance.send("localhost", 4444, "-1");
        Assert.fail();
        

    }
}
