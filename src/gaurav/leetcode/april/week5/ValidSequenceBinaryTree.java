package gaurav.leetcode.april.week5;

import gaurav.leetcode.ds.TreeNode;

public class ValidSequenceBinaryTree {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }


    private boolean helper(TreeNode root, int[] arr, int i) {
        if (root == null || i >= arr.length) {
            return false;
        }

        if (i == arr.length - 1 && root.val == arr[i] && root.left == null && root.right == null) {
            return true;
        }

        if (root.val != arr[i]) {
            return false;
        } else {
            return helper(root.left, arr, i + 1) || helper(root.right, arr, i + 1);
        }


    }

}
