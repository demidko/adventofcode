package com.adventofcode.year2021.day2.part1

import com.adventofcode.year2021.day2.part1.Command.valueOf
import java.util.concurrent.atomic.AtomicReference

data class Submarine(val depth: Long, val horizontal: Long)

@Suppress("EnumEntryName")
enum class Command {
  forward {
    override fun calculate(submarine: Submarine, update: Long): Submarine {
      return submarine.copy(horizontal = submarine.horizontal + update)
    }
  },
  down {
    override fun calculate(submarine: Submarine, update: Long): Submarine {
      return submarine.copy(depth = submarine.depth + update)
    }
  },
  up {
    override fun calculate(submarine: Submarine, update: Long): Submarine {
      return submarine.copy(depth = submarine.depth - update)
    }
  };

  abstract fun calculate(submarine: Submarine, update: Long): Submarine;

}


fun solveDay2Part1() {
  val resource = "/com/adventofcode/year2021/0201.input"
  val submarine = AtomicReference(Submarine(0, 0))
  Submarine::class.java.getResourceAsStream(resource)!!.reader().forEachLine {
    val (command, update) = it.split(" ")
    valueOf(command)
      .calculate(submarine.get(), update.toLong())
      .let(submarine::set)
  }
  println(submarine.get().depth * submarine.get().horizontal)
}