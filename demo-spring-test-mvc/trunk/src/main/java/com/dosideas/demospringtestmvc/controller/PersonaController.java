/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.demospringtestmvc.controller;

import com.dosideas.demospringtestmvc.domain.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author parivero
 */
@Controller
public class PersonaController {
    
    @RequestMapping(value="/persona",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Persona guardar(@RequestBody Persona persona) {
        persona.setId(new Random(Long.MAX_VALUE).nextInt());
        persona.setNombre(persona.getNombre());
        return persona;
    } 
    
    @RequestMapping(value="/persona",method=RequestMethod.GET)
    public @ResponseBody Collection<Persona> buscar() {
        Collection personas = new ArrayList<Persona>();
        Persona persona = new Persona();
        persona.setId((int)Math.random());
        persona.setNombre("coco");
        personas.add(persona);
        personas.add(persona);
        return personas;
    }
    
    @RequestMapping(value="/persona/{id}",method=RequestMethod.GET)
    public @ResponseBody Persona buscarPorId(@PathVariable int id) throws Exception {
        if (id == 2) {
            throw new Exception("No encontrado");
        }
        Persona persona = new Persona();
        persona.setId(id);
        persona.setNombre("coco");
        return persona;
    }
    
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void exceptionGHandler(Exception ex) {
        
    }
    
}
