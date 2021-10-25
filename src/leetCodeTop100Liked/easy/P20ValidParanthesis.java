package leetCodeTop100Liked.easy;

import java.util.Stack;

/**
 * @author vranjan
 * created 25/10/2021
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class P20ValidParanthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        final Stack<Character> stack = new Stack<>();
        final int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            if (!stack.isEmpty()) {
                if (matchingBracket(s.charAt(i), stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    private static boolean matchingBracket(char charAt, char peek) {
        return (charAt == ')' & peek == '(') || (charAt == '}' & peek == '{') || (charAt == ']' & peek == '[');
    }
}

/**
 * Learning
 *
 * `1. There was simple mistakes for "matching bracket function" have written the keys in opposite ways. So, always do
 *     dry run first.
 *
 */