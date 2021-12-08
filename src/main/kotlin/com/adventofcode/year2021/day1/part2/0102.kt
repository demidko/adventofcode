package com.adventofcode.year2021.day1.part2

import java.util.concurrent.atomic.AtomicLong

private class Sonar {
  private val measurements = mutableListOf<Long>()

  fun appendMeasurement(v: Long) {
    if (measurements.size == 4) {
      measurements.removeFirst()
    }
    measurements.add(v)
  }

  fun checkIncreased(): Boolean {
    if (measurements.size < 4) {
      return false
    }
    val previousMeasurements = measurements.take(3).sum()
    val nextMeasurements = measurements.drop(1).sum()
    return nextMeasurements > previousMeasurements
  }
}


fun solve0102() {
  val sonar = Sonar()
  val counter = AtomicLong()
  val resource = "/com/adventofcode/year2021/0102.input"
  Sonar::class.java.getResourceAsStream(resource)!!.reader().forEachLine {
    it.toLong().let(sonar::appendMeasurement)
    if(sonar.checkIncreased()) {
      counter.incrementAndGet()
    }
  }
  println(counter)
}