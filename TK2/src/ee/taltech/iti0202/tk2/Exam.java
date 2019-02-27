package ee.taltech.iti0202.tk2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
public class Exam {


    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
     * except ignoring the largest and smallest values in the array. If there are multiple copies of the
     * smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce
     * the final average. You may assume that the array is length 3 or more.
     * <p>
     * centeredAverage([1, 2, 3, 4, 100]) → 3
     * centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
     * centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */
    public static int centeredAverage(List<Integer> nums) {
        int min = nums.get(0);
        int max = nums.get(0);
        for (Integer num : nums) {
            if (num < min) {
                min = num;
            }
        }
        for (Integer num : nums) {
            if (num > max) {
                max = num;
            }
        }
        nums.remove(nums.indexOf(min));
        nums.remove(nums.indexOf(max));

        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum / nums.size();
    }


    /**
     * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
     * Return 0 if they both go over.
     * <p>
     * blackjack(19, 21) → 21
     * blackjack(21, 19) → 21
     * blackjack(19, 22) → 19
     */
    public static int blackjack(int a, int b) {
        if (a > b && a <=21) {
            return a;
        }
        if (b > a && b <= 21) {
            return b;
        }
        if (b == a && a <= 21) {
            return a;

        }
        return 0;
    }


    /**

     Given a string and an int n, return a string made of n repetitions of the last n characters
     of the string. You may assume that n is between 0 and the length of the string, inclusive.

     repeatEnd("Hello", 3) → "llollollo"
     repeatEnd("Hello", 2) → "lolo"
     repeatEnd("Hello", 1) → "o"
     */
    public static String repeatEnd(String str, int n) {
        String end = str.substring(str.length() - n);
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + end;
        }
        return result;

    }

    /**

     Modify and return the given map as follows: if the keys "a" and "b" are both in the map
     and have equal values, remove them both.

     mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
     mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
     mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
     */
    public static Map<String, String> mapAB(Map<String, String> map) {
        return null;
    }
}
