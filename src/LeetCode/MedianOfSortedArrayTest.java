package LeetCode;

public class MedianOfSortedArrayTest {

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};

        MedianOfSOrtedArray medianOfSOrtedArray = new MedianOfSOrtedArray();

        System.out.println("Median of both array is "+medianOfSOrtedArray.findMedianSortedArrays(num1, num2));
    }
}
