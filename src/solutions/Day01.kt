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
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toLong()
            val second = line.substringAfterLast(" ").toLong()
            first to second
        }.unzip()

        val result = left.sumOf { value ->
            value * right.count { it == value }
        }

        return result
    }

    val testExampleInput = listOf(
        "3   4",
        "4   3",
        "2   5",
        "1   3",
        "3   9",
        "3   3",
    )
    val part1TestExample: Pair<TestInput, TestResult> = testExampleInput to 11
    val part2TestExample: Pair<TestInput, TestResult> = testExampleInput to 31

    // Test if implementation meets criteria from the example in the description:
    val part1TestInput = part1TestExample.first
    val part1TestResult = part1TestExample.second
    val part1Result = part1(part1TestInput)
    check(part1Result == part1TestResult) {
        "Part 1 Result = $part1Result instead of $part1TestResult Test passed: ${part1Result == part1TestResult}"
    }.also {
        part1(part1TestInput).println {
            "Part 1 Result = $this Test passed: ${this == part1TestResult}"
        }
    }

    val part2TestInput = part2TestExample.first
    val part2TestResult = part2TestExample.second
    val part2Result = part2(part2TestInput)
    check(part2Result == part2TestResult) {
        "Part 2 Result = $part2Result instead of $part2TestResult Test passed: ${part2Result == part2TestResult}"
    }.also {
        part2(part2TestInput).println {
            "Part 2 Result = $this Test passed: ${this == part2TestResult}"
        }
    }

    // Read the input for day 1.
    val input = readInput(day = 1)

    part1(input).println()
    part2(input).println()
}
