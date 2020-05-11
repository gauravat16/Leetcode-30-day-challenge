package gaurav.leetcode.may.week2;

public class FloodFill {

    private static int dir[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;

        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }


    void dfs(int[][] image, int r, int c, int newColor, int currColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[r].length || image[r][c] != currColor) {
            return;
        }
        image[r][c] = newColor;

        for (int[] pos : dir) {
            dfs(image, r + pos[0], c + pos[1], newColor, currColor);
        }
    }
}
