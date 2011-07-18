/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.biMap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 *
 * @author DosIdeas
 */
public class BiMapDemo {

    public static void main(String[] args) {

        try {
            BiMap<Integer, String> output = HashBiMap.create();
            output.put(1, "Josefina");
            output.put(2, "Lali");
            output.put(3, "Josefina"); //IllegalArgumentException
        }catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
