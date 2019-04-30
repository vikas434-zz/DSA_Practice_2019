package LeetCode;

public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        // Keep reversing till the head.next == null
        while (head.next != null) {

            head = head.next;
        }

        // TODO (DO it through iterative approach and use prev, curr and temp(to take care after reversal)
        return head;


    }


}
