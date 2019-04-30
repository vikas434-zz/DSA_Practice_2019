public class LinkedList {

    LLNode head;

    public LinkedList(LLNode head) {
        this.head = head;
    }

    public int getNthElementFromLast(int n) {

        LLNode temp = head;
//        int lengthOfNode = 0;
//
//        while (temp !=null) {
//            temp = temp.next;
//            lengthOfNode++;
//        }
//
//        if(lengthOfNode < n) {
//            return -1;
//        }
        LLNode temp2 = head;
        // Move the temp1 to n node and then start temp2.
        int count = 0;
        while (count < n) {
            if(temp.next == null && count == n-1) { // Exceptionl case when count is same as n.
                return temp.data;
            } else if(temp.next == null) {
                return -1;
            }
            temp = temp.next;
            count++;
        }
        // temp is at node n and temp2 is at start. Start moving temp2
        temp2 = head;
//        for(int i = 1; i<lengthOfNode-n+1; i++) {
//            temp2 = temp2.next;
//        }
        while (temp != null) {
            temp2 = temp2.next;
            temp = temp.next;
        }

        return temp2.data;
    }


}

class LLNode {
    int data;
    LLNode next;

    public LLNode(int data) {
        this.data = data;
        next = null;
    }
}
