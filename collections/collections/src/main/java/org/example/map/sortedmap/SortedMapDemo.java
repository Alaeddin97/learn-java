package org.example.map.sortedmap;

import java.util.*;

public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(2, "Two");
        map.put(1, "One");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(6, "Six");
        map.put(5, "Five");
        System.out.println("map = " + map);
        SortedMap<Integer, String> map1 = map.subMap(3, 6);//shallow copy
        System.out.println("map1 = " + map1);
        map1.put(3, "Trois");
        System.out.println("map = " + map);
        Comparator<? super Integer> comparator = map1.comparator(); // null for natural order
        System.out.println("comparator = " + comparator);
        //

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        navigableMap.put(2, "Two");
        navigableMap.put(4, "Four");
        System.out.println("navigableMap natural order = " + navigableMap);
        System.out.println("navigableMap descending order = " + navigableMap.descendingMap());

        //

        NavigableMap<Product,String> productStringNavigableMap=new TreeMap<>(new CustomOrderProduct());
        productStringNavigableMap.put(new Product(2,"Trisquel"),"FSF");
        productStringNavigableMap.put(new Product(1,"Windows"),"Microsoft");
        System.out.println("productStringNavigableMap = " + productStringNavigableMap);

    }
}
