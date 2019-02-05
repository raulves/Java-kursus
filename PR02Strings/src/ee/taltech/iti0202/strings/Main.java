package ee.taltech.iti0202.strings;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {

        Map<String, Integer> wordToCount = new HashMap<>();

        for (String word: sentence) {
            Integer count = wordToCount.get(word);
            if (count == null) {
                wordToCount.put(word, 1);
            } else {
                wordToCount.put(word, count + 1);
            }


        }

        return wordToCount;
    }


    /**
     * Find the most frequent word in given array of strings.
     *
     * If there are multiple most frequent words to choose from pick any of them.
     *
     * @param sentence array of strings, can't be null.
     * @return most frequent word in the sentence
     */
    public static String mostFrequentWord(String[] sentence) {
        Map<String, Integer> wordToCount = new HashMap<>();

        if (sentence.length == 0) {
            return null;
        }
        String result = sentence[0];

        for (String word: sentence) {
            Integer count = wordToCount.get(word);
            if (count == null) {
                wordToCount.put(word, 1);
            } else {
                wordToCount.put(word, count + 1);
            }
            if (wordToCount.get(result) < wordToCount.get(word)) {
                result = word;
            }

        }

        return result;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        Map<String, Integer> wordToCount = new HashMap<>();

        for (String word: words) {
            Integer count = wordToCount.get(word);
            if (count == null) {
                wordToCount.put(word, 1);
            } else {
                wordToCount.put(word, count + 1);
            }


        }
        // System.out.println(wordToCount);
        ArrayList<String> even = new ArrayList<String>();

        for (String string: wordToCount.keySet()) {
            if (wordToCount.get(string) % 2 == 0) {
                even.add(string);
            }
        }

        return even;


    }

    /**
     * Loop over the given string to build a result string like this:
     * when a character appears the 2nd, 4th, 6th, etc. time in the string, append the character to the result.
     * <p>
     * Return the empty string if no character appears a 2nd time.
     * <p>
     * Use map to count times that character has appeared.
     * Easy way to get char array (char[]) from string: input.toCharArray();
     *
     * @param input string
     * @return string
     */
    public static String onlyEvenCharacters(String input) {
        return "FooBar";
    }


    public static void main(String[] args) {
        System.out.println(wordCount(new String[]{})); // empty
        System.out.println(wordCount(new String[]{"eggs", "SPAM", "eggs", "bacon", "SPAM", "bacon", "SPAM"})); // {bacon=2, eggs=2, SPAM=3}

        System.out.println();
        System.out.println(mostFrequentWord(new String[]{})); // null
        System.out.println(mostFrequentWord(new String[]{"SPAM", "SPAM", "eggs", "bacon", "and", "SPAM"})); // SPAM

        System.out.println();
        System.out.println(onlyEvenWords(Arrays.asList("tere", "tere", "vanakere"))); // [tere]
        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "a", "b"))); // [a, b]
        System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]

        System.out.println();
        System.out.println(onlyEvenCharacters("aaa")); // a
        System.out.println(onlyEvenCharacters("aabbcaca")); // abca
        System.out.println(onlyEvenCharacters("bob")); // b
        System.out.println("\"" + onlyEvenCharacters("abc") + "\"");// ""
    }
}
