package merge_two;

public class Solution {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode current1 = list1;
        ListNode current2 = list2;

        ListNode top;
        ListNode current;

        if (list1.val > list2.val) {
            current = current2;
            current2 = current2.next;
        } else {
            current = current1;
            current1 = current1.next;
        }

        top = current;

        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }

            current = current.next;
        }

        if (current1 != null) {
            current.next = current1;
        }


        if (current2 != null) {
            current.next = current2;
        }

        return top;
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
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;

        ListNode aa = new ListNode(1);
        ListNode bb = new ListNode(3);
        ListNode cc = new ListNode(4);
        aa.next = bb;
        bb.next = cc;

        mergeTwoLists(a, aa);

    }

}
