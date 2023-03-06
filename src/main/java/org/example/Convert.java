package org.example;

/**
 * Write a program that converts any given year (from 1 to 3999) to Roman Numeral Examples:
 */
public class Convert {

    public   String romanNumberExamples(int year){
        String repeat = "I".repeat(year);
        System.out.println(repeat);
        return repeat;
    }
}
