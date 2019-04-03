package ee.taltech.iti0202.kt2;
import java.util.Arrays;
import java.util.List;

public class Exam {
    /**
     * Given lists nums1 and nums2 of the same length,
     * for every element in nums1, consider the corresponding
     * element in nums2 (at the same index).
     * Return the count of the number of times
     * that the two elements differ by 2 or less, but are not equal.
     *
     * matchUp([1, 2, 3], [2, 3, 10]) => 2
     * matchUp([1, 2, 3], [2, 3, 5]) => 3
     * matchUp([1, 2, 3], [2, 3, 3]) => 2
     */
    public static int matchUp(List<Integer> a, List<Integer> b) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(i)) {
                continue;
            }
            if (Math.abs(a.get(i) - b.get(i)) <= 2) {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, word and a separator sep,
     * return a big string made of count occurrences of the word,
     * separated by the separator string.
     *
     * repeatSeparator("Word", "X", 3) => "WordXWordXWord"
     * repeatSeparator("This", "And", 2) => "ThisAndThis"
     * repeatSeparator("This", "And", 1) => "This"
     */
    public static String repeatSeparator(String word, String sep, int count) {

        if (word.length() == 0) {
            return "";
        }
        if (count == 0) {
            return "";
        }

        String result = "";

        for (int i = 0; i < count; i++) {
            result += word + sep;
        }

        return result.substring(0, result.length() - sep.length());
    }

    public static void main(String[] args) {
        System.out.println(repeatSeparator("Word", "X", 3));

    }

}
