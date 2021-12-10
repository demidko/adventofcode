package com.adventofcode.year2021.day9.part1

import com.adventofcode.year2021.day

class RiskMap(private val rows: List<String>) {

  val horizontalLength = rows.first().length

  val verticalLength = rows.size

  /**
   * @param x horizontal
   * @param y vertical
   */
  operator fun get(x: Int, y: Int): Point? {
    if (x in 0 until horizontalLength && y in 0 until verticalLength) {
      return Point(this, x, y, rows[y][x].toString().toShort());
    }
    return null
  }
}

class Point(private val map: RiskMap, private val x: Int, private val y: Int, private val number: Short) {

  fun isLow(): Boolean {
    val neighbors = listOfNotNull(
      map[x, y - 1],
      map[x, y + 1],
      map[x - 1, y],
      map[x + 1, y]
    )
    return neighbors.all {
      it.number > number
    }
  }

  fun calculateRisk(): Int {
    return number + 1
  }
}

fun calculateRisk(map: RiskMap): Int {
  var totalRisk = 0
  for (x in 0 until map.horizontalLength) {
    for (y in 0 until map.verticalLength) {
      val p = map[x, y]
      if (p != null && p.isLow()) {
        totalRisk += p.calculateRisk()
      }
    }
  }
  return totalRisk
}

fun main() {
  val map = RiskMap(day(9))
  println(calculateRisk(map))
}