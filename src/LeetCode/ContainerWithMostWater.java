package LeetCode;

import java.util.*;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        int size = height.length;
        if (size == 2) {
            // If anyone of the height is 0. Return 0.
            if((height[0] == 0) || (height[1] == 0)) {
                return 0;
            } else { // Find the smallest height and since width is 1, so that is the maxArea.
                return Math.min(height[0], height[1]);
            }
        }

        /**
         * Approach 1 :- Using left and right pointer to find leftMax and RightMax along with its indexes - FAILED!!
         */
//        int leftPointer = 0;
//        int rightPointer = size-1;
//        int leftMaxSoFar = 0;
//        int rightMaxSoFar = 0;
//        int leftMaxSoFarIndex = 0;
//        int rightMaxSoFarIndex = size-1;
//
//        while (leftPointer < rightPointer) {
//            if(height[leftPointer] < height[rightPointer]) { // Increment left pointer and update leftMax and indices
//                // Check and update leftMax so far. In any case increment left counter.
//                if(leftMaxSoFar < height[leftPointer]) {
//                    leftMaxSoFar = height[leftPointer];
//                    leftMaxSoFarIndex = leftPointer;
//                }
//                leftPointer++;
//            } else { // Decrement right pointer and update rightMax and indices
//                // Check and update right max so far and decrement rightMax.
//                if(rightMaxSoFar < height[rightPointer]) {
//                    rightMaxSoFar = height[rightPointer];
//                    rightMaxSoFarIndex = rightPointer;
//                }
//                rightPointer--;
//            }
//        }
//        // Min height of left and right wall is the max height of container and width of container is distance on X axis.
//        return (Math.min(leftMaxSoFar, rightMaxSoFar) * (rightMaxSoFarIndex - leftMaxSoFarIndex));
        // TODO this approach fails as we have lost indices. Think about something else.

        /**
         * Approach 2 :- Use Max priority queue and get first 2 element with index. STUCK as need to use Class and comparator or implement comparable.
         */
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> 0);
//
//        return containerSize;

        /**
         * Approach 3 :- Use Tree map, it will have last 2nd last element (as height) and indices difference as width. This also failed because,
         * calculated area shouldn't be the last and second last. It was in that case only.
         *
         */
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for(int i =0; i<size; i++) {
//            // For duplicate entry first check if it doesn't exist then only push. Otherwise it will update the indexes
//            // With latest value.
//            if(Objects.isNull(treeMap.get(height[i]))) {
//                treeMap.put(height[i], i);
//            }
//        }
//
//        Map.Entry<Integer, Integer> last = treeMap.pollLastEntry();
//        int maxHeightContainerIndex = last.getValue();
//
//        Map.Entry<Integer, Integer> lastButOne = treeMap.pollLastEntry();
//        int minHeightContainer = lastButOne.getKey();
//        int minHeightContainerIndex = lastButOne.getValue();
//
//        int widthDiff = Math.abs(maxHeightContainerIndex - minHeightContainerIndex);
//
//        return minHeightContainer*widthDiff;

        /**
         * Approach 4 :- using both pointers and keep calculating the area.
         */

        int leftPointer = 0;
        int rightPointer = size - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                maxArea = Math.max(maxArea, ((rightPointer-leftPointer)*height[leftPointer]));
                leftPointer++;
            } else {
                maxArea = Math.max (maxArea, ((rightPointer-leftPointer) * height[rightPointer]));
                rightPointer--;
            }
        }

        return maxArea;
    }
}