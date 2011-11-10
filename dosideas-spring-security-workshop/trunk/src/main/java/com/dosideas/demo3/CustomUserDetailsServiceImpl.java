/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.demo3;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esta clase se encarga de cargar los datos de un usuario, útil para integrar
 * con cualquier sistema de usuarios existente. 
 * 
 */
@Service("security.customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    
    
    /**
     * Este método tiene que devolver un UserDetails a partir del username. 
     * Spring Security invoca este método para obtener los detalles de un usuario, 
     * y luego Spring Security realizará la comprobación de seguridad y otras
     * evaluaciones. Est método se puede usar para integrar Spring Security con el
     * sistema de usuarios existente. 
     * 
     * Esta implementación es dummy, y crea un UserDetails fijo para pruebas. 
     * En una implementación real los datos del usuario se sacarían de algún 
     * sistema existente (como ser, un LDAP o una base de datos).
     */    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        
        //Esta es la lista de roles que tiene el usuario.
        List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
        
        //cargamos los roles segun el usuario. En una implementación real, esta
        //información se obtendría de algún sistema, como ser la base de datos.
        if (username.equals("bart")) {
            ga.add(new GrantedAuthorityImpl("ALUMNO"));            
        } else if (username.equals("edna")){
            ga.add(new GrantedAuthorityImpl("PROFESOR"));
        } else if (username.equals("skinner")) {
            ga.add(new GrantedAuthorityImpl("ALUMNO"));            
            ga.add(new GrantedAuthorityImpl("PROFESOR"));
        } else if (username.equals("willy")) {
            ga.add(new GrantedAuthorityImpl("ENCARGADO"));
        }
        
        //El password del usuario. Spring Security comparará el password ingresado
        //contra este password. En una implementación real este password estará
        //encriptado o con un hash, y habrá que informarle a Spring Security 
        //este detalle para que pueda compararlo correctamente. 
        String password = "123";
        
        //construimos el UserDetails. En particular, tiene el nombre de usuario,
        //la contraseña, y los roles. 
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password, true, true, true, true, ga);
        
        return userDetails;
    }
}