package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }

        if(denominator == 0) {
            return "Divided By Zero error.";
        }

        StringBuilder fraction = new StringBuilder();

        if(numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend/divisor));

        long remainder = dividend % divisor;

        if(remainder == 0) {
            return fraction.toString();
        }

        fraction.append(".");

        Map<Long,Integer> map = new HashMap<>();

        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder = remainder*10;
            fraction.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }

        return fraction.toString();
    }
}
