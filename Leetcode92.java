public class Leetcode92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m > n) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }

        ListNode reverseBefore = head;
        ListNode mNode = head.next;

        ListNode cur = mNode.next;
        ListNode prev = mNode;
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        reverseBefore.next = prev;
        mNode.next = cur;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(8);
        reverseBetween(start, 1, 1);
    }
}
