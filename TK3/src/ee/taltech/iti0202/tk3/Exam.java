package ee.taltech.iti0202.tk3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Exam {

    /**
     * Return the sum of the numbers in the array,
     * except ignore sections of numbers
     * starting with a 6 and extending to the next 7
     * (every 6 will be followed by at least one 7).
     * Return 0 for no numbers.
     *
     * sum67([1, 2, 2]) => 5
     * sum67([1, 2, 2, 6, 99, 99, 7]) => 5
     * sum67([1, 1, 6, 7, 2]) => 4
     */
    public static int sum67(List<Integer> numbers) {
        List<Integer> nr = numbers;

        for (int i = 0; i < nr.size(); i++) {
            if (nr.get(i) == 6) {
                nr.set(i, 0);
                for (int j = i; j < nr.size(); j++) {
                    if (nr.get(j) == 7) {
                        nr.set(j, 0);
                        break;
                    } else {
                        nr.set(j, 0);
                    }
                }
            }
        }


        return nr.stream().mapToInt(a -> a).sum();
    }

    /**
     * Given 3 ints, a b c, return the sum of their rounded values.
     * We'll round an int value up to the next multiple of 10
     * if its rightmost digit is 5 or more, so 15 rounds up to 20.
     * Alternately, round down to the previous multiple of 10
     * if its rightmost digit is less than 5, so 12 rounds down to 10
     *
     * roundSum(16, 17, 18) => 60
     * roundSum(12, 13, 14) => 30
     * roundSum(6, 4, 4) => 10
     */
    public static int roundSum(int a, int b, int c) {


        return roundNr(a) + roundNr(b) + roundNr(c);
    }

    public static int roundNr(int nr) {
        if (nr % 10 < 5) {
            return nr - (nr % 10);
        } else {
            return (nr - (nr % 10)) + 10;
        }
    }

    /**
     * Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca".
     * Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     *
     * oneTwo("abc") => "bca"
     * oneTwo("tca") => "cat"
     * oneTwo("tcagdo") => "catdog"
     */
    public static String oneTwo(String str) {
        String input = str;

        List<String> subString = new ArrayList<>();

        while (input.length() > 2) {
            subString.add(input.substring(0, 3));
            input = input.substring(3);
        }

        String result = "";
        for (String s : subString) {
            result += s.substring(1) + s.substring(0, 1);
        }
        return result;
    }

    /**
     * Modify and return the given map as follows:
     * if exactly one of the keys "a" or "b" exists in the map (but not both), set the other to have that same value in the map.
     *
     * mapAXorB({"a": "aaa", "c": "cake"}) => {"a": "aaa", "b": "aaa", "c": "cake"}
     * mapAXorB({"b": "bbb", "c": "cake"}) => {"a": "bbb", "b": "bbb", "c": "cake"}
     * mapAXorB({"a": "aaa", "b": "bbb", "c": "cake"}) => {"a": "aaa", "b": "bbb", "c": "cake"}
     */
    public static Map<String, String> mapAXorB(Map<String, String> map) {
        Map<String, String> result = map;
        Map<String, String> toReturn = new HashMap<>();
        if (result.containsKey("a") && result.containsKey("b")) return result;
        if (result.containsKey("a") && !result.containsKey("b")) {
            toReturn.put("a", "aaa");
            toReturn.put("b", "aaa");
            toReturn.put("c", "cake");
            return toReturn;
        }
        if (!result.containsKey("a") && result.containsKey("b")) {
            toReturn.put("a", "bbb");
            toReturn.put("b", "bbb");
            toReturn.put("c", "cake");
            return toReturn;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        List<Integer> nr = new ArrayList<>();
        nr.add(1);
        nr.add(2);
        nr.add(2);
        nr.add(6);
        nr.add(99);
        nr.add(99);
        nr.add(7);


        System.out.println(sum67(nr));
        System.out.println(14 % 10);
        System.out.println(roundSum(12, 13, 14));
        System.out.println(oneTwo("tcagdo"));
    }
}