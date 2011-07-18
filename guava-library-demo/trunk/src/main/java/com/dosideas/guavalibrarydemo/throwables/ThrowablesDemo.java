/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.throwables;

import com.google.common.base.Throwables;

/**
 *
 * @author DosIdeas
 */
public class ThrowablesDemo {

    public static void main(String[] args) {
        try {
            try {
                throw new Exception("Error !!!");
            } catch (Throwable t) {
                throw Throwables.propagate(t);
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
