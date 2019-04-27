package LeetCode;

import java.util.Objects;
import java.util.Stack;

public class NumberOfIsland {
    private static final int MIN_ROW = 0;
    private static final int MIN_COL = 0;
    int noOfRows;
    int noOfColumn;
    boolean[][] isVisited;
    char[][] gridArray;

    public int numIslands(char[][] grid) {
        final char LAND = '1';
        final char WATER = '0';
        int numOfIsLands = 0;

        if(grid.length == 0) {
            return 0;
        }
        gridArray = grid;

        noOfRows = grid.length;
        noOfColumn = grid[0].length;

        // Assuming that no of rows and columns are constant.
        isVisited = new boolean[noOfRows][noOfColumn];

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumn; j++) {
                if(gridArray[i][j] == LAND && !isVisited[i][j]) {
                    doDFSStartingFromNode(i, j);
                    numOfIsLands++;
                }
            }
        }

        return numOfIsLands;
    }

    private void doDFSStartingFromNode(final int i, final int j) {

        Stack<Coordinates> stack = new Stack<>();
        stack.push(new Coordinates(i,j));

        while (!stack.empty()) {
            Coordinates peekedCoordinates = stack.peek();
            if(Objects.isNull(peekedCoordinates)) {
                return;
            }
            if(isNoMorePathAvailable(peekedCoordinates)) {
                stack.pop();
            } else {
                stack.push(nextAvailablePath(peekedCoordinates));
            }
        }

    }

    private Coordinates nextAvailablePath(Coordinates peekedCoordinates) {
        if(canMoveUp(peekedCoordinates)) {
            isVisited[peekedCoordinates.x-1][peekedCoordinates.y] = true;
            return new Coordinates(peekedCoordinates.x-1, peekedCoordinates.y);
        } else if(canMoveRight(peekedCoordinates)) {
            isVisited[peekedCoordinates.x][peekedCoordinates.y+1] = true;
            return new Coordinates(peekedCoordinates.x, peekedCoordinates.y+1);
        } else if(canMoveBottom(peekedCoordinates)) {
            isVisited[peekedCoordinates.x+1][peekedCoordinates.y] = true;
            return new Coordinates(peekedCoordinates.x+1, peekedCoordinates.y);
        } else if(canMoveLeft(peekedCoordinates)) {
            isVisited[peekedCoordinates.x][peekedCoordinates.y-1] = true;
            return new Coordinates(peekedCoordinates.x, peekedCoordinates.y-1);
        }
        return null;
    }

    private boolean isNoMorePathAvailable(final Coordinates peekedCoordinates) {
        if(!canMoveUp(peekedCoordinates) && !canMoveRight(peekedCoordinates) && !canMoveBottom(peekedCoordinates) && !canMoveLeft(peekedCoordinates) ) {
            return true;
        }
        return false;
    }

    private boolean canMoveBottom(Coordinates peekedCoordinates) {
        int x = peekedCoordinates.x;
        int y = peekedCoordinates.y;
        if((x + 1 <= noOfRows - 1) && (gridArray[x+1][y] == '1' ) && !isVisited[x + 1][y]) {
            return true;
        }
        return false;
    }

    private boolean canMoveLeft(Coordinates peekedCoordinates) {
        int x = peekedCoordinates.x;
        int y = peekedCoordinates.y;
        if((y-1 >= MIN_COL) && (gridArray[x][y-1] == '1' ) && !isVisited[x][y-1]) {
            return true;
        }
        return false;
    }

    private boolean canMoveRight(Coordinates peekedCoordinates) {
        int x = peekedCoordinates.x;
        int y = peekedCoordinates.y;
        if((y+1 <= noOfColumn -1) && (gridArray[x][y+1] == '1' ) && !isVisited[x][y+1]) {
            return true;
        }
        return false;
    }

    private boolean canMoveUp(Coordinates peekedCoordinates) {
        int x = peekedCoordinates.x;
        int y = peekedCoordinates.y;
        if((x-1 >= MIN_ROW) && (gridArray[x-1][y] == '1') && !isVisited[x-1][y]) {
            return true;
        }
        return false;
    }
}

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
