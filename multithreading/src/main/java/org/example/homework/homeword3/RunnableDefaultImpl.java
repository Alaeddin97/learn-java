package org.example.homework.homeword3;

import java.util.concurrent.TimeUnit;

public class RunnableDefaultImpl implements Runnable{
    private static int counter1;
    private static int counter2;

    public static int getCounter1() {
        return counter1;
    }

    public static int getCounter2() {
        return counter2;
    }

    @Override
    public void run() {
       synchronized (RunnableDefaultImpl.class)
        {
           while (true){
               try{
                   System.out.println(counter1 + "==" +counter2);
                   counter1++;
                   TimeUnit.MILLISECONDS.sleep(100);
                   counter2++;
                   TimeUnit.MILLISECONDS.sleep(100);
               }catch (InterruptedException e){
                   System.out.println("Thread was interrupted");
               }
           }
        }
    }
}
