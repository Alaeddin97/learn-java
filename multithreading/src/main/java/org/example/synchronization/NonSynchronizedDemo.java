package org.example.synchronization;

import java.util.ArrayList;
import java.util.List;

public class NonSynchronizedDemo {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        List<Thread>threads=new ArrayList<>();

        for(int i=0;i<10000;i++){
            Thread t=new Thread(NonSynchronizedDemo::execute);
            threads.add(t);
            t.start();
        }

        for(int i=0;i<1000;i++){
            threads.get(i).join();
        }

        System.out.println(count);
        //count not always equal to 1000, as tow might access execute at the same time,
        //then one will override the increment result of the other
    }
    public static void execute(){
        count++;
    }

}
