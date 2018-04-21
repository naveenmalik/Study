package com.sparklabs

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * Created by Neo on 10/22/2017.
  */
object SparkFunctions {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("TestingSpark")
    val session = SparkSession.builder().config(conf).getOrCreate()
    session.sparkContext.setLogLevel("ERROR")

    val input = session.sparkContext.parallelize(List(1,2,3,4))

    val result =input.map(x=>x*x)
    println(result.collect().mkString(":"))

    val flatMapRes = input.flatMap(x=>x.to(5))
    println(flatMapRes.collect().mkString(","))

    //println(input.sample(true, 1).collect().mkString(":"))

    println(input.cartesian(result).collect().mkString("-"))

  }

}
