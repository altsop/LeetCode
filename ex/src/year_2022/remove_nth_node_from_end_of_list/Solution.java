package year_2022.remove_nth_node_from_end_of_list;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            listNodes.add(currentNode);
            currentNode = currentNode.next;
        }

        if (listNodes.size() == 1) {
            return null;
        } else if (n == 1) {
            listNodes.get(listNodes.size() - n - 1).next = null;
        } else if (n == listNodes.size()) {
            return head.next;
        } else {
            listNodes.get(listNodes.size() - n - 1).next = listNodes.get(listNodes.size() - n + 1);
        }

        return head;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Input: head = [1,2,3,4,5], n = 2
        // Output: [1,2,3,5]
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(2);
        ListNode one3 = new ListNode(3);
        ListNode one4 = new ListNode(4);
        ListNode one5 = new ListNode(5);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;

//        ListNode result1 = solution.removeNthFromEnd(one1, 2);
        ListNode result2 = solution.removeNthFromEnd(one1, 5);
        System.out.println(result2);
    }

}
