public class Leetcode002 {

    /* Definition for singly-linked list.*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null || l2 != null || carry == 1) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int cur = val1 + val2 + carry;
            carry = cur / 10;
            head.next = new ListNode(cur % 10);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            head = head.next;
        }

        return dummy.next;
    }
}
