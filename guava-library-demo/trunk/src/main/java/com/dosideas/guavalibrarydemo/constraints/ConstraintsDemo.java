/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.constraints;

import com.google.common.collect.Constraint;
import static com.google.common.collect.Constraints.*;
import static com.google.common.base.Preconditions.*;
import static com.google.common.collect.Lists.*;
import java.util.Collection;

/**
 *
 * @author DosIdeas
 */
public class ConstraintsDemo {

    public static void main(String[] args) {

        // constrainedCollection
        Constraint<String> debeContenerJoL = new Constraint<String>() {

            @Override
            public String checkElement(String s) {
                checkNotNull(s);
                if (!s.contentEquals("JL")) {
                    throw new IllegalArgumentException("No contiene J ni L");
                }
                return s;
            }
        };

        try {
            Collection<String> input = newArrayList("Josefina");
            Collection<String> output = constrainedCollection(input, debeContenerJoL);
            output.add("Nacho");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Collection<String> input = newArrayList("Josefina");
            Collection<String> output = constrainedCollection(input, notNull());
            output.add(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }



    }
}
