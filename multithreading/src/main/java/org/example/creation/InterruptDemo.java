package org.example.creation;

import java.util.concurrent.TimeUnit;

public class InterruptDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new InterruptDemo());

        newThread.start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("we are interrupting newThread");
        newThread.interrupt();

        newThread.join();
        System.out.println("main is leaving.");
    }

    public void work() throws InterruptedException {
        while (true) {
            System.out.println("working..");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("isInterrupted() method :" + Thread.currentThread().isInterrupted());
               /* System.out.println("interrupted() method: " + Thread.interrupted());
                System.out.println("isInterrupted() method again :" + Thread.currentThread().isInterrupted());
                */
                TimeUnit.MILLISECONDS.sleep(2);

            }
        }
    }

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            System.out.println("work() is no longer executing");;
        }
    }
}
