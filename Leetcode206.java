public class Leetcode206 {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     */


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    // iterative method
    public static ListNode reverseList(ListNode head) {

        //  1 -> 2 -> 3 -> 4
        //  1 <- 2 -> 3 -> 4
        //  1 <- 2 <- 3 -> 4
        //  1 <- 2 <- 3 <- 4

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    // recursive method
    public static ListNode reverseList2(ListNode head) {

        // 1 -> 2 -> 3 -> 4
        // 1 -> 2 -> 3 <- 4
        // 1 -> 2 <- 3 <- 4
        // 1 <- 2 <- 3 <- 4
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        ListNode last = head.next;
        last.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);

        ListNode res = reverseList(input);


        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
