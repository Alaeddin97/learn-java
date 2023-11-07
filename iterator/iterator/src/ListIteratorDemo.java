import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer>integers=new ArrayList<>(Arrays.asList(1,3,5,6,7));
        ListIterator<Integer>iterator=integers.listIterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("next= " + next);

           /* if(next.equals(3)){
                iterator.remove();
            }*/

            if(iterator.nextIndex()==(integers.size())) iterator.add(11);

        }
        System.out.println("integers = " + integers);

    }
}
