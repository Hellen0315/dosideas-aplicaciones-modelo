/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.security;

import com.dosideas.domain.Examen;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    /**
     * Este método se ejecuta con la expresión "hasPermission(object, permiso)". 
     * Se utiliza cuando el método a segurizar recibe el objeto que tiene que
     * evaluarse. 
     * @param authentication contiene al usuario logueado.
     * @param targetDomainObject el objeto a evaluar. 
     * @param permission el permiso a evaluar contra el objeto y el usuario logueado.
     * @return true si el usuario tiene el permiso permission sobre el objeto targetDomainObject, 
     *         false en caso contrario.
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (targetDomainObject instanceof Examen) {
            //acá vendrí la evaluación. 
            //en este caso, sólo vamos a permitir borrar un examen si su fecha
            //es posterior a la actual (un examen que todavía no ocurrió).
            Examen examen = (Examen) targetDomainObject;
            if (examen.getFecha().after(new Date())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método se ejecuta con la expresión "hasPermission(id, tipo, permiso)". 
     * Se utiliza cuando el método a segurizar recibe el identificador único del
     * objeto que tiene que evaluarse. 
     * @param authentication contiene al usuario logueado.
     * @param targetId el identificador único del objeto a evaluar. 
     * @param targetType el tipo de objeto representado por targetId. 
     * @param permission el permiso a evaluar contra el objeto y el usuario logueado.
     * @return true si el usuario tiene el permiso permission sobre el objeto de
     *         tipo targetType con identificador targetId, false en caso contrario.
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if (targetType.equals("Examen")) {
            //acá buscariamos al examen con id targetId en nuestro repositorio de datos.
            //para esta prueba, vamos a construir con una fecha 10 días anteriores a hoy. 
            Examen examen = new Examen();
            examen.setId(Long.parseLong(targetId.toString()));
            Calendar cal = GregorianCalendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -10);
            examen.setFecha(new Date(cal.getTimeInMillis()));
            
            //reusamos el evaluador ya existente
            hasPermission(authentication, examen, permission);
        }
        return false;
    }
}
