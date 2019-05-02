package LeetCode;

import java.util.*;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 *
 * If there is no non-empty subarray with sum at least K, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 *
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 *
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class ShortestSubArrayWithSumAtLeastK {


    public int shortestSubarray(int[] A, int K) {
        // Pseudo code.
        // 1. Create SumArray, of length n+1 as sum[i] =                sum[0]+...sum[i-1]
        // 2. Use a doubly linked list.
        // 3. Traverse through sum array and for each element if it is less than the last inserted elment, keep removing.
        // 4. If the first and p(y) has difference of K, then keep removing and keep tracking of min number.

        int size = A.length;

        int[] sum = new int[size+1];
        for(int i =1; i<sum.length; i++) {
            sum[i] = sum[i-1] + A[i-1];
        }

        int ans = sum.length; // Which is not possible.

        LinkedList<Integer> queue = new LinkedList<>();

        for(int y = 0; y<sum.length; y++) {

            while(!queue.isEmpty() && sum[y] <= sum[queue.getLast()])
            {
                queue.removeLast();
            }

            while(!queue.isEmpty() && sum[y] - sum[queue.getFirst()] >= K) {
                int firstElement = queue.removeFirst();
                ans = Math.min(ans, y-firstElement);
            }
            queue.addLast(y);

        }

        return ans < sum.length ? ans : -1;
    }

    public int leetAnswer(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

    public static Integer bestAverageGrade(String[][] scores)
    {
        // TODO: implement this function
        HashMap<String, List<Integer>> map = new HashMap<>();
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
                List<Integer> score = map.get(name);
                int sumTillNow = (Integer)score.get(0);
                int averageTillNow = (Integer)score.get(1);
                int countTillNow = (Integer)score.get(2);
                sumTillNow += Integer.valueOf(scoreNow);
                countTillNow++;
                averageTillNow = sumTillNow/countTillNow;

                score.set(0, sumTillNow);
                score.set(1, averageTillNow);
                score.set(2, countTillNow);
                map.put(name, score);
            }else {
                List<Integer> score = new ArrayList<>();
                score.add(Integer.valueOf(scoreNow));
                score.add(Integer.valueOf(scoreNow));
                score.add(1);
                map.put(name, score);
            }

        } // For ends

        // Find lowest average.
        double average = Integer.MIN_VALUE;
        for(String s : map.keySet()) {
            List<Integer> score = map.get(s);
            if(score.get(1)  > average) {
                average = score.get(1);
            }
        }
        System.out.println("average is "+average);
        if(average > 0) {
            return (int)Math.floor(average);
        } else {
            return (int)Math.ceil(average);
        }
    }
}
