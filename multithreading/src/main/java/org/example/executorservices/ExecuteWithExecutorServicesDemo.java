package org.example.executorservices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteWithExecutorServicesDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService
        ExecutorService es= Executors.newCachedThreadPool();
        es.execute(()->{
            System.out.println("HELLO FROM THREAD: " + Thread.currentThread().getName());
            System.out.println("HELLO FROM THREAD: " + Thread.currentThread().getName());
        });


    }
}
