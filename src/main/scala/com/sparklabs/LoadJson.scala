package com.sparklabs

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * Created by Neo on 10/18/2017.
  */
object LoadJson {
  def main(args: Array[String]): Unit = {
     val conf = new SparkConf().setMaster("local").setAppName("TestingSpark")
    val session = SparkSession.builder().config(conf).getOrCreate()
    session.sparkContext.setLogLevel("ERROR")

    val df = session.read.json("D:\\temp\\data\\input\\temp.json")

    println(df.collect().mkString("::"))

  }
}
