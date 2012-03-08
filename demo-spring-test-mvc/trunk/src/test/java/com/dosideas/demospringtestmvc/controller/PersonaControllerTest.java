/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.demospringtestmvc.controller;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import org.springframework.test.web.server.setup.MockMvcBuilders;

/**
 *
 * @author parivero
 */
public class PersonaControllerTest {
    
    @Test
    public void guardar_retorna_persona_con_id() throws Exception {
        String personaJson = "{\"nombre\":\"coco\"}";
        MockMvcBuilders.standaloneSetup(new PersonaController()).build()
                /* Operación y servicio */
                .perform(post("/persona")
                /* Content type para indicar formato de la información del body */
                .contentType(MediaType.APPLICATION_JSON)
                /* Accep para que la respuesta sea JSON */
                .accept(MediaType.APPLICATION_JSON)
                /* Set del body */
                .body(personaJson.getBytes()))
                /* Imprime por consola */
                .andDo(print())
                /* Control del status http */
                .andExpect(status().isCreated())
                /* Control de que exista el atributo nombre */
                .andExpect(jsonPath("nombre").exists())
                /* Control de que exista el atributo id */
                .andExpect(jsonPath("id").exists())
                /* Control del valor del atributo nombre */
                .andExpect(jsonPath("nombre").value("coco"));
                
    }
    
    @Test
    public void buscar_retorna_coleccion_de_personas() throws Exception {
        MockMvcBuilders.standaloneSetup(new PersonaController()).build()
                .perform(get("/persona")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("nombre").exists())
                /* Control de los valores que contiene el atributo nombre de la colección */
                .andExpect(jsonPath("[?(@.nombre = '%s')]","coco").exists()) 
                /* Control del tamaño de la colección */
                .andExpect(jsonPath("nombre",hasSize(equalTo(2))));
                
    }
    
    @Test
    public void buscarPorid_retorna_persona_con_id_y_nombre() throws Exception {
        int id = 1;
        MockMvcBuilders.standaloneSetup(new PersonaController()).build()
                .perform(get("/persona/"+id)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("nombre").exists())
                .andExpect(jsonPath("nombre").value("coco"))
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("id").value(id));
    }
    
    @Test
    public void buscarPorid_retorna_persona_no_encontrada() throws Exception {
        int id = 2;
        MockMvcBuilders.standaloneSetup(new PersonaController()).build()
                .perform(get("/persona/"+id).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
