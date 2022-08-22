package lowest_common_ancestor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = findPath(root, p, List.of(root));
        List<TreeNode> pathToQ = findPath(root, q, List.of(root));

        Set<TreeNode> set = new HashSet<>(pathToP);
        for (int i = pathToQ.size() - 1; i >= 0 ; i--) {
            if (set.contains(pathToQ.get(i))) {
                return pathToQ.get(i);
            }
        }

        return null;
    }

    private static List<TreeNode> findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root.val == target.val) {
            return path;
        }

        TreeNode left = root.left;
        if (left != null) {
            List<TreeNode> updatedPath = new ArrayList<>(path);
            updatedPath.add(left);
            List<TreeNode> treeNodes = findPath(left, target, updatedPath);
            if (treeNodes != null) {
                return treeNodes;
            }
        }

        TreeNode right = root.right;
        if (right != null) {
            List<TreeNode> updatedPath = new ArrayList<>(path);
            updatedPath.add(right);
            List<TreeNode> treeNodes = findPath(right, target, updatedPath);
            if (treeNodes != null) {
                return treeNodes;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode aLeftLeft = new TreeNode(7);

        TreeNode aLeft = new TreeNode(8, aLeftLeft, null);
        TreeNode aRight = new TreeNode(12);
        TreeNode root = new TreeNode(10, aLeft, aRight);

        lowestCommonAncestor(root, aLeftLeft, aRight);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }


}
