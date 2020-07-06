package gaurav.leetcode.july;

public class AddOne {

    public int[] plusOne(int[] digits) {

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            if (val > 9) {
                carry = 1;
            } else {
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
            for (int i = digits.length - 1, j = nums.length - 1; i >= 0; i--) {
                nums[j] = digits[i];
            }
            return nums;
        }


        return digits;

    }
}
