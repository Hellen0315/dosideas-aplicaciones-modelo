package com.dosideas.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dosideas.data.domain.Usuario;

/**
 * Definimos la interfaz para los usuarios que al heredar de
 * {@link PagingAndSortingRepository} nos habilita métodos para paginar y
 * ordenar los resultados.
 * 
 * @author nbarrios
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

}
