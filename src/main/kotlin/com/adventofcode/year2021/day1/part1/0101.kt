package com.adventofcode.year2021.day1.part1

import java.util.concurrent.atomic.AtomicReference

private fun Sonar?.next(data: String): Sonar {
  val newValue = data.toLong()
  return when {
    this == null -> Sonar(newValue)
    newValue > oldValue -> Sonar(newValue, incrementCounter + 1)
    else -> Sonar(newValue, incrementCounter)
  }
}

private class Sonar(val oldValue: Long, val incrementCounter: Long = 0)

fun solve0101() {
  val resource = "/com/adventofcode/year2021/0101.input"
  val sonar = AtomicReference<Sonar>()
  Sonar::class.java.getResourceAsStream(resource)!!.reader().forEachLine {
    sonar.get().next(it).let(sonar::set)
  }
  println("Day 1, Part One: ${sonar.get().incrementCounter}")
}