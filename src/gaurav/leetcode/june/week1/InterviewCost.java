package gaurav.leetcode.june.week1;

public class InterviewCost {

    public int twoCitySchedCost(int[][] costs) {
        int[][][] dp = new int[costs.length][costs.length / 2 + 1][costs.length / 2 + 1];
        return helper(costs, 0, costs.length / 2, costs.length / 2, dp);
    }

    private int helper(int[][] costs, int i, int a, int b, int[][][] dp) {
        if (a < 0 || b < 0) return Integer.MAX_VALUE;
        if (i >= costs.length) return 0;

        if (dp[i][a][b] > 0) return dp[i][a][b];

        int cityA = helper(costs, i + 1, a - 1, b, dp);
        int cityB = helper(costs, i + 1, a, b - 1, dp);

        int costA = (cityA == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (costs[i][0] + cityA);
        int costB = (cityB == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (costs[i][1] + cityB);


        dp[i][a][b] = Math.min(costA, costB);

        return dp[i][a][b];
    }


    public static void main(String[] args) {
        System.out.println(new InterviewCost().twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
    }
}


