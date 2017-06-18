package com.nav.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by Neo on 12/15/2015.
 */
public class PairRDD {
    static SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("My App");
    static JavaSparkContext sc = new JavaSparkContext(sparkConf);

    public static void main(String[] args) {

        joinPairRDD();
    }

    private static void joinPairRDD() {
        JavaPairRDD pairRDD1 = sc.parallelizePairs(
                Arrays.asList(new Tuple2<String, String>("1","2"),
                        new Tuple2<String, String>("3","4"),
                        new Tuple2<String, String>("3","6")));

        JavaPairRDD pairRDD2 = sc.parallelizePairs(
                Arrays.asList(new Tuple2<String, String>("3","9")));

        JavaPairRDD result = pairRDD1.leftOuterJoin(pairRDD2);

        System.out.println("joinPairRDD");
        System.out.println(result.collect());


        JavaPairRDD r1 = pairRDD1.reduceByKey( (x, y) -> {return (Integer.parseInt((String)x) + Integer.parseInt((String)y));});
        System.out.println(r1.collect());

        JavaPairRDD r2 = pairRDD2.reduceByKey( (x, y) -> {return (Integer.parseInt((String)x) + Integer.parseInt((String)y));});
        System.out.println(r2.collect());

        JavaPairRDD r3 = r1.cogroup(r2);
        System.out.println(r3.collect());
    }
}
