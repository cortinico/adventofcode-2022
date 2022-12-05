package com.ncorti.aoc2022

import java.util.*

private fun String.processInput(): Pair<List<Stack<Char>>, List<List<Int>>> {
  val (stackDefs, moveDefs) = split("\n\n")
  val stacks = mutableListOf<Stack<Char>>()
  val stackLines = stackDefs.split("\n")
  stackLines.last().split(" ").filter(String::isNotBlank).forEach { _ ->
    stacks.add(Stack<Char>())
  }
  for (i in stackLines.size - 2 downTo 0) {
    val line = stackLines[i]
    val chars = line.toCharArray()
    for (j in chars.indices step 4) {
      if (chars[j] == '[') {
        stacks[j / 4].push(chars[j+1])
      }
    }
  }
  val moves = moveDefs.split("\n")
    .map {
      val tokens = it.split(" ")
      listOf(tokens[1].toInt(), tokens[3].toInt(), tokens[5].toInt())
    }
  return stacks.toList() to moves
}

fun main() {
  fun part1() = getInputAsText("05", String::processInput)
    .let { (stacks, moves) ->
      moves.forEach { (count, from, to) ->
        repeat(count) {
          stacks[to - 1].push(stacks[from - 1].pop())
        }
      }
      stacks
    }
    .let {
      it.joinToString("") { stack -> stack.peek().toString() }
    }

  fun part2() = getInputAsText("05", String::processInput)
    .let { (stacks, moves) ->
      moves.forEach { (count, from, to) ->
        val list = mutableListOf<Char>()
        repeat(count) {
          list.add(stacks[from - 1].pop())
        }
        repeat(count) {
          stacks[to - 1].push(list.removeLast())
        }
      }
      stacks
    }
    .let {
      it.joinToString("") { stack -> stack.peek().toString() }
    }


  println(part1())
  println(part2())
}
