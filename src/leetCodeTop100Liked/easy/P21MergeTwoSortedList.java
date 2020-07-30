package leetCodeTop100Liked.easy;

/* Created by Vikas Ranjan on 2020-07-17
 *
 *
 * */
public class P21MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lf = new ListNode();

        if (null == l1 && null == l2) {
            return lf;
        }

        if (null == l1 ) {
            return l2;
        }

        if (null == l2 ) {
            return l1;
        }

        while (l1.next != null || l2.next != null) {
            // System.out.println("l1 value is " +l1.val);
            // System.out.println("l2 value is " +l2.val);
            if (l1IsGreater(l1.val, l2.val)) {
                lf.val = l2.val;
                l2 = l2.next;
                // System.out.println("l1 > l2, so adding l2 to lf value is " +lf.val);
            } else {
                lf.val = l1.val;
                l1 = l1.next;
                // System.out.println("l1 < l2 so adding l1 to lf value is " +lf.val);
            }
            lf.next = new ListNode();
            lf = lf.next;
        }

        if (l1.next == null ) {
            lf.val = l1.val;
            lf.next = new ListNode();
           iterateLfToLast(lf, l2);
        } else {
            lf.val = l2.val;
            lf.next = new ListNode();
            iterateLfToLast(lf, l1);
        }

        return lf;
    }

    private boolean l1IsGreater(int val1, int val2) {
        return val1 > val2;
    }


    private void iterateLfToLast(ListNode lf, ListNode l) {
        while(l.next != null) {
            lf.val = l.val;
            l = l.next;
            lf.next = new ListNode();
        }
        lf.val = l.val;
    }

}

class ListNode {
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