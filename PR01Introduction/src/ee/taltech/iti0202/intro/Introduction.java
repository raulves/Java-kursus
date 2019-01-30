package ee.taltech.iti0202.intro;

public class Introduction {

    /**
     * Method gets a string containing word Java in different cases.
     * Method must be case-insensitive to recognize all the Java words.
     *
     * @param stringWithJava the string to find words Java from.
     * @return The number of word Java occurrences.
     */
    public static int countJava(String stringWithJava) {

        int i = 0;

        for (int x = 0; x < stringWithJava.length() - 3; x++) {
            if (stringWithJava.toLowerCase().substring(x, x + 4).equals("java")) {
                i += 1;

            }
        }


        return i;
    }


    /**
     * Method gets an array of numbers and another number.
     * The second integer's value must equal to the number of its occurrences in the given array.
     *
     * @param inputNumbers int array
     * @param sneakyNumber int
     * @return true if sneakyNumber's value equals its number of occurrences
     */
    public static boolean doubleNumber(int[] inputNumbers, int sneakyNumber) {
        int count = 0;
        for (int element: inputNumbers) {
            if (element == sneakyNumber) {
                count += 1;
            }

        }
        if (count == sneakyNumber) {
            return true;
        }
        return false;
    }


    /**
     * Method gets two numbers as parameters.
     * Method must answer if the given pair gives bad, normal or good outcome.
     * Outcome is "ok" if both values equal at least 5.
     * Outcome is "bad" if any of values is less than 5.
     * Outcome is "good" if one value equals doubled second value.
     * The priority is as follows: "bad", "good", "ok" (if several cases apply, take the higher / earlier).
     *
     * @param valueOne int
     * @param valueTwo int
     * @return true if sneakyNumber's value equals its number of occurrences
     */
    public static String howIsOutcome(int valueOne, int valueTwo) {
        return "";
    }

    public static void main(String[] args) {
        // static method we can call directly from static method (main)
        System.out.println(countJava("javaJavaJAVA"));  // 3
        System.out.println(countJava("Nothing here"));  // 0
        System.out.println(doubleNumber(new int[] {1, 4, 8, 2, 2, 3}, 2));
        // try some other examples here
    }
}
