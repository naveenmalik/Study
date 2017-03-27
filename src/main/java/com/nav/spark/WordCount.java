package com.nav.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by naveen on 28-Sep-16.
 */
public class WordCount {

    public static void main(String[] args) throws IOException {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        JavaRDD<String> inputRDD = jsc.textFile("D:\\temp\\test\\wordCount.txt");

        //System.out.println("Spit the RDD");
        //inputRDD.saveAsTextFile("D:\\temp\\test\\wordCount-spit.txt");

//        JavaRDD<String> words = inputRDD.flatMap(new FlatMapFunction<String, String>() {
//            @Override
//            public Iterable<String> call(String s) throws Exception {
//                return Arrays.asList(s.split(""));
//            }
//        });

        JavaRDD<String> wordRDD = inputRDD.flatMap( (String x) ->{ return Arrays.asList(x.split(" ")).iterator();} );

        JavaPairRDD<String,Integer> wordPairRDD= wordRDD.mapToPair((String x)->{return new Tuple2(x,1);});

        JavaPairRDD<String, Integer> wordCountRDD = wordPairRDD.reduceByKey((x,y)->{ return x+y;});

        wordCountRDD.saveAsTextFile("D:\\temp\\test\\wordCount-result.txt");

//        Job job = Job.getInstance();
//        wordCountRDD.saveAsNewAPIHadoopFile( "D:\\temp\\test\\wordCount-result-parquet",
//                String.class,
//                String.class,
//                ParquetOutputFormat.class,
//                job.getConfiguration() );

    }
}
