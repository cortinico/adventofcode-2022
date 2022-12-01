package com.ncorti.aoc2022

fun main() {
  fun part1() = getInputAsText("01") { split("\n\n").map(String::trim) }
    .maxOfOrNull {
      it.split("\n").sumOf(String::toInt)
    }

  fun part2() = getInputAsText("01") { split("\n\n").map(String::trim) }
    .map { it.split("\n").sumOf(String::toInt) }
    .sortedDescending()
    .take(3)
    .sum()

  println(part1())
  println(part2())
}
