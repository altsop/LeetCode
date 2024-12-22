package year_2024.easy.maximum_depth_of_binary_tree_104;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int max = 0;
    
//    public int maxDepth(TreeNode root) {
//        calculatedMaxDepth(root, 0);
//
//        return max;
//    }

    private void calculatedMaxDepth(TreeNode current, int depth) {
        if (current == null) {
            return;
        }

        int localDepth = depth + 1;

        if (localDepth > max) {
            max++;
        }

        calculatedMaxDepth(current.left, localDepth);
        calculatedMaxDepth(current.right, localDepth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        final var listNode1 = new TreeNode(1);
        final var listNode2 = new TreeNode(2);
        final var listNode22 = new TreeNode(3);
        final var listNode222 = new TreeNode(4);

        listNode1.left = listNode2;
        listNode1.right = listNode22;
        listNode2.right = listNode222;


        solution.maxDepth(listNode1);
    }

    public static class TreeNode {
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
