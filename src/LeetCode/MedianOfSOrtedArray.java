package LeetCode;

public class MedianOfSOrtedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int totalLength = length1 + length2;
        boolean isEven = (totalLength % 2 == 0);
        int middleIndex = totalLength / 2;
        int i = 0;
        int num1Index = 0;
        int num2Index = 0;
        double valueHolder1 = 0;
        double valueHolder2 = 0;
        System.out.println("Lenght 1 " + length1 + " length 2 " + length2 + " Middle index " + middleIndex);
        while (i <= (middleIndex - 1)) {
            if(num1Index < length1 && num2Index < length2) {
                if (nums1[num1Index] < nums2[num2Index]) {
                    valueHolder1 = nums1[num1Index];
                    num1Index++;
                } else {
                    valueHolder1 = nums2[num2Index];
                    num2Index++;
                }
                i++;
            } else {
                break;
            }
        }
        System.out.println("Value of i is " + i + " Middle index " + middleIndex);
        while (i <= middleIndex - 1) {
            if(num1Index < length1) {
                valueHolder1 = nums1[num1Index];
                num1Index++;
            } else if(num2Index < length2) {
                valueHolder1 = nums2[num2Index];
                num2Index++;
            }
            i++;
        }
        System.out.println("Value holder 1 is "+valueHolder1);
        if(num1Index < length1 && num2Index < length2) {
            valueHolder2 = Math.min(nums1[num1Index], nums2[num2Index]);
        } else if(num1Index < length1 && num2Index == length2) {
            valueHolder2 =  nums1[num1Index];
        } else if(num2Index < length2 && num1Index == length1) {
            valueHolder2 =  nums2[num2Index];
        }
        System.out.println("Value holder 2 is "+valueHolder2);
        System.out.println("Is even "+isEven);
        System.out.println("NOT DONE!!!!");
        //TODO Approach is fine. First try with filling up all the array and then traverse only till half.
        if(isEven) { // Return median of n/2 index and n/2 - 1 index
            return (valueHolder1 + valueHolder2) / 2;
        } else { // Return value of n/2 index.
            return valueHolder2;
        }

    }
}
