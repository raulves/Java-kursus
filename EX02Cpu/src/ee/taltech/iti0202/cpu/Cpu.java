package ee.taltech.iti0202.cpu;
import java.util.HashMap;
import java.util.Map;

public class Cpu {

    public static Map<String, Integer> compute(String instructions) {
        Map<String, Integer> registry = registers(instructions);


        return registry;
    }

    private static Map<String, Integer> registers(String lines) {
        String[] linesList = lines.split("\\r?\\n");
        Map<String, Integer> result = new HashMap<>();


        for (String line: linesList) {
            String[] lineSplit = line.split(" ");
            if (!result.containsKey(lineSplit[0])) {
                result.put(lineSplit[0], 0);

            }
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(registers("b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"));

        var res = compute(
                "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10");
        System.out.println(res); // {a=1, b=0, c=-10}

        res = compute(
                "b inc 7 if a > 4\n" +
                "a inc 1 if c < 13\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10\n" +
                "abc inc 100 if a != -23\n" +
                "a inc 2 if a <= 0");
        System.out.println(res); // {a=1, b=0, c=-10, abc=100}


    }

}
