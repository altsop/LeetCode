package swap_pairs;

public class Solution {

    private ListNode currentNode = null;
    private ListNode currentNodeNext = null;


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 1. create variables for each node
        ListNode currentNodePrevious = null;
        this.currentNode = head;
        this.currentNodeNext = head.next;
        boolean isFirstIteration = true;
        ListNode top = head;

        // 1 2 3 4
        while(currentNode != null && currentNodeNext != null) {
            // 2. update first node next (to 3.)
            currentNode.next = currentNodeNext.next;

            // 3. update second node next (to 1.)
            currentNodeNext.next = currentNode;

            // choose a new TOP of linkedlist
            if(isFirstIteration) {
                // 4. remember the previous value
                currentNodePrevious = currentNode;

                top = currentNodeNext;
                isFirstIteration = false;
            } else {
                currentNodePrevious.next = currentNodeNext;
                currentNodePrevious = currentNode;
            }

            updateNodePair();
        }

        return top;
    }

    private void updateNodePair() {
        // it can be null;
        this.currentNode = this.currentNode.next;
        if(this.currentNode == null) {
            this.currentNodeNext = null;
        } else {
            this.currentNodeNext = this.currentNode.next;
        }
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

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(val).append(" ");
            ListNode localNext = next;
            while(localNext != null) {
                builder.append(localNext.val).append(" ");
                localNext = localNext.next;
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(2);
        ListNode one3 = new ListNode(3);
        ListNode one4 = new ListNode(4);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        var a = solution.swapPairs(one1);
        System.out.println(a);
    }

}
