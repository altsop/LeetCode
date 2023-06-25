package year_2022.reverse_linked_list;

import java.util.Stack;

public class Solution {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode reversedHead = head;
        while (reversedHead.next != null) {
            stack.push(reversedHead);
            reversedHead = reversedHead.next;
        }

        ListNode currentNode = reversedHead;
        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
        currentNode.next = null;

        return reversedHead;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode current = head;
        if (current == null) {
            return null;
        }

        ListNode next = current.next;
        current.next = null;
        while (next != null) {
            ListNode nextNext = next.next;

            next.next = current;
            current = next;
            next = nextNext;
        }

        return current;
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
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        reverseList(a);

        ListNode aa = new ListNode(1);
        ListNode bb = new ListNode(2);
        ListNode cc = new ListNode(3);
        aa.next = bb;
        bb.next = cc;
        reverseList2(aa);
    }

}
