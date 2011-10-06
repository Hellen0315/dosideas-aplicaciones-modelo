package com.dosideas.server;

import java.io.IOException;

/**
 * Interface a mockear utilizada por el servidor.
 * @author dosIdeas
 */
public interface RequestHandle {
    
    Object handleRequest(Object request) throws IOException;
    
}
