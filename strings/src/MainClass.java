import collections.ListImpl;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        ListImpl<String> listImpl=new ListImpl<>();
        System.out.println(listImpl.size());
        System.out.println(listImpl.isEmpty());
        listImpl.add("One");
        listImpl.add("Two");
        listImpl.add("Three");
        System.out.println(listImpl.size());
        listImpl.remove("Two");
        System.out.println(listImpl.size());
    }
}
