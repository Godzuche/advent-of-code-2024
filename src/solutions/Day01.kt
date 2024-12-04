package solutions

import println
import readInput
import kotlin.math.absoluteValue

private typealias TestInput = List<String>
private typealias TestResult = Long

// --- Day 1: Historian Hysteria ---

fun main() {
    fun part1(input: List<String>): Long {
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toLong()
            val second = line.substringAfterLast(" ").toLong()
            first to second
        }.unzip()

        val result = left.sorted().zip(right.sorted()).sumOf { (first, second) ->
            val distanceApart = first - second
            distanceApart.absoluteValue
        }
        return result
    }

    fun part2(input: List<String>): Long {
        //

        return input.size.toLong()
    }

    val part1TestExample: Pair<TestInput, TestResult> =
        listOf(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3",
        ) to 11

    // Test if implementation meets criteria from the example in the description:
    val testInput = part1TestExample.first
    val testResult = part1TestExample.second
    val result = part1(testInput)
    check(result == testResult).also {
        part1(testInput).println {
            "Result = $result Test passed: ${result == testResult}"
        }
    }

    // Read the input for day 1.
    val input = readInput(day = 1)
    part1(input).println()
    part2(input).println()
}
