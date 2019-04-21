    package ee.taltech.iti0202.recursion;
    public class Recursion {


        /**
         * Find the text between the first and last parenthesis.
         *
         * @param word a random word
         * @return content between first and last parenthesis
         */
        public static String parentheses(String word) {



            if (word.length() == 0) {
                return "";
            }

            if (word.substring(0, 1).equals("(") && word.contains(")")) {
                return word.substring(0, word.lastIndexOf(")") + 1);
            }
            return parentheses(word.substring(1));
        }

        /**
         * Remove every neighbouring duplicate char in the string recursively.
         *
         * @param word a word with duplicates
         * @return a word without any duplicates
         */
        public static String removeDuplicates(String word) {

            if (word.length() == 1) {
                return word;
            }
            if (word.substring(0, 1).equals(word.substring(1, 2))) {
                return removeDuplicates(word.substring(1));
            } else {
                return word.substring(0, 1) + removeDuplicates(word.substring(1));
            }
        }

        /**
         * Remove any char that isn't in the Pseudo Hawaiian pidgin language.
         *
         * @param word a word that may contain other chars
         * @return a word where only Hawaiian pidgin chars exist
         */
        public static String pidginfy(String word) {

            if (word.length() == 0) {
                return "";
            }
            if ("a e i o u h k l m n p w r ' \" \" ā ō ū . , ! ?".contains(word.substring(0, 1).toLowerCase())) {
                return word.substring(0, 1) + pidginfy(word.substring(1));
            }
            return pidginfy(word.substring(1));
        }

        public static void main(String[] args) {

            System.out.println(parentheses("I am useless text(Find me), yet again useless")); // "(Find me)"
            System.out.println(parentheses("This doesn't have any parentheses.")); // ""
            System.out.println(parentheses("What do you do if (sentence has (many parentheses) and " +
                    "where it ends)")); // "(sentencce has (many parentheses) and where it ends)"
            // System.out.println();

            System.out.println(removeDuplicates("aabbccddeeffgg")); // "abcdefg"
            System.out.println(removeDuplicates("foakfjdirmdogmvooasf")); // "foakfjdirmdogmvoasf"
            System.out.println(removeDuplicates("ilIliiiiilIili1lilllliiilil1ilili111111lili1"));
            // "ilIlilIili1lililil1ilili1lili1"
            // System.out.println();

            System.out.println(pidginfy("Kūle'a ka'ōpopo'ōpiopio ma luna o ka'īlio palaualelo."));
            // "Kūle'a ka'ōpopo'ōpiopio ma luna o ka'lio palaualelo."
            System.out.println(pidginfy("kasmdfastu naidsfnasidn weraiskdfm sdfasdf''assdffaksndfasdf"));
            // "kamau nainain weraikm a''aakna"
            System.out.println(pidginfy("He nani ka'iliahi, akā,'a'ohe mea'ala, no ka mea he " +
                    "mea'alala'i ka raiki, pono nō ka'ohe."));
            //"He nani ka'iliahi, akā,'a'ohe mea'ala, no ka mea he mea'alala'i ka raiki, pono nō ka'ohe."

        }
    }
