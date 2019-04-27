package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapPractice {

    public static void main(String[] args) {
        MyLinkedHashMap<Integer, Integer> linkedHashMap = new MyLinkedHashMap<>(2);
        linkedHashMap.put(1,1);
        System.out.println(linkedHashMap);
        linkedHashMap.put(2,2);
        System.out.println(linkedHashMap.get(1));
        System.out.println(linkedHashMap);
        linkedHashMap.put(3,3);
        System.out.println(linkedHashMap);
        linkedHashMap.get(2);
        System.out.println(linkedHashMap);
        linkedHashMap.put(4,4);
        System.out.println(linkedHashMap);
        linkedHashMap.get(1);
        System.out.println(linkedHashMap);
        linkedHashMap.get(3);
        System.out.println(linkedHashMap);
        linkedHashMap.get(4);
        System.out.println(linkedHashMap);
    }
}

class MyLinkedHashMap<K,V> extends LinkedHashMap{

    final int capacity;

    public MyLinkedHashMap(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    public Object get(Object key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }
}
