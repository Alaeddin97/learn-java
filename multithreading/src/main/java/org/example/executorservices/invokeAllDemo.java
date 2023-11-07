package org.example.executorservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class invokeAllDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newCachedThreadPool();
        List<Callable<String>> tasks=new ArrayList<>(Arrays.asList(
                ()->"task1",
                ()->"task2",
                ()-> "task3"
        ));

        List<Future<String>> futures=es.invokeAll(tasks);
        futures.stream().map(f->
                {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).forEach(System.out::println);
    }
}
