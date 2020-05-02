package gaurav.leetcode.april.week4;

public class MaxSquareSize {

    class Solution {

        public int maximalSquare(char[][] matrix) {

            if (matrix.length == 0) {
                return 0;
            }

            int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

            int max = 0;
            for (int r = 1; r < dp.length; r++) {
                for (int c = 1; c < dp[r].length; c++) {
                    if (matrix[r - 1][c - 1] == '1') {
                        dp[r][c] = Math.min(dp[r][c - 1], Math.min(dp[r - 1][c], dp[r - 1][c - 1])) + 1;
                        max = Math.max(max, dp[r][c]);
                    }

                }
            }

            return max * max;
        }
    }
}
