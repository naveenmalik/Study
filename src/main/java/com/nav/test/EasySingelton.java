package com.nav.test;

import com.TestAnything;

import java.io.IOException;

/**
 * Created by Neo on 12/2/2015.
 */
public enum EasySingelton {

    INSTANCE;

    public int sum(int i, int j){
        return (i +j);
    }
}
