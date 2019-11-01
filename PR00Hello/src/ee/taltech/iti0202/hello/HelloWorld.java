package ee.taltech.iti0202.hello;

import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        // Prints "Hello world!" to console window.
        System.out.println("Hello, world!");

        List<String> games = new ArrayList<String>();
        games.add("football");
        System.out.println(games);
        System.out.println(games.contains("football"));
        System.out.println(games.indexOf("football"));
        System.out.println(games.get(0));
        System.out.println(games.isEmpty());
        // System.out.println(games.remove("football"));
        System.out.println(games);

        String[] colours = {"red", "green", "yellow"};
        System.out.println(games.size());
        System.out.println(games.get(0).length());

        Map<String, Integer> hostCities = new HashMap<String, Integer>();

        hostCities.put("Beijing", 2008);
        hostCities.put("London", 2012);
        hostCities.put("Rio de Janeiro", 2016);

        for (String city: hostCities.keySet()) {
            System.out.println(city);
            System.out.println(hostCities.get(city));


        }

        String compute = "b inc 7 if a > 4\n" +
                "a inc 1 if c < 13\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10\n" +
                "abc inc 100 if a != -23\n" +
                "a inc 2 if a <= 0";
        String[] lines = compute.split("\\r?\\n");

        for (String line: lines) {
            System.out.println(line);
            System.out.println(line.charAt(0));
            System.out.println("yes");
        }


        System.out.println(156);
        System.out.println(156 % 10);
        System.out.println(150 % 100);
        System.out.println(150 - 100);
    }



}
