import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author vranjan
 * created 23/08/2021
 */
public class AddTwoBinary {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String firstNumber = "0";
        String secondNumber = "0";
        line = in.readLine();
        if (line != null) {
            firstNumber = line.split(",")[0];
            secondNumber = line.split(",")[0];
        }

        if (firstNumber.equals("0") && secondNumber.equals("0")) {
            System.out.println("0");
        }

        if (firstNumber.length() != secondNumber.length()) {
            String[] numbers = appendZeros(firstNumber, secondNumber);
            firstNumber = numbers[0];
            secondNumber = numbers[1];
        }
        // Now first and second number is of same size
        String finalAddition = addBinary(firstNumber, secondNumber);
        System.out.println(finalAddition);
    }

    private static String addBinary(String firstNumber, String secondNumber) {
        StringBuilder sum = new StringBuilder();
        int length = firstNumber.length(); // Length for both numbers are same.
        String reverseFirst = new StringBuilder(firstNumber).reverse().toString();
        String reverseSecond = new StringBuilder(secondNumber).reverse().toString();
        int carryForward = 0;
        for (int i = 0; i < length; i++) {
            if(reverseFirst.charAt(i) == '0' && reverseSecond.charAt(i) == '0') {
                if(carryForward == 0) {
                    sum.append("0");
                } else {
                    sum.append("1");
                }
            } else if(reverseFirst.charAt(i) == '1' && reverseSecond.charAt(i) == '1') {
                if(carryForward == 0) {
                    sum.append("0");

                } else {
                    sum.append("1");
                }
                carryForward = 1;
            } else {
                if(carryForward == 0) {
                    sum.append("1");
                    carryForward = 0;
                } else {
                    sum.append("0");
                    carryForward = 1;
                }
            }
        }
        // return reversed sum
        return sum.reverse().toString();
    }

    private static String[] appendZeros(String firstNumber, String secondNumber) {
        int length1 = firstNumber.length();
        int length2 = secondNumber.length();
        int diff = 0;
        String[] numbers = new String[2];

        if (length1 > length2) {
            diff = length1 - length2;
            numbers[1] = getDiffZeros(diff) + secondNumber;
        }
        else {
            diff = length2 - length1;
            numbers[0] = getDiffZeros(diff) + firstNumber;
        }
        return numbers;
    }

    private static String getDiffZeros(int diff) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < diff) {
            sb.append("0");
        }
        return sb.toString();
    }
}

