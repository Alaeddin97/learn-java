package org.example.executorservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es= Executors.newCachedThreadPool();
        List<Callable<String>> tasks=new ArrayList<>(Arrays.asList(
                ()-> {
                    TimeUnit.SECONDS.sleep(2);
                    return "task1";
                },
                ()-> {
                    TimeUnit.SECONDS.sleep(1);
                    return "task2";
                },
                ()->  {
                    TimeUnit.SECONDS.sleep(2);
                    return "task3";
                }
        ));

        String result=es.invokeAny(tasks);
        System.out.println("result = " + result);

    }

    }

