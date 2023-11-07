package org.example.map.linkedhashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo<K, V> extends LinkedHashMap<K, V>{
    private int capacity = 3;

    public LinkedHashMapDemo() {
    }

    public LinkedHashMapDemo(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

 @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        if (size() > this.capacity) {
           return true;
        }
        return false;
    }
}
