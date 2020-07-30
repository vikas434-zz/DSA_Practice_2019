package leetCodeTop100Liked.easy;

/* Created by Vikas Ranjan
*
* Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
* */

import java.util.ArrayList;
import java.util.List;

public class P448FindDisappearedElement {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> numbers = new ArrayList<>();
        if (nums.length == 0) {
            return numbers;
        }

        if (nums.length == 1) {
            numbers.add(nums[0]);
            return numbers;
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value < 0) {
                value = value * -1;
            }

            if (nums[value - 1] > 0) {
                nums[value - 1] *= -1;
            }
        }

       for(int j = 0; j < nums.length; j++) {
           if(nums[j] > 0) {
               numbers.add(j+1);
           }
       }

        return numbers;
    }

}
