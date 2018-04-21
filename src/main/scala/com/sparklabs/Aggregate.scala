package com.sparklabs

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * Created by Neo on 22-Nov-17.
  */
object Aggregate {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Aggregate")
    val session = SparkSession.builder().config(conf).getOrCreate()
    session.sparkContext.setLogLevel("ERROR")

    val input = session.sparkContext.parallelize(Seq(1, 2, 3, 4, 5))


    val result = input.aggregate((0, 0))(
      ((acc, value) => (acc._1 + value, acc._2 + 1)),
      ((acc1, acc2) => ((acc1._1 + acc2._1), (acc1._2 + acc2._2))))

    val avg = result._1/result._2

    println("Avg :"+ avg)

    println("Top 2: " + input.top(2).mkString(":"))
  }

}
