package com.nav.collection;

import com.couchbase.client.core.state.LifecycleState;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Neo on 4/9/2017.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet elem = new TreeSet();
        elem.add("one");
        elem.add("two");
        elem.add("three");
        elem.add("four");
        elem.add("one");

        System.out.println(elem);

        List<?> abc = new ArrayList<String>();
    }
}
