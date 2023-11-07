package org.example.memorymanagment;

public class InheritableThreadLocalDemo{
    private static InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();
    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {

        Thread thread1=new Thread(()->{
            System.out.println("........Thread #1........");
            threadLocal.set("....Thread #1- threadLocal....." );
            inheritableThreadLocal.set("......Thread #1- inheritableThreadLocal.......");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread= new Thread(()->{
                System.out.println("........Child thread........");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });
        thread1.start();
        Thread thread2=new Thread(()->{
            System.out.println("........ Thread #2........");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        });
        //thread2.start();
    }
}
