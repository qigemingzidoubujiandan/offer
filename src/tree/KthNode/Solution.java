package tree.KthNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaocl on 2021/10/7 15:14.
 * desc：
 */


public class Solution {
    ArrayList<TreeNode> objects = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <=0) {
            return null;
        }
         inOrder(pRoot);
        if(k>=1 && objects.size()>=k) {
            return objects.get(k-1);
        }
        return null;
    }

   private void inOrder(TreeNode pRoot) {
        if (pRoot != null) {
            inOrder(pRoot.left);
            objects.add(pRoot);
            inOrder( pRoot.right);
        }
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
