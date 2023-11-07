package org.example.executorservices;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService es = Executors.newCachedThreadPool();


        Future<?> future = es.submit(
                () -> System.out.println("future- " + Thread.currentThread().getName())
        );
        Object result = future.get();
        System.out.println("result = " + result);


        Future<Integer> future1 = es.submit(
                () -> {
                    TimeUnit.SECONDS.sleep(11);
                    System.out.println(Thread.currentThread().getName());
                    return 1 + 1;
                }
        );
        Integer result1 = future1.get();
        System.out.println("result1 = future1- " + result1);


        Callable<String> task = () -> "future2- " +Thread.currentThread().getName();
        Future<String> future2 = es.submit(task);
        String result2 = future2.get();
        System.out.println("result2 = " + result2);


    }
}
