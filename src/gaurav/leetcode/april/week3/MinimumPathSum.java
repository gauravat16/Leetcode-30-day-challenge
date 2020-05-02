package gaurav.leetcode.april.week3;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        return sum(grid, dp, 0, 0);
    }


    private int sum(int[][] grid, int[][] dp, int r, int c){
        if(r< 0 || c < 0 || r>=grid.length || c>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[r][c] != 0){
            return dp[r][c];
        }

        int down = sum(grid, dp, r+1, c);
        int right =  sum(grid, dp, r, c+1);
        int min = Math.min(down, right);



        dp[r][c] = (min != Integer.MAX_VALUE ? grid[r][c] + min : grid[r][c]);

        return dp[r][c];

    }
}
