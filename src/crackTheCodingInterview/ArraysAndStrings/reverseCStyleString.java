package crackTheCodingInterview.ArraysAndStrings;

public class reverseCStyleString {

    public static void main(String[] args) {
        String s1 = "abcd\n";
        String s2 = "\n";
        String s3 = "abc\n";

        System.out.println("S1 before reverse :: " + s1 + " after reverse :: " + rotateChar(s1.toCharArray()));
        System.out.println("S2 before reverse :: " + s2 + " after reverse :: " + rotateChar(s2.toCharArray()));
        System.out.println("S3 before reverse :: " + s3 + " after reverse :: " + rotateChar(s3.toCharArray()));
    }

    public static String rotateChar(char[] ch) {
        if (ch.length <= 1) {
            return new String(ch);
        }

        char temp;
        int n = ch.length;

        //iterate through n/2
        for (int i = 0; i < n / 2; i++) {
            temp = ch[i];
            ch[i] = ch[n - 1 - i];
            ch[n - 1 - i] = temp;
        }
        return new String(ch);
    }
}


