package gaurav.leetcode.may.week3;

import gaurav.leetcode.ds.TreeNode;

public class KthSmallestBST {

    private int currK, num;

    public int kthSmallest(TreeNode root, int k) {
        num = Integer.MIN_VALUE;
        currK = k;
        helper(root);

        return num;
    }

    private void helper(TreeNode root) {
        if (root == null || currK <= 0) return;
        helper(root.left);
        currK--;
        if (currK == 0) {
            num = root.val;
            return;
        }
        helper(root.right);
    }
}
