/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.ordering;

import static com.google.common.collect.Lists.*;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author DosIdeas
 */
public class OrderingDemo {

    public static void main(String[] args) {

        // sortedCopy
        List<String> input = newArrayList("Josefina", "Nacho", "Lali");

        Ordering<String> ordering = Ordering.from(new Comparator< String>() {

            @Override
            public int compare(String string1, String string2) {
                return Ints.compare(string1.length(), string2.length());

            }
        });

        List<String> output = ordering.sortedCopy(input);
        System.out.println(output);
        
        
    }
}
