package com.nav.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Neo on 12/11/2015.
 */
public class PracticeSpark {
    static SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("My App");
    static JavaSparkContext sc = new JavaSparkContext(sparkConf);
    static JavaRDD<String> input = sc.textFile("C:\\spark\\spark-1.3.1-bin-hadoop2.4\\bin\\test.txt");

    public static void main(String[] args) {

        //createPairRDD();
        //reduceByKey();

        joinPairRDD();
    }

    public static void createPairRDD() {
        PairFunction<String, String, String> pairFunction = (String input) -> {
            return new Tuple2<String, String>(input.split(" ")[0], input);};

        JavaPairRDD<String, String> pairRDD = input.mapToPair(pairFunction);
        System.out.println("createPairRDD");
        System.out.println(pairRDD.collect());
    }

    public static void wordCount() {
        JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        words.countByValue();

        JavaPairRDD<String, Integer> result = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });

        System.out.println("ReduceByKey");
        System.out.println(result.collect());
    }

    private static void joinPairRDD() {
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        JavaPairRDD pairRDD1 = sc.parallelizePairs(
                Arrays.asList(new Tuple2<String, String>("1","2"),
                        new Tuple2<String, String>("3","4"),
                        new Tuple2<String, String>("3","6")));

        JavaPairRDD pairRDD2 = sc.parallelizePairs(
                Arrays.asList(new Tuple2<String, String>("3","9")));

        JavaPairRDD result = pairRDD1.leftOuterJoin(pairRDD2);

        System.out.println("joinPairRDD");
        System.out.println(result.collect());
    }
}
