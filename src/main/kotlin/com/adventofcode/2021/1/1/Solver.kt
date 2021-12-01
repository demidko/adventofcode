package com.adventofcode.`2021`.`1`.`1`

import java.util.concurrent.atomic.AtomicReference

fun print() {
  val resource = "/com/adventofcode/2021/1.day"
  val sonar = AtomicReference<Sonar>()
  Sonar::class.java.getResourceAsStream(resource)!!.reader().forEachLine {
    sonar.get().next(it).let(sonar::set)
  }
  println(sonar.get().incrementCounter)
}