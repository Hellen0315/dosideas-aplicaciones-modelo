/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.collection2;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import static com.google.common.collect.Lists.*;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author DosIdeas
 */
public class Collection2Demo {

    public static void main(String[] args) {

        // filter
        List<String> input = newArrayList("Josefina", "Nacho", "Lali");
        Collection<String> output = Collections2.filter(input, new Predicate<String>() {

            public boolean apply(String t) {
                if (t.contains("i")) {
                    return true;
                }
                return false;
            }
        });

        System.out.println(output);

        // transform
        input = newArrayList("Josefina", "Nacho", "Lali");
        output = Collections2.transform(input, new Function<String, String>() {
            public String apply(String f) {
                return f.replaceAll("fina", "");
            }
        });

        System.out.println(output);

    }
}
