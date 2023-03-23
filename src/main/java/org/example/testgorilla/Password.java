package org.example.testgorilla;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Password.controlStringPasswords(new String[]{"P@sswORD1","20PassWORd20","PaSS6Word"},"4dro6");
    }
    public static  String controlStringPasswords(String password[],String control){
       // regular expresion for Upper Letters
        String numberUpperCase = control.substring(0, 1);
        String matchUpCase = String.format(".*[A-Z]{%s}", 2);

        //regular expresion for last three letters
        StringBuilder stringBuilder = new StringBuilder(control.substring(1,4));
        String matchEndThreeWord = String.format("ord", stringBuilder.reverse());



        String pas1 = "PASS6word";

        String pasEndWord = pas1.substring(pas1.length()-3 ,pas1.length());


        Pattern pattern = Pattern.compile(matchEndThreeWord);
        Matcher matcher = pattern.matcher(pasEndWord);
        boolean matches = matcher.matches();
        System.out.println(matches);



        int i = Integer.parseInt(numberUpperCase);
        String partPassword = control.substring(1, 4);
        String sumNumberPassword = control.substring(control.length()-1);
        Pattern p = Pattern.compile(matchUpCase);
        for (String passwords: password) {



        }









        return "";
    }
}
