package org.example.homework.homeword3;


import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new RunnableDefaultImpl());
        Thread t2=new Thread(new RunnableDefaultImpl());

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(3);

        t1.interrupt();
        t2.interrupt();

    }
}
