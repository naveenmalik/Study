package com.scalalab

import scala.io.Source

/**
  * Created by Neo on 8/21/2017.
  */
object FileReader {

  def main(args: Array[String]): Unit = {
    println("File IO testing")
    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines()) {
        println(line)
      }
    }
  }

}
