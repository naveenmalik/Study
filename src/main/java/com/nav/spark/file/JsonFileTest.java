package com.nav.spark.file;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * Created by Neo on 5/20/2017.
 */
public class JsonFileTest {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("TestJsonFile");
        SparkSession session = SparkSession.builder().config(conf).getOrCreate();

        //JavaSparkContext jsc = session.

       // session.read().json("");
    }
}
