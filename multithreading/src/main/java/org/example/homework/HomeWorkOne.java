package org.example.homework;

import java.util.concurrent.TimeUnit;

public class HomeWorkOne {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i=0;i<5;i++){
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
    }
}

