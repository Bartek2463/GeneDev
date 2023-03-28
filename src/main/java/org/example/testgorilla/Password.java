package org.example.testgorilla;

import javax.lang.model.element.PackageElement;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * dopoasuj z tablicy stringów według wzoru podanego w ciągu
 * 1 - pierwszy znak to cyfra reprezentująca liczbę wielkich liter w prawidłowym haśle
 * 2 - Kolejne trzy znaki to 3 ostatnie znkaki poprawnego hasła w odwrotonej kolejności
 * 3 - Ostatnie znaki reprezentują sumę wszystkich cyfr w haśle
 */
public class Password {
    public static void main(String[] args) {
        Password.controlStringPasswords(new String[]{"P@ssw7RD", "20PassWORd20", "PaSS6W6ord"}, "40pass7");
    }

    public static String controlStringPasswords(String password[], String control) {


        System.out.println("summingNumbers(password, control) = " + summingNumbers(password, control));

// pattern for number

        // pattern for letters








//        String pas1 = "20PassWORd20";
//        // regular expresion for Upper Letters
//        String numberUpperCase = control.substring(0, 1);
//        String matchUpCase = String.format(".*[A-Z]{%s}", 2);
//
//        //regular expresion for last three letters
//        StringBuilder stringBuilder = new StringBuilder(control.substring(1,4));
//        String matchEndThreeWord = String.format("ord", stringBuilder.reverse());
//
//        //regular expresion for sum Number about password equals to control sequence .
//        double sumNumber = 0;
//        for (int i=0;i<pas1.length();i++){
//            if (Character.isDigit(pas1.charAt(i))){
//              char  isDigit = pas1.charAt(i);
//                double a= isDigit -'0';
//               sumNumber+=a;
//
//            }
//
//
//        }
//        String sumNumberPassword = String.valueOf(sumNumber);
//
//        String numberForSum = control.substring(control.length()-1);
//
//        String s = matchUpCase + matchEndThreeWord + numberForSum;
//        System.out.println(s);
//
//
//
//
//        String pasEndWord = pas1.substring(pas1.length()-3 ,pas1.length());
//
//
//        int i = Integer.parseInt(numberUpperCase);
//        String partPassword = control.substring(1, 4);


        return "";
    }
    public static int summingNumbers(String password[],String control){
        Map<Integer,Integer> date = new HashMap<>();
        int value = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Integer> sumNumbers = new ArrayList<>();
        Pattern separationNumberString = Pattern.compile("\\d+");
        Matcher number = separationNumberString.matcher(control);
        while (number.find()) {
            String i = number.group();
            numbers.add(Integer.valueOf(i));
        }

        Pattern separationNumberTab = Pattern.compile("\\d+");
        for (int i = 0;i< password.length;i++) {
            int sum = 0;
            Matcher matcher = separationNumberTab.matcher(password[i]);
            while (matcher.find()) {
               sum+=Integer.parseInt(matcher.group());
                sumNumbers.add(sum);
            }
             sumNumbers.retainAll(numbers);
        }
           try {
              return sumNumbers.get(1);
           }catch (IndexOutOfBoundsException e){
               System.out.println("nie ma indeksu ");
           }
           return sumNumbers.get(1);
    }
}
