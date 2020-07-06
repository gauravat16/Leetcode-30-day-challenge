package gaurav.leetcode.may.week3;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {

        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, currMax = 0, currMin = 0, total = 0;

        for (int i = 0; i < A.length; i++) {
            total += A[i];
            currMax = Math.max(A[i] + currMax, A[i]);
            currMin = Math.min(A[i] + currMin, A[i]);
            maxSum = Math.max(currMax, maxSum);
            minSum = Math.min(currMin, minSum);
        }

        return currMax < 0 ? maxSum : Math.max(maxSum, total - minSum);

    }
}
