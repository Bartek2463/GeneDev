package org.example.testgorilla;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Password.controlStringPasswords(new String[]{"P@sswORD1","20PassWORd20","PaSS6Word"},"4dro6");
    }
    public static  String controlStringPasswords(String password[],String control){
        String pas1 = "PASS6wor4d";
        // regular expresion for Upper Letters
        String numberUpperCase = control.substring(0, 1);
        String matchUpCase = String.format(".*[A-Z]{%s}", 2);

        //regular expresion for last three letters
        StringBuilder stringBuilder = new StringBuilder(control.substring(1,4));
        String matchEndThreeWord = String.format("ord", stringBuilder.reverse());

        //regular expresion for sum Number about password equals to control sequence .
        String sumNumberPassword = control.substring(control.length()-1);

        System.out.println(sumNumberPassword);



        int sumNumber = 0;
        for (int i=0;i<pas1.length();i++){
            if (Character.isDigit(pas1.charAt(i))){
              char  isDigit = pas1.charAt(i);
                int a= isDigit -'0';
               sumNumber+=a;

            }

        }





        String pasEndWord = pas1.substring(pas1.length()-3 ,pas1.length());






        int i = Integer.parseInt(numberUpperCase);
        String partPassword = control.substring(1, 4);

        Pattern p = Pattern.compile(matchUpCase);
        for (String passwords: password) {



        }









        return "";
    }
}
