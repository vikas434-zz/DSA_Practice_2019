package LeetCode;

import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        int rows = points.length;


        SortedMap<Double, List<CoordinatePoint>> distanceToPoint = new TreeMap<>();

        for(int i =0; i<rows; i++) {
            double distance = getDistance(points[i]);
            if(Objects.nonNull(distanceToPoint.get(distance))) {
                List<CoordinatePoint> coordinatePointList = distanceToPoint.get(distance);
                coordinatePointList.add(new CoordinatePoint(points[i][0], points[i][1]));
            } else {
                List<CoordinatePoint> coordinatePoints = new ArrayList<>();
                coordinatePoints.add(new CoordinatePoint(points[i][0], points[i][1]));
                distanceToPoint.put(distance, coordinatePoints);// x and y coordinates.
            }
        }

        int[][] arrayToReturn = new int[K][2];
        int counter = 0;
        for (Double key : distanceToPoint.keySet()) {
            List<CoordinatePoint> coordinatePoints = distanceToPoint.get(key);
            Iterator iterator1 = coordinatePoints.iterator();
            while (iterator1.hasNext() && counter < K) {
                CoordinatePoint coordinatePoint = (CoordinatePoint) iterator1.next();
                arrayToReturn[counter][0] = coordinatePoint.x;
                arrayToReturn[counter][1] = coordinatePoint.y;
                counter++;
            }
        }

        return arrayToReturn;
    }

    private double getDistance(int[] point) {
        int x = point[0];
        int y = point[1];

        int x2 = Math.abs(x) * Math.abs(x);
        int y2 = Math.abs(y) * Math.abs(y);

        return Math.sqrt(x2+y2);
    }

    class test {

    }
}

class CoordinatePoint {
    int x;
    int y;

    public CoordinatePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
