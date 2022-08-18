package middle_of_linked_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        int middleIndex = list.size() / 2;

        return list.get(middleIndex);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        middleNode(a);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
