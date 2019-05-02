package LeetCode;

import java.util.Arrays;

public class ProductExceptSelfTest {

    public static void main(String[] args) {
        int[] input = {1,2,3,4};

        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println("Output array is "+ Arrays.toString(productExceptSelf.productExceptSelf(input)));
    }
}
