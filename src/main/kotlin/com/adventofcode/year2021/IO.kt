package com.adventofcode.year2021

fun day(dayNumber: Int, parseLine: String.() -> Unit) {
  {}::class.java
    .getResourceAsStream("$dayNumber.input")!!
    .reader()
    .forEachLine(parseLine)
}


fun day(dayNumber: Int): List<String> {
  return {}::class.java
    .getResourceAsStream("$dayNumber.input")!!
    .reader()
    .readLines()
}