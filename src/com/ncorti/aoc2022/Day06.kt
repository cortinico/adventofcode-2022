package com.ncorti.aoc2022

fun main() {

  fun List<Char>.findFirstWindowed(windowSize: Int) =
    windowed(windowSize, 1)
    .mapIndexed { index, chars -> index + windowSize to (chars.distinct().size == windowSize) }
    .first { (_, isUnique) -> isUnique }
    .first

  fun part1() = getInputAsText("06") { trim().toList() }.findFirstWindowed(4)

  fun part2() = getInputAsText("06") { trim().toList() }.findFirstWindowed(14)

  println(part1())
  println(part2())
}
