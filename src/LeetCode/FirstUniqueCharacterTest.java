package LeetCode;

public class FirstUniqueCharacterTest {

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        String str = "dddccdbba";
        System.out.println("Length of first non-unique of string "+str+" is "+firstUniqueCharacter.firstUniqChar(str));
    }
}
