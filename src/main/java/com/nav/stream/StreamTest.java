package com.nav.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Neo on 7/18/2017.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringCollection= new ArrayList<String>();
        stringCollection.add("abc");
        stringCollection.add("xyz");
        stringCollection.add("lmn");
        stringCollection.add("rst");
        stringCollection.add("uvw");

        Stream<String> stringStream = stringCollection.parallelStream();
        //stringStream.filter()
    }
}
