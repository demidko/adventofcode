package com.adventofcode.year2021.day3.part1

import com.adventofcode.year2021.day
import java.math.BigInteger

/**
 * Calculates bits in one column
 */
class BitColumn {
  private var trueCounter = 0L
  private var falseCounter = 0L

  fun collectBit(bit: Char) {
    when (bit) {
      '0' -> ++falseCounter
      '1' -> ++trueCounter
    }
  }

  fun mostCommonBit(): Char {
    check(trueCounter != falseCounter)
    return when (trueCounter > falseCounter) {
      true -> '1'
      else -> '0'
    }
  }

  fun leastCommonBit(): Char {
    return when (mostCommonBit()) {
      '0' -> '1'
      else -> '0'
    }
  }
}

/**
 * Calculates bits in 12 columns
 */
class PowerCalculator(private val columnsCount: Int) {
  private val bitColumn = Array(columnsCount) { BitColumn() }

  fun collectBits(bits: String) {
    bits.forEachIndexed { index, bit ->
      bitColumn[index].collectBit(bit)
    }
  }

  private fun gamma(): BigInteger {
    val g = bitColumn.map(BitColumn::mostCommonBit).toCharArray().let(::String)
    return BigInteger(g, 2)
  }

  private fun epsilon(): BigInteger {
    val e = bitColumn.map(BitColumn::leastCommonBit).toCharArray().let(::String)
    return BigInteger(e, 2)
  }

  fun calculatePower(): BigInteger {
    return gamma() * epsilon()
  }
}

/**
 * [Day 3 Part 1](https://adventofcode.com/2021/day/3)
 */
fun main() {
  val calculator = PowerCalculator(12)
  day(3) {
    let(calculator::collectBits)
  }
  println(calculator.calculatePower())
}