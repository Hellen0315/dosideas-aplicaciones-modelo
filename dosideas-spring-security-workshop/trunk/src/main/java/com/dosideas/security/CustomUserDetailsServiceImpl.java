/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.security;

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

@Service("security.customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
                
        List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();        
        ga.add(new GrantedAuthorityImpl("USER"));
        
        String password = "123";
        
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, password, true, true, true, true, ga);
        
        return userDetails;
    }
}