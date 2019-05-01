package LeetCode;

public class RainWaterHarvestingTest {

    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        RainWaterHarvesting rainWaterHarvesting = new RainWaterHarvesting();

        System.out.println("Total trapped water "+rainWaterHarvesting.trap(height));
    }
}
