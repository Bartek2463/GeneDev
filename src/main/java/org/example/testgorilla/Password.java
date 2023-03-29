package org.example.testgorilla;

import java.util.*;
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
        Password.controlStringPasswords(new String[]{"P@sswORD1", "20PassWORD20", "PASS6word"}, "0dro6");
    }

    public static String controlStringPasswords(String password[], String control) {
        int upperCaseControlString;
        int sumDigitsControlString;


        summingNumbers(password);

        lastThreeCharacters(password);

        upperCaseControlString = numbersControlString(control).get(0).intValue();
        sumDigitsControlString = numbersControlString(control).get(1).intValue();


        Integer isSumDigitsControlString = summingNumbers(password).stream()
                .filter(num -> num.intValue() == sumDigitsControlString)
                .findAny().orElse(0);



        Integer isUpperCaseControlString = isUpperCase(password).stream()
                .filter(num -> num.intValue() == upperCaseControlString)
                .findAny().orElse(0);

        String threeLetters = control.replaceAll("\\d", "");






        return "";
    }


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




    public static List<Integer> summingNumbers(String password[]) {


        List<Integer> sumNumbers = new ArrayList<>();
        Pattern separationNumberTab = Pattern.compile("\\d+");
        for (String number : password) {
            int sum = 0;
            Matcher matcher = separationNumberTab.matcher(number);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
            sumNumbers.add(sum);
        }
        return sumNumbers;

    }

    public static List<Integer> numbersControlString(String control) {
        List<Integer> numbers = new ArrayList<>();
        Pattern separationNumberString = Pattern.compile("\\d+");
        Matcher num = separationNumberString.matcher(control);

        while (num.find()) {

            String group = num.group();
            Integer integer = Integer.valueOf(group);
            numbers.add(integer);

        }
        return numbers;

    }

    public static List<Integer> isUpperCase(String[]password){
        List<Integer> collect = Arrays.stream(password).map(up -> up.replaceAll("[^A-Z]", ""))
                .map(num -> num.length())
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> lastThreeCharacters(String[]password){

        List<String> collect = Arrays.stream(password)
                .map(last -> last.replaceAll("\\d", ""))
                .map(last -> last.substring(last.length() - 3, last.length()))
                .map(num -> new StringBuilder(num).reverse())
                .map(StringBuilder::toString)
                .collect(Collectors.toList());

        return collect;
    }
  }