package org.example.memorymanagment;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static AtomicInteger counter=new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThreads=new ArrayList<>();

        for(int i=0;i<10000;i++){
            var t=new Thread(AtomicDemo::execute);
            allThreads.add(t);
            t.start();
        }

        for(Thread thread:allThreads){
            thread.join();
        }

        System.out.println(counter);
        //count not always equal to 1000, as two threads might access execute at the same time,
        //then one will override the increment result of the other
    }
    public static void execute(){
        counter.incrementAndGet();
    }
    public static void executeWithSyncBlock(){
            counter.incrementAndGet();
    }

}
