package gaurav.leetcode.april.week4;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence_DP(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public int longestCommonSubsequence_memo(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(text1, text2, 0, 0, dp);
    }


    int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i > s1.length() - 1 || j > s2.length() - 1) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int len = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + helper(s1, s2, i + 1, j + 1, dp);
        } else {
            len = Math.max(helper(s1, s2, i, j + 1, dp), helper(s1, s2, i + 1, j, dp));
        }

        dp[i][j] = len;

        return dp[i][j];
    }

}
