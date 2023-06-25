package year_2022.medium_add_two_numbers;

public class Main {

    public static void main(String[] args) {
//        // Input: l1 = [2,4,3], l2 = [5,6,4]
//        // Output: [7,0,8]
//        // Explanation: 342 + 465 = 807.
//        ListNode l11 = new ListNode(2);
//        ListNode l12 = new ListNode(4);
//        ListNode l13 = new ListNode(3);
//        l11.next = l12;
//        l12.next = l13;
//
//        ListNode l21 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;
//
//        Solution solution1 = new Solution();
////        ListNode listNode = solution1.addTwoNumbers(l11, l21);
////        System.out.println();
//
//        // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        // Output: [8,9,9,9,0,0,0,1]
//        ListNode l31 = new ListNode(9);
//        ListNode l32 = new ListNode(9);
//        ListNode l33 = new ListNode(9);
//        ListNode l34 = new ListNode(9);
//        ListNode l35 = new ListNode(9);
//        ListNode l36 = new ListNode(9);
//        ListNode l37 = new ListNode(9);
//        l31.next = l32;
//        l32.next = l33;
//        l33.next = l34;
//        l34.next = l35;
//        l35.next = l36;
//        l36.next = l37;
//
//        ListNode l41 = new ListNode(9);
//        ListNode l42 = new ListNode(9);
//        ListNode l43 = new ListNode(9);
//        ListNode l44 = new ListNode(9);
//        l41.next = l42;
//        l42.next = l43;
//        l43.next = l44;
//
//        ListNode listNode1 = solution1.addTwoNumbers(l31, l41);
//        System.out.println(listNode1);

        Solution3 solution3 = new Solution3();
        var a = Solution3.reverseWords(new char[]{'I', ' ', 'd', 'r', 'i', 'v', 'e', ' ', 'w', 'i', 't', 'h', ' ', 'B', 'o', 'l', 't'});
        System.out.println(a);
        var b = Solution3.reverseWords(new char[]{'d', 'r', 'i', 'v', 'e'});
        System.out.println(b);
        var c = Solution3.reverseWords(new char[]{' ', 'd', 'r', 'i', 'v', 'e', ' '});
        System.out.println(c);
        var d = Solution3.reverseWords(new char[]{' '});
        System.out.println(d);
    }

}
