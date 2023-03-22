package org.example.testgorilla;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(sorted(new String[]{"Pierwszy człowiek w kosmosie 12-03-1961"}));
        System.out.println(getWord(123455));
    }
    public static String[] sorted( String[] events ) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(2000, 1, 1);

     List<String> listOfEvents = new ArrayList<String>();
        for(String event: events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if(date.isEmpty()) continue;
            Period timeLeft = Period.between(date.get(),now);


            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(0, dateIndex - 0);
            StringBuilder sb = new StringBuilder();
            sb.append(timeLeft.getYears()).append(" years ;").append(timeLeft.getMonths()).append("Month ;").append(timeLeft.getDays()).append("day ").append("- ").append(title);
            listOfEvents.add(sb.toString());
            String s = sb.toString();
            System.out.println(s);

        }
        listOfEvents.sort((String e1, String e2)->e1.compareTo(e2));

        return listOfEvents.toArray(new String[listOfEvents.size()]);
    }



    private static Optional<LocalDate> findDateInLine(String line,DateTimeFormatter formatter) {


        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.find()) {
            LocalDate date = LocalDate.parse(m.group(), formatter);

            return Optional.of(date);

        }
        return Optional.empty();
    }

    private static String getWord(int number){
        String s = String.valueOf(number);
        char c = s.charAt(s.length()-1);
        String s1 = String.valueOf(c);
        int i = Integer.parseInt(s1);
        if (i==5){
            return "five";
        }else if (i==0){
            return "zero";
        }else  if (number%2==0 && i!=5){
            return "add";
        }else {
            return "";
        }

    }
}
