package gaurav.leetcode.may.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

    public int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > nums.length / 2) {
                return n;
            }
        }

        return -1;

    }
}
