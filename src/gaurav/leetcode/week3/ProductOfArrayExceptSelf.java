package gaurav.leetcode.week3;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] fwd = new int[nums.length];
        int[] bk = new int[nums.length];


        fwd[0] = 1;
        fwd[1] = nums[0];

        for(int i=2; i<nums.length ; i++){
            fwd[i] = nums[i-1] * fwd[i-1];
        }

        bk[nums.length -1] = 1;
        bk[nums.length -2] = nums[nums.length -1];

        for(int i=nums.length -3; i>=0 ; i--){
            bk[i] = nums[i+1] * bk[i+1];
        }

        for(int i=0; i<nums.length ; i++){
            fwd[i] *= bk[i];
        }

        return fwd;
    }
}
