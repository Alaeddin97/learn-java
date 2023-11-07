package org.example.synchronization;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedDemo {
    private static int counter =0;
    public static void main(String[] args) throws InterruptedException {
        List<Thread> allThreads=new ArrayList<>();

        for(int i=0;i<10000;i++){
            var t=new Thread(SynchronizedDemo::execute);
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
    public synchronized static void execute(){
        counter++;
    }
    public static void executeWithSyncBlock(){
        synchronized (SynchronizedDemo.class){
            counter++;
        }
    }

}
