package com.ncorti.aoc2022

fun scoreForInput(input: String) = when(input) {
  "X" -> 1
  "Y" -> 2
  else -> 3
}

fun playLose(input: String) = when(input) {
  "A" -> "Z"
  "B" -> "X"
  else -> "Y"
}

fun playDraw(input: String) = when(input) {
  "A" -> "X"
  "B" -> "Y"
  else -> "Z"
}

fun playWin(input: String) = when(input) {
  "A" -> "Y"
  "B" -> "Z"
  else -> "X"
}

fun main() {
  fun part1() = getInputAsText("02") { split("\n") }
    .map { it.split(" ") }
    .sumOf { (opponent, you) ->
      val selectedScore = scoreForInput(you)
      val outcomeScore = when {
        (opponent == "A" && you == "X") ||
          (opponent == "B" && you == "Y") ||
          (opponent == "C" && you == "Z") -> 3
        (you == "X" && opponent == "C") ||
          (you == "Y" && opponent == "A") ||
          (you == "Z" && opponent == "B") -> 6
        else -> 0
      }
      selectedScore + outcomeScore
    }

  fun part2() = getInputAsText("02") { split("\n") }
    .map { it.split(" ") }
    .sumOf { (opponent, you) ->
      val outcomeScore = when (you) {
        "X" -> 0
        "Y" -> 3
        else -> 6
      }
      val selectedLetter = when(outcomeScore) {
        0 -> playLose(opponent)
        3 -> playDraw(opponent)
        else -> playWin(opponent)
      }
      outcomeScore+ scoreForInput(selectedLetter)
    }

  println(part1())
  println(part2())
}
