package com.dosideas.data.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dosideas.data.domain.Usuario;

/**
 * Test para {@link UsuarioRepository}.
 * 
 * @author nbarrios.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:datasource.xml" })
@Transactional
public class UsuarioRepositoryTest {

    /**
     * {@link UsuarioRepository} que vamos a testear.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void findAllSort_ordenadoPorNombreUsuario_retornaListadoUsuariosOrdenadoPorNombreUsuarioAscendentemente() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll(new Sort("nombreUsuario"));

        Assert.assertNotNull(usuarios);
        Assert.assertFalse(usuarios.isEmpty());

        Usuario primero = usuarios.get(0);
        Assert.assertEquals("jgarcia", primero.getNombreUsuario());

        Usuario segundo = usuarios.get(1);
        Assert.assertEquals("jperez", segundo.getNombreUsuario());

        Usuario tercero = usuarios.get(2);
        Assert.assertEquals("rgonzalez", tercero.getNombreUsuario());
    }
    
    @Test
    public void findAllSort_ordenadoPorNombreUsuario_retornaListadoUsuariosOrdenadoPorNombreUsuarioDescendentemente() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll(new Sort(Direction.DESC, "nombreUsuario"));

        Assert.assertNotNull(usuarios);
        Assert.assertFalse(usuarios.isEmpty());

        Usuario tercero = usuarios.get(0);
        Assert.assertEquals("rgonzalez", tercero.getNombreUsuario());
        
        Usuario segundo = usuarios.get(1);
        Assert.assertEquals("jperez", segundo.getNombreUsuario());
        
        Usuario primero = usuarios.get(2);
        Assert.assertEquals("jgarcia", primero.getNombreUsuario());
    }

}
