package com.adventofcode.`2021`.`1`

fun Sonar?.next(data: String): Sonar {
  val newValue = data.toLong()
  return when {
    this == null -> Sonar(newValue)
    newValue > oldValue -> Sonar(newValue, incrementCounter + 1)
    else -> Sonar(newValue, incrementCounter)
  }
}