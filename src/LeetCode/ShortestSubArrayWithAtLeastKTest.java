package LeetCode;

public class ShortestSubArrayWithAtLeastKTest {

    public static void main(String[] args) {
        int[] array = {17,85,93,-45,-21};
        int askedSum = 150;

        ShortestSubArrayWithSumAtLeastK shortestSubArrayWithSumAtLeastK = new ShortestSubArrayWithSumAtLeastK();

        System.out.println("Array  with min substring "+shortestSubArrayWithSumAtLeastK.shortestSubarray(array, askedSum));

    }
}
