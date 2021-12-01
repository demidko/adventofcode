package com.adventofcode.year2021

import java.util.concurrent.atomic.AtomicReference

private class Sonar(val oldValue: Long, val incrementCounter: Long = 0)

private fun Sonar?.next(data: String): Sonar {
  val newValue = data.toLong()
  return when {
    this == null -> Sonar(newValue)
    newValue > oldValue -> Sonar(newValue, incrementCounter + 1)
    else -> Sonar(newValue, incrementCounter)
  }
}

private fun solveFirstPart() {
  val resource = "/com/adventofcode/year2021/1.day"
  val sonar = AtomicReference<Sonar>()
  Sonar::class.java.getResourceAsStream(resource).reader().forEachLine {
    sonar.get().next(it).let(sonar::set)
  }
  println(sonar.get().incrementCounter)
}

fun solveFirstDay() {
  solveFirstPart()
}