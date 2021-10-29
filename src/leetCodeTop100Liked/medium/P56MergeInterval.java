package leetCodeTop100Liked.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author vranjan
 * created 29/10/2021
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class P56MergeInterval {
    public int[][] merge(int[][] intervals) {
        // Step 1 sort the array
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] arr : intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < arr[0]) {
                merged.add(arr);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], arr[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

// Caution look for the edge case when overlapping array is subset.
