package org.example;

/**
 * Write a program that converts any given year (from 1 to 3999) to Roman Numeral Examples:
 */
public class Convert {

    public   String romanNumberExamples(int year){
        return "I".repeat(year)
                .replace("IIIII", "V").replace("IIII", "IV")
                .replace("VV", "X").replace("VIV", "IX")
                .replace("XXXXX", "L").replace("XXXX", "XL")
                .replace("LL", "C").replace("LXL", "XC")
                .replace("CCCCC", "D").replace("CCCC", "CD")
                .replace("DD", "M").replace("DCD", "CM");
    }
}
