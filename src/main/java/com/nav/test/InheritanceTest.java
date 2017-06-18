package com.nav.test;

import java.util.UUID;

/**
 * Created by naveen on 5/1/2016.
 */
public class InheritanceTest {
}
class A{
    public int i = 10;

    void display(){
        System.out.println("A");
    }
}

class B extends A{
    public int i = 20;

    void display(){
        System.out.println("B");
    }
}

class C extends B{
    public static void main(String[] args) {
        A o1 = new A();
        B o2 = new B();
        A r ;

        r = o1;
        r.display();
        System.out.println(r.i);
        r = o2;
        r.display();
        System.out.println(r.i);

        UUID idOne = UUID.randomUUID();
        System.out.println(idOne);

        idOne = UUID.fromString(idOne.toString());
        System.out.println(idOne);
    }
}
