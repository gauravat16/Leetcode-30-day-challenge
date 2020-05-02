package gaurav.leetcode.april.week4;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        int[] prefixArr = new int[nums.length];
        prefixArr[0] = nums[0];

        for (int s = 1; s < nums.length; s++) {
            prefixArr[s] = nums[s] + prefixArr[s - 1];
        }

        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int s = 0; s < nums.length; s++) {

            if (sumMap.containsKey(prefixArr[s] - k)) {
                count += sumMap.get(prefixArr[s] - k);
            }
            sumMap.put(prefixArr[s], sumMap.getOrDefault(prefixArr[s], 0) + 1);

        }

        return count;
    }
}
