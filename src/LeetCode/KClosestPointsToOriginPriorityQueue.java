package LeetCode;

import java.util.*;

public class KClosestPointsToOriginPriorityQueue {

    public int[][] kClosest(int[][] points, int K) {

        int rows = points.length;

        // Using Priority queue.
        PriorityQueue<CoordinatePoint> priorityQueue = new PriorityQueue<>();
        int i =0;
        while (i < rows) {
            priorityQueue.add(new CoordinatePoint(points[i][0], points[i][1]));
            if(i > K-1) { // Keep the size of Priority queue to max K.
                priorityQueue.remove();
            }
            i++;
        }

        int[][] returnArray = new int[K][2];
        for(int m = 0; m<K; m++) {
           CoordinatePoint cp = priorityQueue.poll();
           returnArray[m][0] = cp.x;
           returnArray[m][1] = cp.y;
        }

        return returnArray;
    }

    class CoordinatePoint implements Comparable<CoordinatePoint> {
        int x;
        int y;
        int squaredDistance;

        public CoordinatePoint(int x, int y) {
            this.x = x;
            this.y = y;
            this.squaredDistance = (x*x) + (y*y);
        }

        @Override
        public int compareTo(CoordinatePoint other) {
            return -Integer.compare(this.squaredDistance, other.squaredDistance);
        }
    }

}

