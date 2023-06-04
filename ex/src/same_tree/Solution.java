package same_tree;

public class Solution {

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

        @Override
        public String toString() {
            return String.format("%s", val);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // we've found a leaf
        if (p == null && q == null ) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        // compare left side
        boolean sameLeft = isSameTree(p.left, q.left);
        boolean sameRight = isSameTree(p.right, q.right);

        if (sameLeft && sameRight) {
            return p.val == q.val;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(
                composeBalancedTree1(),
                composeBalancedTree2()
        ));
    }

    public static TreeNode composeBalancedTree1() {
        // Create the nodes
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node8 = new TreeNode(8);

        // Construct the tree structure
        root.left = node2;
        root.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.left = node9;
        node7.right = node10;
        node9.left = node8;

        return root;
    }

    public static TreeNode composeBalancedTree2() {
        // Create the nodes
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node8 = new TreeNode(8);

        // Construct the tree structure
        root.left = node2;
        root.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.left = node9;
        node7.right = node10;
        node9.left = node8;

        return root;
    }

}
