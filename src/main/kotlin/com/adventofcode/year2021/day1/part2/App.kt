package com.adventofcode.year2021.day1.part2

import com.adventofcode.year2021.day
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


fun main() {
  val sonar = Sonar()
  val counter = AtomicLong()
  day(1) {
    toLong().let(sonar::appendMeasurement)
    if (sonar.checkIncreased()) {
      counter.incrementAndGet()
    }
  }
  println(counter)
}