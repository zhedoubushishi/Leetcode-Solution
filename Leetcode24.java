public class Leetcode24 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        // dummy -> 1 -> 2 -> 3 -> 4
        //      dummy -> 2 -> 1        tmp   n3
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null && cur.next.next != null) {

            ListNode n3 = cur.next.next.next;
            ListNode n2 = cur.next.next;
            ListNode n1 = cur.next;
            cur.next = n2;
            n2.next = n1;
            n1.next = n3;
            cur = cur.next.next;

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);

        ListNode res = swapPairs(input);


        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
