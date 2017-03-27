package com.nav.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TestEnum
{
    public static AtomicInteger count = new AtomicInteger(1);

    public enum E
    {
        One("One");

        String s;

        E(final String s)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In the constructor");
            this.s = s + new Date().getTime();
        }

        public void set(final String s)
        {
            this.s = s;
        }

        public String get()
        {
            return this.s;
        }
    }

    public static void main(final String[] args)
    {
        for (int i=0; i < 10; i++) {
            doit().start();
            doit().start();
            doit().start();
        }
    }

    static Thread doit()
    {
        return new Thread()
        {
            @Override
            public void run()
            {
                String name = "MyThread_" + count.getAndIncrement();

                System.out.println(name + " started");

                try
                {
                    int i = 2;
                    while (--i >= 0)
                    {

                        //synchronized (E.One)
                        {
                            System.out.println("Before:" + E.One.get());
                            E.One.set("1111");
                            System.out.println("After:" + E.One.get());
                        }

                    }
                } catch (Exception ex){

                }


                System.out.println(name + " ended");
            }
        };
    }
}