package com.adventofcode.year2021.day2.part2

import com.adventofcode.year2021.day

class Submarine {
  private var aim = 0
  private var depth = 0
  private var horizontal = 0

  infix fun down(x: Int) {
    aim += x
  }

  infix fun up(x: Int) {
    aim -= x
  }

  infix fun forward(x: Int) {
    horizontal += x
    depth += (aim * x)
  }

  fun multiplication(): Int {
    return depth * horizontal
  }
}

fun main() {
  val submarine = Submarine()
  day(2) {
    val (command, x) = split(" ")
    when (command) {
      "up" -> submarine up x.toInt()
      "down" -> submarine down x.toInt()
      "forward" -> submarine forward x.toInt()
    }
  }
  println(submarine.multiplication())
}