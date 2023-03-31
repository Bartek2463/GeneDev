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
    public  void main(String[] args) {

       Password password = new Password();
       password.controlStringPasswords(new String[]{"P@sswOD7", "20PassW20", "PASS6word"}, "4dro6");
    }

    public  String controlStringPasswords(String password[], String control) {
        Pattern pattern = Pattern.compile("\\d\\D{3}\\d");
        Matcher matcher = pattern.matcher(control);

        String findPassword = "";

        if (matcher.matches() != true) {
            return findPassword;
        }

        List<String> passwordList = new ArrayList<>();

        for (int i = 0; i < password.length; i++) {
            passwordList.add(countingCapitalLetters(password).get(i) + extractLastThreeCharacters(password).get(i) + summingNumbersPasswords(password).get(i));
            if (control.equalsIgnoreCase(passwordList.get(i))) {
                findPassword = password[i];
            }
        }
        return findPassword;
    }
    public List<String> countingCapitalLetters(String[] password) {
        List<String> sumUpperLetters = Arrays.stream(password).map(up -> up.replaceAll("[^A-Z]", ""))
                .map(num -> num.length())
                .map(String::valueOf)
                .map(String::toString)
                .collect(Collectors.toList());

        return sumUpperLetters;
    }


    public  List<String> extractLastThreeCharacters(String[] password) {

        List<String> collect = Arrays.stream(password)
                .map(last -> last.replaceAll("\\d", ""))
                .map(last -> last.substring(last.length() - 3, last.length()))
                .map(num -> new StringBuilder(num).reverse())
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
        return collect;
    }


    public  List<String> summingNumbersPasswords(String password[]) {
        List<Integer> sumNumbersPassword = new ArrayList<>();
        Pattern separationNumberTab = Pattern.compile("\\d+");
        for (String number : password) {
            int sum = 0;
            Matcher matcher = separationNumberTab.matcher(number);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
            sumNumbersPassword.add(sum);
        }
        List<String> sumNumbersToString = sumNumbersPassword.stream()
                .map(String::valueOf)
                .map(String::toString)
                .collect(Collectors.toList());

        return sumNumbersToString;

    }

}