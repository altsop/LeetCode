package merge_two_sorted_lists;

import java.util.List;

// https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentResultNode = null;

        ListNode currentL1Node = l1;
        ListNode currentL2Node = l2;
        // iterate over l1 and l2 while some of them has elements
        // to compare elements and to choose the least one to be added as element of a result

        while (currentL1Node != null || currentL2Node != null) {
            if (result == null) {
                result = new ListNode();
                currentResultNode = result;
            } else {
                currentResultNode.next = new ListNode();
                currentResultNode = currentResultNode.next;
            }

            int comparisonResult = compare(currentL1Node, currentL2Node);
            if (comparisonResult == 1) {
                currentResultNode.val = currentL2Node.val;
                currentL2Node = currentL2Node.next;
            } else {
                currentResultNode.val = currentL1Node.val;
                currentL1Node = currentL1Node.next;
            }
        }

        return result;
    }

    private int compare(ListNode first, ListNode second) {
        if (second == null) {
            return 0;
        }

        if (first == null) {
            return 1;
        }

        if (first.val > second.val) {
            return 1;
        }

        return 0;
    }

    public static class ListNode {
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
        ListNode first1 = new ListNode(1);
        ListNode first2 = new ListNode(3);
        ListNode first3 = new ListNode(5);
        first1.next = first2;
        first2.next = first3;

        ListNode second1 = new ListNode(0);
        ListNode second2 = new ListNode(2);
        ListNode second3 = new ListNode(4);
        second1.next = second2;
        second2.next = second3;


        var a = solution.mergeTwoLists(first1, second1);
        System.out.println(a);
    }

}