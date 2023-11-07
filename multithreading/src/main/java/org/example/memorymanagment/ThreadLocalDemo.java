package org.example.memorymanagment;

public class ThreadLocalDemo implements Runnable {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("threadLocal in main ");
        System.out.println(threadLocal.get());
        Thread thread1 = new Thread(new ThreadLocalDemo());
        thread1.start();
    }

    @Override
    public void run() {
        threadLocal.set("threadLocal in thread1");
        System.out.println(threadLocal.get());
    }
}
