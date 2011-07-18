/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.multimap;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 *
 * @author DosIdeas
 */
public class MultimapDemo {

    public static void main(String[] args) {
        
        Multimap<Integer, String> output = HashMultimap.create();
        output.put(1, "Josefina");
        output.put(2, "nacho");
        output.put(3, "Lali");
        output.put(1, "Josefina_2");
        
        System.out.println(output);
    }
}
