package com.dosideas.testsimplexmlframework.domain;

import org.simpleframework.xml.Element;

/**
 * Representa una rueda de un {@link Auto}.
 * <p/>
 * Created on 1/25/13, at 1:20 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 */
public class Rueda {

    @Element(name = "tamaño")
    private int diametro;

    @Element
    private String marca;

    public int getDiametro() {
        return diametro;
    }

    public String getMarca() {
        return marca;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
