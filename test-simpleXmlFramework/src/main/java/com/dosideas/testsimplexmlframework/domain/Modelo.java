package com.dosideas.testsimplexmlframework.domain;

import org.simpleframework.xml.Element;

/**
 * Representa el modelo de un {@link Auto}.
 * <p/>
 * Created on 1/25/13, at 1:20 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 */
public class Modelo {

    @Element
    private String marca;

    @Element
    private String nombre;

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
