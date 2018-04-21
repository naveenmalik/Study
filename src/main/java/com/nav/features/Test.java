package com.nav.features;

/**
 * Created by Neo on 6/25/2017.
 */
public class Test {

    public static void main(String[] args) {
        Converter<String, Integer> con = (f) -> Integer.valueOf(f);

        Integer i = con.convert("123");

        System.out.println("I:"+ i);

}
}
