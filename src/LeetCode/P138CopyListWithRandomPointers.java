package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 */

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

/**
 * Idea is to keep a hashmap for cloning the node and next time while filling the node in cloned linked list, use that.
 */

public class P138CopyListWithRandomPointers {

    public Node copyRandomList(Node head) {
        if(null == head) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node originalCurrent = head, clonedCurrent = null;

        while (originalCurrent != null) {
            clonedCurrent = new Node();
            clonedCurrent.val = originalCurrent.val;
            map.put(originalCurrent, clonedCurrent);
            originalCurrent = originalCurrent.next;
        }

        originalCurrent = head;

        while (originalCurrent !=null) {
            clonedCurrent = map.get(originalCurrent);
            clonedCurrent.next = map.get(originalCurrent.next);
            clonedCurrent.random = map.get(originalCurrent.random);
            originalCurrent = originalCurrent.next;
        }

        return map.get(head);
    }
}
