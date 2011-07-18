/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.guavalibrarydemo.splitter;

import com.google.common.base.Splitter;
import static com.google.common.collect.Lists.*;
import java.util.List;

/**
 *
 * @author DosIdeas
 */
public class SplitterDemo {
    
    public static void main(String[] args) {
        
        // Split
        String input = "Josefina|Nacho|Lali";
        Iterable<String> split = Splitter.on("|").split(input);
        List<String> output = newArrayList(split);
        System.out.println(output);
        
        // fixedLength
        input ="Josefina  Nacho     Lali      ";
        Iterable<String> splitted = Splitter.fixedLength(10).trimResults().split(input);
        output = newArrayList(splitted);
        System.out.println(output);
        
        // onPattern
        input ="Josefina Nacho Lali";
        splitted = Splitter.onPattern("[a-z&&[aeiou]]").omitEmptyStrings().split(input);
        output = newArrayList(splitted);
        System.out.println(output);
        
    }

}
