package LeetCode;

public class ContainerWithMostWaterTest {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("Maximum container can be made is "+containerWithMostWater.maxArea(height));
    }
}
