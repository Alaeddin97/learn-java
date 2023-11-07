package org.example.creation;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException{
        ThreadGroup group=new ThreadGroup("firstThreadGroup");
        Thread t1=new Thread(group,ThreadGroupDemo::execute);
        Thread t2=new Thread(group,ThreadGroupDemo::execute);
        Thread t3=new Thread(group,ThreadGroupDemo::execute);
        Thread t4=new Thread(group,ThreadGroupDemo::execute);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        TimeUnit.SECONDS.sleep(2);
        group.interrupt();


    }

    public static void execute(){
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
                return;
            }
        }
    }
}
