package LeetCode;

public class NumberOfIslandTest {

    public static void main(String[] args) {
        char[][] array = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println(numberOfIsland.numIslands(array));
    }
}
