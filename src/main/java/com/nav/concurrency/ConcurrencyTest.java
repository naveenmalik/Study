package com.nav.concurrency;

/**
 * Created by Neo on 6/18/2017.
 */
public class ConcurrencyTest {
    public static void main(String[] args) {
        System.out.println("Begin");

        Runnable task = ()->{
            String threadname = Thread.currentThread().getName();
            System.out.println("Thread name is:" + threadname);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("End");
    }
}
