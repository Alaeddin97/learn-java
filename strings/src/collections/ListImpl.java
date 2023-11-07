package collections;

import java.util.*;

public class ListImpl<T> implements List<T> {

    private final static int capacity;
    private static int index;
    private int actualCapacity;
    private static Object[] arr;

    static {
        capacity = 10;
    }

    public ListImpl() {
        arr = new Object[capacity];
        index = 0;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i <= index; i++) {
            if (arr[i].equals(o)) return true;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        Object[] aux = Arrays.copyOf(arr, index);
        return aux;
    }


    @Override
    public boolean add(T t) {
        if(size()<=capacity){
            arr[index+1]=t;
            index++;
            return true;
        }else{
            Object[]arr1=Arrays.copyOf(arr,capacity);
            arr=null;
            arr=new Object[capacity*2];
            actualCapacity=arr.length;
            for(int i=0;i<index;i++){
                arr[i]=arr1[i];
            }
            arr[index]=t;
            index++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if(!contains(o)){
            return false;
        }else {
            int indexO = 0;
            for(int i=0;i<index;i++){
                if(arr[i].equals(o)){
                    indexO=i;
                    break;
                }
            }
            Object[]arr1=new Object[indexO-1];
            Object[]arr2=new Object[arr.length-indexO+1];

            for(int i=0;i<indexO;i++){
               arr2[i]=arr[i];
            }
            for (int i=0;i<(size()-indexO + 1);i++){
                arr1[i]=arr[indexO+i+1];
            }

            arr=null;
            arr=new Object[actualCapacity];

            for(int i=0;i<actualCapacity;i++){
                if(i<indexO) arr[i]=arr1[i];
                arr[i]=arr2[i];
                index--;
            }
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
}
