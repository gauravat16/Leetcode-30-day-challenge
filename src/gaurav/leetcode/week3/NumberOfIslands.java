package gaurav.leetcode.week3;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(!visited[r][c] && grid[r][c] == '1'){
                    count++;
                    markIsland(grid, r, c, visited);
                }
            }
        }

        return count;
    }



    void markIsland(char[][] grid, int r, int c, boolean[][] visited){
        if(r< 0 || c <0 || r>= grid.length || c >= grid[0].length  || grid[r][c] == '0' || visited[r][c]){
            return;
        }


        visited[r][c] = true;

        markIsland(grid, r+1, c, visited);
        markIsland(grid, r-1, c, visited);
        markIsland(grid, r, c+1, visited);
        markIsland(grid, r, c-1, visited);

    }
}
