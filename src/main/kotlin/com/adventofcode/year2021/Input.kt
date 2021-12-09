package com.adventofcode.year2021

fun readDay(day: Int, parse: String.() -> Unit) {
  {}::class.java.getResourceAsStream("$day.input")!!.reader().forEachLine(parse)
}