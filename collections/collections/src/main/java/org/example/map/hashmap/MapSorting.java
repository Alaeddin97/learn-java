package org.example.map.hashmap;

import java.util.*;

public class MapSorting {
    public static void main(String[] args) {
        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(1, "Uno");
        mapStr.put(1, "One");
        mapStr.put(2, "Two");
        mapStr.put(3, "Three");


        List<Map.Entry<Integer,String>>list=new ArrayList<>();
        for (Map.Entry<Integer,String> entry:mapStr.entrySet()){
            list.add(entry);
        }
        Collections.shuffle(list);
        System.out.println("list = " + list);
        list.sort(Comparator.comparing(Map.Entry::getKey));
        System.out.println("list = " + list);

        mapStr.put(3,"A");
        list.sort(Comparator.comparing(Map.Entry::getValue));
        System.out.println("list = " + list);

        Collections.sort(list,((o1, o2) -> -(o1.getKey()-o2.getKey())));
        System.out.println("list = " + list);

        Map<UserWithoutHashcode, Product> userWithoutHashcodeProductMap = new HashMap<>();
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(1, "Grigori", "Perlman", "grigori@gmail.com", "grigo123"),
                new Product(1, "Topology"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(2, "Marie", "Curie", "marie@gmail.com", "marie123"),
                new Product(2, "polonium"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(3, "Euler", "Euler", "euler@gmail.com", "euler123"),
                new Product(3, "Euler formula"));
        userWithoutHashcodeProductMap.put(
                new UserWithoutHashcode(4, "Maxwell", "Maxwell", "maxwell@gmail.com", "maxwell123"),
                new Product(4, "Maxwell Equations"));

        List<Map.Entry<UserWithoutHashcode,Product>> listUserProduct=new ArrayList<>();
        for (Map.Entry<UserWithoutHashcode,Product>entry:userWithoutHashcodeProductMap.entrySet()){
            listUserProduct.add(entry);
        }
        Collections.shuffle(listUserProduct);
        System.out.println("listUserProduct = " + listUserProduct);

        /*listUserProduct.sort(Comparator.comparing(Map.Entry::getKey));
        System.out.println("listUserProduct = " + listUserProduct);*/

        Collections.sort(listUserProduct, Map.Entry.comparingByKey());
        System.out.println("listUserProduct = " + listUserProduct);

    }
}
