import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>(Arrays.asList(1,3,3,1,4,5));
        Iterator<Integer> iterator=integers.iterator();
        //integers.add(10);
        while(iterator.hasNext()){
            //integers.add(10);
            Integer next = iterator.next();
            if(next.equals(3)) iterator.remove();
        }

        System.out.println("integers = " + integers);
    }
}