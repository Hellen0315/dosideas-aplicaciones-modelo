/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.app.controller;

import com.dosideas.app.business.PersonaBo;
import com.dosideas.app.domain.Persona;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author DosIdeas
 */
@Controller
@RequestMapping(value = "/persona")
public class PersonaController {

    @Autowired
    private PersonaBo personaBo;

    @RequestMapping(value = "/guardar", method=RequestMethod.POST)
    public @ResponseBody String guardar(@RequestBody Persona persona) {
        System.out.println("################Guardar##############");
        personaBo.guardar(persona);
        return "Ok";
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Persona buscarPorId(@PathVariable Long id) {

        return personaBo.buscarPorId(id);
    }

    @RequestMapping(value = "/todos")
    public @ResponseBody Collection<Persona> buscarTodos() {

        return personaBo.buscarTodos();
    }
}
