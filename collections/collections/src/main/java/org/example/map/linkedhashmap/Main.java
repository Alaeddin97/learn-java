package org.example.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String>map=new LinkedHashMapDemo<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        System.out.println("map = " + map);
        map.put(4,"Four");
        System.out.println("map = " + map);
        System.out.println("===================================");
        Map<Integer,String> map1=new LinkedHashMapDemo<>(3,1,true);
        map1.put(1,"One");
        map1.put(2,"Two");
        map1.put(3,"Three");
        map1.put(4,"Four");
        //map1.get(2);
        System.out.println("map1 = " + map1);
    }
}