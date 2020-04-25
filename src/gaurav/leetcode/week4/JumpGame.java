package gaurav.leetcode.week4;

public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            int reachable = 0;

            for(int i=0; i<nums.length; i++){
                if(i > reachable){
                    return false;
                }

                reachable = Math.max(reachable, i+nums[i]);
            }

            return true;
        }


    }
}
