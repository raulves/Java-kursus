package ee.taltech.iti0202.sum100;
import java.util.ArrayList;
import java.util.List;

public class Sum100 {

  private static List<String> allPermutations = new ArrayList<>();

  private static List<String> sum100 = new ArrayList<>();


  public static List<String> calcSums() {
    String[] set1 = {"+", "-"};

    int k = 7;
    printAllKLength(set1, k);
    findCombinations();

    return sum100; // TODO
  }

  private static void findCombinations() {
    List<Integer> nrs = List.of(12, 3, 4, 5, 67, 8, 9);
    for (String permutation : allPermutations) {
      String[] splitString = permutation.split("");


      int sum = 0;
      for (int i = 0; i < splitString.length; i++) {

        if (splitString[i].equals("+")) {
          sum += nrs.get(i);
        } else {
          sum -= nrs.get(i);
        }
      }
      System.out.println(sum);
      if (sum == 100) {
        String s = "";
        for (int i = 0; i < nrs.size();i++) {
          s += splitString[i] + nrs.get(i);
        }
        if (s.substring(0, 1).equals("+")) {
          sum100.add(s.substring(1));
        } else {
          sum100.add(s);
        }

        System.out.println("YESSS");
      }


    }
  }






  // The method that prints all
// possible strings of length k.
// It is mainly a wrapper over
// recursive function printAllKLengthRec()
  private static void printAllKLength(String[] set, int k) {

    int n = set.length;
    printAllKLengthRec(set, "", n, k);
  }

  // The main recursive method
// to print all possible
// strings of length k
  private static void printAllKLengthRec(String[] set, String prefix, int n, int k) {

    // Base case: k is 0,
    // print prefix
    if (k == 0) {
      allPermutations.add(prefix);
      // System.out.println(prefix);
      return;
    }

    // One by one add all characters
    // from set and recursively
    // call for k equals to k-1
    for (int i = 0; i < n; ++i) {

      // Next character of input added
      String newPrefix = prefix + set[i];

      // k is decreased, because
      // we have added a new character
      printAllKLengthRec(set, newPrefix, n, k - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(calcSums());
    /*
    String[] set1 = {"+", "-"};
    String[] set2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    int k = 3;
    printAllKLength(set2, k);

    System.out.println(allPermutations);

     */

    // System.out.println(allPermutations);
    // System.out.println(allPermutations.size());
    // findCombinations();
  }
}
