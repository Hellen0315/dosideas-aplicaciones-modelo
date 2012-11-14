package com.dosideas.controller;

import com.dosideas.domain.Pais;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Esta es la clase controladora que toma las peticiones HTTP.
 * Por medio de esta clase asociaremos las URL con los métodos.
 *
 * A través de la anotación @RequestMapping iremos formando la URL a la cual
 * habrá que acceder para consumir el servicio expuesto.
 * Para consumir algún servicio que se encuentre en este controlador, en la url
 * deberemos pedir acceder a "/pais".
 *
 * La anotación @Controller es de Spring, y le indica a Spring que
 * esta clase deberá ser tratada como clase controlladora. Spring registrará esta
 * clase para ser inyectada en donde sea necesario.
 *
 * La anotación @Autowired del atributo paisService le indica a Spring que
 * deberá inyectar en dicho atributo una implementación de PaisService (que
 * es la clase de negocio para Pais).
 *
 * @author ldeseta
 */
@Controller
@RequestMapping(value = "/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    /**
     * Este va a ser el método que expondremos.
     * La anotación @RequestMapping indica qué valor de la URL mapeará con
     * este método, y además especificaremos el tipo de método por el cual
     * será invocado (en este caso GET).
     *
     * Además, la anotación @PathVariable indica que el parámetro id será
     * tomado de la url para ser usado en el método, y la anotación @ResponseBody
     * indica que un objeto Pais será enviado por medio de json en el body del response.
     *
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Pais buscarPorId(@PathVariable Long id) throws PaisNoEncontradoException {

        Pais pais = paisService.buscarPorId(id);

        if (pais == null) {
            throw new PaisNoEncontradoException("Pais no encontrado");
        }
        return pais;
    }

}
