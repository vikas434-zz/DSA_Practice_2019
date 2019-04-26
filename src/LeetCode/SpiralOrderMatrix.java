package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        spiralOrder(matrix1);
        spiralOrder(matrix2);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) {
            return integers;
        }
        int cols = matrix[0].length;

        int rowBegin = 0;
        int rowEnd = rows - 1;
        int colBegin = 0;
        int colEnd = cols - 1;

        int direction = 0; // 0 => right, 1 => down, 2=> left, 3 => down

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            switch (direction) {
                case 0 :
                    // Traverse right and increase rowBegin
                    for(int i = colBegin; i <= colEnd; i++) {
                        // System.out.print(matrix[rowBegin][i] + " -> ");
                        integers.add(matrix[rowBegin][i]);
                    }
                    rowBegin++;
                    break;
                case 1 :
                    // Traverse down and decrease col end
                    for(int i = rowBegin; i<=rowEnd; i++) {
                        // System.out.print(matrix[i][colEnd] + " -> ");
                        integers.add(matrix[i][colEnd]);
                    }
                    colEnd--;
                    break;
                case 2 :
                    // Traverse left and decrease row ends
                    for(int i = colEnd; i>=colBegin; i--) {
                        // System.out.print(matrix[rowEnd][i] + " -> ");
                        integers.add(matrix[rowEnd][i]);
                    }
                    rowEnd--;
                    break;
                case 3 :
                    // Traverse up and increment col starts
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        // System.out.print(matrix[i][colBegin] + " -> ");
                        integers.add(matrix[i][colBegin]);
                    }
                    colBegin++;
                    break;
            }
            direction = (++direction % 4);
        }
        // System.out.println("Done");
        return integers;
    }
}
