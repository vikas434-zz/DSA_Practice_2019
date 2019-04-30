public class LLTest {

    public static void main(String[] args) {
        LLNode llNode = new LLNode(1);
        llNode.next = new LLNode(2);
        llNode.next.next = new LLNode(3);
        llNode.next.next.next = new LLNode(4);
        llNode.next.next.next.next = new LLNode(5);

        LinkedList linkedList = new LinkedList(llNode);
        System.out.println(linkedList.getNthElementFromLast(2));
    }
}
