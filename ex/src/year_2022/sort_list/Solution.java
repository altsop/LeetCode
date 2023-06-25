package year_2022.sort_list;

public class Solution {

    public ListNode sortList(ListNode head) {
        // The number of nodes in the list is in the range [0, 5 * 104].
        //-105 <= Node.val <= 105

        if (head == null || head.next == null) {
            return head;
        }

        ListNode minElement = head;

        ListNode previousElement = null;
        ListNode element = head;
        ListNode nextElement = head.next;

        while (element != null) {
            ListNode elementToCompareWith = minElement;
            ListNode previousToCompareWith = null;

            if (previousElement != null) {
                previousElement.next = nextElement;
            }

            while (true) {
                if (element.val < elementToCompareWith.val) {
                    if (previousToCompareWith == null) {
                        minElement = element;
                        break;
                    }
                }

                previousToCompareWith = elementToCompareWith;
                elementToCompareWith = elementToCompareWith.next;
            }

            previousElement = element;
            element = nextElement;
            nextElement = element.next;
        }

        return minElement;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        Solution solution = new Solution();
        System.out.println(solution.sortList(a));
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
