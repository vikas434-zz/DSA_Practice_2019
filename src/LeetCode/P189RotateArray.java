package LeetCode;

public class P189RotateArray {
    public void rotate(int[] nums, int k) {

        int size = nums.length;
        k = k % size;
        if (k <= 0) {
            return;
        }

        // First rotate all, then rotate till k-1 and the next k to length.
        reverseArray(nums, 0, size-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, size - 1);

    }

    private void reverseArray(int[] nums, int i, int k) {
        int low = i;
        int high = k;
        while (low<high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }

}
