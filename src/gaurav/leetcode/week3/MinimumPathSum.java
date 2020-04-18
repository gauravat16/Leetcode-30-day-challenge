package gaurav.leetcode.week3;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] minGrid = new int[grid.length][grid[0].length];

        return minPathRecursive(grid, minGrid, 0, 0);

    }

    public int minPathRecursive(int[][] grid, int[][] mem, int i, int j) {

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (mem[i][j] != 0) return mem[i][j];


        mem[i][j] = grid[i][j] + Math.min(minPathRecursive(grid, mem, i + 1, j), minPathRecursive(grid, mem, i, j + 1));
        return mem[i][j];
    }
}
