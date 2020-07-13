package General;

public class XORTest {

    public static void main(String[] args) {
        int a = 0;
        int[] arr = {4, 1, 4, 1, 2};

       for(int i =0; i< arr.length; i++) {
           System.out.println("a is "+a+ " arr is "+arr[i]);
           a ^= arr[i];
           System.out.println(" xor is "+a);
       }

        System.out.println(a);
    }
}
