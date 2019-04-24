package crackTheCodingInterview.ArraysAndStrings;

import java.util.HashMap;
import java.util.Objects;

public class isAnagram {

    public static void main(String[] args) {
        String s1 = "TRIANGLE";
        String s2 = "INTEGRAL";
        String s3 = "LISTEN";
        String s4 = "SILENT";

        System.out.println("S1 " + s1 + " S2 " + s2 + " is anagram :: " + isAnagram(s1, s2));
        System.out.println("S3 " + s3 + " S4 " + s4 + " is anagram :: " + isAnagram(s3, s4));
        System.out.println("S1 " + s1 + " S4 " + s4 + " is anagram :: " + isAnagram(s1, s4));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> charToInt = new HashMap<>();

        int n = s1.length();

        // Fill hashmap with s1.

        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);

            if (Objects.nonNull(charToInt.get(c1))) {
                int currentCount = charToInt.get(c1);
                charToInt.put(c1, ++currentCount);
            } else {
                charToInt.put(c1, 1); // Initialize with 1.
            }
        }

        // Itereate over s2 and deduct count
        for (int i = 0; i < n; i++) {
            char c2 = s2.charAt(i);
            if (Objects.isNull(charToInt.get(c2))) { // The key is not present in the hashmap.
                return false;
            }
            int currentCount = charToInt.get(c2);
            charToInt.put(c2, --currentCount);
        }

        // Itereate over hashmap to see if all counts are 0.
        for (char c : charToInt.keySet()) {
            if (charToInt.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
