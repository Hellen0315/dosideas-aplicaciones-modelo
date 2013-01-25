package com.dosideas.testsimplexmlframework.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Entidad que representa un auto. Se utiliza para mostrar un ejemplo mas complejo que el de {@link Persona} debido a que esta entidad se compone de
 * otra clase, tiene dos listados de elementos, y además de tener elementos, el XML asociado tiene atributos.
 * <p/>
 * Created on 1/25/13, at 1:18 PM.
 *
 * @author Nahuel Barrios <barrios.nahuel@gmail.com>.
 */
public class Auto {

    @Attribute
    private boolean usado;

    @Element
    private Modelo modelo;

    @ElementList
    private List<Rueda> ruedas;

    @ElementList(name = "ruedasDeAuxilio")
    private List<Rueda> ruedasAuxiliares;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

    public void setRuedas(List<Rueda> ruedas) {
        this.ruedas = ruedas;
    }

    public List<Rueda> getRuedasAuxiliares() {
        return ruedasAuxiliares;
    }

    public void setRuedasAuxiliares(List<Rueda> ruedasAuxiliares) {
        this.ruedasAuxiliares = ruedasAuxiliares;
    }

    public boolean esUsado() {
        return usado;
    }
}
