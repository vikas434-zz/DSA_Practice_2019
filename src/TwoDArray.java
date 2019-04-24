import java.util.Arrays;

public class TwoDArray {
    int[][] testArray = new int[3][3];

   public void initArray() {
       for(int i =0; i<3; i++) {
           for(int j =0; j<3; j++) {
               testArray[i][j] = i+j;
           }
       }
   }

    public void printArrayFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(testArray[i][j]);
            }
        }
    }

    public void printArrayone(){
       for (int i =0; i<3; i++) {
           System.out.println(Arrays.toString(testArray[i]));
       }
    }
}
