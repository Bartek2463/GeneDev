package org.example.testgorilla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * dopoasuj z tablicy stringów według wzoru podanego w ciągu
 * 1 - pierwszy znak to cyfra reprezentująca liczbę wielkich liter w prawidłowym haśle
 * 2 - Kolejne trzy znaki to 3 ostatnie znkaki poprawnego hasła w odwrotonej kolejności
 * 3 - Ostatnie znaki reprezentują sumę wszystkich cyfr w haśle
 */
public class Password {
    public static void main(String[] args) {
        Password.controlStringPasswords(new String[]{"P@sswOD7", "20PassW20", "PASS6word"}, "4dr5o6");
    }

    public static String controlStringPasswords(String password[], String control) {
        Pattern pattern = Pattern.compile("[0-9][^0-9]+[0-9]");
        Matcher matcher = pattern.matcher(control);
        String findPassword = "";
        if (matcher.find()!=true){
            return findPassword;
        }

        List<String> controls = new ArrayList<>();


        for (int i = 0; i < password.length; i++) {
            controls.add(isUpperCase(password).get(i) + lastThreeCharacters(password, control).get(i) + summingNumbers(password).get(i));
            if (control.equals(controls.get(i))) {
                findPassword = password[i];
            }
        }
        System.out.println(findPassword);
        return findPassword;
    }


    public static List<String> summingNumbers(String password[]) {
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
        List<String> collect = sumNumbers.stream()
                .map(String::valueOf)
                .map(String::toString)
                .collect(Collectors.toList());

        return collect;

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

    public static List<String> isUpperCase(String[] password) {
        List<String> collect = Arrays.stream(password).map(up -> up.replaceAll("[^A-Z]", ""))
                .map(num -> num.length())
                .map(String::valueOf)
                .map(String::toString)
                .collect(Collectors.toList());

        return collect;
    }

    public static List<String> lastThreeCharacters(String[] password, String control) {

        List<String> collect = Arrays.stream(password)
                .map(last -> last.replaceAll("\\d", ""))
                .map(last -> last.substring(last.length() - 3, last.length()))
                .map(num -> new StringBuilder(num).reverse())
                .map(StringBuilder::toString)
                .collect(Collectors.toList());


        String threeLetters = control.replaceAll("\\d", "");


        return collect;
    }
}