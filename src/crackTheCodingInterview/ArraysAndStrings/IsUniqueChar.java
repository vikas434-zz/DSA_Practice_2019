package crackTheCodingInterview.ArraysAndStrings;


import java.util.HashMap;
import java.util.Objects;

public class IsUniqueChar {

    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "abcDFA";
        String s3 = "ABBC";
        String s4 = null;
        String s5 = "";
        String s6 = "AbbAC";

        System.out.println("S1 has repeating char "+isUniqueCharacter(s1));
        System.out.println("S2 has repeating char "+isUniqueCharacter(s2));
        System.out.println("S3 has repeating char "+isUniqueCharacter(s3));
        System.out.println("S4 has repeating char "+isUniqueCharacter(s4));
        System.out.println("S5 has repeating char "+isUniqueCharacter(s5));
        System.out.println("S6 has repeating char "+isUniqueCharacter(s6));

    }

    public static boolean isUniqueCharacter(String s) {
        if(Objects.isNull(s) || s.isEmpty()) {
            return true;
        }
        HashMap<Character, Integer> charIntMap = new HashMap<>();

        char[] chars = s.toCharArray();

        for(int i =0; i<chars.length; i++) {
            char c = chars[i];
            if(Objects.nonNull(charIntMap.get(c))) {
                return false;
            }
            charIntMap.put(c, 1);
        }
        return true;
    }

}
