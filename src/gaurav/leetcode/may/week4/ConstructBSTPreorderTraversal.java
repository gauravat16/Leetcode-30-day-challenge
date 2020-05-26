package gaurav.leetcode.may.week4;

import gaurav.leetcode.ds.TreeNode;

public class ConstructBSTPreorderTraversal {

    private int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return helper(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }


    private TreeNode helper(int[] preorder, int max, int min) {
        if (idx >= preorder.length) return null;

        if (idx == preorder.length - 1) {
            return new TreeNode(preorder[idx]);
        }

        int rootVal = preorder[idx];
        idx++;

        TreeNode root = new TreeNode(rootVal);

        if (idx < preorder.length && rootVal > preorder[idx] && preorder[idx] < max) {
            root.left = helper(preorder, rootVal, min);
        }


        if (idx < preorder.length && rootVal < preorder[idx] && preorder[idx] < max) {
            root.right = helper(preorder, max, rootVal);
        }

        return root;
    }
}
