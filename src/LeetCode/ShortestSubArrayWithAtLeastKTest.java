package LeetCode;

public class ShortestSubArrayWithAtLeastKTest {

    public static void main(String[] args) {
        int[] array = {56,-21,56,35,-9};
        int askedSum = 61;

        ShortestSubArrayWithSumAtLeastK shortestSubArrayWithSumAtLeastK = new ShortestSubArrayWithSumAtLeastK();

        System.out.println("Array  with min substring "+shortestSubArrayWithSumAtLeastK.shortestSubarray(array, askedSum));

        System.out.println("Array  with min substring leet answer"+shortestSubArrayWithSumAtLeastK.leetAnswer(array, askedSum));

    }
}
