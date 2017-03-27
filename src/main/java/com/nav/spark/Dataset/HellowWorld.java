package com.nav.spark.Dataset;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Created by Neo on 3/26/2017.
 */
public class HellowWorld {

    public static void main(String[] args) throws AnalysisException {

        HellowWorld hellowWorld = new HellowWorld();
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Hellow World");

        SparkSession sparkSession = SparkSession
                .builder()
                .appName("Hellow World")
                .config(conf)
                .getOrCreate();

        System.out.println("Start:");

        //hellowWorld.loadCSV( sparkSession, "D:\\temp\\data\\input\\inputDataCSV.csv");

        //hellowWorld.loadJSON( sparkSession, "D:\\temp\\data\\input\\test.json");

        hellowWorld.loadJSON( sparkSession, "D:\\temp\\data\\input\\temp.json");

        System.out.println("End");
    }

    private void loadCSV(SparkSession sparkSession, String path) {
        System.out.println("CSV File Load");

        Dataset<Row> datasetFile = sparkSession.read().csv(path);

        datasetFile.show();
    }

     private void loadJSON(SparkSession sparkSession, String path) throws AnalysisException {
        System.out.println("JSON File Load");

        Dataset<Row> ds = sparkSession.read().json(path);

        //Display Full DS
        ds.show();

         //Display group By
        ds.groupBy("Company").count().show();

        ds.createOrReplaceTempView("employee");

        System.out.println("Display by Sql");
        Dataset<Row> dsr= sparkSession.sql("select Dept, Company, count(*) from employee group by Dept, Company");
        dsr.show();

        ds.createGlobalTempView("employee1");

        Dataset<Row> dsr1 = sparkSession.sql("select * from global_temp.employee1");
        dsr1.show();

    }


}
