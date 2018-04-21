package com.scalalab

/**
  * Created by Neo on 9/4/2017.
  */
class Rational (n:Int, d:Int){

  require(d!=0)

  val num =n
  val dem= d
  override def toString: String = n +"//"+d

  def add(that: Rational): Rational = {
    new Rational(n*that.dem + that.num * d , d * that.dem)
  }

}

object Rational {
  def main(args: Array[String]): Unit = {
    val a = new Rational(1, 2)
    val b = new Rational(3, 4)

    val c = a.add(b)

    print(c)
  }
}
