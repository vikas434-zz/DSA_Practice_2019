/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class GoldmanSacsCoderPad2
{
    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores)
    {
        // TODO: implement this function
        HashMap<String, List<Double>> map = new HashMap<>();
        // for(String score : scores) {
        //   String nameOfStudent = score[0];
        //   System.out.println("Student name "+nameOfStudent);
        // }

        if(scores.length == 0) {
            return 0;
        }

        for(int i =0; i<scores.length; i++) {
            String name = scores[i][0];
            String scoreNow = scores[i][1];
            int scoreCount = 0;
            if(map.get(name) != null) {
                List<Double> score = map.get(name);
                double sumTillNow = score.get(0);
                double averageTillNow = score.get(1);
                double countTillNow = score.get(2);
                sumTillNow += Double.valueOf(scoreNow);
                countTillNow++;
                averageTillNow = sumTillNow/countTillNow;

                score.set(0, sumTillNow);
                score.set(1, averageTillNow);
                score.set(2, countTillNow);
                map.put(name, score);
            }else {
                List<Double> score = new ArrayList<>();
                score.add(Double.valueOf(scoreNow));
                score.add(Double.valueOf(scoreNow));
                score.add(1.0);
                map.put(name, score);
            }

        } // For ends

        // Find lowest average.
        double average = Integer.MIN_VALUE;
        for(String s : map.keySet()) {
            List<Double> score = map.get(s);
            if(score.get(1)  > average) {
                average = score.get(1);
            }
        }
        System.out.println("average is "+average+"floor "+Math.floor(average)+"ceil "+Math.ceil(average));

        return (int)Math.floor(average);

    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // TODO: implement more test cases
        Map<String[][], Integer> testCases = new HashMap<>();

        // example
        testCases.put(new String[][] { { "Bobby", "87" },
                        { "Charles", "100" },
                        { "Eric", "64" },
                        { "Charles", "22" } },
                87);
        // empty
        testCases.put(new String[][] {},
                0);
        // multiple scores each
        testCases.put(new String[][] { { "Sarah", "91" },
                        { "Goldie", "92" },
                        { "Elaine", "93" },
                        { "Elaine", "95" },
                        { "Goldie", "94" },
                        { "Sarah", "93" } },
                94);
        // negatives and zeros
        testCases.put(new String[][] { { "Janie", "-66" },
                        { "Janie", "0" },
                        { "Gina", "-88" },
                        { "Bobby", "0" },
                        { "Gina", "44" },
                        { "Bobby", "0" },
                        { "Bobby", "-6" } },
                -2);
        // same value and average
        testCases.put(new String[][] { { "Alpha", "99" },
                        { "Bravo", "99" },
                        { "Charlie", "99" },
                        { "Delta", "99" },
                        { "Echo", "99" },
                        { "Foxtrot", "99" },
                        { "Foxtrot", "99" } },
                99);
        // non-integer average
        testCases.put(new String[][] { { "Gerald", "91" },
                        { "Gerald", "92" } },
                91);
        // negative non-integer average
        testCases.put(new String[][] { { "Barry", "-66" },
                        { "Barry", "-65" },
                        { "Alfred", "-122"} },
                -66);

        boolean passed = true;
        for(Map.Entry<String[][], Integer> entry : testCases.entrySet())
        {
            Integer actual = bestAverageGrade(entry.getKey());
            if(actual != entry.getValue())
            {
                passed = false;
                System.out.println("Failed for " + Arrays.deepToString(entry.getKey()) + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }

        return passed;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
