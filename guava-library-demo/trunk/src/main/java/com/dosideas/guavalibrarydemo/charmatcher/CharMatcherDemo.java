/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dosideas.guavalibrarydemo.charmatcher;

import com.google.common.base.CharMatcher;

/**
 *
 * @author DosIdeas
 */
public class CharMatcherDemo {
    
    public static void main(String[] args) {
        // and / or
        String input = "La fecha es : 01/01/2011";
        CharMatcher charMatcher = CharMatcher.DIGIT.or(CharMatcher.is('/'));
        String output = charMatcher.retainFrom(input);
        System.out.println(output);
        
        // negate
        input = "MAYUSCULA minuscula";
        charMatcher = CharMatcher.JAVA_LOWER_CASE.or(CharMatcher.WHITESPACE).negate();
        output = charMatcher.retainFrom(input);
        System.out.println(output);
        
        // inRange
        input = "Solo quedan los numeros 1, 2, 3, 4 que son menores a  5 ";
        charMatcher = CharMatcher.inRange('0', '4').or(CharMatcher.WHITESPACE);
        output = charMatcher.retainFrom(input);
        System.out.println(output);
        
    }

}
