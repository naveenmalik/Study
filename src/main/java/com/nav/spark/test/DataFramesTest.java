package com.nav.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

/**
 * Created by naveen on 6/19/2016.
 */
public class DataFramesTest {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("My AppTest");
        SparkContext context = new SparkContext(conf);
        JavaSparkContext jsc = new JavaSparkContext(context);

        SQLContext sqlContext = new SQLContext(jsc);

        Dataset<Row> df = sqlContext.read().json("D:/temp/test.json");

        df.show();

        df.printSchema();

        df.select("name"). show();

        df.select(df.col("age"), df.col("name").alias("NAME")).show();

        df.limit(2).show();
        df.write().parquet("D:/temp/parque-test");

        //df.collect();

    }
}
