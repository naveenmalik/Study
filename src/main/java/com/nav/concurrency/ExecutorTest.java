package com.nav.concurrency;

import java.util.concurrent.*;

/**
 * Created by Neo on 6/24/2017.
 */
public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        exec.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello:" + threadName);
        });

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 111;
            } catch (InterruptedException e) {
                throw new IllegalAccessException("Task Interrupted:" + e);
            }
        };

        Future<Integer> fut = exec.submit(task);

        System.out.println("Future Done: " + fut.isDone());
        Integer result = 0;

        try {
            result = fut.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Future Done: " + fut.isDone());

        System.out.println("Result: " + result);
    }
}
