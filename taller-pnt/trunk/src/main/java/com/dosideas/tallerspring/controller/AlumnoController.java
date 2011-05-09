/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.tallerspring.controller;

import com.dosideas.tallerspring.business.AlumnoBo;
import com.dosideas.tallerspring.domain.Alumno;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author DosIdeas
 */
@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {
    
    @Autowired
    private AlumnoBo alumnoBo;
    
    @RequestMapping(value = "/alta", method=RequestMethod.PUT)
    public void alta(@RequestBody @Valid Alumno alumno) {
        alumnoBo.guardar(alumno);
    }
    
    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public @ResponseBody Alumno buscarPorId(@PathVariable Long id) {
        return alumnoBo.buscarPorId(id);
        
    }
    
    @RequestMapping(value = "/todos", method= RequestMethod.GET)
    public @ResponseBody Collection<Alumno> buscarTodos() {
        return alumnoBo.buscarTodos();
    }
    
    @RequestMapping(value = "/{id}/eliminar", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPorId(@PathVariable Long id) {
        alumnoBo.eliminarPorId(id);
    }
    
    
    
    

}
