package year_2024.easy.symmetric_tree_101;

import java.util.*;

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

    public boolean isSymmetric(TreeNode root) {
        final var leftLayers = new HashMap<Integer, List<Integer>>();
        abc(root.left, 0, leftLayers);

        final var rightLayers = new HashMap<Integer, List<Integer>>();
        abc(root.right, 0, rightLayers);

        if (leftLayers.size() != rightLayers.size()) return false;

        for (int i = 0; i < leftLayers.size(); i++) {
            final var leftLayer = leftLayers.get(i);
            final var rightLayer = rightLayers.get(i);

            if (leftLayer.size() != rightLayer.size()) return false;

            for (int j = 0; j < leftLayer.size(); j++) {
                final var leftLayerElement = leftLayer.get(j);
                final var rightLayerElement = rightLayer.get(rightLayer.size() - j - 1);
                if (!Objects.equals(leftLayerElement, rightLayerElement)) return false;
            }
        }

        return true;
    }

    private void abc(TreeNode current, int depth, Map<Integer, List<Integer>> res) {
        List<Integer> list = res.containsKey(depth) ? res.get(depth) : new ArrayList<>();
        res.put(depth, list);

        if (current == null) {
            list.add(null);
            return;
        };

        abc(current.left, depth + 1, res);
        list.add(current.val);
        abc(current.right, depth + 1, res);
    }

    public static void main(String[] args) {
        final var treeNode1 = new TreeNode(1);
        final var treeNode2 = new TreeNode(2);
        final var treeNode22 = new TreeNode(2);
        final var treeNode3 = new TreeNode(3);
        final var treeNode33 = new TreeNode(4);
        final var treeNode333 = new TreeNode(4);
        final var treeNode3333 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode22;

//        treeNode2.left = treeNode3;
        treeNode2.right = treeNode33;

//        treeNode22.left = treeNode333;
        treeNode22.right = treeNode3333;


        final var solution = new Solution();
        solution.isSymmetric(treeNode1);
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
