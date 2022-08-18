package n_array_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> preorder(Node root) {
        List<Integer> preorderTraversal = new ArrayList<>();
        provideValues(preorderTraversal, root);

        return preorderTraversal;
    }

    private static void provideValues(List<Integer> preorderTraversal, Node current) {
        if (current == null) {
            return;
        }

        preorderTraversal.add(current.val);

        if (current.children != null) {
            for (Node child : current.children) {
                provideValues(preorderTraversal, child);
            }
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Node a11 = new Node(4);
        Node a12 = new Node(5);
        List<Node> aChildren = List.of(a11, a12);

        Node a = new Node(2, aChildren);
        Node b = new Node(3);
        List<Node> rootChildren = List.of(a, b);

        Node root = new Node(1, rootChildren);

        System.out.println(preorder(root));
    }

}
