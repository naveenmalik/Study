package com;

import com.nav.test.EasySingelton;
import com.nav.test.TestEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Neo on 11/19/2015.
 */
public class TestAnything {

//    public static void main(String[] args) {
//        int sum = 9999999;
//
//
////        List<String> testList = new ArrayList<>();
////        for(int i=0; i<9999999 ; i++){
////            testList.add("no: " + i);
////        }
//
//        long st = System.currentTimeMillis();
////        for(int i=0; i<9999999 ; i++){
////            System.out.println(i + " " + testList.size());
////        }
//
//        for(int i=0; i<9999999 ; i++){
//            System.out.println(i + " " +  sum);
//        }
//
//
//        long et = System.currentTimeMillis();
//        long  run1  = et-st;
//
//        System.out.println();
//        System.out.println("run1 : " + run1 );
//
//    }

    public static void main(String[] args) {
        //int result = EasySingelton.INSTANCE.sum(1, 3);

        //System.out.println("result: "+ result);

        //TestEnum.E.One.get();

        ConcurrentHashMap ch = new ConcurrentHashMap();
        ch.put("1", "a");
        ch.put("2", "b");
        ch.put("3", "c");

        Iterator it = ch.keySet().iterator();

        while (it.hasNext()) {
            //ch.put("4", "d");
            ch.remove("1");
            ch.remove("2");
            ch.remove("3");
            System.out.println(it.next());

        }



    }
}
