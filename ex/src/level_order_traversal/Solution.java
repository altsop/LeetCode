package level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        if (root == null) {
            return levelOrderTraversal;
        }

        provideLevelOrderTraversal(levelOrderTraversal, root, 0);

        return levelOrderTraversal;
    }

    private static void provideLevelOrderTraversal(List<List<Integer>> levelOrderTraversal, TreeNode node, int level) {
        List<Integer> levelNodes;
        if (levelOrderTraversal.size() - 1 < level) {
            levelNodes = new ArrayList<>();
            levelOrderTraversal.add(levelNodes);
        } else {
            levelNodes = levelOrderTraversal.get(level);
        }
        levelNodes.add(node.val);

        if (node.left != null) {
            provideLevelOrderTraversal(levelOrderTraversal, node.left, level + 1);
        }

        if (node.right != null) {
            provideLevelOrderTraversal(levelOrderTraversal, node.right, level + 1);
        }
    }


    private static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode aLeftLeft = new TreeNode(5);
        TreeNode aLeftRight = new TreeNode(6);
        TreeNode aRightLeft = new TreeNode(7);
        TreeNode aRightRight = new TreeNode(8);

        TreeNode aLeft = new TreeNode(2, aLeftLeft, aLeftRight);
        TreeNode aRight = new TreeNode(3, aRightLeft, aRightRight);
        TreeNode a = new TreeNode(1, aLeft, aRight);

        System.out.println(levelOrder(a));;
    }

}
