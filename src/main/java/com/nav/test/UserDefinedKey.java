package com.nav.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by naveen on 5/1/2016.
 */
public class UserDefinedKey {
    public static void main(String[] args) {
        Set<MyClass> set = new HashSet<MyClass>(); //new TreeSet<MyClass>();
        MyClass m1 = new MyClass("1");
        MyClass m2 = new MyClass("2");
        MyClass m3 = new MyClass("7");
        MyClass m4 = new MyClass("9");
        MyClass m5 = new MyClass("8");
        MyClass m6 = new MyClass("8");
        set.add(m1);
        set.add(m2);
        set.add(m3);
        set.add(m4);
        set.add(m5);
        set.add(m6);
        System.out.println(set);
    }
}

class MyClass //implements Comparable<MyClass>
{
    private String counter;

    MyClass(String i) {
        counter = i;
    }

    public int compareTo(MyClass o){
        return o.counter.compareTo(counter);
    }

    @Override
    public String toString(){
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyClass myClass = (MyClass) o;

        return counter.equals(myClass.counter);

    }

    @Override
    public int hashCode() {
        int hash = counter.hashCode();
        System.out.println(hash);
        return hash;
    }
}