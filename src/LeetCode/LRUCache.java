package LeetCode;

import java.util.*;

public class LRUCache {

    LinkedList<Integer> keyArrayQueue;
    HashMap<Integer, Integer> map = new HashMap<>();
    int currentIndex = 0;
    int capacity;

    public LRUCache(int capacity) {
        this.keyArrayQueue = new LinkedList<>();
        this.capacity = capacity;
        // System.out.println(this.keyArrayQueue);
    }

    public int get(int key) {
        if(keyArrayQueue.removeFirstOccurrence(key)) {
            keyArrayQueue.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // System.out.println(this.keyArrayQueue + " BEFORE");
        if (Objects.nonNull(map.get(key)) && map.get(key) != -1) {
            return; // Element already exists, no need to do anything.
        }
        if (currentIndex != capacity) { // Add to last
            keyArrayQueue.addFirst(key);
            currentIndex++;
            map.put(key, value);
        } else { // Substitute the last element.
            int removedElement = keyArrayQueue.removeLast();
            map.put(removedElement, -1); // Removed element should be set as -1
            keyArrayQueue.addFirst(key);
            map.put(key, value);
        }
        // System.out.println(this.keyArrayQueue + " After ");
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */