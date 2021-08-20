package medium_add_two_numbers;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        ListNode currentResultNode = null;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        boolean shouldIncrement = false;


        while (true) {
            int first = currentL1 != null ? currentL1.val : 0;
            int second = currentL2 != null ? currentL2.val : 0;

            if (currentL1 == null && currentL2 == null) {
                break;
            } else {
                int sum = first + second;
                if (shouldIncrement) {
                    sum++;
                }

                shouldIncrement = sum >= 10;
                currentL1 = currentL1 != null ? currentL1.next : currentL1;
                currentL2 = currentL2 != null ? currentL2.next : currentL2;
                if (shouldIncrement) {
                    if (currentL2 == null && currentL1 == null) {
                        currentL2 = new ListNode(0);
                    }
                }

                if (result == null) {
                    result = new ListNode();
                    currentResultNode = result;
                } else {
                    currentResultNode.next = new ListNode();
                    currentResultNode = currentResultNode.next;
                }
                currentResultNode.val = sum % 10;
            }
        }

        return result;
    }


}