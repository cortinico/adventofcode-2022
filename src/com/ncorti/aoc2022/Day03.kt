package com.ncorti.aoc2022

fun Char.priority(): Int = when {
  this.isLowerCase() -> this - 'a' + 1
  else -> this - 'A' + 27
}

fun String.splitHalf(): List<String> =
  listOf(this.substring(0, this.length / 2), this.substring(this.length / 2))

fun List<String>.findCommonChar(): Char {
  var commonChars = this.first().toSet()
  this.forEach {
    commonChars = commonChars.intersect(it.toSet())
  }
  return commonChars.first()
}

fun main() {
  fun part1() = getInputAsText("03") { split("\n") }
    .map(String::splitHalf)
    .map(List<String>::findCommonChar)
    .sumOf(Char::priority)

  fun part2() = getInputAsText("03") { split("\n") }
    .windowed(3, 3)
    .map(List<String>::findCommonChar)
    .sumOf(Char::priority)

  println(part1())
  println(part2())
}
