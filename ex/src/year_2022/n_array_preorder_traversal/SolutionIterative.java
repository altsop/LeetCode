package year_2022.n_array_preorder_traversal;

import java.util.*;

public class SolutionIterative {

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node c: node.children) {
                    stack.push(c);
                }
            }
        }
        return res;
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
        List<Node> aChildren = Arrays.asList(a11, a12);

        Node a = new Node(2, aChildren);
        Node b = new Node(3);
        List<Node> rootChildren = Arrays.asList(a, b);

        Node root = new Node(1, rootChildren);

        System.out.println(preorder(root));
    }
    
}
