package gaurav.leetcode.may.week4;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> diffIdxMap = new HashMap<>();
        diffIdxMap.put(0, -1);

        int zero = 0, one = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            int diff = zero - one;

            if (diffIdxMap.containsKey(diff)) {
                max = Math.max(max, i - diffIdxMap.get(diff));
            } else {
                diffIdxMap.put(diff, i);
            }
        }

        return max;

    }
}
