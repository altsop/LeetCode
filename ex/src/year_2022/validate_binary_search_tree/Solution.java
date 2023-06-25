package year_2022.validate_binary_search_tree;

public class Solution {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

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
