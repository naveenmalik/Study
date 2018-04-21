package com.scalalab

/**
  * Created by Neo on 8/15/2017.
  */
object DummyScala {

  def main(args: Array[String]): Unit = {
    val myArray: Array[String] = new Array[String](5)
    myArray(0) = "test0"
    myArray(1) = "test1"
    myArray(4) = "test4"

    val myArray1 = Array(5)

    print(myArray1(0))

    println("\n******************")
    val myArray2 = Array("one", "two")

    for (i <- myArray) {
      print(i)
      print(" ")
    }

    println("\n**************")

    for (i <- 0 to 1) {
      print(myArray2(i))
      print(" ")
    }

    println("\n**************")

    val tuple = ("hello", "world", "good", 123)

    println(tuple._2)
    println(tuple._3)

    println("\n**************")

    println(List(1,2)==List(2,1))

  }
}
