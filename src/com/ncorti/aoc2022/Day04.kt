package com.ncorti.aoc2022

fun String.processInput() = split("\n")
  .map { it.split(",") }
  .map { (p1, p2) ->
    val pair1 = p1.split("-")
    val pair2 = p2.split("-")
    listOf(pair1[0].toInt(), pair1[1].toInt(), pair2[0].toInt(), pair2[1].toInt())
  }

fun main() {
  fun part1() = getInputAsText("04", String::processInput)
    .count { (p1l, p1r, p2l, p2r) ->
      (p2l in p1l..p1r && p2r in p1l..p1r) || (p1l in p2l..p2r && p1r in p2l..p2r)
    }

  fun part2() = getInputAsText("04", String::processInput)
    .count { (p1l, p1r, p2l, p2r) ->
      !(p2l > p1r || p2r < p1l)
    }

  println(part1())
  println(part2())
}
