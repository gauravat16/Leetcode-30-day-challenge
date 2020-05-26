package gaurav.leetcode.may.week4;

import java.util.Arrays;

public class CrossLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return helper(A, B, 0, 0, dp);
    }


    private int helper(int[] A, int[] B, int s, int idx, int[][] dp) {

        if (idx >= A.length || s >= B.length) {
            return 0;
        }

        if (dp[idx][s] != -1) {
            return dp[idx][s];
        }

        int count = 0;

        for (int i = s; i < B.length; i++) {
            if (B[i] == A[idx]) {
                count = Math.max(count, Math.max((1 + helper(A, B, i + 1, idx + 1, dp)), helper(A, B, s, idx + 1, dp)));
            } else {
                count = Math.max(count, helper(A, B, s, idx + 1, dp));
            }
        }

        dp[idx][s] = count;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CrossLines().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
