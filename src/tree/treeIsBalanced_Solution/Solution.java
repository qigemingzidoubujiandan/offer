package tree.treeIsBalanced_Solution;

import javax.swing.tree.TreeNode;

/**
 * Created by zhaocl on 2021/10/7 15:14.
 * desc：
 */


public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) { return true;}

        int left = TreeDepth(root.left);
        int right= TreeDepth(root.right);



        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
