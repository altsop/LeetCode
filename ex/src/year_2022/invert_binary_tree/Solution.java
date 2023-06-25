package year_2022.invert_binary_tree;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        invert(root.left);
        invert(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }

    public static void main(String[] args) {
        TreeNode aLeftLeft = new TreeNode(5);
        TreeNode aLeftRight = new TreeNode(6);
        TreeNode aRightLeft = new TreeNode(7);
        TreeNode aRightRight = new TreeNode(8);

        TreeNode aLeft = new TreeNode(2, aLeftLeft, aLeftRight);
        TreeNode aRight = new TreeNode(3, aRightLeft, aRightRight);
        TreeNode a = new TreeNode(1, aLeft, aRight);
        
        Solution solution = new Solution();
        solution.invertTree(a);
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


}
