/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.files;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author DosIdeas
 */
public class FilesDemo {

    public static void main(String[] args) {

        List<String> output = null;
        ClassLoader cla = FilesDemo.class.getClassLoader();
        File file = new File(cla.getResource("prueba.txt").getFile());

        try {
            output = Files.readLines(file, Charsets.UTF_8);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
