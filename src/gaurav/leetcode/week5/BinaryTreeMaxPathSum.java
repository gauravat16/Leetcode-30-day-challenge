package gaurav.leetcode.week5;

import gaurav.leetcode.ds.TreeNode;

public class BinaryTreeMaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);

        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int path = Math.max(left + right + root.val, Math.max(root.val, root.val + Math.max(left, right)));

        max = Math.max(max, path);

        return Math.max(root.val, root.val + Math.max(left, right));
    }
}
