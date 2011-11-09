/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.security;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The custom PermissionEvaluator for this application. It handles domain object
 * permissions.
 * See: http://static.springsource.org/spring-security/site/docs/3.0.x/reference/el-access.html#el-method-built-in
 */
@Service("security.customPermissionEvaluatorService")
@Transactional
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
