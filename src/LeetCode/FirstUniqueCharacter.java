package LeetCode;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            if (Objects.isNull(map.get(c))) {
                map.put(c, 1);
            } else {
                int count = (Integer) map.get(c);
                map.put(c, ++count);
            }
        }

        for (Map.Entry e : map.entrySet()) {
            int value = (int) e.getValue();
            Character c = (Character) e.getKey();
            if (value == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }
}
