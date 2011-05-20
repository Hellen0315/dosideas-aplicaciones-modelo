/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.tallerspring.controller;

import com.dosideas.tallerspring.business.AlumnoBo;
import com.dosideas.tallerspring.domain.Alumno;
import com.dosideas.tallerspring.exception.NotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    

    @RequestMapping(value = "/alta", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alta(@RequestBody Alumno alumno) {
        alumnoBo.guardar(alumno);
    }



    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public @ResponseBody
    Collection<Alumno> buscarTodos() {
        return alumnoBo.buscarTodos();
    }

    @RequestMapping(value = "/{id}/eliminar", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPorId(@PathVariable Long id) {
        alumnoBo.eliminarPorId(id);
    }

    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public @ResponseBody Map<String, String> handleException(ConstraintViolationException ex) {
        Map<String, String> fault = new HashMap<String, String>();
        
        for (ConstraintViolation error : ex.getConstraintViolations() ) {
            fault.put(error.getPropertyPath().toString(),error.getMessage());
        }
        
        return fault;
    }
    
    
    //    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NotFoundException.class)
//    public @ResponseBody
//    Map<String, String> handleException(NotFoundException ex) {
//        Map<String, String> fault = new HashMap<String, String>();
//        fault.put("error", ex.getMensaje());
//        return fault;
//    }
    
    //    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public @ResponseBody
//    Alumno buscarPorId(@PathVariable Long id) throws NotFoundException {
//        Alumno alumno = alumnoBo.buscarPorId(id);
//        if (alumno == null) {
//            throw new NotFoundException("Alumno no encontrado");
//        }
//
//        return alumno;
//
//    }
}
