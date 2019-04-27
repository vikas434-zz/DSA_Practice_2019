package LeetCode;

public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode sumNode = dummyHead;
        if ((l1 == null) && (l2 == null)) {
            return sumNode;
        }
        int carryOver = 0;
        while ((l1 != null) || (l2 != null)) {
            int sum = l1.val + l2.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }
            sumNode.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
        }

        // Whatever remaining add with carryover
        if (l1 != null) { // add l1
            add(sumNode, l1.next, carryOver);
        } else if(l2 != null){
            add(sumNode, l2.next, carryOver);
        }

        return dummyHead.next;
    }

    private void add(ListNode sumNode, ListNode listNodeNext, int carryOver) {
        sumNode.next.val = listNodeNext.next.val + carryOver;
        while (listNodeNext.next != null) {
            sumNode.next = listNodeNext.next;
            listNodeNext = listNodeNext.next;
            sumNode = sumNode.next;
        }
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }