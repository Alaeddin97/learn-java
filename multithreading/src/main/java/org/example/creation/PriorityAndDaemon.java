package org.example.creation;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class PriorityAndDaemon {
    public static void main(String[] args) throws InterruptedException{
        //daemon demo
        Thread thread=new Thread(PriorityAndDaemon::execute);
        thread.setDaemon(true);
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("main is leaving..");

        //priority demo
        Thread thread1=new Thread(PriorityAndDaemon::executeOnce);
        Thread thread2=new Thread(PriorityAndDaemon::executeOnce);
        Thread thread3=new Thread(PriorityAndDaemon::executeOnce);
        Thread thread4=new Thread(PriorityAndDaemon::executeOnce);

        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        TimeUnit.SECONDS.sleep(2);
    }
    public static void execute(){
       while (true){
           try{
           TimeUnit.MILLISECONDS.sleep(500);
           System.out.println(Thread.currentThread().getName());

           }catch (InterruptedException exception){
               break;
           }
       }
    }

    public static void executeOnce(){
                System.out.println(Thread.currentThread().getName());
    }
}
