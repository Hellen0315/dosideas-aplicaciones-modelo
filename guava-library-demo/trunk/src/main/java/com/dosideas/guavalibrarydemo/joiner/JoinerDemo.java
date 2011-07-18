/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.guavalibrarydemo.joiner;

import com.google.common.base.Joiner;
import static com.google.common.collect.Maps.*;
import java.util.Map;

/**
 *
 * @author DosIdeas
 */
public class JoinerDemo {
    
    public static void main(String[] args) {
        
        // join
        String[] nombres = {"Josefina", "Nacho", "Lali", "Coco"};
        String output = Joiner.on(", ").join(nombres);
        System.out.println(output);
        
        // skipNulls
        String[] nombres2 = {null, "Josefina", null, "Nacho", null, "Lali", null, "Coco"};
        output = Joiner.on(", ").skipNulls().join(nombres2);
        System.out.println(output);
        
        //useForNull
        String[] nombres3 = {null, "Josefina", null, "Nacho", null, "Lali", null, "Coco"};
        output = Joiner.on(", ").useForNull("n/a").join(nombres3);
        System.out.println(output);
        
        //withKeyValueSeparator
        Map<Integer, String> map = newHashMap();
        map.put(1, "Josefina");
        map.put(2, "Nacho");
        map.put(3, "Lali");
        output = Joiner.on(", ").withKeyValueSeparator(" -> ").join(map);
        System.out.println(output);
        
 

    }

}
