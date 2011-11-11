/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.security;

import java.io.Serializable;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Esta clase es un evaluador de permisos, que permite hacer evaluaciones 
 * arbitrarias sobre cualquier objeto. 
 * Ver más: http://static.springsource.org/spring-security/site/docs/3.0.x/reference/el-access.html#el-method-built-in
 */
@Service("security.customPermissionEvaluatorService")
public class CustomPermissionEvaluatorServiceImpl implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
