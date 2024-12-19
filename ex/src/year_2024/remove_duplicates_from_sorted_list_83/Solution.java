package year_2024.remove_duplicates_from_sorted_list_83;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            final var next = current.next;
            if (current.val == next.val) {
                current.next = null;

                if (next.next != null) {
                    current.next = next.next;
                }
            } else {
                current = current.next;
            }
        }

        return head;
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

        final var listNode1 = new ListNode(1);
        final var listNode2 = new ListNode(2);
        final var listNode22 = new ListNode(2);
        final var listNode222 = new ListNode(2);
        final var listNode3 = new ListNode(3);
        final var listNode33 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode22;
        listNode22.next = listNode222;
        listNode222.next = listNode3;
        listNode3.next = listNode33;


        solution.deleteDuplicates(listNode1);
    }

}
