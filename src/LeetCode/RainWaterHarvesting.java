package LeetCode;

public class RainWaterHarvesting {

    /**
     * Problem :- Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * The solution is to find left_max and right_max value from that index. Take min of them and find the diff.
     *
     */
    public int trap(int[] height) {
        int size = height.length;
        int sum = 0;
        if(size <=1) {
            return sum;
        }

        /**
         * Approach 1 :- Using DP. Use extra space, Get Left_max and right_max_array.
         */
//        int[] leftMax = new int[size];
//        int[] rightMax = new int[size];
//        int leftMaxSoFar = 0;
//        int rightMaxSofar = 0;
//
//        for(int i =0; i < size; i++) {
//            leftMax[i] = Math.max(leftMaxSoFar, height[i]);
//            leftMaxSoFar = leftMax[i];
//        }
//
//        for(int j = size-1; j >= 0; j--) {
//            rightMax[j] = Math.max(rightMaxSofar, height[j]);
//            rightMaxSofar = rightMax[j];
//        }
//
//        // Start computing sum using from left to right with help of right and left max.
//        for (int k = 0; k < size; k++) {
//            sum = sum + (Math.min(leftMax[k], rightMax[k]) - height[k]);
//        }
//        return sum;

        /**
         * Approach 2 using left and right pointer, this will save extra space.
         *
         */
        int leftPointer = 0;
        int rightPointer = size-1;
        int leftMax = 0;
        int rightMax = 0;

        while (leftPointer < rightPointer) {
            if(height[leftPointer] < height[rightPointer]) {
                leftMax = Math.max(leftMax, height[leftPointer]);
                sum = sum + (leftMax - height[leftPointer]);
                leftPointer++;
            } else {
                rightMax = Math.max(rightMax, height[rightPointer]);
                sum = sum + (rightMax - height[rightPointer]);
                rightPointer--;
            }
        }
        return sum;
    }


}
