package com.dosideas.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Excepción lanzada en caso de no encontrar el pais buscado.
 *
 * Por medio de la anotación @ResponseStatus indicamos que, en caso de
 * que esta excepción sea lanzada, se le asociará el código de error NOT_FOUND (404).
 * De esta forma el cliente verá dicho error.
 *
 * @author DosIdeas
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends Exception {

    /**
     * Constructor de la excepción que llama al constructor de la clase padre.
     * @param mensaje - mensaje utilizado por la excepción.
     */
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
