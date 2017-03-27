package com.sparklabs

import java.io.StringReader

import au.com.bytecode.opencsv.CSVReader
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Neo on 2/4/2017.
  */
object LoadCSV {
  val conf = new SparkConf().setAppName("LoadCSV").setMaster("local");
  val sc = new SparkContext(conf);

  def main(args: Array[String]): Unit = {

    val input = sc.textFile("D:\\Workspace\\Study\\src\\main\\resources\\input.csv")

    val result = input.map { line =>
      val reader = new CSVReader(new StringReader(line))
      reader.readNext()
    }

    result.collect().foreach(x => {
      x.foreach(y => {
        print(y);
        print(" ")
      });
      println("")
    })

  }

}
