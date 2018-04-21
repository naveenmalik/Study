package com.nav.spark.file;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

/**
 * Created by Neo on 5/20/2017.
 */
public class JsonFileTest {

    public static void main(String[] args) {
        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);
        SparkConf conf = new SparkConf().setMaster("local").setAppName("TestJsonFile");
        SparkSession session = SparkSession.builder().config(conf).getOrCreate();

        session.read().json("D:\\temp\\data\\input\\temp.json").show();
    }
}
