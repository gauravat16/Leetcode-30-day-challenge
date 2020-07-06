package gaurav.leetcode.june.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange2 {

    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount + 1][coins.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(amount, coins, 0, dp);
    }

    private int helper(int amount, int[] coins, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i > coins.length - 1) {
            return 0;
        }

        if (dp[amount][i] != -1) return dp[amount][i];

        dp[amount][i] = helper(amount - coins[i], coins, i, dp) + helper(amount, coins, i + 1, dp);

        return dp[amount][i];
    }

}
