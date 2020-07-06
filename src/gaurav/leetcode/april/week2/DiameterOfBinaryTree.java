package gaurav.leetcode.april.week2;

import gaurav.leetcode.ds.TreeNode;

public class DiameterOfBinaryTree {

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 0, right = 0;
        if (root.left != null)
            left = helper(root.left);

        if (root.right != null)
            right = helper(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
