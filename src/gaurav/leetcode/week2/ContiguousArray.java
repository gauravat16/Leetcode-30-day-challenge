package gaurav.leetcode.week2;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> idxMap = new HashMap<>();
        idxMap.put(0, -1);

        int zero = 0;
        int one = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }
            int diff = zero - one;
            if(idxMap.containsKey(diff)){
                max = Math.max(max, i - idxMap.get(diff));
            }else{
                idxMap.put(diff, i);
            }

        }

        return max;

    }
}
