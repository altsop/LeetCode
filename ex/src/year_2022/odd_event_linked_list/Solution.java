package year_2022.odd_event_linked_list;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode even = head.next;
        ListNode lastEven = even;
        if (even.next == null) {
            return head;
        }
        ListNode secondOdd = even.next;
        
        while (secondOdd != null) {
            lastEven.next = secondOdd.next;
            odd.next = secondOdd;
            secondOdd.next = even;
            
            odd = secondOdd;
            lastEven = lastEven.next;
            if (lastEven == null) {
                break;
            }
            secondOdd = lastEven.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(solution.oddEvenList(a));
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


}
