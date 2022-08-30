package palindrome_linked_list;

import java.util.Stack;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        // boring

        // 1. find middle
        // 2. go up to middle and reverse the first part
        // 3. compare left and right parts

        return  false;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
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
