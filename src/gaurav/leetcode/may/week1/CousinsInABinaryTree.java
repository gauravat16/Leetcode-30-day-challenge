package gaurav.leetcode.may.week1;

import gaurav.leetcode.ds.TreeNode;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsInABinaryTree {

    TreeNode par1, par2;
    int depth1, depth2;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, null, x, y, 0);

        return par1 != par2 && depth1 == depth2;
    }


    private void helper(TreeNode root, TreeNode prev, int x, int y, int depth) {
        if (root == null) return;

        if (root.val == x || root.val == y) {
            if (par1 == null) {
                par1 = prev;
                depth1 = depth;
            } else {
                par2 = prev;
                depth2 = depth;
            }
            return;
        }

        helper(root.left, root, x, y, depth + 1);
        helper(root.right, root, x, y, depth + 1);
    }
}
