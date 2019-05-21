package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class P349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Approach 1 :- Putting both of them in two sets and finding the common set. - use retains all
        if (nums1.length == 0 && nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n1 : nums1) {
            set1.add(n1);
        }

        for (int n2 : nums2) {
            set2.add(n2);
        }

        set1.retainAll(set2);

        int size = set1.size();

        int[] intersectionArray = new int[size];
        int i = 0;
        for (Integer integer : set1) {
            intersectionArray[i++] = integer;
        }

        return intersectionArray;
    }
}
