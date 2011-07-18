/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.guavalibrarydemo.tables;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

/**
 *
 * @author DosIdeas
 */
public class TablesDemo {

    public static void main(String[] args) {
        
        Table<Integer, String, String> table = HashBasedTable.create();
        table.put(1, "Hija", "Josefina");
        table.put(1, "Sobrino", "Nacho");
        table.put(1, "Pareja", "Lali");

        Table output = Tables.transpose(table);

        System.out.println(output);
    }
}
