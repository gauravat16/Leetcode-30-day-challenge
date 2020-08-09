package gaurav.leetcode.july;

public class IslandPerimeter {

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    return helper(grid, r, c);
                }
            }
        }

        return 0;
    }


    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] == -1) return 0;

        grid[i][j] = -1;

        int count = 0;

        for (int[] dir : dirs) {
            count += helper(grid, i + dir[0], j + dir[1]);
        }

        return count;
    }

    private int getSides(int[][] grid, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];

            boolean cond = di >= 0 && di < grid.length && dj >= 0 && dj < grid[di].length
                    && grid[di][dj] == 1;

            if (!cond) count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

}
