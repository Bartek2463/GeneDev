package org.example.testgorilla;

import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Password.controlStringPasswords(new String[]{"P@sswORD1","20passWORD20","PASS6word"},"4dro6");
    }
    public static  String controlStringPasswords(String password[],String control){
        String numberUpperCase = control.substring(0, 1);
        String partPassword = control.substring(1, 4);
        String sumNumberPassword = control.substring(control.length()-1);


        StringBuilder stringBuilder = new StringBuilder(partPassword);
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(reverse);
        Pattern pattern = Pattern.compile("");
        return "";
    }
}
