package LeetCode;

public class ShortestSubArrayWithAtLeastKTest {

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int askedSum = 6;

        ShortestSubArrayWithSumAtLeastK shortestSubArrayWithSumAtLeastK = new ShortestSubArrayWithSumAtLeastK();

        System.out.println("Array  with min substring "+shortestSubArrayWithSumAtLeastK.shortestSubarray(array, askedSum));

        System.out.println("Array  with min substring leet answer"+shortestSubArrayWithSumAtLeastK.leetAnswer(array, askedSum));

    }
}
