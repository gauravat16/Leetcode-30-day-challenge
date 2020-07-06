package gaurav.leetcode.may.week2;

public class ArePointsInStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {

        Double slope = null;

        for (int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[i - 1];
            int[] p2 = coordinates[i];

            double num = p2[1] - p1[1];
            double den = p2[0] - p1[0];

            double currSlope = (den == 0) ? Integer.MAX_VALUE : num / den;

            if (slope == null) {
                slope = currSlope;
            } else {
                if (slope != currSlope) return false;
            }
        }

        return true;

    }

}
