package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

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
}
