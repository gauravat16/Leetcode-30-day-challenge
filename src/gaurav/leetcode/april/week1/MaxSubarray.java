package gaurav.leetcode.april.week1;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {

        int max = 0, maxSoFar = 0, minNeg = Integer.MIN_VALUE;
        boolean allNeg = true;

        for (int i = 0; i < nums.length; i++) {

            if (allNeg && nums[i] > 0) {
                allNeg = false;
            } else {
                minNeg = Math.max(minNeg, nums[i]);
            }

            maxSoFar += nums[i];

            max = Math.max(maxSoFar, max);

            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }

        return allNeg ? minNeg : max;

    }
}
