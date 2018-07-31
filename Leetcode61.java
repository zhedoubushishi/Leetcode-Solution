public class Leetcode61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int length = getLength(head);
        k = k % length;

        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;  // 防止head.next为空

        // 0 -> 1 -> 2 -> 3 -> NULL   K = 2
        //    START
        // 2 -> 3 -> 1 -> 0 -> NULL
        int start = length - k, count = 0;
        ListNode startNode = null;

        while (head.next != null) {
            if (count == start) {
                startNode = head;
            }
            count++;
            head = head.next;
        }

        head.next = dummy.next;
        dummy.next = startNode.next;
        startNode.next = null;

        return dummy.next;
    }



    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        rotateRight(head, 2);
    }

}
