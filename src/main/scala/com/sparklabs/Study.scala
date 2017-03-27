import org.apache.spark.{SparkConf, SparkContext}


object Study{
  val conf = new SparkConf().setMaster("local").setAppName("Study");
  val sc = new SparkContext(conf);

  def main(args: Array[String]): Unit ={
    println("Inside main")
   // testFlatMap()

    testMap()
    println("Exiting main")
  }

  def testFlatMap(): Unit ={
    val input = sc.parallelize(List("hello sir", "how are ", "things"))

    val res = input.flatMap(line=>line.split(" "))
    res.foreach(x=> println(x))
    //println(res.toString())
    //println(res.first())

    val result = input.map(line =>line.split(" "))
    result.foreach(x => println(x.toString))
    //println(res.toString())
    //println(res.first())

  }

  def testMap(): Unit ={
    println("Inside test")
    val input = sc.parallelize(List(1,2,3,4));

    val result = input.map(x=> x*x)
    val res = result.collect()
    println(res.size)
    res.foreach(x=> println(x))
    println( res.mkString(","))

    val r = input.map(x=> x.to(3));

    r.foreach(x=> println(x))
  }

}