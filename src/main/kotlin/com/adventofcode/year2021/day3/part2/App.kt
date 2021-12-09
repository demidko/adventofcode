package com.adventofcode.year2021.day3.part2

import com.adventofcode.year2021.day

fun List<String>.mostCommonBit(column: Int): Char {
  return when (count { it[column] == '1' } >= count { it[column] == '0' }) {
    true -> '1'
    else -> '0'
  }
}

fun List<String>.leastCommonBit(column: Int): Char {
  return when (count { it[column] == '0' } <= count { it[column] == '1' }) {
    true -> '0'
    else -> '1'
  }
}

fun List<String>.filterBy(detectBitCriteria: List<String>.(Int) -> Char): String {
  for (column in 0 until first().length) {
    val bitCriteria = detectBitCriteria(column)
    val foundedNumbers = filter { it[column] == bitCriteria }
    if (foundedNumbers.size == 1) {
      return foundedNumbers.first()
    }
  }
  error("Number not found!")
}


fun main() {
  val allBinaryNumbers = day(3)
  val oxygenGeneratorRating = allBinaryNumbers.filterBy(List<String>::mostCommonBit)
  val co2ScrubberRating = allBinaryNumbers.filterBy(List<String>::leastCommonBit)
  println(oxygenGeneratorRating)
  println(co2ScrubberRating)
}
