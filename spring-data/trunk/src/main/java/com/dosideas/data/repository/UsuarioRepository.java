package com.dosideas.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dosideas.data.domain.Usuario;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * Definimos la interfaz para los usuarios que al heredar de
 * {@link PagingAndSortingRepository} nos habilita métodos para paginar y
 * ordenar los resultados.
 * MVC-REST
 * Mediante la anotación RestResource se indica que no se quiere exponer este
 * repositorio como servicio REST.
 * 
 * @author nbarrios
 */
@RestResource(exported = false)
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

}
