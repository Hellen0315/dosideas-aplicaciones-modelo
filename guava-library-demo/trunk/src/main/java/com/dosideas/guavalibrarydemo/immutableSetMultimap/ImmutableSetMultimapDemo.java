/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.guavalibrarydemo.immutableSetMultimap;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;

/**
 *
 * @author DosIdeas
 */
public class ImmutableSetMultimapDemo {
    
    public static void main(String[] args) {
        
        // inline
        Multimap<Integer, String> output = 
        ImmutableSetMultimap.of(1, "Josefina", 2, "Nacho", 3, "Lali", 1, "Josefina_2"); 
        System.out.println(output);
        
        // builder
        output = new ImmutableSetMultimap.Builder<Integer, String>()
                    .put(1, "Josefina")
                    .put(2, "Nacho")
                    .put(3, "Lali")
                    .put(1, "Josefina_2")
                    .build();
        System.out.println(output);
        
        
        
    }

}
