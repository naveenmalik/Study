package com;

import com.nav.test.EasySingelton;
import com.nav.test.TestEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

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
        System.out.println(returnCheck(30, 10));
        System.out.println(returnCheck(11, 0));
    }

    public static long returnCheck(int x,int y) {
        long result = 0;
        try{
            result = x/y;
            return result;
        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            result = 5;
        }
        return 2;
    }

    public static void iteratorCheck(String[] args) {
        //int result = EasySingelton.INSTANCE.sum(1, 3);

        //System.out.println("result: "+ result);

        //TestEnum.E.One.get();

        ConcurrentHashMap ch = new ConcurrentHashMap();
        //HashMap ch = new HashMap();
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
