package com.nav.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by naveen on 25-Sep-16.
 */
public class HelloWorld {

    public static void main(String[] args) throws IOException {
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        list.forEach(n -> System.out.println(n));

        //list.forEach( (x)->{return x;});

        //Integer sum =  (int x,int y)->{return x + y;}
        //System.out.println("Sum" + );

        String contents = new String(Files.readAllBytes(Paths.get("D:\\Workspace\\Study\\src\\main\\resources\\abc.txt")));

        List<String> words = Arrays.asList(contents.split(":"));

        normalCount(words);

        streamCount(words);

    }

    private static void streamCount(List<String> words) {
        long time1 = System.currentTimeMillis();

        long count = words.parallelStream().filter(x->x.length()>10).count();

        long time2= System.currentTimeMillis();
        System.out.println("count:"+ count);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println("time:" + (time2-time1));
    }

    private static void normalCount(List<String> words) {
        long time1 = System.currentTimeMillis();
        int count=0;
        for(String s :words){
            if(s.length()>10)
            count++;
        }
        long time2= System.currentTimeMillis();
        System.out.println("count:"+ count);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println("time:" + (time2-time1));
    }
}
