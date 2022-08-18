package linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return current;
            }

            visited.add(current);
            current = current.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = a;

        detectCycle(a);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
