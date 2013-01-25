/**
 * Created by: Nahuel Barrios.
 * On: 22/01/13 at 15:38hs.
 */
package com.dosideas.testsimplexmlframework.domain;

import org.simpleframework.xml.Element;

/**
 * Entidad de dominio que vamos a des/serializar. Este es el caso de ejemplo más sencillo.
 *
 * @author Nahuel Barrios.
 */
public class Persona {

    @Element
    private String identidad;

    @Element
    private int edad;

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
