package org.example.creation;

public class FirstMultiThreadingProgram extends Thread{
    public static void main(String[] args) {
        Thread t1=new Thread(new DefaultRunnableImpl());
        Thread t2=new Thread(()->{
            System.out.println("Thread: " + Thread.currentThread().getName());
        });
        Thread t3 = new FirstMultiThreadingProgram();

        System.out.println("current thread name is: " + Thread.currentThread().getName());
        t1.start();
        t2.start();
        t3.start();

    }

    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName());
    }
}

class DefaultRunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}
