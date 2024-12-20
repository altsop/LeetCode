package year_2024.binary_tree_in_order_traversal_94;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);

        return res;
    }

    public void preorderTraversal(TreeNode current, List<Integer> res) {
        if (current == null) {
            return;
        }

        preorderTraversal(current.left, res);
        res.add(current.val);
        preorderTraversal(current.right, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
