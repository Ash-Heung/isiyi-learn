package com.isiyi.scala


class TestFunctionMain {


}

object  TestTestFunctionMain{
  def main(args: Array[String]): Unit = {
    val res = fun01()
    println(res)

    val res02 = fun02();
    println(res02)

    val res03 = fun03(1, 3);
    println(res03)

    val res04 = fun04(2, 3);
    println(res04)


    val res05 = fun05(4);
    println(res05)

  }


  def fun01(): Unit ={
    println("fun01")
  }

  def fun02(): Int ={
    3
  }


  def fun03(x: Int, y: Int): Int ={
    return x + y;
  }


  def fun04(x: Int, y: Int) = x * y

  // 递归函数
  def fun05(num : Int): Int ={
      // 触底判断
    if (num==1) {
      num
    }else {
      num * fun05(num-1)
    }

  }


  def max(x: Int, y: Int) = if(x > y) x else y;

  def add(x: Int, y: Int): Int = {
    var sum:Int = 0
    sum = x + y
    return sum
  }

  def printMsg(msg: Int) {
    println(msg)
  }
}
