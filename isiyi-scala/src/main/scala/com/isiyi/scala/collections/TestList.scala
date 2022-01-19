package com.isiyi.scala.collections

import scala.collection.mutable.ListBuffer

object TestList {

  def main(args: Array[String]): Unit = {

    // 数组
    val array = Array[Int](11, 22, 33)
    array(1)=44
    array.foreach( println ) //11 44  33

    println("-----------------List--------------------------")
    // 链表(不可变)
    val list = List[Int](1, 2, 3, 4)

    // 可变列表
    val listBuffer = ListBuffer[Int]()
    listBuffer.+=(34)
    listBuffer.+=(35)
    listBuffer.foreach( println )

    println("-----------------Set--------------------------")

    // 无序，去重
    val set = Set(21,22,23,22)
    set.foreach( println)

    val set1 = scala.collection.mutable.Set[Int]()
    set1.add(1)
    set1.add(2)
    set1.foreach( println )

    println("-----------------Tuple--------------------------")

    val t1 = (1,2,3,4,5)
    println(t1._5)
    //迭代
    val iterator = t1.productIterator
    while (iterator.hasNext) {
      println(iterator.next())
    }

    val t2 = (1,2,3,4,5, "test")
    println(t2._6)

    // tuple参数定义函数
    val t3 = ((a:Int)=>a+8,2)
    val i = t3._1(2)
    println(i)

    // 两个值的Tuple，描述的是kv
    println("-----------------Map--------------------------")
    val map = Map[String, Int]( ("k1", 123), ("k2", 456) )
    println(map.get("k22").getOrElse("N"))

    // 算子操作
    println("-----------------算子操作--------------------------")

    val listStr = List("hello world", "hello Scala", "math")
    val listIterator = listStr.iterator
    val iterMap = listIterator.flatMap( (x:String) => x.split(" "))
    //iterMap.foreach( println )

    val mapList = iterMap.map( (_, 1) )
    mapList.foreach( println )

    /**
      * iterMap 迭代 指针跑到了末尾，所以 mapList 没有值
      */

  }


}
