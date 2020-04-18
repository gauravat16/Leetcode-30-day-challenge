package gaurav.leetcode.week3;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    doDFS(grid, i, j);
                    count++;
                }
            }
        }

        return count;

    }

    void doDFS(char[][] grid, int x, int y) {

        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = 'x';

        doDFS(grid, x + 1, y);
        doDFS(grid, x, y + 1);
        doDFS(grid, x - 1, y);
        doDFS(grid, x, y - 1);


    }
}
