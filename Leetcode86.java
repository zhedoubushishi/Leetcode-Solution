public class Leetcode86 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode cur = head;
        ListNode smaller = null;
        ListNode bigger = null;

        ListNode smallerStart = null;
        ListNode biggerStart = null;

        while (cur != null) {
            if (cur.val < x) {
                if (smallerStart == null) {
                    smallerStart = cur;
                    smaller = cur;
                } else {
                    smaller.next = cur;
                    smaller = smaller.next;
                }
            } else {
                if (biggerStart == null) {
                    biggerStart = cur;
                    bigger = cur;
                } else {
                    bigger.next = cur;
                    bigger = bigger.next;
                }
            }

            cur = cur.next;
        }

        smaller.next = biggerStart;
        return smallerStart;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(4);
        start.next = new ListNode(3);
        start.next = new ListNode(2);
        start.next = new ListNode(5);
        start.next = new ListNode(2);
        partition(start, 3);
    }
}
